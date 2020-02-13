package com.lxisoft.repository;
import java.util.*;
import java.io.*;
import com.lxisoft.controller.*;
import com.lxisoft.model.*;
public interface Repository
{
	public void sqlrepository();
	public void delete(int id);
	public void write(Contact contact);
	public void clear();
	public  ArrayList <Contact> read();
	public void edit(Contact contact);
	public ArrayList<Contact> search(String name);
}