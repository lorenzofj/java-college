package Dto;

public class DtoPromedioEdades {
    public float promedioEdad;
    public int cantidadMascotas;

    public DtoPromedioEdades(float promedioEdad, int cantidadMascotas) {
        this.promedioEdad = promedioEdad;
        this.cantidadMascotas = cantidadMascotas;
    }

    public float getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(float promedioEdad) {
        this.promedioEdad = promedioEdad;
    }  

    public int getCantidadMascotas() {
        return cantidadMascotas;
    }

    public void setCantidadMascotas(int cantidadMascotas) {
        this.cantidadMascotas = cantidadMascotas;
    }
    
    
}
