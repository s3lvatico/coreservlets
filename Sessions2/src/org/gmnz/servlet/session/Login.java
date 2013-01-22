package org.gmnz.servlet.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gmnz.servlet.ServletUtil;

public final class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;



   public Login() {
      super();
   }



   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String nome = request.getParameter("usrNome");
      String numero = request.getParameter("usrNumero");
      HttpSession session = request.getSession();
      session.setAttribute("nome", nome);
      session.setAttribute("numero", numero);
      response.setContentType(ServletUtil.XHTML_DOCTYPE);
      PrintWriter out = response.getWriter();
      out.write(ServletUtil.XML_PREAMBLE);
      out.write(ServletUtil.XHTML_OPENING);
      out.write("<body>");
      out.write("<p>Benvenuto " + composeNameAndNumber(nome, numero) + "</p>");
      out.write("<form action=\"main\" method=\"post\">");
      out.write("<input type=\"submit\" value=\"continua\"/>");
      out.write("</form>");
      out.write("</body>");
      out.write("</html>");
   }



   public static String composeNameAndNumber(String nome, String numero) {
      return String.format("%s (%s)", nome, numero);
   }

}
