package Servlet;

import GestorBD.GestorBD;
import Modelo.Alumno;
import Modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicioSesionServlet", urlPatterns = {"/inicioSesionServlet"})
public class inicioSesionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexAdministradorServlet");
            rd.forward(request, response);
            return;
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioSesion.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();

        String usuario = request.getParameter("txtUsuario");
        String contrasenia = request.getParameter("txtPassword");

        if (gestor.ingresoUsuario(usuario, contrasenia)) {

            request.getSession().setAttribute("usuario", usuario);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexAdministradorServlet");
            rd.forward(request, response);

        } else {
            request.setAttribute("Error", "Usuario o contraseña incorrectos");

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
