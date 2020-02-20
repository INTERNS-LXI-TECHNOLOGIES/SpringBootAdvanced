package com.lxisoft.contacts.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.lxisoft.contacts.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class repoController 
{
	int id=0;
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ArrayList<Contact> contacts=new ArrayList<Contact>();
	
	
	 public void setConnection()
 	 {
 	 	try
 	 	{
 	 		Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");
			Connection con=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			setId();
//			ArrayList<Contact> contacts=new ArrayList<Contact>();
			// stm.executeUpdate("CREATE DATABASE "+dataBase)
			
 	 	}catch(Exception e)
 	 	{
 	 		System.out.println("error in connection "+e);
 	 	}
 	 }
	 
	 public void writeNewContact(Contact contact,boolean write)
		{
			try
			{
				setConnection();
				// stmt=con.prepareStatement("use tab");
				// setId();
			// System.out.println("erroro"+contact.getName());
				if (write)
				{
					stmt=con.prepareStatement("insert into tab values(?,?,?,?)");
					stmt.setInt(1,id);
					stmt.setString(2,contact.getFirstName());
					stmt.setString(3,contact.getLastName());
					stmt.setString(4,contact.getNo());
					stmt.executeUpdate();
					// System.out.println(" added");
					id++;
				}
				else
				{
					stmt=con.prepareStatement("insert into tab values(?,?,?,?)");
					stmt.setInt(1,contact.getId());
					stmt.setString(2,contact.getFirstName());
					stmt.setString(3,contact.getLastName());
					stmt.setString(4,contact.getNo());
					stmt.executeUpdate();
					
					// System.out.println("contact");
				}
				con.close();
				
			}catch(Exception p)
			{
				System.out.println("Error "+p);
			}
		}
		public ArrayList<Contact> getAllContacts()
		{
			contacts.clear();
			try
			{
				setConnection();
				stmt=con.prepareStatement("use tab");
				rs=stmt.executeQuery("select * from tab");
				while(rs.next())
				{
					Contact contact=new Contact();
					contact.setId(rs.getInt("ID"));
					contact.setFirstName(rs.getString("FIRSTNAME"));
					contact.setLastName(rs.getString("LASTNAME"));
					contact.setNo(rs.getString("NUMBER"));
					contacts.add(contact);
				}
				con.close();
			}
			catch(Exception p)
			{
				System.out.println(p+"  error");
			}
			// for(Contact a: contacts)
			// System.out.println(a.getName());
			return contacts;
		}
		public void editContact(Contact contact, int i)
		{
			try
			{
				setConnection();
				stmt=con.prepareStatement("update tab set firstname=?, lastname=?, number=? where id=?");
				stmt.setString(1,contact.getFirstName());
				stmt.setString(2,contact.getLastName());
				stmt.setString(3,contact.getNo());
				stmt.setInt(4,contact.getId());
				stmt.executeUpdate();
				// System.out.println("contact added");
				con.close();
			}catch(Exception p)
			{
				System.out.println(p);
			}
		}
		public  void setId()
		{
		
			id=0;
			
			// if(contacts.size()!=0)
			// {
			// 	id=contacts.get(contacts.size()-1).getId();
			for(Contact a: contacts)
			{
				if(a.getId()>id)
					{
						id=a.getId();
					}
			// System.out.println(" id==i "+a.getId());
			}
			id++; 
			
			// System.out.println(contacts.size()+"===size id=="+id);
			
			
		}
		public void deleteContact(Contact c)
		{
			try
			{
				setConnection();
				stmt=con.prepareStatement("delete from tab where id=?");
				stmt.setInt(1,c.getId());
				stmt.executeUpdate();
				con.close();
			}catch(Exception p)
			{
				System.out.println(p);
			}
		}
		public void clearAllContacts()
		{
			try
			{
				setConnection();
				id=0;
				stmt=con.prepareStatement("truncate table tab");
				stmt.executeUpdate();
				con.close();
			}catch(Exception p)
			{
				System.out.println(p);
			}
		}
		public void sortByFirstName()
		{
	  		try
			{
	  			setConnection();
				contacts.clear();
				rs=stmt.executeQuery("select * from tab order by firstname");
				while(rs.next())
				{
					Contact contact=new Contact();
					contact.setId(rs.getInt("ID"));
					contact.setFirstName(rs.getString("FIRSTNAME"));
					contact.setLastName(rs.getString("LASTNAME"));
					contact.setNo(rs.getString("NUMBER"));
					contacts.add(contact);
				}
				clearAllContacts();
				resetDataBase();
				con.close();
			}catch(Exception e)
			// System.out.println("     "+a.getName());			
			{

			}


	  	}
	  	public void sortByLastName()
	  	{
	  		try
			{
	  			setConnection();
				contacts.clear();
				rs=stmt.executeQuery("select * from tab order by lastname");
				while(rs.next())
				{
					Contact contact=new Contact();
					contact.setId(rs.getInt("ID"));
					contact.setFirstName(rs.getString("FIRSTNAME"));
					contact.setLastName(rs.getString("LASTNAME"));
					contact.setNo(rs.getString("NUMBER"));
					contacts.add(contact);
				}
				clearAllContacts();
				resetDataBase();
				con.close();
			}catch(Exception e)
			// System.out.println("     "+a.getName());			
			{

			}


	  	}
	  	
	  	public void sortById()
	  	{
	  		try
			{
	  			setConnection();
				contacts.clear();
				rs=stmt.executeQuery("select * from tab order by id");
				while(rs.next())
				{
					Contact contact=new Contact();
					contact.setId(rs.getInt("ID"));
					contact.setFirstName(rs.getString("FIRSTNAME"));
					contact.setLastName(rs.getString("LASTNAME"));
					contact.setNo(rs.getString("NUMBER"));
					contacts.add(contact);
				}
				clearAllContacts();
				resetDataBase();
				con.close();
			}catch(Exception e)
			{

			}


	  	}
	  	public void sortByNumber()
	  	{
	  		try
			{
	  			setConnection();
				contacts.clear();
				rs=stmt.executeQuery("select * from tab order by number");
				while(rs.next())
				{
					Contact contact=new Contact();
					contact.setId(rs.getInt("ID"));
					contact.setFirstName(rs.getString("FIRSTNAME"));
					contact.setLastName(rs.getString("LASTNAME"));
					contact.setNo(rs.getString("NUMBER"));
					contacts.add(contact);
				}
				clearAllContacts();
				resetDataBase();
				con.close();
			}catch(Exception e)
			{

			}

		}
		public void resetDataBase()
		{
			try
			{
				setConnection();
			// for(Contact a: contacts)
				for (int i=0;i<contacts.size();i++) 
				{
					// System.out.println(contacts.size()+"=size "+i+"i  "+contacts.get(i).getName());			
					writeNewContact(contacts.get(i),false);
				}
				con.close();
			}catch(Exception e)
			{

			}
		}
		
}
