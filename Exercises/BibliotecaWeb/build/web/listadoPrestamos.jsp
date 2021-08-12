<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="gestor" scope="request" class="Gestor.Gestor"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de prestamos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h3 class="text-center">Listado de los prestamos con tematica en Programacion</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Fecha del prestamo
                            </th>
                            <th class="text-center">
                                Nombre del alumno
                            </th>
                            <th class="text-center">
                                Titulo del libro
                            </th>
                            <th class="text-center">
                                Tipo de libro
                            </th>          
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reporte" items="${listaPrestamo}">
                            <tr class="text-center">
                                <td>${reporte.fecha}</td>
                                <td>${reporte.nombreCompleto}</td>
                                <td>${reporte.tituloLibro}</td>
                                <c:choose>
                                    <c:when test="${reporte.tipoLibro} == '1'">
                                        <td>Prestamo</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Solo lectura</td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-4"></div>
        </div>
    </body>
</html>
