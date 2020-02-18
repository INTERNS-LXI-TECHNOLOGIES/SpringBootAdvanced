package com.lxisoft.dao;
import com.lxisoft.model.*;
import java.util.*;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class Sqlrepository
{
	@Autowired
	private SessionFactory sessionFactory;
	
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
		
	sessionFactory.getCurrentSession().save(contact);	
	}
	
	public ArrayList <Contact> read()
	{
		ArrayList<Contact> contactList=(ArrayList<Contact>) sessionFactory.getCurrentSession().createQuery("from Contact").list();
		return contactList;
	}
	public void edit(Contact contact)
	{ 
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}
	public void delete(int id)
	{
		sessionFactory.getCurrentSession().delete(id);
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