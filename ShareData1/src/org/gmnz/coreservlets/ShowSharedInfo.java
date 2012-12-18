package org.gmnz.coreservlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowSharedInfo
 */
public class ShowSharedInfo extends HttpServlet {
   private static final long serialVersionUID = 1L;



   /**
    * @see HttpServlet#HttpServlet()
    */
   public ShowSharedInfo() {
      super();
   }



   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Shared Info";

//@formatter:off
	   out.println(
	         "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\">\n" +
	         "<html>\n" +
            "<head><title>" + title + "</title></head>" +
	         "<body bgcolor=\"#fdf5e6\">" +
            "<h1 align=\"center\">" + title + "</h1>" +
	         "<ul>" +
               "<li>Session:");
//@formatter:on

      HttpSession session = request.getSession(true);
      Enumeration<?> attributes = session.getAttributeNames();
      out.println(getAttributeList(attributes));
      out.println("<li>Current servlet context:");
      ServletContext application = getServletContext();
      attributes = application.getAttributeNames();
      out.println(getAttributeList(attributes));
      out.println("<li>Servlet context of /ShareData1");
      application = application.getContext("/ShareData1");
      if (application == null) {
         out.println("Context sharing is disabled.");
      }
      else {
         attributes = application.getAttributeNames();
         out.println(getAttributeList(attributes));
      }
      out.println("<li>Cookies: <ul>");
      Cookie[] cookies = request.getCookies();
      if (cookies == null || cookies.length == 0) {
         out.println("<li>No cookies found.");
      }
      else {
         Cookie c;
         for (int i = 0; i < cookies.length; i++) {
            c = cookies[i];
            out.println("<li>" + c.getName());
         }
      }
      out.println("</ul></ul></body></html>");
   }



   private String getAttributeList(Enumeration<?> attributes) {
      StringBuffer list = new StringBuffer("   </ul>");
      if (!attributes.hasMoreElements()) {
         list.append("<li>no attributes found");
      }
      else {
         while (attributes.hasMoreElements()) {
            list.append("   <li>");
            list.append(attributes.nextElement());
            list.append("\n");
         }
      }
      list.append("</ul>");
      return list.toString();
   }
}
