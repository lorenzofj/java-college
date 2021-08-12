<%-- 
    Document   : todosLosCursos
    Created on : 28-oct-2020, 21:55:28
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos los cursos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <c:choose>
            <c:when test="${empty usuario}">
                <jsp:include page="navbar.jsp" flush="true" />
            </c:when>
            <c:otherwise>
                <jsp:include page="navBarAdministrador.jsp" flush="true" />
            </c:otherwise>
        </c:choose>
        <br>
        <div class="row paddingMargenes">
            <div class="col-md-6">
                <h3 class="text-center" style="color: white">Cursos disponibles en la academia</h3>
                <table class="table table-bordered table-striped" style="background-color: white">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Nombre
                            </th>
                            <th class="text-center">
                                Aula
                            </th>
                            <th class="text-center">
                                Descuento
                            </th>
                            <th class="text-center">
                                Precio
                            </th>
                            <c:choose>
                                <c:when test="${not empty usuario}">
                                    <th class="text-center">Acciones
                                    </th>
                                </c:when>
                            </c:choose>           
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="curso" items="${listaCursos}">
                            <tr class="text-center">
                                <td>${curso.nombreCurso}</td>
                                <td>${curso.nombreAula}</td>
                                <td>${curso.porcentaje}%</td>
                                <td>$${curso.precio}</td>
                                <c:choose>
                                    <c:when test="${not empty usuario}">
                                        <td><a class="  btn btn-warning" href="/AcademiaProgramacion/modificarCursoServlet?id=${curso.idCurso}">Modificar</a> 
                                            <a class="btn btn-danger" href="/AcademiaProgramacion/eliminarCursoServlet?id=${curso.idCurso}">Eliminar</a></td>
                                        </c:when>
                                    </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-6">
                <c:choose>
                    <c:when test="${not empty usuario}">
                        <form method="POST" action="/AcademiaProgramacion/todosLosCursosServlet">
                            <h3 style="color: white">Buscar alumnos inscriptos en un curso</h3>
                            <div class="form-group">
                                <select class="form-control" name="cboCurso">
                                    <c:forEach var="curso" items="${gestor.obtenerTodosLosCursos()}">
                                        <option value="${curso.idCurso}">${curso.nombreCurso}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button class="btn btn-primary" type="submit">Buscar</button>
                        </form>
                        <br>
                        <table class="table table-bordered table-striped" style="background-color: white">
                            <thead>
                                <tr>
                                    <th class="text-center">
                                        Nombre y Apellido
                                    </th>          
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="alumnos" items="${listaAlumnos}">
                                    <tr class="text-center">
                                        <td>${alumnos.nombre} ${alumnos.apellido}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                </c:choose> 
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
