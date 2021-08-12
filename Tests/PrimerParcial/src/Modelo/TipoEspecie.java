package Modelo;

public class TipoEspecie {
    private int idEspecie;
    private String demoninacion;

    public TipoEspecie(int idEspecie, String demoninacion) {
        this.idEspecie = idEspecie;
        this.demoninacion = demoninacion;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getDemoninacion() {
        return demoninacion;
    }

    public void setDemoninacion(String demoninacion) {
        this.demoninacion = demoninacion;
    }

    @Override
    public String toString() {
        return demoninacion;
    }  
}
