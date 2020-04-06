package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	 public String addQuestion(@ModelAttribute MockModel mockModel) {
		System.out.println("<<<<<<<<<<<<<"+mockModel.getId());
	        if (mockModel.getId() == 0) {
	            mockService.addMockQuestion(mockModel);
	            return "SuccessAdd";
	        } else {
	            mockService.updateQuestion(mockModel);
	            return "SuccessUpdate";
	        }    
	        
	    }
	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }
	 
	 @RequestMapping(value = "/delete")
     public ModelAndView questionsForDelete(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Delete");
        return model;
	 }
	 
	 @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	    public String deleteQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuestion(questionId);
	        return "SuccessDelete";
	    }
	 
	 @RequestMapping(value = "/update")
     public ModelAndView questionsForUpdate(ModelAndView model) throws IOException {
        List<MockModel> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Update");
        return model;
	 }
	 
	  @RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	    public ModelAndView editQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        MockModel mockModel = mockService.getQuestionId(questionId);
	        ModelAndView model = new ModelAndView("UpdateQuestion");
	        model.addObject("mockModel1", mockModel);
	 
	        return model;
	    }

}
