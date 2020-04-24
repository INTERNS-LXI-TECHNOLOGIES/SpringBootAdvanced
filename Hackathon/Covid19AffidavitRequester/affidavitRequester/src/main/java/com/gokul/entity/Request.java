package com.gokul.entity;


import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REQUEST")
public class Request implements Serializable {
	 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int slnoGok;
 
    @Column
    private String nameGok;
    @Column
    private String mobGok;
    @Column
    private String vehTypeGok;
    @Column
    private String adressGok;
    @Column
    private String startGok;
    @Column
    private String destGok;
    @Column
    private String copassGok;
    @Column
    private String relatnGok;
    @Column
    private String reasonGok;
    @Column
    private String startDateAndTimeGok;
    @Column
    private String endDateAndTimeGok;
    @Column
    private int vechNoGok;
 
    public int getSlnoGok() {
        return slnoGok;
    }
 
    public void setSlnoGok(int slnoGok) {
        this.slnoGok = slnoGok;
    }
 
    public String getNameGok() {
        return nameGok;
    }
    public String getMobGok() {
        return mobGok;
    }
    public String getVehTypeGok() {
        return vehTypeGok;
    }
    public String getAdressGok() {
        return adressGok;
    }
    public String getStartGok() {
        return startGok;
    }
    public String getDestGok() {
        return destGok;
    }
    public String getCopassGok() {
        return copassGok;
    }
    public String getRelatnGok() {
        return relatnGok;
    }
    public String getReasonGok() {
        return reasonGok;
    }
    public String getStartDateAndTimeGok() {
        return startDateAndTimeGok;
    }
    public String getEndDateAndTimeGok() {
        return endDateAndTimeGok;
    }
    public int getVechNoGok() {
        return vechNoGok;
    }
 
    public void setNameGok(String nameGok) {
        this.nameGok = nameGok;
    }
    public void setMobGok(String mobGok) {
        this.mobGok = mobGok;
    }
    public void setVehTypeGok(String vehTypeGok) {
        this.vehTypeGok = vehTypeGok;
    }
    public void setAdressGok(String adressGok) {
        this.adressGok = adressGok;
    }
    public void setStartGok(String startGok) {
        this.startGok = startGok;
    }
    public void setDestGok(String destGok) {
        this.destGok = destGok;
    }
    public void setCopassGok(String copassGok) {
        this.copassGok = copassGok;
    }
    public void setRelatnGok(String relatnGok) {
        this.relatnGok = relatnGok;
    }
    public void setReasonGok(String reasonGok) {
        this.reasonGok = reasonGok;
    }
    public void setStartDateAndTimeGok(String startDateAndTimeGok) {
        this.startDateAndTimeGok = startDateAndTimeGok;
    }
    public void setEndDateAndTimeGok(String endDateAndTimeGok) {
        this.endDateAndTimeGok = endDateAndTimeGok;
    }
    public void setVechNoGok(int vechNoGok) {
        this.vechNoGok = vechNoGok;
    }
 
}
