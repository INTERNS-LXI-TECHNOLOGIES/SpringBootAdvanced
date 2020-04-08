package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	 @RequestMapping(value = "/addQuestions", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
        MockModel mockModel = new MockModel();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String addQuestion(@ModelAttribute MockModel mockModel) 
	 {
	    mockService.addMockQuestion(mockModel);
	    return "DoneAdd";
	 }

	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }

     @RequestMapping(value = "/delete")
     public ModelAndView removeQuestion(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Delete");
        return model;
    }

	 @RequestMapping(value = "/deleteQuest", method = RequestMethod.GET)
	    public String deleteQuest(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuest(questionId);
	        return "deleteDone";
	 }
}