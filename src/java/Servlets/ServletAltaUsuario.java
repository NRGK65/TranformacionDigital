
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import Persistencia.ControladoraPersistencia;
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

@WebServlet(name = "ServletAltaUsuario", urlPatterns = {"/ServletAltaUsuario"})
public class ServletAltaUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String legajo = request.getParameter("legajo") ;
        String usuario = request.getParameter("usuario") ;
        String contras = request.getParameter("contra") ;
        int permiso = Integer.parseInt(request.getParameter("permiso")) ;
        
               
        response.sendRedirect("altaUsuario.jsp");
        Controladora control = new Controladora();
        
        try {
            control.crearUsuario (legajo, usuario, contras, permiso);
        } catch (Exception ex) {
            Logger.getLogger(ServletAltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
    }

        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
