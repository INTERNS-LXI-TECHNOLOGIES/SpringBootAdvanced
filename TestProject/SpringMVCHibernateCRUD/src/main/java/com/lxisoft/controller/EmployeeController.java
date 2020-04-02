package com.lxisoft.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.service.*;
import com.lxisoft.model.*;

@Controller
public class EmployeeController {
	
	 	@Autowired
	    private EmployeeService employeeService;
	 	
	 	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	    public ModelAndView newContact(ModelAndView model) {
	        Employee employee = new Employee();
	        model.addObject("employee", employee);
	        model.setViewName("EmployeeForm");
	        return model;
	    }
	 	
	 	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	    public String saveEmployee(@ModelAttribute Employee employee) {
	    	
	    	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< : "+employee.getName());
	    	
//	    	employee.addAttribute("employee",new Employee());
//	        if (employee.getId() == 0) { // if employee id is 0 then creating the
//	            // employee other updating the employee
//	            employeeService.addEmployee(employee);
//	        } else {
//	            employeeService.updateEmployee(employee);
//	        }
	    	employeeService.addEmployee(employee);
	        return ("redirect:home.jsp");
	    }
//	 	@RequestMapping(value = "/", method = RequestMethod.GET)
//	    public String listEmployees(ModelMap map)
//	    {
//	        map.addAttribute("employee", new Employee());
//	        map.addAttribute("employeeList", employeeService.getAllEmployees());
//	        return "editEmployeeList";
//	    }
//	 	 @RequestMapping(value = { "/newEmployee" }, method = RequestMethod.GET)
//	     public String newEmployee(ModelMap model) {
//	         Employee employee = new Employee();
//	         model.addAttribute("employee", employee);
//	         model.addAttribute("edit", false);
//	         return "EmployeeForm";
//	     }
//	 	@RequestMapping("/newEmployee")
//	 	public String newEmployee(Map<String, Object> model) {
//	 	    Employee employee = new Employee();
//	 	    model.put("employee", employee);
//	 	    return "EmployeeForm";
//	 	}
	 
	    @RequestMapping(value = "/")
	    public ModelAndView listEmployee(ModelAndView model) throws IOException {
	        List<Employee> listEmployee = employeeService.getAllEmployees();
	        model.addObject("listEmployee", listEmployee);
	        model.setViewName("home");
	        return model;
	    }
	 
	    
	    
	    
	 
	    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	    public ModelAndView deleteEmployee(HttpServletRequest request) {
	        int employeeId = Integer.parseInt(request.getParameter("id"));
	        employeeService.deleteEmployee(employeeId);
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	        int employeeId = Integer.parseInt(request.getParameter("id"));
	        Employee employee = employeeService.getEmployee(employeeId);
	        ModelAndView model = new ModelAndView("EmployeeForm");
	        model.addObject("employee", employee);
	 
	        return model;
	    }

}
