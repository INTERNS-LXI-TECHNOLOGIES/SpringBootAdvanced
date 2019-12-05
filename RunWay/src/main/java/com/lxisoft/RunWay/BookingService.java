package com.lxisoft.RunWay;
 
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
