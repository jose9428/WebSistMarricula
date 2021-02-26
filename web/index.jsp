<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html  lang="en">
    <head>
        <title>Inicio Sesion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/style-login.css" rel="stylesheet" type="text/css"/>
    </head>
<!--
background-image: url('./img/wood_1.png');
-->
    <style>
        body {
            color: #999;
            background: #f5f5f5;
            background-image: url('./img/fondo2.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100%;
        }
    </style>

    <body class="login" >
        <div class="login-form">

            <form action="ControlLogin"  method="post">
                <div class="avatar">
                    <img src="./img/user.png" alt=""/>
                </div>

                <h2 class="text-center">Iniciar Sesion</h2>  

                <div class="form-group">
                    <input type="text"  class="form-control" name="username" id="username" placeholder="Username" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="pass" id="pass" placeholder="Password" required="required">
                </div>        
                <div class="form-group">
                    <input type="hidden" name="opc" value="iniciarSesion">
                    <button type="submit" class="btn btn-info btn-lg btn-block">Ingresar</button>
                </div>

            </form>
        </div>


    </body>
</html>