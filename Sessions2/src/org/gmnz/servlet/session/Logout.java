package org.gmnz.servlet.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gmnz.servlet.ServletUtil;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
   private static final long serialVersionUID = 1L;



   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType(ServletUtil.XHTML_DOCTYPE);
      HttpSession session = request.getSession();
      session.invalidate();
      PrintWriter out = response.getWriter();
      out.write(ServletUtil.XML_PREAMBLE);
      out.write(ServletUtil.XHTML_OPENING);
      out.write("<body>");
      out.write("<h1>Bye.</h1>");
      out.write("<p>You have successfully logged out.</p>");
      out.write("</body>");
      out.write("</html>");
   }

}
