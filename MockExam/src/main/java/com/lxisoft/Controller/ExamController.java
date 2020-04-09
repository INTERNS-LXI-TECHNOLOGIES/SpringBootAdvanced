package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.model.ExamModel;
import com.lxisoft.service.ExamService;

@Controller
public class ExamController {

	private static final Logger logger = Logger
			.getLogger(ExamController.class);

	public ExamController() {
		System.out.println("ExamController()");
	}	

	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/firstpage")
	public ModelAndView listExam(ModelAndView model) throws IOException {
		List<ExamModel> listExam = examService.getAllExams();
		model.addObject("listExam", listExam);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		ExamModel examModel = new ExamModel();
		model.addObject("examModel", examModel);
		model.setViewName("ExamForm");
		return model;
	}

	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public String saveExam(@ModelAttribute ExamModel examModel) {
		if (examModel.getId() == 0) { 
			examService.addExam(examModel);
		} else {
			examService.updateExam(examModel);
		}
		return ("Succes");
	}

	@RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
	public String deleteExam(HttpServletRequest request) {
		int examId = Integer.parseInt(request.getParameter("id"));
		examService.deleteExam(examId);
		return ("Succes");
	}

	@RequestMapping(value = "/editExam", method = RequestMethod.GET)
	public ModelAndView editQuestiont(HttpServletRequest request) {
		int examId = Integer.parseInt(request.getParameter("id"));
		ExamModel examModel = examService.getExam(examId);
		ModelAndView model = new ModelAndView("ExamForm");
		model.addObject("examModel", examModel);

		return model;
	}

	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public ModelAndView displayInstruction(HttpServletRequest request) {
			 return new ModelAndView("Instruction");
	}
	
	 
	@RequestMapping(value = "/startExam", method = RequestMethod.GET)
    public String startExam(HttpServletRequest request) throws IOException {
    	 List<ExamModel> listExam = examService.getAllExams();
    	 HttpSession session= request.getSession(true);
    	 session.setAttribute("exam",listExam );
    	 return "QuestionView";
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView displayResult(HttpServletRequest request) {
			 return new ModelAndView("Result");
	}
}