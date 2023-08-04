<%-- 
    Document   : sectorEditar
    Created on : 2023 Jul 29, 21:12:35
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
  <title>Registro Web Ver 0.1.0 | Modificar Sectores</title>

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
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Modificar Sector</h3>
                            </div>
                        
                        <form name="formSector" action="ServletEditarSector" method="POST" >
                            <div class="card-body ">
                                
                                <div class="form-group">
                                    <label  >Código</label>
                                    <!-- 
                                    <input name="codSector" type="number" style="width: 25%;" min="1" max="1000" 
                                           class="form-control" onclick="consultaSector()" placeholder="Ingrese número">
                                    -->
                                </div>
                                
                                <div class="form-group">
                                    <label >Denominación</label> 
                                    <!-- 
                                    <input name="nomSector" type="text" class="form-control" maxlength="40" placeholder="Ingrese nombre">
                                    -->
                                </div>                    
                                
                                <div class="form-group">
                                    <label >Responsable</label> 
                                    <!-- 
                                    <input name="resSector" type="text" class="form-control" maxlength="40" placeholder="Ingrese responsable">
                                    -->
                                </div>                    

                                <div class="form-group">
                                    <label  >Permiso</label> 
                                    <!-- 
                                    <select name="perSector" class="form-control btn-sm" style="width: 25%;" >
                                        <option selected="selected">1. RR.HH.</option>
                                        <option>2. Servicio Médico</option>
                                        <option>3. Encargado</option>
                                        <option>4. Gerencia</option>
                                        <option>5. Empleado</option>
                                        <option>6. Otros</option>
                                    </select>                                    
                                    -->
                                </div>                    

                                <div class="input-group-append">
                                    <a href="menuprincipal.jsp" class="btn btn-primary" >Cancelar</a>
                                    <p> </p>
                                    <button type="submit" class="btn disabled btn-success">Modificar</button>
                                </div>
                    
                            </div>
                        </form>

                        </div>                        

                        <!-- <a href="menuprincipal.jsp">Regresar</a>comment -->
                                            
                    </div>
                            
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6 mt-1 row-cols-1">
            <!-- Form Element sizes -->
            <div class="card card-success" o>
                <div class="card-header">
                    <h3 class="card-title">Detalle Sectores</h3>
                    <button class="btn btn-success float-md-right btn-sm" onclick="location.reload()" >Actualizar</button>
                </div>

                <div class="card-body table-responsive p-0" style="height: 450px;" >
                    <table id="tablaSector" class="table table-head-fixed text-nowrap table-bordered table-active table-striped" height="45" >
                        <thead>
                            <!-- Cabecera de la tabla -->
                            <tr>
                                <th>Codigo</th>
                                <th>Denominacion</th>
                                <th>Responsable</th>
                                <th>Area</th>
                                <th>Acción</th>                                
                                <!--  <th></th> comment -->
                                    
                                <th style="display:none;" ></th>
                                <th style="display:none;" ></th>
                                <th style="display:none;" ></th>
                                <th style="display:none;" ></th>
                                <th style="display:none;" ></th>
                                
                            </tr>                                
                        </thead>
                        
                        <tbody>
                            <tr>
                                <%
                                    Controladora control = (Controladora) misession.getAttribute("control");
                                    List<Sector> listaSector = control.getListaSector();
                                    for (Sector sect : listaSector) {
                                        
                                %>
                                <td id="idSector"><%=sect.getIdSector()%></td>
                                <td id="nombreSector"><%=sect.getNombreSector()%></td>
                                <td id="nombreResponsable"><%=sect.getNombreResponsable()%></td>
                                <td id="areaSector"><%=sect.getAreaSector()%></td>
                                <td>
                                    <form name="frmModificaSector" action="ServletEditarSector" method="POST" >
                                        <input type="hidden" name="idSector" value="<%=sect.getIdSector()%>">
                                        <button type="submit" class="btn icon btn-success btn-xs" >Modificar</button>
                                    </form>
                                    <%-- <a href="sectorEditar_1.jsp?idSector=<%=sect.getIdSector()%>" id="IdEditar" class="btn icon btn-success btn-xs" >Modificar</a> comment --%>
                                </td>
                            </tr>
                                <%
                                    }                                        
                                %>                                        
                                    
                        </tbody>
                    </table>
                                          
                  
                <!-- <input class="form-control form-control-lg" type="text" placeholder=".form-control-lg">
                <br>
                <input class="form-control" type="text" placeholder="Default input">
                <br>
                <input class="form-control form-control-sm" type="text" placeholder=".form-control-sm">
                -->
                
                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->
            
            
            </div>
        
                <!-- Control Sidebar
                <aside class="control-sidebar control-sidebar-dark">
                    <!-- Control sidebar content goes here -->
                <!-- </aside>   -->
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


}
