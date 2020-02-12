package com.lxisoft.sqlrepository;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.servlet.*;
import java.sql.*;
import java.io.*;
public class Sqlrepository
{
	ArrayList <Contact> contactList = new ArrayList<Contact>();
	Connection con; 
	ResultSet rs ;
	PreparedStatement stmnt; 
	{
		sqlrepository();
	}

	public void sqlrepository()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abhijith","root","root");
        }  
        catch(Exception e)
        {
        	System.out.println(e);
        }                             
	}
	
	public void write(Contact contact)
	{
		
		try
		{
			
	     	stmnt = con.prepareStatement("insert into contact (firstname,lastname,number)values(?,?,?)");
			stmnt.setString(1,contact.getFirstname());
			stmnt.setString(2,contact.getLastname());
			stmnt.setString(2,contact.getNumber());
			
			stmnt.executeUpdate();
		
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
	public ArrayList <Contact> read()
	{
		try
		{
			contactList.clear();
			Statement s = con.createStatement();
			 rs = s.executeQuery("select * from contact");
			while(rs.next())
			{
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setFirstname(rs.getString("firstname"));
				contact.setLastname(rs.getString("lastname"));
				contact.setNumber(rs.getString("number"));
				contactList.add(contact);

			}
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return contactList;
	}
	public void edit(Contact contact)
	{ 
		try
		{
		stmnt = con.prepareStatement("update contact set firstname=?,lastname=?,number=? where id =?");
		stmnt.setString(1,contact.firstname);
		stmnt.setString(2,contact.lastname);
		stmnt.setString(3,contact.number);
		stmnt.setInt(4,contact.id);
		stmnt.executeUpdate();
		}
		catch(Exception e)
		{

		}
		
	}
	public void delete(int id)
	{
		try
		{
		stmnt = con.prepareStatement("delete from contact where id = ? ");
		stmnt.setInt(1,id);
		stmnt.executeUpdate();

		}
		catch(Exception ee)
		{

		}
	}
	public void clear()
	{
		try
		{
			stmnt= con.prepareStatement("TRUNCATE TABLE contact");
			stmnt.executeUpdate();
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
	public ArrayList<Contact> search(String name)
	{
		ArrayList <Contact> searchtList = new ArrayList<Contact>();
		try
		{
			Statement s = con.createStatement();
			 rs = s.executeQuery("select * from contact where concat(firstname,' ',lastname) LIKE '%"+name+"%'");
			while(rs.next())
			{
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setFirstname(rs.getString("firstname"));
				contact.setLastname(rs.getString("lastname"));
				contact.setNumber(rs.getString("number"));
				searchtList.add(contact);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return searchtList;

		}
		
}