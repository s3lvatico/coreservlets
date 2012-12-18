package org.gmnz.coreservlets;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieSender1
 */
public class SendSharedInfo extends HttpServlet {
   private static final long serialVersionUID = 1L;



   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(true);
      session.setAttribute("SessionTest", "Session Entry One");

      ServletContext context = getServletContext();
      context.setAttribute("ServletContextTest", "Servlet Context Entry One");

      Cookie c1 = new Cookie("cookieTest1", "Cookie One");
      c1.setMaxAge(3600);
      response.addCookie(c1);

      Cookie c2 = new Cookie("cookieTest2", "Cookie Two");
      c2.setMaxAge(3600);
      c2.setPath("/");
      response.addCookie(c2);

      String url = request.getContextPath() + "/servlet/org.gmnz.coreservlets.ShowSharedInfo";
      url = response.encodeRedirectURL(url);
      response.sendRedirect(url);

   }

}
