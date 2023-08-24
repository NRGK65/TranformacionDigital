<%-- 
    Document   : menuprincipal
    Created on : 2023 Jul 20, 18:25:25
    Author     : Nestor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="ES">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro Web Ver 0.1.0 | MENU PRINCIPAL</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">  
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">  
  
</head>
<body class="hold-transition skin-green-light sidebar-mini">
  
    
        <%
        HttpSession misession = request.getSession(false);
        String usu = (String) request.getSession().getAttribute("usuario");
        String usu2 = (String) request.getSession().getAttribute("contra");
        int permiso = (int) request.getSession().getAttribute("permiso"); 
            
        if (usu == null) {
            response.sendRedirect ("sinusuario.jsp");
        }
                
        %>
          
        <!-- <p> Nombre: <%=session.getAttribute("usuario")%></p>       comment -->
        <!-- <p> Contra: <%=session.getAttribute("contra")%></p>        comment -->

        
        <%@include file="template/layouts/header.jsp"%> 
        
        
        
        
    <!-- Site wrapper -->
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    
    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

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


