package Servlet;

import GestorBD.GestorBD;
import Modelo.Alumno;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "eliminarAlumnoServlet", urlPatterns = {"/eliminarAlumnoServlet"})
public class eliminarAlumnoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        GestorBD gestor = new GestorBD();
        int id = Integer.parseInt((String) request.getParameter("id"));

        Alumno alumno = gestor.obtenerAlumnoPorId(id);
        request.setAttribute("alumno", alumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminarAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();
        int id = Integer.parseInt((String) request.getParameter("txtIdAlumno"));
        gestor.eliminarUnAlumno(id);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosAlumnosServlet");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
