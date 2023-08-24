<%-- 
    Document   : licenciasAltas
    Created on : 2023 Jul 12, 22:58:13
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
        <title>Registro Web Ver 0.1.0 | Nuevas Licencias</title>

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
                response.sendRedirect("sinusuario.jsp");
            } else {
                Controladora control = new Controladora();
                misession.setAttribute("control", control);

            }

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
                            <div class="col-md-10 mt-1 row-cols-1">
                                <div class="card card-success">
                                    <div class="card-header">
                                        <h3 class="card-title">Nuevas Licencias</h3>
                                    </div>

                                    <!-- form start -->
                                    <!--        <form action="ServletAltaSector" method="POST" > -->

                                    <form name="formSector" action="ServletAltaLicencia" method="POST"  >                            
                                        <div class="card-body sx">

                                            <div class="form-group input-group-append">
                                                <label  >Tipo Licencia   </label> 
                                                <select name="idDoc" class="form-control btn-sm" style="width: 250px;" >
                                                    <option selected="selected">1. Vacaciones</option>
                                                    <option>2. Enfermedad</option>
                                                    <option>3. Estudios</option>
                                                    <option>4. Matrimonio</option>
                                                    <option>5. Nacimiento</option>
                                                    <option>6. Fallecimiento</option>
                                                    <option>7. Donacion Sangre</option>
                                                    <option>8. Otros</option>
                                                </select>                                    
                                                <p>           </p>
                                                <p>           </p>
                                                <p>           </p>
                                                <label  >Legajo   </label>
                                                <input name="idLeg" style="width: 120px;" required class="form-control col-1" maxlength="6" placeholder="N° Legajo">
                                            </div>  
                                            
                                            <div class="form-group-append input-group-append ">
                                                <label  >Nombre      </label>
                                                <input name="txtNombre" style="width: 300px;" disabled class="form-control col-6" placeholder="Apellido y Nombre">
                                                <p>           </p>
                                                <label  >DNI   </label>
                                                <input name="txtDNI" style="width: 150px;" disabled class="form-control" placeholder="N° DNI">
                                            </div>
                                            <div class="form-group-append input-group-append">
                                                <label >Domicilio   </label> 
                                                <input name="txtDomicilio" type="text"  style="width: 500px;" required class="form-control col-6" maxlength="60" placeholder="Ingrese domicilio">
                                            </div>                    
                                            <div class="form-group-append input-group-append">
                                                <label >Localidad   </label> 
                                                <input name="txtLocalidad" type="text"  style="width: 500px;" required class="form-control col-6" maxlength="60" placeholder="Ingrese localidad">
                                            </div>                    
                                            <div class="form-group-append input-group-append">
                                                <label >C.   Postal   </label> 
                                                <input name="txtCodPostal" type="text"  style="width: 70px;" required class="form-control" maxlength="8" placeholder="Ingrese cod. postal">
                                                <p>           </p>
                                                <label >Teléfono   </label> 
                                                <input name="txtTelefono" type="text" class="col-sm-2 col-form-label" style="width: 200px;" required class="form-control col-3" maxlength="60" placeholder="Ingrese teléfono">
                                            </div>                    

                                            <div class="form-group input-group-append">
                                                <label >Correo          </label> 
                                                <input name="txtCorreo" type="email" class="col-sm-2 col-form-label" style="width: 500px;" required class="form-control fa-mail-forward" maxlength="60" placeholder="Ingrese correo electronico">
                                            </div>                    

                                            <div class="form-group-append input-group-append">
                                                <label >Fecha Inicio   </label> 
                                                <input name="feinicio" type="date" style="width: 170px;" required class="form-control" placeholder="Fecha Inicio">
                                                <p>           </p>
                                                <label >Fecha Final   </label> 
                                                <input name="fefinal" type="date" style="width: 170px;" required class="form-control " placeholder="Fecha Final">
                                                <p>           </p>
                                                <label >Dias     </label> 
                                                <input name="nrodias" type="number"  style="width: 70px;" requerid class="form-control" min="1" max="30" placeholder="Dias">
                                            </div>                    
                                            <div class="form-group input-group-append">
                                                <label >Diagnostico   </label> 
                                                <input name="txtDiagnos" type="text" style="width: 500px;" class="form-control col-6" maxlength="60" placeholder="Ingrese diagnostico">
                                            </div>                    
                                            <div class="form-group input-group-append">
                                                <label >Archivo   </label> 
                                                <input name="txtArchivo" type="file" accept="*.pdf *.jpg" style="width: 500px;" required class="form-control-file" >
                                            </div>                    
                                            <div class="form-group input-group-append">
                                                <label >Observaciones   </label> 
                                                <input name="txtObserva" type="text" style="width: 500px;" class="form-control" maxlength="100" >
                                            </div>                    
                                            
                                            <input name="feactual" type="date" hidden value="fechaPedido" >
                                            
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

