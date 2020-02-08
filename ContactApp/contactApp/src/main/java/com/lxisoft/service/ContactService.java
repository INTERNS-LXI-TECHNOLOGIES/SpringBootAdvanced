package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.domain.Contact;
import com.lxisoft.model.ContactListModel;
import com.lxisoft.model.ContactModel;
import com.lxisoft.repository.MysqlRepository;

@Service 

public class ContactService {
	
	@Autowired
	public List<ContactModel> getAllContact()
	{
		MysqlRepository dbrepo=new MysqlRepository();
		List<Contact>contactList=dbrepo.findAllContact();
		ContactListModel listModel=new ContactListModel();
	
		for(int i=0;i<contactList.size();i++)
	    {
	    	ContactModel contact=new ContactModel();
	    	contact.setId(contactList.get(i).getContactId());
	    	contact.setFirstName(contactList.get(i).getContactFirstName());
	    	contact.setLastName(contactList.get(i).getContactLastName());
	    	listModel.setContactListModel(contact);
	    }
		return listModel.getContactListModel();
	}
	public Contact addContact(Contact cont)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		Contact c=dbrepo.saveContact(cont);
		return c;
	}
	public Contact getContact(int idd)
	{
		MysqlRepository dbrepo=new MysqlRepository();
		Contact contact=dbrepo.findContactById(idd);
		return contact;
	}

}
