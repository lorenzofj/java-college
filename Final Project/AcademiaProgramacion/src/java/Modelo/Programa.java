package Modelo;

public class Programa {

    private int id;
    private String nombre;
    private String tamanio;
    private String version;
    private int descargas;
    private boolean habilitado;
    private Alumno alumno;
    private String rutaDescarga;

    public Programa(String nombre, String tamanio, String version, Alumno alumno) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.version = version;
        this.alumno = alumno;
    }

    public Programa(String nombre, String tamanio, String version, boolean habilitado, Alumno alumno, String rutaDescarga) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.version = version;
        this.habilitado = habilitado;
        this.alumno = alumno;
        this.rutaDescarga = rutaDescarga;
    }

    public Programa(String nombre, Alumno alumno) {
        this.nombre = nombre;
        this.alumno = alumno;
    }

    public Programa(int id, String nombre, String tamanio, String version, Alumno alumno, int descargas, String rutaDescarga) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.version = version;
        this.alumno = alumno;
        this.descargas = descargas;
        this.rutaDescarga = rutaDescarga;
    }

    public Programa(int id, String nombre, String tamanio, String version, Alumno alumno) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.version = version;
        this.alumno = alumno;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getRutaDescarga() {
        return rutaDescarga;
    }

    public void setRutaDescarga(String rutaDescarga) {
        this.rutaDescarga = rutaDescarga;
    }
}
