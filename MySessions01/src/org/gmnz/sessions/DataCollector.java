package org.gmnz.sessions;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataCollector
 */
public class DataCollector extends HttpServlet {
   private static final long serialVersionUID = 1L;



   /**
    * @see HttpServlet#HttpServlet()
    */
   public DataCollector() {
      super();
      // TODO Auto-generated constructor stub
   }



   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// HttpSession session = request.getSession();
      Object objCodice = request.getParameter("codice");
      String codice = "";
      if (objCodice != null) {
         codice = objCodice.toString();
      }
      Object objDescrizione = request.getParameter("descrizione");
      String descrizione = "";
      if (objDescrizione != null) {
         descrizione = objDescrizione.toString();
      }
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String docType = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\">\n";
      //@formatter:off
      out.write(docType +
            "<html>\n" +
            "<head><title>Servlet Test</title></head>" +
            "<body bgcolor=\"#fdf5e6\">\n" +
            "<h1>Passaggio di parametri</h1>\n" +

            "<p>Codice: ");
      //@formatter:on
      if (codice.isEmpty()) {
         out.write("<i>nessun codice specificato.</i>");
      }
      else {
         out.write(codice);
      }
      out.write("</p><p>Descrizione: ");
      if (descrizione.isEmpty()) {
         out.write("<i>nessuna descrizione specificata.</i>");
      }
      else {
         out.write(descrizione);
      }
      out.write("</p></body></html>");
   }



   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("sono in POST");
      doGet(request, response);
   }

}
