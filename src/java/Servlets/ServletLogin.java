package Servlets;

import Logica.Controladora;
import Persistencia.ControladoraPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    /* private String legUsuario; */

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        // Obtengo usuario y contraseña desde Login (login)
        String nomUsuario = request.getParameter("usuario");
        String conUsuario = request.getParameter("contra");
        String legUSuario = request.getParameter("legajo");
        int perUSuario = 0  ;   //  Integer.parseInt(request.getParameter("permiso"));        
                
        boolean estaONo = false;
        
        Controladora control = new Controladora();
        String legUsuario = null;
        int legPermiso = 0 ;
        
        // comprobar
        estaONo = control.comprobarIngreso(legUsuario,nomUsuario,conUsuario);
        
        if (estaONo == true ){
            // Verificar que exista la sesión
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", nomUsuario);
            misession.setAttribute("contra", conUsuario);
            misession.setAttribute("legajo", legUsuario);
            misession.setAttribute("control", control);            
            misession.setAttribute("permiso", legPermiso);                        
            
            response.sendRedirect("menuprincipal.jsp");

        }
        else {
            response.sendRedirect("sinusuario.jsp");        
        }
        
        
        //  request.getSession().setAttribute("nomUsuario", nomUsuario);
        //  request.getSession().setAttribute("conUsuario", conUsuario);
        //  response.sendRedirect("menuprincipal.jsp");
        
    }

    public ServletLogin() {
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
