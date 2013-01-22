package org.gmnz.servlet.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gmnz.servlet.ServletUtil;

public class StartPageServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;



   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType(ServletUtil.XHTML_DOCTYPE);
      HttpSession session = request.getSession();
      String nome = (String) session.getAttribute("nome");
      String numero = (String) session.getAttribute("numero");
      PrintWriter out = response.getWriter();
      out.write(ServletUtil.XML_PREAMBLE);
      out.write(ServletUtil.XHTML_OPENING);
      out.write("<body>");
      out.write("<h1>Main page</h1>");
      out.write("<p>This is the main page</p>");
      out.write("<p>You are logged as " + Login.composeNameAndNumber(nome, numero) + "</p>");
      out.write("<p>Here you can <a href=\"logout\">logout</a>.</p>");
      out.write("</body>");
      out.write("</html>");
   }

}
