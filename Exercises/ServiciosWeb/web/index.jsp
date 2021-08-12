<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row" style="; padding-left: 20px; padding-right: 20px;">
            <div class="col-md-4">
                <a class="btn btn-primary" href="/ServiciosWeb/altaServlet" style="width: 100%; transform: translateY(120px)">Alta de servicios</a>
            </div>
            <div class="col-md-4">
                <a class="btn btn-danger" href="/ServiciosWeb/listadoServlet" style="width: 100%; transform: translateY(120px)">Listado de servicios</a>
            </div>
            <div class="col-md-4">
                <a class="btn btn-warning" href="/ServiciosWeb/reporteServlet" style="width: 100%; transform: translateY(120px)">Reportes</a>
            </div>
        </div>
    </body>
</html>
