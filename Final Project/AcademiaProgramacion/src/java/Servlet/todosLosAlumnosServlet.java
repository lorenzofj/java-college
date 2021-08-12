package Servlet;

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

@WebServlet(name = "todosLosAlumnosServlet", urlPatterns = {"/todosLosAlumnosServlet"})
public class todosLosAlumnosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        GestorBD gestor = new GestorBD();
        ArrayList<Alumno> listaAlumnos = gestor.obtenerTodosLosAlumnos();
        
        request.setAttribute("listaAlumnos", listaAlumnos);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosAlumnos.jsp");
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
