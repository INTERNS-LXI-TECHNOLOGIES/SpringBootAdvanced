package com.lxisoft.repository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lxisoft.domain.Contact;
@Repository
public class MysqlRepo {

	@Autowired
	private SessionFactory sessionFactory;
	{System.out.println("mysql{{{{{{{{{{");}
	
	public void set() {
		Contact contact=new Contact();
		contact.setId("1");
		contact.setFName("afdsa");
		contact.setLName("afdsa");
		contact.setNumber("afdsa");
		save(contact);
	}
	
	public void save(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAll()
	{
		List<Contact> x=sessionFactory.getCurrentSession().createQuery("from contacts").list();
		System.out.println("list---"+x);
		System.out.println("mysql111111");
		return x;
	}

}
