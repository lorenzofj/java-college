<%@page import="GestorBD.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />
        <br>
        <div class="row" style="padding-left: 20px; padding-right: 20px;">
            <div class="col-lg-4">
                <h5 class="text-center" style="color: white">Total facturado por curso</h5>
                <table class="table table-bordered table-striped" style="background-color: white;">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Curso
                            </th>
                            <th class="text-center">
                                Total facturado
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="curso" items="${listaCurso}">
                            <tr class="text-center">
                                <td>${curso.nombre}</td>
                                <td>$${curso.precio}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <h5 class="text-center" style="color: white">Alumnos que accedieron a descuentos</h5>
                <table class="table table-bordered table-striped" style="background-color: white;">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Nombre y apellido
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="alumno" items="${listaAlumno}">
                            <tr class="text-center">
                                <td>${alumno.nombre}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <h5 class="text-center" style="color: white">Sumatoria total de los descuentos realizados</h5>
                <table class="table table-bordered table-striped" style="background-color: white;">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Sumatoria
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="text-center">
                            <%
                                GestorBD gestor = new GestorBD();
                                float sumatoriaTotal = gestor.obtenerSumatoriaTotalDescuentosRealizados();

                                out.print("<td>$" + sumatoriaTotal + "</td>");
                            %>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
