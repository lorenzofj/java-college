<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navbar.jsp" flush="true" />
        <br>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/AcademiaProgramacion/inicioSesionServlet" style="transform: translateY(120px);">
                    <div class="form-group">
                        <label for="txtUsuario" style="color: white">Usuario</label>
                        <input type="text" class="form-control" name="txtUsuario" placeholder="admin">
                    </div>
                    <div class="form-group">
                        <label for="txtPassword" style="color: white">Contraseña</label>
                        <input type="password" class="form-control" name="txtPassword" placeholder="admin">
                    </div>
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Entrar</button>
                </form>
            </div>
             <div class="col-md-3"></div>
        </div>

    </body>
</html>
