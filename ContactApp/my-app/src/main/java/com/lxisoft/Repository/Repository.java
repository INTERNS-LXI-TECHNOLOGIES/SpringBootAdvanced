package com.lxisoft.Repository;
import com.lxisoft.Domain.Contact;
import java.io.*;
import java.util.*;

public interface Repository

{

public ArrayList <Contact> getFromFile();
public Contact add(Contact c);
public void delete(int id);
public Contact edit(int id,String name,String number);
//public ArrayList <Contact>  sortName();

}