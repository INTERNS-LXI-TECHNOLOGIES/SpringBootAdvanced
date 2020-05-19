package com.lxisoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lxisoft.entity.Customer;
import com.lxisoft.exception.ResourceNotFoundException;
import com.lxisoft.service.CustomerServiceImpl;

@Controller
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerServiceImpl customerService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
			ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}

    @RequestMapping(value = "/check", method = RequestMethod.GET)
   	public String checkPage() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		if(hasRole)
		{
			return "redirect:/list";
		}
		else
		{
			return "redirect:/user";
		}
   	}

    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model theModel) {
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String displayInstructions(Model theModel) {
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "instructions";
    }
    
    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public String startExam(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	 List<Customer> listExam =  customerService.getCustomers();
    	 HttpSession session= request.getSession(true);
    	 session.setAttribute("exam",listExam );
    	 return "Exam";
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "redirect:/list";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged outsuccessfully.");
		}

		model.setViewName("loginPage");
		return model;
	}


    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/list";
    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public String showFormForUpdate(@RequestParam("customerId") int theId,
        Model theModel) throws ResourceNotFoundException {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
        customerService.deleteCustomer(theId);
        return "redirect:/list";
    }
    
    @RequestMapping(value = "/start", method = RequestMethod.GET)
	  public ModelAndView seletedOption(HttpServletRequest request, HttpServletResponse response) throws IOException
	  {
		  HttpSession sessions = request.getSession(true);
		  int selectedOption =  Integer.parseInt(request.getParameter("opt"));
		  int count = Integer.parseInt(request.getParameter("qcount"));
		  @SuppressWarnings("unchecked")
		  List<Customer> listQuestions = (List<Customer>)sessions.getAttribute("exam");
		  
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
	public String resultExam(HttpServletRequest request,Model theModel)
	  {
		  int resultCount = 0;
		  HttpSession sessions = request.getSession(true);
		  HttpSession session1 = request.getSession(true);
		  List<Integer>select=new ArrayList<Integer>();
		@SuppressWarnings("unchecked")
		List<Customer> listQuestions = (List<Customer>)sessions.getAttribute("listQuestions");
		  for(int i =0;i<listQuestions.size();i++)
		  {
			  select.add(listQuestions.get(i).getSelectedOption());
			if(listQuestions.get(i).getAns()==(listQuestions.get(i).getSelectedOption()))
			{
				resultCount++;
			}
		  }
		  sessions.setAttribute("Result", resultCount);
		  session1.setAttribute("select", select);
		  List < Customer > theCustomers = customerService.getCustomers();
	        theModel.addAttribute("customers", theCustomers);
		  return "Result";
	  }
  

}
