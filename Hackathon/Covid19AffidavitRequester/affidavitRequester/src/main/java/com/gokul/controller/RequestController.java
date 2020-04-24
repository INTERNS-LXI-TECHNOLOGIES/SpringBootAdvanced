package com.gokul.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gokul.entity.Request;
import com.gokul.exception.ResourceNotFoundException;
import com.gokul.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {

    private static final Logger LOG = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private RequestService requestService;

    @GetMapping("/list")
    public String listRequest(Model theModel) {
        List < Request > theRequest = requestService.getRequest();
        theModel.addAttribute("request", theRequest);
        return "display";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Request theRequest = new Request();
        theModel.addAttribute("request", theRequest);
        return "request-form";
    }
    
    @GetMapping("/loginPage")
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


    @PostMapping("/saveRequest")
    public String saveRequest(@ModelAttribute("request") Request theRequest) {
        requestService.saveRequest(theRequest);
        return "redirect:/request/list";
    }


    @GetMapping("/delete")
    public String deleteRequest(@RequestParam("requestId") int theId) throws ResourceNotFoundException {
        requestService.deleteRequest(theId);
        return "redirect:/customer/list";
    }
}

