package com.lxisoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="EMPLOYEE")
public class EmployEntity {
	
	@Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
 
    @Column(name="FIRSTNAME")
    private String firstname;
 
    @Column(name="LASTNAME")
    private String lastname;
 
    @Column(name="EMAIL")
    private String email;
 
    @Column(name="TELEPHONE")
    private String telephone;
    
    public int getId()
    {
    	return id;
    }
    public void setFirstName(String firstName)
    {
    	this.firstname = firstName;
    }
    public String getFirstName()
    {
    	return firstname;
    }
    public void setLastName(String lastName)
    {
    	this.lastname = lastName;
    }
    public String getLastName()
    {
    	return lastname;
    }
    public void setEmail(String email)
    {
    	this.email = email;
    }
    public String getEmail()
    {
    	return email;
    }
    public void setTelephone(String telephone)
    {
    	this.telephone = telephone;
    }
    public String getTelephone()
    {
    	return telephone;
    }
    

}
