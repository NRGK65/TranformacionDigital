<%-- 
    Document   : menuprincipal
    Created on : 2023 Jul 20, 18:25:25
    Author     : Nestor
--%>

<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="ES">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro Web Ver 0.1.0 | Alta Usuario</title>

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
                <!-- general form elements -->
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Alta Usuario</h3>
                        </div>
                        
                        <!-- form start -->
                        <form action="ServletAltaUsuario" method="POST" >
                            <div class="card-body">
                                
                                <div class="form-group">
                                    <label name="usuario" >Usuario</label>
                                    <input type="text" class="form-control" placeholder="Ingrese Usuario">
                                </div>
                                
                                <div class="form-group">
                                    <label name="legajo">Legajo</label> 
                                    <input type="text" class="form-control" placeholder="Ingrese Legajo">
                                </div>                    
                                
                                <div class="form-group">
                                    <label name="contra" for="exampleInputPassword1">Contraseña</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ingrese Contraseña">
                                </div>
                    
                                <div class="input-group-append">
                                    <button href="menuprincipal.jsp"  class="btn btn-primary">Cancelar</button>                        
                                    <p> </p>                            
                                    <button type="submit" class="btn btn-primary">Registrar</button>                                                
                                </div>
                            </div>
                        </div>
                    </div>
        
                <!-- Control Sidebar -->
                <aside class="control-sidebar control-sidebar-dark">
                    <!-- Control sidebar content goes here -->
                </aside>
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

    </body>
</html>


