package com.lxisoft.Repository;
import com.lxisoft.Domain.Contact;
import com.lxisoft.Model.SortName;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DataRepository  
{
  
  public ArrayList <Contact> displayAll()
  {   ArrayList <Contact> contactsList = new ArrayList <Contact>();   
  	  try{ 
        
          Class.forName("com.mysql.jdbc.Driver");  
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
          Statement stmt=con.createStatement();  
          ResultSet rs=stmt.executeQuery("select * from contactlist");  
      
        while(rs.next())  
          {
            Contact c = new Contact();
            c.setId(rs.getInt("ID"));
            c.setName(rs.getString("NAME"));
            c.setNumber(rs.getString("NUMBER"));
            contactsList.add(c);
          }
           con.close();  
          }catch(Exception e){ System.out.println(e);}  
          return contactsList;
  }
  public Contact findById(int id)
  {       Contact c=null;
   try{
       Class.forName("com.mysql.jdbc.Driver");  
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");   
       Statement stmt=con.createStatement();  
       ResultSet rs=stmt.executeQuery("select * from contactlist where id ='"+id+"'");

        while(rs.next())  
          {
            c = new Contact();
            c.setId(rs.getInt("ID"));
            c.setName(rs.getString("NAME"));
            c.setNumber(rs.getString("NUMBER"));
          }
           con.close();  
          }catch(Exception e){ System.out.println(e);}  
          return c;
  }

  public Contact add(Contact c)
   {
  try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");   
    Statement stmt=con.createStatement();  
    stmt.executeUpdate("insert into contactlist(name,number) values(  '"+c.getName()+"','"+c.getNumber()+"')");  
    con.close();  
   
    }catch(Exception e){ System.out.println(e);} 
     return c;
   }


   public Contact edit(int id,String name,String number)
   {
    String query = "update contactlist set name ='"+name+"',number ='"+number+"' where id = '"+id+"'";
    System.out.println(query);
    Contact c=new Contact();
    c.setName(name);
    c.setNumber(number);
    c.setId(id);
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            con.close();
           }catch(Exception e){System.out.println(e);}
           return c;
   }
   
   // 
   public void delete(int id)
   {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
        Statement stmt=con.createStatement();
        stmt.executeUpdate("delete from contactlist where id = '"+id+"'");
        con.close();
       
    }catch(Exception e){}
   }
}





   // public String edit(String name,String newname,String newnumber)
   // {
   //  try{
   //      Class.forName("com.mysql.jdbc.Driver");  
   //      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
   //      Statement stmt=con.createStatement();
   //      if(newname==null)
   //      {
   //        stmt.executeUpdate("update contactlist set name ='"+newname+"' where name = '"+name+"'");
   //      //ResultSet rs = stmt.executeQuery("select * from contactlist");

   //      //while(rs.next())

   //      con.close();
   //     }
   //     }catch(Exception e){System.out.println(e);}
   // }
   // public void edit()
   // {
   //  try{
   //      Class.forName("com.mysql.jdbc.Driver");  
   //      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
   //      Statement stmt=con.createStatement();

   //     }

   // }

//public void editByName(String name,String newname)
   // {
   //  try{
   //      Class.forName("com.mysql.jdbc.Driver");  
   //      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
   //      Statement stmt=con.createStatement();
   //      stmt.executeUpdate("update contactlist set name ='"+newname+"' where name = '"+name+"'");
   //      con.close();
   //     }catch(Exception e){System.out.println(e);}
   // }

   // public void editByNumber(String name,String newnumber)
   // {
   //  try{
   //      Class.forName("com.mysql.jdbc.Driver");  
   //      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");  
   //      Statement stmt=con.createStatement();
   //      stmt.executeUpdate("update contactlist set number ='"+newnumber+"' where name = '"+name+"'");
   //      con.close();
   //     }catch(Exception e){System.out.println(e);}
   // }