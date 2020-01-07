package com.lxisoft.temp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.temp.model.Sports;
import com.lxisoft.temp.service.SportsService;

/*@RequestMapping("/api")*/
@RestController
public class SportsController {
	@Autowired
	SportsService sportsService;
	@GetMapping("/request")
	public List<Sports> findAll() throws IOException
	{
		return sportsService.findAll();
	}
	
	@GetMapping("range/{start}/{end}")
	public List<Sports> findAllByRange(@PathVariable Integer start,@PathVariable Integer end) throws IOException
	{
		return sportsService.findAllByRange(start,end);
	}
	@GetMapping("bool/{name}/{start}/{end}")
	public List<Sports> findAllByBool(@PathVariable String name,@PathVariable Integer start,@PathVariable Integer end) throws IOException
	{
		return sportsService.findAllByBool(name,start,end);
	}
	
	@GetMapping("filter/{name}")
	public List<Sports> findAllUsingMustAndFilter(@PathVariable String name) throws IOException
	{
		return sportsService.findAllUsingMustAndFilter(name);
	}
	@GetMapping("mustnot/{name}")
	public List<Sports> findAllUsingMustnot(@PathVariable String name) throws IOException
	{
		return sportsService.findAllUsingMustnot(name);
	}
	
	@GetMapping("should/{name}/{start}/{end}") 
	public List<Sports> findAllUsingShould(@PathVariable String name,@PathVariable Integer start,@PathVariable Integer end)throws IOException
	{
		return sportsService.findAllUsingShould(name,start,end);
	}
	@GetMapping("Usingfilter/{name}")
	public List<Sports> findAllUsingFilter(@PathVariable String name)throws IOException
	{
		return sportsService.findAllUsingFilter(name);
	}
	@GetMapping("sort/{name}")
	public List<Sports> findAllUsingSort(@PathVariable String name)throws IOException
	{
		return sportsService.findAllUsingSort(name);
	}
	@GetMapping("sortByAge/{name}")
	public List<Sports> sortByAge(@PathVariable String name)throws IOException
	{
		return sportsService.sortByAge(name);
	}
	@GetMapping("sortByName")
	public List<Sports> sortByAgeAndName()throws IOException
	{
		return sportsService.sortByName();
	}
	@GetMapping("orderByName")
	public List<Sports> orderByName()throws IOException
	{
		return sportsService.orderByName();
	}
	@GetMapping("orderByNameAndAge")
	public List<Sports> orderByNameAndAge()throws IOException
	{
		return sportsService.orderByNameAndAge();
	}
	@GetMapping("UsingBoolSortByAge/{name1}")
	public List<Sports> findAllUsingBoolSortByAge(@PathVariable String name1)throws IOException
	{
		return sportsService.findAllUsingBoolSortByAge(name1);
	}
	/*
	@GetMapping("sortByAgeAndName")
	public List<Sports> sortByAgeAndName()throws IOException
	{
		return sportsService.sortByAgeAndName();
	}*/
}
