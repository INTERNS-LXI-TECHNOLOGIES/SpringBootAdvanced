package com.lxisoft.Repository;
import com.lxisoft.Domain.Contact;
import com.lxisoft.Model.SortName;
import java.io.*;
import java.util.*;

public interface Repository1

{

public ArrayList <Contact> getFromFile();
public void add(Contact c);
public void delete(int id);
public void edit(int id,String newname);
public ArrayList <Contact>  sortName();

}