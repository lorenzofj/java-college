package Modelo;

public class Turno {
    private int id;
    private String nombrePaciente;
    private int edad;
    private int mes;
    private int anio;
    private Prestacion prestacion;

    public Turno(int id, String nombrePaciente, int edad, int mes, int anio, Prestacion prestacion) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.mes = mes;
        this.anio = anio;
        this.prestacion = prestacion;
    }

    public Turno(String nombrePaciente, int edad, int mes, int anio, Prestacion prestacion) {
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.mes = mes;
        this.anio = anio;
        this.prestacion = prestacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Prestacion getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(Prestacion prestacion) {
        this.prestacion = prestacion;
    }
    
    
}
