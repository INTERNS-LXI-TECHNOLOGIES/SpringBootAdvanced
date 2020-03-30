package com.lxisoft.dao;


import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.lxisoft.entity.EmployEntity;
@Repository
public class EmployDaoImpl {
	
	  @Autowired
	    private SessionFactory sessionFactory;
	    @Override
	    public void addEmployee(EmployEntity employee) {
	        this.sessionFactory.getCurrentSession().save(employee);
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<EmployEntity> getAllEmployees() {
	        return this.sessionFactory.getCurrentSession().createQuery("from EmployEntity").list();
	    }
	    @Override
	    public void deleteEmployee(Integer employeeId) {
	        EmployEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
	                EmployEntity.class, employeeId);
	        if (null != employee) {
	            this.sessionFactory.getCurrentSession().delete(employee);
	        }
	    }

}
