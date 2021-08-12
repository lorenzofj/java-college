package Modelo;

public class Mascota {
    private int idMastocta;
    private String nombre;
    private Cliente cliente;
    private TipoEspecie tipoEspecie;
    private int nacimiento;

    public Mascota(int idMastocta, String nombre, Cliente cliente, TipoEspecie tipoEspecie, int nacimiento) {
        this.idMastocta = idMastocta;
        this.nombre = nombre;
        this.cliente = cliente;
        this.tipoEspecie = tipoEspecie;
        this.nacimiento = nacimiento;
    }

    public Mascota(String nombre, Cliente cliente, TipoEspecie tipoEspecie, int nacimiento) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tipoEspecie = tipoEspecie;
        this.nacimiento = nacimiento;
    }

    public int getIdMastocta() {
        return idMastocta;
    }

    public void setIdMastocta(int idMastocta) {
        this.idMastocta = idMastocta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEspecie getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(TipoEspecie tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMastocta=" + idMastocta + ", nombre=" + nombre + ", cliente=" + cliente + ", tipoEspecie=" + tipoEspecie + ", nacimiento=" + nacimiento + '}';
    }

}
