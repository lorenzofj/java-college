<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Gestor.Gestor"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form method="POST" action="/BibliotecaWeb/nuevoPrestamoServlet" style="transform: translateY(120px)">
                    <h3>Cargar un nuevo prestamo</h3>
                    <div class="form-group">
                        <label for="txtFechaPrestamo">Fecha del prestamo</label>
                        <input type="text" class="form-control" name="txtFechaPrestamo" id="txtFechaPrestamo" required/>
                    </div>
                    <div class="form-group">
                        <label for="cboAlumno">Alumno</label>
                        <select class="form-control" name="cboAlumno">
                            <c:forEach var="alumno" items="${gestor.obtenerTodosLosAlumnos()}">
                                <option value="${alumno.id}">${alumno.nombreCompleto}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtTituloLibro">Titulo del libro</label>
                        <input type="text" class="form-control" name="txtTituloLibro" id="txtTituloLibro" required/>
                    </div>
                    <div class="form-group">
                        <label for="cboTematicaLibro">Tematica del libro</label>
                        <select class="form-control" name="cboTematicaLibro">
                            <option value="1">Informatica</option>
                            <option value="2">Programacion</option>
                            <option value="3">Ciencias Basicas</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="cboTipoLibro">Tipo de libro</label>
                        <select class="form-control" name="cboTipoLibro">
                            <option value="1">Prestamo</option>
                            <option value="2">Solo lectura</option>
                        </select>
                    </div>
                    <button class="btn btn-primary" style="width: 100%" type="submit">Cargar</button>
                    <br>
                    <br>
                    <a href="/BibliotecaWeb/listadoPrestamosServlet" style="width: 100%"  class="btn btn-warning">Listado de prestamos</a>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </body>
</html>
