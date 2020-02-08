package com.lxisoft.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;
import com.lxisoft.Domain.*;
import com.lxisoft.Model.Model1;
import com.lxisoft.Repository.DataRepository;

@Controller
public class ContactController {
	

	@Autowired
	DataRepository drr ;
	 
	@RequestMapping("start")
	public String ViewAll(Model1 model)
	{  
		ArrayList<Contact> contactList = drr.displayAll();
		model.addAttribute("contacts",contactList);
		System.out.println(contactList.size());
		return "ViewAll";
	}
    

}