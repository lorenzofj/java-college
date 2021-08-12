package Servlet;

import GestorBD.GestorBD;
import Modelo.Alumno;
import Modelo.Curso;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "indexAdministradorServlet", urlPatterns = {"/indexAdministradorServlet"})
public class indexAdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioSesion.jsp");
            rd.forward(request, response);
            return;
        }

        GestorBD gestor = new GestorBD();
        ArrayList<Curso> listaCurso = gestor.obtenerTotalFacturadoPorCurso();
        request.setAttribute("listaCurso", listaCurso);

        ArrayList<Alumno> listaAlumno = gestor.obtenerAlumnosConDescuento();
        request.setAttribute("listaAlumno", listaAlumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexAdministrador.jsp");
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
