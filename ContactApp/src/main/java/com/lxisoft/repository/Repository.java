package com.lxisoft.repository;
import com.lxisoft.model.*;
import java.util.ArrayList;
import com.lxisoft.domain.*;

public interface Repository
{
	public void save(Contact contact);
	public ArrayList<Contact> findAll();
	public void edit(EditModel editModel,String[] tempEdit);
	public void delete(Contact contact);
	public ArrayList<Contact> search(String searchName);
	public ArrayList<Contact> sort(String type);
	public void clear();
}
