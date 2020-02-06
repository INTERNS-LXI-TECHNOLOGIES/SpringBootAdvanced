package com.lxisoft.RunWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.model.BookedDetail;
import com.lxisoft.RunWay.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService service;	
	@PostMapping("/booking")
	public BookedDetail saveCustomer(@RequestBody BookedDetail bookedDetail ){
	    
	    return service.saveBooking(bookedDetail);
	}
	@GetMapping("/booking")
	public List<BookedDetail> readBookingDetails() {
		return service.fetchBookingdetails();
	}

	}
