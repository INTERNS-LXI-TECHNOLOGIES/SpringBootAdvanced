package com.lxisoft.RunWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import com.lxisoft.RunWay.repository.HomeRepository;



@Service
public class HomeService {
    @Autowired
    HomeRepository repo;

    public String home(Model model) {
      model.addAttribute("msgs", repo.findAll());
      return "login";
       
    }

}