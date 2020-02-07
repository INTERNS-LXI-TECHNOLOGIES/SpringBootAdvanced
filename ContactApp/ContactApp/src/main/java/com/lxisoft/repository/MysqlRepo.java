package com.lxisoft.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;

import com.lxisoft.domain.Contact;

@Controller
public class MysqlRepo implements Repository
{

		String driver_Class="com.mysql.jdbc.Driver";
		String userName="root";
		String password="root";
		String db_URL="jdbc:mysql://localhost:3306/";
		String dataBase="contacts";
		Connection con=null; 
		Statement stm=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		static int id=0;
			ArrayList<Contact> contacts=new ArrayList<Contact>();
	
		{
	
		try
		{
			dB_Connection(true);
		}catch(Exception e)
		{
			System.out.println("error "+e);
		}
	}
		
	public void dB_Connection(boolean dBexists) throws SQLException,ClassNotFoundException
	{
		try
		{
		
			if(dBexists)
			{	
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/",userName,password);
				stm=con.createStatement();
				System.out.println("DB Connection created successfully");
				checkDBExists();
				
			}
			else
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBase,userName,password);
				System.out.println("DB Connection created successfully");
				con.setCatalog(dataBase);
				System.out.println("DB set");
				
			}
			boolean tableExists=checkTableExists();
			if(tableExists)
				System.out.println("table exist");
			else
		    	createTable();
		}catch(SQLException ex) 
		{ 
	   		ex.printStackTrace();
		}
	}
	
	public boolean checkTableExists()
	{
		boolean exists=false;
		try
		{
			rs =  con.getMetaData().getTables(null, null, "Contactlist", null);
		    if (rs.next()) 
		    {
		     exists=true;
		    }
		}catch(SQLException e)
		{
			System.out.println("error"+e);
		}
		return exists;
	}
	public void checkDBExists()
	{
		boolean exists=false;
		try
		{
			if(con != null)
			{
				String catalog=null;
				rs =  con.getMetaData().getCatalogs();
	     		while (rs.next())
	     		{
	      	 		catalog = rs.getString(1); 
		      		if(dataBase.equals(catalog))exists=true;
		      	}
				if(exists)
				{
					Class.forName(driver_Class);
					con=DriverManager.getConnection(db_URL+dataBase,userName,password);
					stm=con.createStatement();
					System.out.println("the database "+dataBase+" exists");
				}
				else
				{
					stmt=con.prepareStatement("create database "+dataBase);
					stmt.executeUpdate();
					dB_Connection(false);
				}	
			}
		}catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("SQLException"+e);
		}
	}
	
	public void createTable()throws SQLException
	{
		try
		{
			String create_Table="create table Contactlist(ID int(3),FIRSTNAME varchar(50) default 'c',LASTNAME varchar(50) default 'c',NUMBER varchar(10) default '000')";
			stmt=con.prepareStatement(create_Table);
			stmt.execute();
			System.out.println("table created successfully");
		}
		catch(SQLException ex) 
		{ 
		   	System.out.println("Error: SQLSyntax error!"); 
		}
	}
	public ArrayList<Contact> getAllContacts(int start,int total)
	{
		try
		{
		contacts.clear();
		stmt=con.prepareStatement("use contacts");

			rs = stmt.executeQuery("select * from Contactlist limit "+(start-1)+","+total);
			while(rs.next()) 
			{ 
				Contact	contact=new Contact();
				contact.setId(rs.getInt("ID"));
				contact.setFirstName(rs.getString("FIRSTNAME"));
				contact.setLastName(rs.getString("LASTNAME"));
				contact.setNo(rs.getString("NUMBER"));
				contacts.add(contact);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return contacts;
	}
	public ArrayList<Contact> getAllContacts() throws SQLException
	{
		try
		{
	
		contacts.clear();
		stmt=con.prepareStatement("use contacts");
			rs = stmt.executeQuery("select * from Contactlist");
			while(rs.next()) 
			{ 
				Contact	contact=new Contact();
				contact.setId(rs.getInt("ID"));
				contact.setFirstName(rs.getString("FIRSTNAME"));
				contact.setLastName(rs.getString("LASTNAME"));
				contact.setNo(rs.getString("NUMBER"));
				contacts.add(contact);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return contacts;
	}
	public void addContactDetails(Contact contact)
	{
		contacts.add(contact);	
		boolean val=false;
		insertContactDetails(contact,val);
	}

	private void insertContactDetails(Contact contact, boolean tbexists)
	{
		try
		{	
			if(tbexists==false)
			{
				id=getId();
				stmt=con.prepareStatement("insert into Contactlist values(?,?,?,?)");  
				stmt.setInt(1,id);
				stmt.setString (2,contact.getFirstName());
				stmt.setString (3,contact.getLastName());
				stmt.setString(4,contact.getNo());
				stmt.executeUpdate();
			}else
			{
				stmt=con.prepareStatement("insert into Contactlist values(?,?,?,?)");  
				stmt.setInt(1,contact.getId());
				stmt.setString (2,contact.getFirstName());
				stmt.setString (3,contact.getLastName());
				stmt.setString(4,contact.getNo());
				stmt.executeUpdate();
			}
		}catch(SQLException ex) 
		{ 
	   		System.out.println(ex);
	   		ex.printStackTrace();
		}
	}

	public int getId()
	{
		try
		{
			id=0;
			contacts=getAllContacts();
			rs= stmt.executeQuery("select * from Contactlist");
			while(rs.next()) 
			{ 
	 			int temp= rs.getInt("ID");
	 			if(temp>id) id=temp;
			}id++;
		}catch(SQLException e)
		{
			System.out.println("Exception"+e);
		}
		return id;	
	}
	public void updateRepo(Contact contact)throws SQLException
	{
		try
		{
			stmt=con.prepareStatement("update Contactlist set firstname=?,lastname=?,number=? where id=?");
			stmt.setString(1,contact.getFirstName());
			stmt.setString(2,contact.getLastName());
			stmt.setString(3,contact.getNo());
			stmt.setInt(4,contact.getId());
			stmt.executeUpdate();
			System.out.println("contact updated");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void clearRepository()throws SQLException
	{
		try
		{
			id=0;
			stmt=con.prepareStatement("truncate table Contactlist");
			stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteContact(Contact contact)throws SQLException
	{
		try
		{
			stmt=con.prepareStatement("delete from Contactlist where id=?");
			stmt.setInt(1,contact.getId());
			stmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void sortContactByFirstName()throws SQLException
	{
		try
		{
			contacts.clear();
			stmt=con.prepareStatement("use contacts");
			rs=stmt.executeQuery("select * from Contactlist ORDER BY FIRSTNAME");
			while(rs.next()) 
			{ 
				Contact	contact=new Contact();
				contact.setId(rs.getInt("ID"));
				contact.setFirstName(rs.getString("FIRSTNAME"));
				contact.setLastName(rs.getString("LASTNAME"));
				contact.setNo(rs.getString("NUMBER"));
				contacts.add(contact);
			}
			clearRepository();
			for(Contact contact : contacts)
			{
				boolean val=true;
				insertContactDetails(contact,val);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void sortContactByLastName()throws SQLException
	{
		try
		{
			contacts.clear();
			stmt=con.prepareStatement("use contacts");
			rs=stmt.executeQuery("select * from Contactlist ORDER BY LASTNAME");
			while(rs.next()) 
			{ 
				Contact	contact=new Contact();
				contact.setId(rs.getInt("ID"));
				contact.setFirstName(rs.getString("FIRSTNAME"));
				contact.setLastName(rs.getString("LASTNAME"));
				contact.setNo(rs.getString("NUMBER"));
				contacts.add(contact);
			}
			clearRepository();
			for(Contact contact : contacts)
			{
				boolean val=true;
				insertContactDetails(contact,val);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
