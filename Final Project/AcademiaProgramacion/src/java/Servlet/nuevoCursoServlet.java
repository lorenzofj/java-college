package Servlet;

import GestorBD.GestorBD;
import Modelo.Aula;
import Modelo.Curso;
import Modelo.Descuento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "nuevoCursoServlet", urlPatterns = {"/nuevoCursoServlet"})
public class nuevoCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();

        ArrayList<Aula> listaAula = gestor.obtenerTodasLasAulas();
        request.setAttribute("listaAula", listaAula);
        
        ArrayList<Descuento> listaDescuentos = gestor.obtenerTodosLosDescuentos();
        request.setAttribute("listaDescuentos", listaDescuentos);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        GestorBD gestor = new GestorBD();
        
        String nombre = request.getParameter("txtNombre");
        int idAula = Integer.parseInt(request.getParameter("cboAula"));
        int idDescuento = Integer.parseInt(request.getParameter("cboDescuento"));
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        
        Aula aula = new Aula(idAula,"");
        Descuento descuento = new Descuento(idDescuento,0);
        Curso curso = new Curso(nombre, aula, descuento, precio);
        gestor.insertarCurso(curso);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
