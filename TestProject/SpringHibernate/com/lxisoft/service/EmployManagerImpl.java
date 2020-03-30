package com.lxisoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.lxisoft.dao.EmployDao;
import com.lxisoft.entity.EmployEntity;

@Service
public class EmployManagerImpl {
	
	   @Autowired
	    private EmployDao employeeDAO;
	    @Override
	    @Transactional
	    public void addEmployee(EmployEntity employee) {
	        employeeDAO.addEmployee(employee);
	    }
	    @Override
	    @Transactional
	    public List<EmployEntity> getAllEmployees() {
	        return employeeDAO.getAllEmployees();
	    }
	    @Override
	    @Transactional
	    public void deleteEmployee(Integer employeeId) {
	        employeeDAO.deleteEmployee(employeeId);
	    }
	    public void setEmployeeDAO(EmployDao employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }
	

}
