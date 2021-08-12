package Dto;

public class DtoAlumnosInscriptos {
    public String nombreApellido;
    public String tituloNivelMedio;
    public String nombreCurso;

    public DtoAlumnosInscriptos(String nombreApellido, String tituloNivelMedio, String nombreCurso) {
        this.nombreApellido = nombreApellido;
        this.tituloNivelMedio = tituloNivelMedio;
        this.nombreCurso = nombreCurso;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getTituloNivelMedio() {
        return tituloNivelMedio;
    }

    public void setTituloNivelMedio(String tituloNivelMedio) {
        this.tituloNivelMedio = tituloNivelMedio;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return "nombreApellido = " + nombreApellido + ", tituloNivelMedio = " + tituloNivelMedio + ", nombreCurso = " + nombreCurso;
    }  
}
