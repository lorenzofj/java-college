<%-- 
    Document   : modificarAlumno
    Created on : 28-oct-2020, 20:15:18
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar el alumno</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/AcademiaProgramacion/modificarAlumnoServlet" style="transform: translateY(120px)">

                    <input type="hidden" name="txtIdAlumno" value="${alumno.id}" required/>

                    <div class="form-group">
                        <label for="txtNombre" style="color: white">Nombre</label>
                        <input type="text" class="form-control" name="txtNombre" value="${alumno.nombre}" required/>
                    </div>
                    <div class="form-group">
                        <label for="txtApellido" style="color: white">Apellido</label>
                        <input type="text" class="form-control" name="txtApellido" value="${alumno.apellido}" required/>
                    </div>
                    <div class="form-group">
                        <label for="txtDireccion" style="color: white">Direccion</label>
                        <input type="text" name="txtDireccion" class="form-control" value="${alumno.direccion}" required/>
                    </div>
                    <button class="btn btn-warning" style="width: 100%" type="submit">Confirmar</button>                
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
