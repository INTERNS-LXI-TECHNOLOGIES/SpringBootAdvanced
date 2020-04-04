package com.lxisoft.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/")
	public ModelAndView findAllQuestions(ModelAndView model) throws IOException {
		List<ExamModel> listQuestions = examService.findAllQuestions();
		model.addObject("listQuestions", listQuestions);
		model.setViewName("QuestionView");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String addQuestion(@ModelAttribute ExamModel models) {
	        examService.addQuestion(models);
	        return "Admin";
	    }
	 
	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newQuestion(ModelAndView model) {
		ExamModel exam = new ExamModel();
		model.addObject("examModel", models);
		model.setViewName("AddQuestion");
		return model;
	}
	
	 
}		
     



