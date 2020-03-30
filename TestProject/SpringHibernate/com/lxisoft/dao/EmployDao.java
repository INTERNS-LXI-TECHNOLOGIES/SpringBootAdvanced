package com.lxisoft.dao;

import java.util.List;
import com.lxisoft.entity.EmployEntity;
public interface EmployDao {
	
	public void addEmployee(EmployEntity employee);
    public List<EmployEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);

}
