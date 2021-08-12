<%-- 
    Document   : modificarCurso
    Created on : 28-oct-2020, 22:23:17
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar curso</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/AcademiaProgramacion/modificarCursoServlet" style="transform: translateY(120px)">

                    <input type="hidden" name="txtIdCurso" value="${dtoCurso.curso.id}" required/>

                    <div class="form-group">
                        <label for="txtNombre" style="color: white">Nombre</label>
                        <input type="text" class="form-control" name="txtNombre" value="${dtoCurso.curso.nombre}" required/>
                    </div>
                    <div class="form-group">
                        <label for="cboAula" style="color: white">Aula</label>
                        <select name="cboAula" class="form-control">
                            <c:forEach var="aula" items="${dtoCurso.listaAulas}">
                                <option value="${aula.id}"<c:if test="${aula.id == dtoCurso.curso.aula.id}">selected</c:if>>${aula.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="cboDescuento" style="color: white">Descuento</label>
                        <select name="cboDescuento" class="form-control">
                            <c:forEach var="descuento" items="${lista}">
                                <option value="${descuento.id}"<c:if test="${descuento.id == dtoCurso.curso.descuento.id}">selected</c:if>>${descuento.porcentaje}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtPrecio" style="color: white">Precio</label>
                        <input type="text" class="form-control" name="txtPrecio" value="${dtoCurso.curso.precio}" required/>
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
