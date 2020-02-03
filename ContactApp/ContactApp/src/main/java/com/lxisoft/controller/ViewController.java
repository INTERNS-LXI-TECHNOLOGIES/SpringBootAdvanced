package com.lxisoft.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.domain.Contact;
import com.lxisoft.repository.MysqlRepo;
import com.lxisoft.repository.Repository;

@Controller
@RequestMapping("/view")
public class ViewController
{
	private Repository repo=new MysqlRepo();
 public ModelAndView getAllContactInfo(HttpServletRequest request, HttpServletResponse response)
 {
	 ArrayList<Contact> contactList=repo.getAllContacts();
	 return mv;
 }
}
