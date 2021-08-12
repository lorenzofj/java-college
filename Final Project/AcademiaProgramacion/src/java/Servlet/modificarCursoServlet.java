package Servlet;

import DTO.DtoCursoAulaDescuento;
import GestorBD.GestorBD;
import Modelo.Aula;
import Modelo.Curso;
import Modelo.Descuento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "modificarCursoServlet", urlPatterns = {"/modificarCursoServlet"})
public class modificarCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }

        GestorBD gestor = new GestorBD();

        String idModificar = (String) request.getParameter("id");
        int id = Integer.parseInt(idModificar);

        DtoCursoAulaDescuento dto = new DtoCursoAulaDescuento();
        dto.curso = gestor.obtenerCursoPorId(id);
        dto.listaAulas = gestor.obtenerTodasLasAulas();
        dto.listaDescuentos = gestor.obtenerTodosLosDescuentos();

        request.setAttribute("dtoCurso", dto);
        request.setAttribute("lista", dto.listaDescuentos);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarCurso.jsp");
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
        
        int idCurso = Integer.parseInt((String) request.getParameter("txtIdCurso"));
        String nombre = request.getParameter("txtNombre");
        int idAula = Integer.parseInt((String) request.getParameter("cboAula"));
        int idDescuento = Integer.parseInt((String) request.getParameter("cboDescuento"));
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        
        Aula aula = new Aula(idAula, "");
        Descuento descuento = new Descuento(idDescuento, 0);
        Curso curso = new Curso(idCurso, nombre, aula, descuento, precio);
        gestor.modificarCurso(curso);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosCursosServlet");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
