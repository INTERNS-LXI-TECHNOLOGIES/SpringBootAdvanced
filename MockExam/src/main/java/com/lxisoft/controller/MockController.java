package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.entity.*;
import com.lxisoft.service.*;

@Controller
public class MockController {
	
	@Autowired
	private MockService mockService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String homePage()
//	{
//		return "Home";
//	}
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
		@RequestParam(value = "logout",	required = false) String logout) {
			
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid Credentials provided.");
			}

			if (logout != null) {
				model.addObject("message", "Logged out from JournalDEV successfully.");
			}

			model.setViewName("Sample1");
			return model;
		}
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String getadministeration()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		if(hasUserRole)
		{
			return "Admin";
		}
		else
		{
			return "Introduction";
		}
		
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String getUser()
	{
		return "Introduction";
	}
	
	@RequestMapping(value = "/logoutUser",method = RequestMethod.GET)
	public String userLogOut()
	{
		return "Logout";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) { 
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }
	
	@RequestMapping(value="/confirmation", method=RequestMethod.GET)
    public String confirmation() { 
        return "Confirmation";  
    }
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String admin() { 
        return "Admin";  
    }
	
	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllQuestions(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("View");
        return model;
    }
	 
	 @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
     public ModelAndView newContact(ModelAndView model) {
        MockEntity mockModel = new MockEntity();
        model.addObject("mockModel", mockModel);
        model.setViewName("Add");
        return model;
    }
	 
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String addQuestion(@ModelAttribute MockEntity mockModel) {
		
	            mockService.saveQuestion(mockModel);
	            return "Admin";
	            
	 }
	 
	 @RequestMapping(value = "/delete")
     public ModelAndView questionsForDelete(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Delete");
        return model;
	 }
	 
	 @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	    public String deleteQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        mockService.deleteQuestion(questionId);
	        return "redirect:/delete";
	    }
	 
	 @RequestMapping(value = "/update")
     public ModelAndView questionsForUpdate(ModelAndView model) throws IOException {
        List<MockEntity> listQuestions = mockService.getAllQuestions();
        model.addObject("listQuestions", listQuestions);
        model.setViewName("Update");
        return model;
	 }
	 
	 	@RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	    public ModelAndView editQuestion(HttpServletRequest request) {
	        int questionId = Integer.parseInt(request.getParameter("id"));
	        Optional<MockEntity> mockModel = mockService.getQuestionId(questionId);
	        ModelAndView model = new ModelAndView("UpdateQuestion");
	        model.addObject("mockModel1", mockModel);
	 
	        return model;
	    }
	 	
	 	@RequestMapping(value = "/userQuestion")
	     public String userQuestionDisplay(HttpServletRequest request) throws IOException {
	        List<MockEntity> listQuestions = mockService.getAllQuestions();
	        HttpSession sessions = request.getSession(true);
	        sessions.setAttribute("listQuestions", listQuestions);
	       return "ExamQuestion";
		 }
	 	
	 	@RequestMapping(value = "/selectOption", method = RequestMethod.GET)
		  public ModelAndView seletedOption(HttpServletRequest request)
		  {
			  HttpSession sessions = request.getSession(true);
			  int selectedOption = 0;
			  if(request.getParameter("option")!= null)
			  {
				   selectedOption =  Integer.parseInt(request.getParameter("option"));
			  }
			  
			  int count = Integer.parseInt(request.getParameter("count"));
			  @SuppressWarnings("unchecked")
			  List<MockEntity> listQuestions = (List<MockEntity>)sessions.getAttribute("listQuestions");
			  
			  switch(selectedOption) 
			  {
			  case 1 :
				  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption1());
				  break;
			  case 2 :
				  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption2());
				  break;
			  case 3 :
				  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption3());
				  break;
			  case 4 :
				  listQuestions.get(count-1).setSelectedOption(listQuestions.get(count-1).getOption4());
				  break;
			  default :
				  listQuestions.get(count-1).setSelectedOption("");
				  break;
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
			List<MockEntity> listQuestions = (List<MockEntity>)sessions.getAttribute("listQuestions");
			  for(int i =0;i<listQuestions.size();i++)
			  {
				if(listQuestions.get(i).getAnswer().equals(listQuestions.get(i).getSelectedOption()))
				{
					result++ ;
				}
			  }
			  sessions.setAttribute("Result", result);		  
			  return "Result";
		  }
}
