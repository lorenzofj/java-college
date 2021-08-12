package Servlet;

import Gestor.Gestor;
import Modelo.Prestamo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "nuevoPrestamoServlet", urlPatterns = {"/nuevoPrestamoServlet"})
public class nuevoPrestamoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        
        String fechaPrestamo = request.getParameter("txtFechaPrestamo");
        int legajoAlumno = Integer.parseInt(request.getParameter("cboAlumno"));
        String tituloLibro = request.getParameter("txtTituloLibro");
        int tematicaLibro = Integer.parseInt(request.getParameter("cboTematicaLibro"));
        int tipoLibro = Integer.parseInt(request.getParameter("cboTipoLibro"));
        
        Prestamo prestamo = new Prestamo(fechaPrestamo, legajoAlumno, tituloLibro, tematicaLibro, tipoLibro);
        gestor.insertarPrestamo(prestamo);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoPrestamos.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
