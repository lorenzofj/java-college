package Servlet;

import DTO.DtoConsultaCurso;
import GestorBD.GestorBD;
import Modelo.Alumno;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "todosLosCursosServlet", urlPatterns = {"/todosLosCursosServlet"})
public class todosLosCursosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();
        ArrayList<DtoConsultaCurso> listaCursos = gestor.obtenerTodosLosCursos();

        request.setAttribute("listaCursos", listaCursos);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosCursos.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorBD gestor = new GestorBD();
        
        int idCurso = Integer.parseInt(request.getParameter("cboCurso"));
        ArrayList<Alumno> listaAlumnos = gestor.obtenerAlumnosEnCursoSeleccionado(idCurso);
        
        request.setAttribute("listaAlumnos", listaAlumnos);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
