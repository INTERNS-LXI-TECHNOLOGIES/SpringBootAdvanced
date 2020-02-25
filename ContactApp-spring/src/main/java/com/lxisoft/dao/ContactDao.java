package com.lxisoft.dao;
import com.lxisoft.model.*;
import java.util.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Repository

public class Contactdao implements ContactdaoImp
{
	@PersistenceContext
	 private EntityManager manager;
	
	ArrayList <Contact> contactList = new ArrayList<Contact>();
	public void write(Contact contact)
	{
		
		 manager.persist(contact);
	}
	
	public List<Contact> read()
	{
 
		List<Contact> contactlist = manager.createQuery("Select a From Contact a", Contact.class).getResultList();
        return contactlist;
		
    }
//	public ArrayList <Contact> read()
//	{
//		ArrayList<Contact> contactList=(ArrayList<Contact>) sessionFactory.getCurrentSession().createQuery("from Contact").list();
//		return contactList;
//	}
	public void edit(Contact contact)
	{ 
		manager.merge(contact);
		
	}

    public void delete(int id)
	{
    	Contact contact =manager.find(Contact.class, id);
    	manager.remove(contact);
		//manager.remove(manager.contains(id) ? id : manager.merge(id));
    	//manager.createQuery("delete from Contact c  where c.id=:"+id);
    }
	
//	public ArrayList<Contact> search(String name)
//	{
//		ArrayList <Contact> searchtList = new ArrayList<Contact>();
//		try
//		{
//			Statement s = con.createStatement();
//			 rs = s.executeQuery("select * from contact where concat(firstname,' ',lastname) LIKE '%"+name+"%'");
//			while(rs.next())
//			{
//				Contact contact = new Contact();
//				contact.setId(rs.getInt("id"));
//				contact.setFirstname(rs.getString("firstname"));
//				contact.setLastname(rs.getString("lastname"));
//				contact.setNumber(rs.getString("number"));
//				searchtList.add(contact);
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		return searchtList;
//
//		}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		
//	}
		
}