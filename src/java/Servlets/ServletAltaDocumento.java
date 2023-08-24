/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nestor
 */
@WebServlet(name = "ServletAltaDocumento", urlPatterns = {"/ServletAltaDocumento"})
public class ServletAltaDocumento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);       

        
        String codiDoc = request.getParameter("codigoDoc") ;
        String descDoc = request.getParameter("descriDoc") ;
        String desdDo = request.getParameter("desdeDoc") ;
        String hastDo = request.getParameter("hastaDoc") ;
        String vigeDo = request.getParameter("vigenciaDoc") ;
        String tiemDo = request.getParameter("tiempoDoc");
        String tipoDo = request.getParameter("tipoDoc") ;
        String temiDo = request.getParameter("tipoEmisorDoc") ;
        String nombDo = request.getParameter("nombreEmisorDoc") ;

        String desdDoc = "x" ;
        String hastDoc = "x" ;
        String vigeDoc = "x" ;
        String tiemDoc = "x" ;
        String tipoDoc = "x" ;
        String temiDoc = "x" ;
        String nombDoc = "x" ;
            
        if (!Objects.isNull(desdDo)){
            desdDoc = "S" ;
        };
        
        if (!Objects.isNull(hastDo)) {
            hastDoc = "S" ;
        } ;
        
        if (!Objects.isNull(vigeDo)) {
            vigeDoc = "S" ;
        };
                
        if (!Objects.isNull(tiemDo)) {
            tiemDoc = "S" ;
        };

        if (!Objects.isNull(tipoDo)) {
            tipoDoc = "S" ;
        };
                
        if (!Objects.isNull(temiDo)) {
            temiDoc = "S" ;
        };
        
        if (!Objects.isNull(nombDo)) {
            nombDoc = "S" ;
        };

        /*
        desdDoc = request.getParameter("desdeDoc") ;
        hastDoc = request.getParameter("hastaDoc") ;
        vigeDoc = request.getParameter("vigenciaDoc") ;
        tiemDoc = request.getParameter("tiempoDoc") ;
        tipoDoc = request.getParameter("tipoDoc") ;
        temiDoc = request.getParameter("tipoEmisorDoc") ;
        nombDoc = request.getParameter("nombreEmisorDoc") ;
        */

        
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
            
            out.println("<h2> 1    " + request.getParameter("codigoDoc") + "     " + codiDoc + "</h2>") ;       
            out.println("<h2> 2    " + request.getParameter("descriDoc") + "     " + descDoc + "</h2>");
            out.println("<h2> 3    " + request.getParameter("desdeDoc") + "     " + desdDoc + "</h2>");
            out.println("<h2> 4    " + request.getParameter("hastaDoc") + "     " + hastDoc + "</h2>");
            out.println("<h2> 5    " + request.getParameter("vigenciaDoc") + "     " + vigeDoc + "</h2>");          
            out.println("<h2> 6    " + request.getParameter("tiempoDoc") + "     " + tiemDoc + "</h2>");
            out.println("<h2> 7    " + request.getParameter("tipoDoc") + "     " + tipoDoc + "</h2>");
            out.println("<h2> 8    " + request.getParameter("tipoEmisorDoc") + "     " + temiDoc + "</h2>");
            out.println("<h2> 9    " + request.getParameter("nombreEmisorDoc") + "     " + nombDoc + "</h2>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
        */
               
        response.sendRedirect("documentoAlta.jsp");
        Controladora control = new Controladora() ;
        
        try {
            control.crearDatoDocumento(codiDoc, descDoc, desdDoc, hastDoc, vigeDoc, tiemDoc, tipoDoc, temiDoc, nombDoc );
        } catch (Exception ex) {
            Logger.getLogger(ServletAltaDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
