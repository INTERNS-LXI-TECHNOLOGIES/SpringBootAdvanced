package com.lxisoft.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.*;

import com.lxisoft.Model.Model1;
import com.lxisoft.Repository.DataRepository;

@Controller

public class Contact {
@RequestMapping(start)
	public String ViewAll(Model1 model)
	 {  
	 DataRepository drr;
	 ArrayList <Contact> contactList = drr.displayAll();
	 model.addAttribute("contacts",contactList);
	 return "ViewAll";
	 }


}