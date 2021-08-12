package Modelo;

public class TipoInmueble {
    private int idTipoInmueble;
    private String tipo;

    public TipoInmueble(int idTipoInmueble, String tipo) {
        this.idTipoInmueble = idTipoInmueble;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    } 
}
