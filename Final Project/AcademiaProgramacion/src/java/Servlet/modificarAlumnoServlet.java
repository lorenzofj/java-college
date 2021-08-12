package Servlet;

import GestorBD.GestorBD;
import Modelo.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "modificarAlumnoServlet", urlPatterns = {"/modificarAlumnoServlet"})
public class modificarAlumnoServlet extends HttpServlet {

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

        Alumno alumno = gestor.obtenerAlumnoPorId(id);
        request.setAttribute("alumno", alumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAlumno.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp ");
            rd.forward(request, response);
            return;
        }
        
        GestorBD gestor = new GestorBD();

        int id = Integer.parseInt((String) request.getParameter("txtIdAlumno"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String direccion = request.getParameter("txtDireccion");

        Alumno alumno = new Alumno(id, nombre, apellido, direccion);
        gestor.modificarAlumno(alumno);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosAlumnosServlet");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
