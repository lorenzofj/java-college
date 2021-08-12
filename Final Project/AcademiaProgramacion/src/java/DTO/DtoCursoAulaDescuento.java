package DTO;

import Modelo.Aula;
import Modelo.Curso;
import Modelo.Descuento;
import java.util.ArrayList;

public class DtoCursoAulaDescuento {
    public Curso curso;
    public ArrayList<Aula> listaAulas;
    public ArrayList<Descuento> listaDescuentos;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Aula> getListaAulas() {
        return listaAulas;
    }

    public void setListaAulas(ArrayList<Aula> listaAulas) {
        this.listaAulas = listaAulas;
    }

    public ArrayList<Descuento> getListaDescuentos() {
        return listaDescuentos;
    }

    public void setListaDescuentos(ArrayList<Descuento> listaDescuentos) {
        this.listaDescuentos = listaDescuentos;
    }
    
    
}
