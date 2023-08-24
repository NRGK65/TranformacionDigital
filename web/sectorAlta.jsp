<%-- 
    Document   : sectorAlta
    Created on : 2023 Jul Nov 29, 21:12:35
    Author     : Nestor
--%>


<%@page import="Logica.Sector"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="ES">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro Web Ver 0.1.0 | Alta Sectores</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">  
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">  
  
</head>
<body id="page-top" class="hold-transition skin-green-light sidebar-mini">
  
    
        <%
        HttpSession misession = request.getSession(false);
        String usu = (String) request.getSession().getAttribute("usuario");
        String usu2 = (String) request.getSession().getAttribute("contra");
        int permi = (int) request.getSession().getAttribute("permiso");        
        
        if (usu == null) {
            response.sendRedirect ("sinusuario.jsp");        
        }else {
            Controladora control = new Controladora();
            misession.setAttribute("control", control);
            
        }
                
        %>
          
        <%@include file="template/layouts/header.jsp"%>
     
        <!-- <p> Nombre: <%=session.getAttribute("usuario")%></p>       comment -->
        <!-- <p> Contra: <%=session.getAttribute("contra")%></p>        comment -->
 
        
    <!-- Site wrapper -->
    <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
 
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-6 mt-1 row-cols-1">
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Alta Sector</h3>
                            </div>
                        
                        <!-- form start -->
                        <!--        <form action="ServletAltaSector" method="POST" > -->
                        
                        <form name="formSector" action="ServletAltaSector" method="POST" >                            
                            <div class="card-body ">
                                
                                <div class="form-group">
                                    <label  >Código</label>
                                    <input name="codSector" type="number" style="width: 25%;" min="1" max="1000" 
                                           class="form-control" onclick="consultaSector()" placeholder="Ingrese número">
                                </div>
                                
                                <div class="form-group">
                                    <label >Denominación</label> 
                                    <input name="nomSector" type="text" class="form-control" maxlength="40" placeholder="Ingrese nombre">
                                </div>                    
                                
                                <div class="form-group">
                                    <label >Responsable</label> 
                                    <input name="resSector" type="text" class="form-control" maxlength="40" placeholder="Ingrese responsable">
                                </div>                    

                                <div class="form-group">
                                    <label  >Area</label> 
                                    <select name="areSector" class="form-control btn-sm" style="width: 25%;" >
                                        <option selected="selected">1. RR.HH.</option>
                                        <option>2. Servicio Médico</option>
                                        <option>3. Encargado</option>
                                        <option>4. Gerencia</option>
                                        <option>5. Empleado</option>
                                        <option>6. Otros</option>
                                    </select>                                    
                                </div>                    

                                <div class="input-group-append">
                                    <a href="menuprincipal.jsp" class="btn btn-primary" >Cancelar</a>
                                    <p> </p>
                                    <button type="submit" class="btn btn-primary">Registrar</button>
                                </div>
                    
                            </div>
                        </form>
                        </div>                        

                        <!-- <a href="menuprincipal.jsp">Regresar</a>comment -->
                                            
                    </div>
                </div>
        
                <!-- Control Sidebar -->
                <aside class="control-sidebar control-sidebar-dark">
                    <!-- Control sidebar content goes here -->
                </aside>
            </div>
        </div>
        </section>
        </div>
        
        <!-- jQuery -->
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>

    
    

        <%@include file="template/layouts/footer.jsp"%> 

    </div>
    </body>
</html>


function consultaSector () {
<% 
//  Controladora control = (Controladora) misession.getAttribute("control");
//  List<Sector> listaSectores = control.getListaSector() ;



%>
}
