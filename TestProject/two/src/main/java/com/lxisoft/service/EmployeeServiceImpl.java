package com.lxisoft.service;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.lxisoft.dao.EmployeeDaoImpl;
import com.lxisoft.model.Employee;
 
@Service
@Transactional
public class EmployeeServiceImpl {
 
    @Autowired
    private EmployeeDaoImpl employeeDao;
 
  
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
 
  
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
 
 
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }
 
    public Employee getEmployee(int empid) {
        return employeeDao.getEmployee(empid);
    }
 
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeDao.updateEmployee(employee);
    }
 
    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }
 
}
