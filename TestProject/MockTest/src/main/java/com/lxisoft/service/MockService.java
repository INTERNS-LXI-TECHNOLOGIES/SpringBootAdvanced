package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.model.MockModel;
import com.lxisoft.dao.MockDao;

@Service
@Transactional
public class MockService {
	
//	@Autowired
//	private MockDao mockDao;
//	
//	 public List < MockModel > getQuestions() {
//	        return mockDao.findAll();
//	    }
//	 
//	  public void saveQuestions(MockModel mockModel) {
//	        mockDao.save(mockModel);
//	    }
	  
	/*
	 * public Customer getCustomer(int id) throws ResourceNotFoundException { return
	 * customerRepository.findById(id).orElseThrow( () - > new
	 * ResourceNotFoundException(id)); }
	 * 
	 * @Override
	 * 
	 * @Transactional public void deleteCustomer(int theId) {
	 * customerRepository.deleteById(theId); }
	 */

}
