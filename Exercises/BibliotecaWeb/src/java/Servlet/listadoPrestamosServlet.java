package Servlet;

import DTO.DTOreporte;
import Gestor.Gestor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listadoPrestamosServlet", urlPatterns = {"/listadoPrestamosServlet"})
public class listadoPrestamosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Gestor gestor = new Gestor();
        ArrayList<DTOreporte> listaPrestamo = gestor.obtenerTodosLosPrestamos();
        
        request.setAttribute("listaPrestamo", listaPrestamo);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoPrestamos.jsp");
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
