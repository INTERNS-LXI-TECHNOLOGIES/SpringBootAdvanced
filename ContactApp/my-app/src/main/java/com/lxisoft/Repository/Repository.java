package com.lxisoft.Repository;
import com.lxisoft.Domain.Contact;
import com.lxisoft.Model.SortName;
import java.io.*;
import java.util.*;


public class Repository implements Repository1
{

 static int id;
 //File file = new File("Contact1.csv");
 public ArrayList <Contact> getFromFile()
  {
     ArrayList <Contact> filelist = new  ArrayList <Contact>(); 
    // TreeSet<Contact> ts=new TreeSet<Contact>(); 
    try{
    String data,name,number;
    FileReader fr = new FileReader("Contact1.csv");
    BufferedReader br = new BufferedReader(fr);
    boolean x=false;
    while((data=br.readLine())!= null)
    {
      if(x){
      String []datas=data.split(",");
      id=Integer.valueOf(datas[0]);
      name = datas[1];
      number=datas[2];
      Contact c = new Contact();
       c.setName(name);
      c.setNumber(number);
      c.setId(id);
      filelist.add(c);
     // System.out.println("name:"+name);
     // ts.add(c);
      //filelist.add(c);
    }//filelist.addAll(ts);
    //System.out.println("Treeset"+filelist.size());
     //filelist.remove(0); 
    x=true;
    }
    }catch(Exception e){}
    return filelist;
   }
  

   public void add(Contact c)
   {
    c.setId(++id);
    try{
      FileWriter fr = new FileWriter("Contact1.csv",true);
      fr.write("\n"+c.getId()+","+c.getName()+","+c.getNumber());
      fr.close();
      
       }catch(IOException e){}
   }
   public void delete(int id)
   {
    try{
        ArrayList <Contact> filelist=getFromFile();
        FileWriter fr = new FileWriter("Contact1.csv");
        for(int i=0;i<filelist.size();i++)
        {
         if(id==filelist.get(i).getId())
         {
          
         }
         else{
       
      FileWriter fr1 = new FileWriter("Contact1.csv",true);
      fr1.write("\n"+filelist.get(i).getId()+","+filelist.get(i).getName()+","+filelist.get(i).getNumber());
      fr1.close();
      
         }
        }
       }catch(IOException e){}
   }
  

   public void edit(int id,String newname)
   {
    try{
        ArrayList <Contact> filelist=getFromFile();
        FileWriter fr = new FileWriter("Contact1.csv");
         for(int i=0;i<filelist.size();i++)
         {
            FileWriter fr1 = new FileWriter("Contact1.csv",true);
           if(id==filelist.get(i).getId())
             {
               fr1.write("\n"+filelist.get(i).getId()+","+newname+","+filelist.get(i).getNumber());
             }
          else
             {
               fr1.write("\n"+filelist.get(i).getId()+","+filelist.get(i).getName()+","+filelist.get(i).getNumber());
             }
         fr1.close();
         }
       }catch(IOException e){}
    }
    public ArrayList <Contact>  sortName()
    {  System.out.println("repo sortname");
       ArrayList <Contact> filelist=getFromFile();
       //filelist.clear();
       Collections.sort(filelist,new SortName());
       for(int i=0;i<filelist.size();i++)
       {
       System.out.println(filelist.get(i).getName());
     }
       return filelist;       
       
       
    }
}