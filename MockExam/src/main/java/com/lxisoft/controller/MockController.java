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
	  
	  @RequestMapping(value = "/userQuestion")
	     public String userQuestionDisplay(HttpServletRequest request) throws IOException {
	        List<MockModel> listQuestions = mockService.getAllQuestions();
	        HttpSession sessions = request.getSession(true);
	        sessions.setAttribute("listQuestions", listQuestions);
	       return "ExamQuestion";
		 }
	  @RequestMapping(value = "/selectOption", method = RequestMethod.GET)
	  public ModelAndView seletedOption(HttpServletRequest request)
	  {
		  HttpSession sessions = request.getSession(true);
		  int selectedOption =  Integer.parseInt(request.getParameter("option"));
		  int count = Integer.parseInt(request.getParameter("count"));
		  @SuppressWarnings("unchecked")
		  List<MockModel> listQuestions = (List<MockModel>)sessions.getAttribute("listQuestions");
		  
		  if(selectedOption == 1)
		  {
			  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption1());  
		  }
		  else if(selectedOption == 2)
		  {
			  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption2());  
		  }
		  else if(selectedOption == 3)
		  {
			  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption3());  
		  }
		  else if(selectedOption == 4)
		  {
			  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption4());  
		  }
		  sessions.setAttribute("listQuestions", listQuestions);
		  ModelAndView model = new ModelAndView("ExamQuestion");
		  return model;
	  }
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String resultCalculation(HttpServletRequest request)
	  {
		  int result = 0;
		  HttpSession sessions = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<MockModel> listQuestions = (List<MockModel>)sessions.getAttribute("listQuestions");
		  for(int i =0;i<listQuestions.size();i++)
		  {
			if(listQuestions.get(i).getAnswer().equals(listQuestions.get(i).getSelectedOption()))
			{
				result++;
			}
		  }
		  sessions.setAttribute("Result", result);		  
		  return "Result";
	  }

}
