<%-- 
    Document   : header
    Created on : 2023 Jul 25, 21:19:52
    Author     : Nestor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ES">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--<title>Registro Web Ver 0.1.0 | Blank Page</title>  -->

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">  
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">  
  
</head>
<body id="page-top" class="hold-transition skin-green-light sidebar-mini">

        <%
        //  HttpSession misession = request.getSession(false);
        // String usu = (String) request.getSession().getAttribute("usuario");
        // String usu2 = (String) request.getSession().getAttribute("contra");
        
        //  int permiso = (int) request.getSession().getAttribute("permiso");
        
        //  if (usu == null) {
        //      response.sendRedirect ("sinusuario.jsp");
        //  }
                
        %>
                    
        <!-- <p> Nombre: <%=session.getAttribute("usuario")%></p>       comment -->
        <!-- <p> Contra: <%=session.getAttribute("contra")%></p>        comment -->
 
        
    <!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header bg-gradient-primary navbar navbar-expand navbar-blue navbar-light">
  <!-- Left navbar links -->
    <ul class="navbar-nav bg-gradient-primary">
      <li class="nav-item">
          
        <a class="nav-link text-white" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars text-white"  ></i>
                      Usuario actual : <%=session.getAttribute("usuario")%> 
            
        </a>
        
      </li>

    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Navbar Search -->
      <li class="nav-item">
        
      </li>
      
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar nav-compact sidebar-light-green elevation-4">
    <!-- Brand Logo -->
    <a href="index.jsp" class="brand-link">
      <!-- <img src="dist/img/AdminLTELogo.png" alt="Registro WEB" class="brand-image img-circle elevation-3" style="opacity: .8"> -->
      <span class="brand-text font-weight-bold">Registro WEB</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-1 pb-1 mb-1 d-flex navbar-blue">
        <div class="image">
          <img src="dist/img/foto2 - 160x160.jpg" class="img-circle elevation" alt="User Image">
        </div>
        <div class="info">
          <a href="menuprincipal.jsp" onclick="nav-collapse-hide-child" class="d-block text-center text-white font-weight-bold">Nestor Gomez</a>
        </div>
      </div>


      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar nav-compact nav-child-indent nav-legacy flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">

              
          <!-- Etiqueta multi nivel -->
          <!-- <li class="nav-header">MULTINIVEL</li>              -->
          
          <!-- 
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fas fa-circle nav-icon"></i>
              <p>Personas</p>
            </a>
          </li>
          -->
          

          <li class="nav-item ">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle"></i>
              <p>
                Personas
                <i class="right fas fa-angle-left inactive"></i>
              </p>
            </a>
              
               
            <ul class="nav nav-treeview ">
              <li class="nav-item">
                <a href="#personaAlta" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Altas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle inactive nav-icon"></i>
                  <p>Modificaciones</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle disabled nav-icon"></i>
                  <p>Bajas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle disabled nav-icon"></i>
                  <p>Listados</p>
                </a>
              </li>              
              
            </ul>
          </li>



          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle inactive"></i>
              <p>
                Usuarios
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="altaUsuario.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Altas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Modificaciones</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Bajas</p>
                </a>
              </li>
              
            </ul>
          </li>

          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle inactive"></i>
              <p>
                Documentos
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="documentoAlta.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Altas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Modificaciones</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Bajas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listados</p>
                </a>
              </li>              
              
            </ul>
          </li>
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle"></i>
              <p>
                Sectores
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="sectorAlta.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Altas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="sectorModifica.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Modificaciones</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="sectorBaja.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Bajas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listados</p>
                </a>
              </li>              
              
            </ul>
          </li>
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle"></i>
              <p>
                Etiqueta 2
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>  Etiqueta 2.1</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>
                      Etiqueta 2.2
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.1</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.2</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.3</p>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>  Etiqueta 2.3</p>
                </a>
              </li>
            </ul>
          </li>
          
                    
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-circle"></i>
              <p>
                Etiqueta 2
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>  Etiqueta 2.1</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>
                      Etiqueta 2.2
                    <i class="right fas fa-angle-left"></i>
                  </p>
                </a>
                <ul class="nav nav-treeview">
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.1</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.2</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="nav-link">
                      <i class="far fa-dot-circle nav-icon"></i>
                      <p>    Etiqueta 2.2.3</p>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>  Etiqueta 2.3</p>
                </a>
              </li>
            </ul>
          </li>
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fas fa-circle nav-icon"></i>
              <p>Etiqueta 3</p>
            </a>
          </li>
          
     
          
          
          
          <!-- <li class="nav-header">LABELS</li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-circle text-danger"></i>
              <p class="text">Important</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-circle text-warning"></i>
              <p>Warning</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-circle text-info"></i>
              <p>Informational</p>
            </a>
          </li>                   -->
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

    
    
    
    
    

  </body>    
    
</html>



