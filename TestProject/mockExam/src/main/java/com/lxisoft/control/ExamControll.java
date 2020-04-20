package com.lxisoft.control;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.model.ExamModel;
import com.lxisoft.service.ExamService;
 
@Controller
public class ExamControll {
 
 
    public ExamControll() {
        System.out.println("EmployeeController()");
    }
    @Autowired
    private ExamService examService;
    
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
			ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}
  

	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("Admin");
		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}
 
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<ExamModel> listExam = examService.getAllExam();
        model.addObject("listExam", listExam);
        model.setViewName("Display");
        return model;
    }
    
    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public void startExam(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	 List<ExamModel> listExam = examService.getAllExam();
    	 HttpSession session= request.getSession(true);
    	 session.setAttribute("exam",listExam );
    	 response.sendRedirect("Exam.jsp?qcount=0");
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView listDelete(ModelAndView model) throws IOException {
        List<ExamModel> listDelete = examService.getAllExam();
        model.addObject("listExam", listDelete);
        model.setViewName("Delete");
        return model;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView listUpdate(ModelAndView model) throws IOException {
        List<ExamModel> listUpdate = examService.getAllExam();
        model.addObject("listExam", listUpdate);
        model.setViewName("Update");
        return model;
    }
        
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newExam(ModelAndView model) {
        ExamModel exam = new ExamModel();
        model.addObject("exam", exam);
        model.setViewName("Add");
        return model;
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() throws IOException {
        
    	 return new ModelAndView("Admin");
       
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveExam(@ModelAttribute ExamModel exam) {
      
            examService.addExam(exam);
        return new ModelAndView("Admin");
    }
    
    @RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
    public ModelAndView deleteExam(HttpServletRequest request) {
        int examSlno = Integer.parseInt(request.getParameter("slno"));
        examService.deleteExam(examSlno);
        return new ModelAndView("Admin");
    }
    
    @RequestMapping(value = "/updateExam", method = RequestMethod.GET)
    public ModelAndView updateExam(HttpServletRequest request) {
        int examSlno = Integer.parseInt(request.getParameter("slno"));
        ExamModel exam = examService.getExam(examSlno);
        ModelAndView model = new ModelAndView("Add");
        model.addObject("exam", exam);
 
        return model;
    }
    @RequestMapping(value = "/start", method = RequestMethod.GET)
	  public ModelAndView seletedOption(HttpServletRequest request, HttpServletResponse response) throws IOException
	  {
		  HttpSession sessions = request.getSession(true);
		  int selectedOption =  Integer.parseInt(request.getParameter("opt"));
		  int count = Integer.parseInt(request.getParameter("qcount"));
		  @SuppressWarnings("unchecked")
		  List<ExamModel> listQuestions = (List<ExamModel>)sessions.getAttribute("exam");
		  
		  if(selectedOption == 1)
		  {
			  listQuestions.get(count-1).setSelectedOption(1);  
		  }
		  else if(selectedOption == 2)
		  {
			  listQuestions.get(count-1).setSelectedOption(2);  
		  }
		  else if(selectedOption == 3)
		  {
			  listQuestions.get(count-1).setSelectedOption(3);  
		  }
		  else if(selectedOption == 4)
		  {
			  listQuestions.get(count-1).setSelectedOption(4);  
		  }
		  sessions.setAttribute("listQuestions", listQuestions);
		  ModelAndView model = new ModelAndView("Exam");
		  return model;
	  }
    @RequestMapping(value = "/result", method = RequestMethod.GET)
	public String resultExam(HttpServletRequest request)
	  {
		  int resultCount = 0;
		  HttpSession sessions = request.getSession(true);
		@SuppressWarnings("unchecked")
		List<ExamModel> listQuestions = (List<ExamModel>)sessions.getAttribute("listQuestions");
		  for(int i =0;i<listQuestions.size();i++)
		  {
			if(listQuestions.get(i).getAns()==(listQuestions.get(i).getSelectedOption()))
			{
				resultCount++;
			}
		  }
		  sessions.setAttribute("Result", resultCount);		  
		  return "Result";
	  }
    }
 

