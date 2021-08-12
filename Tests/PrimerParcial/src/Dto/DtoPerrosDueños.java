package Dto;

public class DtoPerrosDueños {
    public String nombreCliente;
    public String nombreMascota;
    public String tipoEspecie;

    public DtoPerrosDueños(String nombreCliente, String nombreMascota, String tipoEspecie) {
        this.nombreCliente = nombreCliente;
        this.nombreMascota = nombreMascota;
        this.tipoEspecie = tipoEspecie;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoEspecie() {
        return tipoEspecie;
    }

    public void setTipoEspecie(String tipoEspecie) {
        this.tipoEspecie = tipoEspecie;
    }

    @Override
    public String toString() {
        return "nombreCliente = " + nombreCliente + ", nombreMascota = " + nombreMascota + ", tipoEspecie = " + tipoEspecie;
    }  
}
