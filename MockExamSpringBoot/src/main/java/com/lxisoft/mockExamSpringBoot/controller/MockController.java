package com.lxisoft.mockExamSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lxisoft.mockExamSpringBoot.entity.MockEntity;
import com.lxisoft.mockExamSpringBoot.service.*;
@Controller
public class MockController {
	
	@Autowired
	private MockService mockService;
	
	@GetMapping("/")
	public String homeView(){
		return "home";
	}
	
	@GetMapping("/admin")
	public String adminView() {
		return "Admin";
	}
	
	@GetMapping("/user")
	public String userView() {
		return "Introduction";
	}
		
	 @GetMapping("/addQuestion")
     public ModelAndView newContact(ModelAndView model) {
        MockEntity mockEntity = new MockEntity();
        model.addObject("mockEntity", mockEntity);
        model.setViewName("Add");
        return model;
    }

	 @GetMapping("/add")
	 public String addQuestion(@ModelAttribute MockEntity mockEntity) {
		 
		 mockService.saveQuestion(mockEntity);
		 
		 return "Admin";
	 }
	 
	 @GetMapping("/getAllQuestion")
	 public ModelAndView getAllQuestion(ModelAndView model) {
		 List<MockEntity> listQuestions = mockService.getAllQuestions();
		 model.addObject("listQuestions", listQuestions);
	     model.setViewName("View");
		 return model;
	 }
}
