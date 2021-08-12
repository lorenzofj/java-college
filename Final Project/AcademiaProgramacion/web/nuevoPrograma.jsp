<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar un nuevo programa:</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD"/>
        <jsp:include page="navBarAdministrador.jsp" flush="true" />

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/AcademiaProgramacion/nuevoProgramaServlet" enctype="multipart/form-data" onsubmit="return validacionPrograma();" style="transform: translateY(120px)">
                    <h3 class="text-center" style="color: white">Cargar un nuevo programa</h3>
                    <div class="form-group">
                        <label for="txtNombre" style="color: white">Nombre</label>
                        <input type="text" class="form-control" name="txtNombre" id="txtNombre"/>
                    </div>
                    <div class="form-group">
                        <label for="txtVersion" style="color: white">Version</label>
                        <input type="text" class="form-control" name="txtVersion" id="txtVersion"/>
                    </div>
                    <div class="form-group">
                        <label for="txtTamanio" style="color: white">Tamaño</label>
                        <input type="text" class="form-control" name="txtTamanio" id="txtTamanio"/>
                    </div>
                    <div class="form-group">
                        <label for="cboAlumno" style="color: white">Alumno que lo desarrollo:</label>
                        <select class="form-control" name="cboAlumno">
                            <c:forEach var="alumno" items="${gestor.obtenerTodosLosAlumnos()}">
                                <option value="${alumno.id}">${alumno.nombre} ${alumno.apellido}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="btn btn-warning" for="agregarPrograma">Agregar programa</label>
                        <input type="file" id="agregarPrograma" name="agregarPrograma" style="visibility: hidden"/>
                    </div>
                    <div class="form-group">
                        <label for="rbHabilitado" style="color: white">Habilitado para descargas:</label>
                        <label for="rbHabilitado" style="color: white">Si
                            <input type="radio" value="true" name="rbHabilitado">
                        </label>
                        <label for="rbHabilitado" style="color: white">No
                            <input type="radio" value="false" name="rbHabilitado">
                        </label>
                    </div>
                    <button class="btn btn-primary" type="submit" style="width: 100%;">Cargar</button> 
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>

    <script>
        function validacionPrograma() {
            let txtNombre = document.getElementById("txtNombre").value;
            let txtTamanio = document.getElementById("txtTamanio").value;
            let txtVersion = document.getElementById("txtVersion").value;

            if (!txtNombre | !txtTamanio | !txtVersion) {
                alert("Faltan completar campos obligatorios.");
                return false;
            }
            return true;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
