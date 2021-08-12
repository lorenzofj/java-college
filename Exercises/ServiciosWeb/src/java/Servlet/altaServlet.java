package Servlet;

import Gestor.Gestor;
import Modelo.Servicio;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "altaServlet", urlPatterns = {"/altaServlet"})
public class altaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
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

        Gestor gestor = new Gestor();
        
        String tipo = request.getParameter("txtTipo");
        String descripcion = request.getParameter("txtDescripcion");
        float costo = Float.parseFloat(request.getParameter("txtCosto"));
        
        Servicio servicio = new Servicio(tipo, descripcion, costo);
        gestor.insertarServicio(servicio);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
