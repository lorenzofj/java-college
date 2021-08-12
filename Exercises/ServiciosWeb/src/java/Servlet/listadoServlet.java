package Servlet;

import Gestor.Gestor;
import Modelo.Servicio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listadoServlet", urlPatterns = {"/listadoServlet"})
public class listadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gestor gestor = new Gestor();
        ArrayList<Servicio> listaServicios = gestor.obtenerTodosLosServicios();
        
        request.setAttribute("listaServicios", listaServicios);       
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoServicios.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
