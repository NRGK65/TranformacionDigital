/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import static Logica.Controladora.deStringToDate;
import static Logica.Controladora.getFechaActual;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import java.time.Instant;
import java.util.Date;  
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nestor
 */

@WebServlet(name = "ServletAltaLicencia", urlPatterns = {"/ServletAltaLicencia"})
public class ServletAltaLicencia extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //  Date tmpfechaI ;        
        //  Date tmpfechaF ;
        
        String idDocume = request.getParameter("idDoc") ;
        int idSect  = 1 ;    //  Integer.parseInt(request.getParameter("permiso")) ;        
        String idLegajo = request.getParameter("idLeg") ;

        String tmpfechP = request.getParameter("feactual");
        String tmpfechI = request.getParameter("feinicio");        
        String tmpfechF = request.getParameter("fefinal");  
        Date tmpfechaP = deStringToDate(getFechaActual());        
        Date tmpfechaI = deStringToDate(tmpfechI);
        Date tmpfechaF = deStringToDate(tmpfechF);
        int numDias = Integer.parseInt(request.getParameter("nrodias")) ;
        String txtEstado = "1" ;
        String txtDiagno = request.getParameter("txtDiagnos") ;
        String txtDomici = request.getParameter("txtDomicilio") ;
        String txtPostal = request.getParameter("txtCodPostal") ;
        String txtLocali = request.getParameter("txtLocalidad") ;
        String txtTelefo = request.getParameter("txtTelefono") ;
        String txtCorreo = request.getParameter("txtCorreo") ;
        String txtPermis = "1" ;        //  request.getParameter("") ;
        String txtObser  = request.getParameter("txtObserva") ;
        String txtFirma1 = "123" ;      //  request.getParameter("txtDiagnos") ;
        String txtFirma2 = "456 " ;
        // Part comproba = request.getPart("txtArchivo") ;
        

        Controladora control = new Controladora();

        response.sendRedirect("licenciasAltas.jsp");
        //  response.sendRedirect("resultados.jsp");   
        try {
            control.crearLicenciaAlta(idDocume, idSect, idLegajo, tmpfechaP, tmpfechaI, tmpfechaF, numDias,
                    txtEstado, txtDiagno, txtDomici, txtPostal, txtLocali, txtTelefo, txtCorreo, txtPermis, 
                    txtObser, txtFirma1, txtFirma2 );
        } catch (Exception ex) {
            Logger.getLogger(ServletAltaLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
                

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
