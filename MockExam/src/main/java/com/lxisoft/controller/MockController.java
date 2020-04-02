package com.lxisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.*;
import com.lxisoft.service.*;

@Controller
public class MockController {
	
	@Autowired
	private MockService mockService;
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        MockModel mockModel = new MockModel();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String addQuestion(@ModelAttribute MockModel mockModel)
	    {
		System.out.println("<<<<<<<<<<<<<<<<"+mockModel.getQuestion());
	        mockService.addMockQuestion(mockModel);
	        return "Admin";
	    }

}
