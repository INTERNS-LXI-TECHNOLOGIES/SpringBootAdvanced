package com.lxisoft.Controller;
import com.lxisoft.Model.*;
import com.lxisoft.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MockController {
	
	@Autowired
	MockExamDao dao;
	
	@RequestMapping("/add")
	public String addQuestions(@RequestParam("question")String question,@RequestParam("answer")String answer,@RequestParam("option1")String option1,@RequestParam("option2")String option2,@RequestParam("option3")String option3,@RequestParam("option4")String option4)
	{
		Model model = new Model();
		model.setQuestion(question);
		model.setAnswer(answer);
		model.setOption1(option1);
		model.setOption2(option2);
		model.setOption3(option3);
		model.setOption4(option4);
		dao.insertIntoDatabase(model);
		return "sucessPage";
	}
}
