package Dto;

public class DtoMascotaDueño {
    public String nombreMascota;
    public String nombreCliente;
    public String telefono;


    public DtoMascotaDueño(String nombreMascota, String nombreCliente, String telefono) {
        this.nombreMascota = nombreMascota;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;

    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
