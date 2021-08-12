<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Gestor.Gestor"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de los servicios</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th class="text-center">
                                Tipo
                            </th>
                            <th class="text-center">
                                Descripcion
                            </th>
                            <th class="text-center">
                                Costo
                            </th>         
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="servicio" items="${listaServicios}">
                        <tr class="text-center">
                            <td>${servicio.tipo}</td>
                            <td>${servicio.descripcion}</td>
                            <td>${servicio.costo}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-4"></div>
        </div>
    </body>
</html>
