<%-- 
    Document   : programasDeshabilitados
    Created on : 29-oct-2020, 23:34:38
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programas deshabilitados</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <br>
                <h3 style="color: white" class="text-center">Programas deshabilitados</h3>
                <table class="table table-bordered table-striped" style="background-color: white">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Nombre
                            </th>
                            <th class="text-center">
                                Tamaño
                            </th>
                            <th class="text-center">
                                Version
                            </th>
                            <th class="text-center">
                                Alumno
                            </th>
                            <th class="text-center">

                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="programa" items="${listaDeshabilitados}">
                            <tr class="text-center">
                                <td>${programa.nombre}</td>
                                <td>${programa.tamanio}</td>
                                <td>${programa.version}</td>
                                <td>${programa.alumno.nombre} ${programa.alumno.apellido}</td>
                                <td><form method="POST" action="/AcademiaProgramacion/habilitarProgramaServlet?id=${programa.id}">
                                        <button type="submit" class="btn btn-danger">Habilitar</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
