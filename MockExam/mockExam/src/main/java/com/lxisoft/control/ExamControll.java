package com.lxisoft.control;



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

import com.lxisoft.model.ExamModel;
import com.lxisoft.service.ExamService;
 
@Controller
public class ExamControll {
 
 
    public ExamControll() {
        System.out.println("EmployeeController()");
    }
 
    @Autowired
    private ExamService examService;
 
    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<ExamModel> listExam = examService.getAllExam();
        model.addObject("listExam", listExam);
        model.setViewName("Display");
        return model;
    }
    
    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public String startExam(HttpServletRequest request) throws IOException {
    	 List<ExamModel> listExam = examService.getAllExam();
    	 HttpSession session= request.getSession(true);
    	 session.setAttribute("exam",listExam );
    	 return "Exam";
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
 
}
