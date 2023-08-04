
package Servlets;

import Logica.Controladora;
import Logica.Sector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nestor
 */
@WebServlet(name = "ServletEditarSector", urlPatterns = {"/ServletEditarSector"})
public class ServletEditarSector extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        int idEditar = Integer.parseInt(request.getParameter("idSector")) ;
        Controladora control = new Controladora();
        Sector sect = control.buscarSector (idEditar) ;
        
        HttpSession misession = request.getSession();
        misession.setAttribute("sector", sect);
        response.sendRedirect("sectorEditar_1.jsp");        
    
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        int idEditar = Integer.parseInt(request.getParameter("codSector")) ;
        String nomSector = request.getParameter("nomSector");
        String resSector = request.getParameter("resSector");
        String areSector = request.getParameter("areSector");

        Controladora control = new Controladora();
        Sector sect = control.buscarSector (idEditar) ;
        //  sect.setIdSector(idEditar);
        sect.setNombreSector(nomSector);
        sect.setNombreResponsable(resSector);
        sect.setAreaSector(areSector);
        
        try {
            control.modificarSector(sect) ;
        } catch (Exception ex) {
            Logger.getLogger(ServletEditarSector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // request.getSession().setAttribute("listaSectores", control.getListaSector() );
                      
        response.sendRedirect("sectorEditar.jsp");        
        
    
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
