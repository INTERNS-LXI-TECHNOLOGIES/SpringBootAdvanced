package com.lxisoft.service;


import java.util.List;
 
import com.lxisoft.entity.EmployEntity;
public interface EmployManager {
	
	public void addEmployee(EmployEntity employee);
    public List<EmployEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);

}
