package com.lxisoft.sqlrepository;
import com.lxisoft.model.*;
import java.util.*;
import com.lxisoft.repository.*;
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
			
	     	stmnt = con.prepareStatement("insert into contacts (firstname,lastname,number)values(?,?,?)");
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
			 rs = s.executeQuery("select * from contacts");
			while(rs.next())
			{
				Contact contact= new Contact();
				contact.setFirstname(rs.getString(""));
				contact.setLastname(rs.getString(""));
				
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
		
}