package com.lxisoft.repository;
import java.sql.*;
import java.util.*;
import com.lxisoft.domain.Contact;
import com.lxisoft.model.*;
import org.apache.log4j.Logger;
/**
 *class: repository for mysql operation
 */
public class MysqlRepository
{
	final static Logger logger = Logger.getLogger(MysqlRepository.class);
	List <Contact> contactList=new ArrayList<Contact>();
	Connection con=null;
	PreparedStatement ps=null;
	{
		try
		{
			databaseConnection();
			createStorage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *to get database connection
	 */
	public void databaseConnection()
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");

			// con.close();
		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	} 
	/**
	 *to create table
	 */
	public void createStorage()
	{
		try
		{
			Statement s=con.createStatement();
			s.executeUpdate("create table if not exists ContactList(ID int,FIRST_NAME varchar(20),LAST_NAME varchar(20),NUMBER varchar(20))");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *to read all contact from database
	 *
	 *@return arraylist of contact
	 */
	public List<Contact> findAllContact()
	{
		
		try
		{
			contactList.clear();
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from ContactList");
			while(rs.next())
			{
				Contact c=new Contact();
				c.setContactId(rs.getInt("ID"));
				c.setContactFirstName(rs.getString("FIRST_NAME"));
				c.setContactLastName(rs.getString("LAST_NAME"));			
				c.setContactNumber(rs.getString("NUMBER"));
				contactList.add(c);				
			}
			s.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return contactList; 
	}
	/**
	 *to get contact id
	 *
	 *@return contact id
	 */
	public int getContactId()
	{
		int id=1;

		try
		{
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select ID from ContactList");
			while(rs.next())
			{
				id=rs.getInt("ID");
				id++;
			}
			s.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	/**
	 *to write contact in to database
	 *
	 *@param contact contact containing id,name and number
	 */
	public Contact saveContact(Contact contact)
	{
		try
		{
			ps=con.prepareStatement("insert into ContactList(ID,FIRST_NAME,LAST_NAME,NUMBER) values(?,?,?,?)");
			int id=getContactId();
			contact.setContactId(id);
			ps.setInt(1,id);
			ps.setString(2,contact.getContactFirstName());
			ps.setString(3,contact.getContactLastName());
			ps.setString(4,contact.getContactNumber());
			int x=ps.executeUpdate();
			System.out.println(""+x);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return contact;
	}
	/**
	 *to read contact from database with the desired id
	 *
	 *@return contact
	 */
	public Contact findContactById(int n)
	{
		logger.warn("This is warn : " + n);
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " +n);
		}
		
		logger.error("This is error : " + n);
		
		contactList=findAllContact();
		Contact contact=new Contact();
		for(int i=0;i<contactList.size();i++)
		{
			if((contactList.get(i).getContactId())==(n))
			{
				contact=contactList.get(i);
			}
		}
		return contact;
	}
	/**
	 *to delete contact
	 *
	 *@param n integer value
	 */
	public void deleteContact(int n)
	{
		try
		{
			ps=con.prepareStatement("delete from ContactList where id=?");
			ps.setInt(1,n);
			ps.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *to update contact
	 *
	 *@param n integer value
	 *@param c contact
	 */
	public Contact updateContact(int n,Contact c)
	{
		try
		{
			PreparedStatement pst=con.prepareStatement("update ContactList set FIRST_NAME=?,LAST_NAME=?,NUMBER=? where ID=?");
			pst.setString(1,c.getContactFirstName());
			pst.setString(2,c.getContactLastName());
			pst.setString(3,c.getContactNumber());
			pst.setInt(4,n);
			pst.execute();
			c.setContactId(n);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return c;
	}
	/**
	 *to delete all contact
	 */
	public void deleteAllContact()
	{
		try
		{
			Statement s=con.createStatement();
			int x=s.executeUpdate("truncate ContactList");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 *to sort contact by number
	 *
	 *@return arraylist of contact
	 */
	public List <Contact> sortByNumber()
	{
		contactList.clear();
		contactList=findAllContact();
		Collections.sort(contactList, new SortByNumber());
		return contactList;
	}
	/**
	 *to sort contact by name
	 *
	 *@return arraylist of contact
	 */
	public List <Contact> sortByName()
	{
		contactList.clear();
		contactList=findAllContact();
		Collections.sort(contactList, new SortByName());
		return contactList;
	}
	/**
	 *to sort contact by id
	 *
	 *@return arraylist of contact
	 */
	public List <Contact> sortById()
	{
		contactList.clear();
		contactList=findAllContact();
		Collections.sort(contactList, new SortById());
		return contactList;
	}	  
}