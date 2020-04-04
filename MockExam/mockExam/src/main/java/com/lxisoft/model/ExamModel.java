package com.lxisoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOCK")
public class ExamModel implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int slno;
 
    @Column
    private String qn;
 
    public int getSlno() {
        return slno;
    }
 
    public void setSlno(int slno) {
        this.slno = slno;
    }
 
    public String getQn() {
        return qn;
    }
 
    public void setQn(String qn) {
        this.qn = qn;
    }
 
}


