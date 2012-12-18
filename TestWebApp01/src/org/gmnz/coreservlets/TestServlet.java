package org.gmnz.coreservlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;



   /**
    * @see HttpServlet#HttpServlet()
    */
   public TestServlet() {
      super();
      // TODO Auto-generated constructor stub
   }



   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\">\n";
      //@formatter:off
      out.write(docType +
            "<html>\n" +
            "<head><title>Servlet Test</title></head>" +
            "<body bgcolor=\"#fdf5e6\">\n" +
            "<h1>Servlet test</h1>\n" +
            "<p>URL you used: " + request.getRequestURL() + "</p>\n" +
            "</body></html>");
      //@formatter:on

   }



   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
