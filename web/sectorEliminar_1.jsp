<%-- 
    Document   : sectorEliminar_1
    Created on : 2023 Jul 11, 17:41:02
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
        <title>Registro Web Ver 0.1.0 | Baja Sectores</title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">  
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">  

    </head>



    <%
        HttpSession misession = request.getSession(false);
        String usu = (String) request.getSession().getAttribute("usuario");
        String usu2 = (String) request.getSession().getAttribute("contra");

        if (usu == null) {
            response.sendRedirect("sinusuario.jsp");
        } else {
            Controladora control = new Controladora();
            misession.setAttribute("control", control);
        }

        int sector = Integer.parseInt(request.getParameter("idSector")); 
        String codSecto = "" ;
        String nomSect = "" ;
        String resSect = "" ;
        String perSect = "" ;

        Controladora control = (Controladora) misession.getAttribute("control");
        List<Sector> listaSector1 = control.getListaSector();
        for (Sector sect1 : listaSector1) {

            if (sector == sect1.getIdSector()) {
                int codSect = sect1.getIdSector();
                codSecto = String.valueOf(sect1.getIdSector());
                nomSect = sect1.getNombreSector();
                resSect = sect1.getNombreResponsable();
                perSect = sect1.getAreaSector();
                
            }
        }
        
                /* TODO output your page here. You may use following sample code. */
            
            /*
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cargando Input </title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>codSector " + sector + "</h1>");
                out.println("<h2>      " + nomSect + "</h2>");
                out.println("<h2>      " + resSect + "</h2>");
                out.println("<h2>      " + perSect + "</h2>");
                out.println("</body>");
                out.println("</html>");
                
            */
                

           
        
            
    %>                      



    <%@include file="template/layouts/header.jsp"%>

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
                                    <h3 class="card-title">Eliminar Sector</h3>
                                </div>

                                <!-- form start -->
                                <!--        <form action="ServletAltaSector" method="POST" > -->

                                <form name="formSector" action="ServletBorrarSector" method="POST" >                            
                                    <div class="card-body ">

                                        <div class="form-group">    
                                            <label  >Código</label>
                                            <input name="idSector"  type="number" style="width: 25%;" readonly class="form-control" 
                                                   value="<%= request.getParameter("idSector") %>" >
                                        </div>                                                        

                                        <div class="form-group">
                                            <label >Denominación</label> 
                                            <p></p> <%out.println("<h5>" + nomSect + "<h5>");%>
                                            
                                        </div>                    

                                        <div class="form-group">
                                            <label >Responsable</label> 
                                            <p></p> <%out.println("<h5>" + resSect + "<h5>");%>
                                        </div>                    

                                        <div class="form-group">
                                            <label  >Permiso</label> 
                                            <p></p> <%out.println("<h5>" + perSect + "<h5>");%>

                                        </div>                    

                                        <div class="input-group-append">
                                            <a href="sectorEliminar.jsp" class="btn btn-primary" >Cancelar</a>
                                            <p> </p>
                                            <button type="submit" class="btn btn-danger">Eliminar</button>
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
                                                    List<Sector> listaSector = control.getListaSector();
                                                    for (Sector sect : listaSector) {

                                                %>
                                                <td id="idSector"><%=sect.getIdSector()%></td>
                                                <td id="nombreSector"><%=sect.getNombreSector()%></td>
                                                <td id="nombreResponsable"><%=sect.getNombreResponsable()%></td>
                                                <td id="areaSector"><%=sect.getAreaSector()%></td>
                                                <td>
                                                    <!--
                                                    <a href="sectorEditar.jsp?idSector=<%=sect.getIdSector()%>" class="btn btn-success btn-xs" >Modificar</a>  
                                                    -->

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

</html>

