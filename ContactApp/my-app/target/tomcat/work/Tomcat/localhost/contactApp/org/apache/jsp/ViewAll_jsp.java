/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-02-12 06:32:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lxisoft.Domain.*;
import com.lxisoft.Model.*;
import java.util.*;
import java.io.*;

public final class ViewAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<title>CONTACTS </title>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<h1><center>CONTACT LIST</center></h1>\n");
      out.write("<body>\n");
      out.write("\t<table align=\"center\" border= \"5\" width=\"30%\" border color= \"red\" bgcolor=\"yellow\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>ID</th>\n");
      out.write("\t\t\t<th>NAME</th>\n");
      out.write("\t\t\t<th>NUMBER</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("table {\n");
      out.write("  font-family: arial, sans-serif;\n");
      out.write("  border-collapse: collapse;\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write("td, th {\n");
      out.write("  border: 1px solid #dddddd;\n");
      out.write("  text-align: left;\n");
      out.write("  padding: 8px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("tr:nth-child(even) {\n");
      out.write("  background-color: #dddddd;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<a href=\"Add.jsp\"><h1><center>ADD<center></h1></a>\n");
      out.write("\t<form action = \"Search\" method = \"post\">\n");
      out.write("\t  Name   : <input type=\"text\" name=\"name\"><br>\n");
      out.write("\t\t  <input type=\"submit\" value=\"SEARCH\"></form>\n");
      out.write("\t\n");

ArrayList<Contact> c=(ArrayList<Contact>)request.getAttribute("contacts");
for(int i=0;i<c.size();i++)
{

      out.write("\n");
      out.write("\t<tr>\n");
      out.write("\t\t <td>");
      out.print((c.get(i).getId()));
      out.write(" </td>\n");
      out.write("\t\t <td>");
      out.print((c.get(i).getName()));
      out.write(" </td>\n");
      out.write("\t\t  <td>");
      out.print((c.get(i).getNumber()));
      out.write(" </td>\n");
      out.write("\t\t  ");

		  	Contact co=new Contact();
		  	co=c.get(i);
		  	session.setAttribute("contact",co);
		    String urldel = "Delete?id=" + c.get(i).getId();
		  
      out.write("\n");
      out.write("\t\t  <td><form action=\"Edit.jsp\">\n");
      out.write("\t\t  \t<input type=\"hidden\" name=\"id\" value=\"");
      out.print((c.get(i).getId()));
      out.write("\">\n");
      out.write("\t\t  \t<input type=\"submit\" name=\"EDIT\" value=\"EDIT\"></form>\n");
      out.write("\t\t  <td><a href=\"");
      out.print(urldel);
      out.write("\"><h4>DELETE</h4></a>\n");
      out.write("\t</tr>\n");

}

      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
