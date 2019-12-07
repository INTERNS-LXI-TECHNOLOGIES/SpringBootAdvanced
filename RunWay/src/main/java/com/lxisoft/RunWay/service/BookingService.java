package com.lxisoft.RunWay.service;
 
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.BookedDetail;
import com.lxisoft.RunWay.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository repo;

	public BookedDetail saveBooking(BookedDetail bookedDetail) {
		// TODO Auto-generated method stub
		 
		return repo.save(bookedDetail);
	}

	public List<BookedDetail> fetchBookingdetails() {
		// TODO Auto-generated method stub
		 return repo.findAll();
	}

 
 

}
