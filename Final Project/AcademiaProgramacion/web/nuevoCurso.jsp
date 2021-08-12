<%-- 
    Document   : nuevoCurso
    Created on : 24-oct-2020, 18:03:25
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar un nuevo curso:</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD"/>
        <jsp:include page="navBarAdministrador.jsp" flush="true" />

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">                
                <form method="POST" action="/AcademiaProgramacion/nuevoCursoServlet" onsubmit="return validacionCurso();" style="transform: translateY(120px)">
                    <h3 class="text-center" style="color: white">Cargar un nuevo curso en la academia</h3>
                    <div class="form-group">
                        <label for="txtNombre" style="color: white">Nombre</label>
                        <input type="text" class="form-control" name="txtNombre" id="txtNombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="cboAula" style="color: white">Aula</label>
                        <select class="form-control" name="cboAula">
                            <c:forEach var="aula" items="${gestor.obtenerTodasLasAulas()}">
                                <option value="${aula.id}">${aula.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="cboDescuento" style="color: white">Descuento</label>
                        <select class="form-control" name="cboDescuento">
                            <c:forEach var="descuento" items="${gestor.obtenerTodosLosDescuentos()}">
                                <option value="${descuento.id}">${descuento.porcentaje}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtPrecio" style="color: white">Precio</label>
                        <div class="input-group-prepend">
                            <span class="input-group-text">$</span>
                            <input type="text" class="form-control" name="txtPrecio" id="txtPrecio"/>
                        </div>
                    </div>
                    <button class="btn btn-primary" style="width: 100%" type="submit">Cargar</button>                
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>

    <script>
        function validacionCurso() {
            let txtNombre = document.getElementById("txtNombre").value;
            let txtPrecio = document.getElementById("txtPrecio").value;

            if (!txtNombre | !txtPrecio) {
                alert("Faltan completar campos obligatorios.");
                return false;
            }
            return true;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
