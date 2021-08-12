<%-- 
    Document   : nuevoUsuario
    Created on : 02-nov-2020, 20:53:00
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo usuario</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/AcademiaProgramacion/nuevoUsuarioServlet" onsubmit="return validacionUsuario();" style="transform: translateY(120px)">
                    <h3 class="text-center" style="color: white">Cargar un nuevo usuario en el sistema:</h3>
                    <div class="form-group">
                        <label for="txtNombreUsuario" style="color: white">Nombre</label>
                        <input type="text" class="form-control" name="txtNombreUsuario" id="txtNombreUsuario" required>
                    </div>
                    <div class="form-group">
                        <label for="txtContrasenia" style="color: white">Contraseña</label>
                        <input type="password" class="form-control" name="txtContrasenia" id="txtContraseniaUsuario" required>
                    </div>
                    <button class="btn btn-primary" type="submit" style="width: 100%">Guardar</button>                
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>

    </body>

    <script>
        function validacionUsuario() {
            let txtNombreUsuario = document.getElementById("txtNombreUsuario").value;
            let txtContrasenia = document.getElementById("txtContraseniaUsuario").value;


            if (!txtNombreUsuario | !txtContrasenia) {
                alert("Faltan completar campos obligatorios.");
                return false;
            }
            return true;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
