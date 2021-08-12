<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Página principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navbar.jsp" flush="true" />

        <div class="row paddingMargenes">
            <div class="col-md-6">
                <c:forEach var="curso" items="${listaCursos}">
                    <div class="main center">
                        <div class="box center">
                            <h1>${curso.nombreCurso}</h1>
                            <p>
                                <label>- Aula: ${curso.nombreAula}</label><br>
                                <label>- Descuento: ${curso.porcentaje}%</label>
                                <label>- Precio: ${curso.precio}</label>
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-6">
                <h2 style="color: white">Top 5 programas más descargados:</h2>
                <table style="background-color: white" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Nombre
                            </th>
                            <th class="text-center">
                                Alumno
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="lista" items="${listaTop5}">
                            <tr class="text-center">
                                <td>${lista.nombre}</td>
                                <td>${lista.alumno.nombre} ${lista.alumno.apellido}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>

</html>
