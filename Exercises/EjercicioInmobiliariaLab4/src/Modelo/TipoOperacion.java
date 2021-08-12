package Modelo;

public class TipoOperacion {
    private int idTipoOperacion;
    private String tipo;

    public TipoOperacion(int idTipoOperacion, String tipo) {
        this.idTipoOperacion = idTipoOperacion;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
    
}
