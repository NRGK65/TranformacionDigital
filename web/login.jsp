<%-- 
    Document   : index
    Created on : 2023 Jul 21, 23:24:11
    Author     : Nestor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- <meta http-equiv="X-UA-Compatible" content="ie=edge"> -->
    
        <title>Login de Ingreso</title>
        <link rel="stylesheet" href="css/estilos_2.css">
        <link rel="stylesheet" href="css/boton.css">        
        <link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap" rel="stylesheet"> 
        
    </head>
        
<body>

    <header>
        <div class="container">

            <div class="textos">
                <h1>Login de Usuarios</h1>
                <h2>Ingrese sus datos</h2>
                    
                <form action="ServletLogin" method="POST">

                    <p class="center-content">                    
                    <p>Usuario:</p>
                    <div class="field-container">
                        <!-- <i class="fa fa-user fa-lg"></i>comment -->
                        <input type="text" name="usuario" class="field" placeholder="usuario"> <br/>	
                    </div>
                    <p>  </p>			
                    <p>Contraseña:</p>
                    <div class="field-container">
                        <!-- <i class="fa fa-key fa-lg"></i> comment -->
                        <input type="password" name="contra" class="field" placeholder="*******"> <br/>
                    </div>
                    <p>  </p>	
                    <p class="center-content">
                        <input type="submit" class="btn btn-green" value="Iniciar sesión">                    
                    </p>
                </form>

                <a href="index.jsp">Regresar</a>
                    
            </div>
            
            <img src="img/vector.png" alt="">
        </div>
    </header>

    <div class="wave">
        <div style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M0.00,49.98 C150.00,150.00 349.20,-50.00 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" style="stroke: none; fill: #fff;"></path></svg></div> ;
    </div>
</body>
    
        
</html>




