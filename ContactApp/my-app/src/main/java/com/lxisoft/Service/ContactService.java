package com.lxisoft.Service;
import com.lxisoft.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.Domain.*;
@Service

public class ContactService {
	@Autowired
	DataRepository drr;
	public Contact addContact(Contact cont)
	{
//		DataRepository drr=new DataRepository();
		Contact con=drr.add(cont);
		return con;
	}

}
