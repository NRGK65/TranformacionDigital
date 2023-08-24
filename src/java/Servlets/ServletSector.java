/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Sector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Nestor
 */
@WebServlet(name = "ServletAltaSector", urlPatterns = {"/ServletAltaSector"})
public class ServletSector extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        /*
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
          
            out.println("</body>");
            out.println("</html>");
        }
        */


       
        int codigoS = Integer.parseInt(request.getParameter("codSector")) ;        
        String nombreS = request.getParameter("nomSector");
        String responS = request.getParameter("resSector");
        String areaS = request.getParameter("areSector");
               
        boolean estaONo = false;
                
        Controladora control = new Controladora();
                
        // comprobar
        estaONo = control.comprobarSector(codigoS, nombreS, responS, areaS)  ;
                
        if (estaONo == false ){
            // Verificar que exista la sesión
                         
            response.sendRedirect("sectorAlta.jsp");
            //  response.sendRedirect("resultados.jsp");   
            try {
                //  Controladora control = new Controladora();
                
                control.crearSector(codigoS, nombreS, responS, areaS);
            } catch (Exception ex) {
                Logger.getLogger(ServletSector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            
            JOptionPane.showMessageDialog(null, "Código Sector Repetido", "Alerta", JOptionPane.WARNING_MESSAGE) ;
            response.sendRedirect("sectorAlta.jsp");
            
            // response.sendRedirect("sinusuario.jsp");        
        }
           
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}


