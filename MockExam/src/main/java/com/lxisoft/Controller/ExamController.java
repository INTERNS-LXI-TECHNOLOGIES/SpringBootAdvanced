package com.lxisoft.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxisoft.Model.*;
import com.lxisoft.Repository.ExamDao;
@Controller
public class ExamController {
	
	@Autowired
	ExamDao dao;
	
	@RequestMapping("/add")
	public String addQuestions(@RequestParam("question")String question,@RequestParam("opt1")String option1,@RequestParam("opt2")String option2,@RequestParam("opt3")String option3,@RequestParam("opt4")String option4,@RequestParam("answer")String answer)
	{
		ExamModel model = new ExamModel();
		model.setQuestion(question);
		model.setOpt1(option1);
		model.setOpt2(option2);
		model.setOpt3(option3);
		model.setOpt4(option4);
		model.setAnswer(answer);
		dao.insertIntoDatabase(model);
		return "sucessPage";
		
	}
}
