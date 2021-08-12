<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscribir un nuevo alumno</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="fondoindex">
        <jsp:include page="navBarAdministrador.jsp" flush="true" />
        <br>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h3 class="text-center" style="color: white">Inscriba a un nuevo alumno</h3>

                <form method="POST" action="/AcademiaProgramacion/nuevoAlumnoServlet" onsubmit="return validacionAlumno();">
                    <div class="form-group">
                        <label for="txtNombre" style="color: white">Nombre</label>
                        <div>
                            <input type="text" class="form-control" id="txtNombre" name="txtNombre" required> 
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="txtApellido" style="color: white">Apellido</label>
                        <div>
                            <input type="text" class="form-control" id="txtApellido" name="txtApellido" required>
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label for="txtDireccion" style="color: white">Dirección</label>
                        <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" required>
                    </div>
                    <button type="submit" class="btn btn-primary" style="width: 100%;">INSCRIBIR</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>
    </body>

    <script>
        function validacionAlumno() {
            let txtNombre = document.getElementById("txtNombre").value;
            let txtApellido = document.getElementById("txtApellido").value;
            let txtDireccion = document.getElementById("txtDireccion").value;

            if (!txtNombre | !txtApellido | !txtDireccion) {
                alert("Faltan completar campos obligatorios.");
                return false;
            }
            return true;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
