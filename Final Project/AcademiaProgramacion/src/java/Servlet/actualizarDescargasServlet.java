package Servlet;

import GestorBD.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "actualizarDescargasServlet", urlPatterns = {"/actualizarDescargasServlet"})
public class actualizarDescargasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();
        int idPrograma = Integer.parseInt((String) request.getParameter("id"));
        int descargas = Integer.parseInt((String) request.getParameter("descargas"));
        gestor.agregarDescarga(idPrograma, descargas);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/descargasServlet");
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
