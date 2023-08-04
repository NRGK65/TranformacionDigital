/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nestor
 */
@WebServlet(name = "ServletBuscarSector", urlPatterns = {"/ServletBuscarSector"})
public class ServletBuscarSector extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h2> 1    " + request.getParameter("codSector") + "</h2>") ;       
            out.println("<h2> 1a    " + Integer.parseInt(request.getParameter("codSector")) + "</h2>") ;       
            out.println("<h2> 2    " + request.getParameter("nomSector") + "</h2>");
            out.println("<h2> 3    " + request.getParameter("resSector") + "</h2>");
            out.println("<h2> 4    " + request.getParameter("perSector") + "</h2>");
            out.println("<h2> 4    " + request.getParameter("idSector") + "</h2>");          
            
            out.println("</body>");
            out.println("</html>");
        }
                
        
        
    }

    // int id = Integer.parseInt(request.getParameter("idBorrar"));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
