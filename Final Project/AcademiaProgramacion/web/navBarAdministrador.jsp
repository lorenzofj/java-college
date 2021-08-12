<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">

    <button class="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapse_target">
        <a class="nav-link  mb-0 h3" href="/AcademiaProgramacion/indexServlet">Academia Programación</a>
        <a class="navbar-brand" href="/AcademiaProgramacion/indexServlet">
            <img src="https://miro.medium.com/max/626/1*2xJ-TxeRusymnG9D_gY9pw.gif" width="40" height="40" alt="" loading="lazy">
        </a>

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/AcademiaProgramacion/descargasServlet">Descargas</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" data-target="dropdown_target" href="#">Alumnos
                    <span class="caret"></span>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdown_target">
                    <a class="dropdown-item" href="/AcademiaProgramacion/todosLosAlumnosServlet">Ver todos</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/AcademiaProgramacion/nuevoAlumnoServlet">Nuevo</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/AcademiaProgramacion/inscribirAlumnoCursoServlet">Inscribir a un curso</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" data-target="dropdown_target" href="#">Cursos
                    <span class="caret"></span>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdown_target">
                    <a class="dropdown-item" href="/AcademiaProgramacion/todosLosCursosServlet">Ver todos</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/AcademiaProgramacion/nuevoCursoServlet">Nuevo</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/AcademiaProgramacion/nuevoProgramaServlet">Programas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/AcademiaProgramacion/nuevoUsuarioServlet">Nuevo usuario</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/AcademiaProgramacion/cerrarSesionServlet">Cerrar Sesion</a>
            </li>
        </ul>
    </div>
</nav>
