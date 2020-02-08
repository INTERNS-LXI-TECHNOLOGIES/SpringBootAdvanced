package com.lxisoft.servlet;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.lxisoft.repository.*;
import com.lxisoft.model.*;
import com.lxisoft.sqlrepository.*;

public class Select extends HttpServlet
{
	Repository rep = (Repository) new Sqlrepository();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
	{
		Contact contact = new Contact();
    }
}