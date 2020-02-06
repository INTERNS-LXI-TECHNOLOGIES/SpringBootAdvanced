package com.lxisoft.Model;
import com.lxisoft.Domain.Contact;
import java.util.Comparator;
public class SortName implements Comparator <Contact>
{
	 public int compare(Contact c1,Contact c2) 
    { 
        return c1.getName().compareTo(c2.getName()); 
    } 
}