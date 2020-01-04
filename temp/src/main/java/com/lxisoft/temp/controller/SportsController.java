package com.lxisoft.temp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.temp.model.Sports;
import com.lxisoft.temp.service.SportsServiceImpl;

@RestController
public class SportsController {
	@Autowired
	SportsServiceImpl sportsServiceImpl;
	@GetMapping("/request/{name}")
	public Sports getName(@PathVariable String name) throws IOException
	{
		return sportsServiceImpl.findByName(name);
	}
}
