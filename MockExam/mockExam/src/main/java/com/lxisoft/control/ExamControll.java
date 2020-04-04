package com.lxisoft.control;



import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
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
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<ExamModel> listExam = examService.getAllExam();
        model.addObject("listExam", listExam);
        model.setViewName("AdminMenu");
        return model;
    }
 
}
