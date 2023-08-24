<%-- 
    Document   : formularioAlta
    Created on : 2023 Jul 18, 16:49:19
    Author     : Nestor
--%>

<%@page import="Logica.Controladora"%>
<%@page import="Logica.DatosDocumentacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="ES">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro Web Ver 0.1.0 | Alta Documentación</title>

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
                    <div class="col-md-7 mt-1 row-cols-1">
                        <div class="card card-primary btn-group-sm">                        
                            <div class="card-header">
                                <h3 class="card-title">Alta Documentación</h3>
                            </div>
                        
                            <form name="formDocumento" action="ServletAltaDocumento" method="POST" >
                            <div class="card-body ">
                                
                                <div class="form-group">
                                    <label>Código</label>
                                    <input name="codigoDoc" type="text" style="width: 25%;" class="form-control" required placeholder="Ingrese codigo" minlength="4" maxlength="8">
                                    <span class="validity"></span>
                                </div>
                                
                                <div class="form-group">
                                    <label>Descripción</label> 
                                    <input name="descriDoc" type="text" class="form-control" required placeholder="Ingrese descripcion" minlength="8" maxlength="30">
                                    <span class="validity"></span>                                
                                </div>                    
                                
                                <div class="form-group">
                                    <label class="col-md-3">Incluye : </label>  
                                    <hr>
                                   
                                    <label class="col-md-3">Fecha Desde ? </label> 
                                    <input name="desdeDoc" type="checkbox" class="form-check-input" checked >
                                
                                    <label class="col-md-3">Fecha Hasta ? </label> 
                                    <input name="hastaDoc" type="checkbox" class="form-check-input" checked>
                                
                                    <label class="col-md-3">Vigencia ? </label> 
                                    <input name="vigenciaDoc" type="checkbox" class="form-check-input" checked >
                                </div>
                                

                                <div class="form-group">                                    
                                    <label class="col-md-3">Tiempo Vigencia ? </label> 
                                    <input name="tiempoDoc" type="checkbox" class="form-check-input" checked >
                                
                                    <label class="col-md-3">Tipo Documento ? </label> 
                                    <input name="tipoDoc" type="checkbox" class="form-check-input" checked>
                                </div>
                                

                                <div class="form-group">                                    
                                    <label class="col-md-3">Tipo Emisor ? </label> 
                                    <input name="tipoEmisorDoc" type="checkbox" class="form-check-input" checked>

                                    <label class="col-md-3">Nombre Emisor ? </label> 
                                    <input name="nombreEmisorDoc" type="checkbox" class="form-check-input" checked>                                    
                                </div>
                                

                                <div class="input-group-append">
                                    <button href="menuprincipal.jsp"  class="btn btn-primary">Cancelar</button>                        
                                    <p> </p>                            
                                    <button type="submit" class="btn btn-primary">Registrar</button>                                                
                                </div>
                                
                              </div>
                        </form>
                        </div>                            
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






                            <!--
                                <div class="form-group">
                                    <label name="tiempoDoc" >Tiempo de Vigencia</label> 
                                    <select class="form-control btn-sm" style="width: 25%;">
                                        <option selected="selected">dia</option>
                                        <option>mes</option>
                                        <option>cuatrimestre</option>
                                        <option>semestr</option>
                                        <option>año</option>
                                        <option>sin vencimiento</option>
                                    </select>                                    
                                </div>                    
                                
                                <div class="form-group">
                                    <label name="tipoDoc" >Tipo de Documento</label> 
                                    <select class="form-control btn-sm" style="width: 50%;">
                                        <option selected="selected">Carnet Conducir</option>
                                        <option>Licencia Nacional Habilitante - MMPP</option>
                                        <option>Curso Mercancias Peligrosas</option>
                                        <option>Licencia Nacional Habilitante - CCGG</option>
                                        <option>Curso Cargas Generales</option>
                                        <option>Libreta Sanitaria</option>
                                        <option>Analisis Alcohol y Drogas</option>
                                        <option>Examen Medico</option>
                                        <option>Requisito Cliente 1</option>
                                        <option>Requisito Cliente 2</option>
                                        <option>Requisito Cliente 3</option>
                                        <option>Requisito Cliente 4</option>
                                        <option>Requisito Cliente 5</option>
                                        <option>Requisito Cliente 6</option>
                                        <option>Requisito Cliente 7</option>
                                        <option>Requisito Cliente 8</option>
                                    </select>                                    
                                </div>                    
                                
                                <div class="form-group">
                                    <label name="tipoEmisorDoc" >Origen Documentación</label> 
                                    <select class="form-control btn-sm" style="width: 25%;">
                                        <option selected="selected">Interno</option>
                                        <option>Externo</option>
                                        <option>Legal</option>
                                        <option>Otros 1</option>
                                        <option>Otros 2</option>
                                    </select>                                    
                                </div>                    
              
                                <div class="form-group">
                                    <label name="nombreEmisorDoc">Descripción</label> 
                                    <input type="text" class="form-control btn-sm" placeholder="Ingrese denominación">
                                </div>                    
                            -->
                                

                            <!-- 
                                <div class="input-group-append ">
                                    <a href="menuprincipal.jsp"  class="btn btn-danger">Cancelar</a>
                                    <p> </p>
                                    <a href="ServletAltaDocumento" action="ServletAltaDocumento" method="POST" type="submit" class="button_active btn btn-primary">Registrar</a> 

                                </div>
                            
                            
                            
                            <p class="center-content">
                                <input type="submit" class="btn btn-green" value="Registrar9999">                    
                            </p>
                            
                            -->
