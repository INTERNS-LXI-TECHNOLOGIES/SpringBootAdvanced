package com.lxisoft.models;

public class ContactModel 
{
		private String firstName;
		private String lastName;
		private int id;
		
		public void setId(int id)
		{
			this.id=id;
		}
		public void setFirstName(String firstName)
		{ 
			this.firstName=firstName;
		}
		
		public void setLastName(String lastName)
		{ 
			this.lastName=lastName;
		}
			
		public String getFirstName()
		{
			return this.firstName;
		}
		
		public String getLastName()
		{
			return this.lastName;
		}
		
		public String getFullName()
		{
			return this.firstName+ " " +this.lastName;
		}
		
		public int getId()
		{
			return this.id;
		}
	
}
