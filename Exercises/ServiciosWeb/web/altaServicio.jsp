<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <form method="POST" action="/ServiciosWeb/altaServlet" style="transform: translateY(120px)">
                    <h3>Ingrese los datos para cargar un nuevo servicio</h3>
                    <div class="form-group">
                        <label for="txtTipo">Tipo</label>
                        <input type="text" class="form-control" name="txtTipo" id="txtTipo" required/>
                    </div>  
                    <div class="form-group">
                        <label for="txtDescripcion">Descripcion</label>
                        <input type="text" step="any" class="form-control" name="txtDescripcion" id="txtDescripcion" required/>
                    </div>
                    <div class="form-group">
                        <label for="txtCosto">Costo</label>
                        <input type="number" step="any" class="form-control" name="txtCosto" id="txtCosto" required/>
                    </div>                    
                    <button class="btn btn-primary" style="width: 100%" type="submit">Cargar</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>
</html>
