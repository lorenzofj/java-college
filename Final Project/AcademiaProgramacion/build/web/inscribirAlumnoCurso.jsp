<%-- 
    Document   : inscribirAlumnoCurso
    Created on : 02-nov-2020, 9:20:21
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscribir alumno</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />
        <jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD"/>
        <br>
        <div class="row" style="margin-top: 50px">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h3 class="text-center" style="color: white">Inscriba un alumno en el curso deseado</h3>
                <form method="POST" action="/AcademiaProgramacion/inscribirAlumnoCursoServlet">
                    <div class="form-group">
                        <label for="cboAlumno" style="color: white">Alumno</label>
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="cboAlumno">
                            <c:forEach var="alumno" items="${gestor.obtenerTodosLosAlumnos()}">
                                <option value="${alumno.id}">${alumno.nombre} ${alumno.apellido}</option>
                            </c:forEach>
                        </select>
                    </div>            
                    <div class="form-group">
                        <label for="cboCurso" style="color: white">Curso</label>
                    </div>
                    <div class="form-group">
                        <select class="form-control" name="cboCurso">
                            <c:forEach var="curso" items="${gestor.obtenerTodosLosCursos()}">
                                <option value="${curso.idCurso}">${curso.nombreCurso} - Descuento ${curso.porcentaje}%</option>
                            </c:forEach>
                        </select>
                    </div>             
                    <button class="btn btn-primary" style="width: 100%" type="submit">Inscribir</button>                
                </form>
            </div>
            <div class="col-md-3"></div>

        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
