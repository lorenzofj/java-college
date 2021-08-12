package Servlet;

import GestorBD.GestorBD;
import Modelo.Programa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "habilitarProgramaServlet", urlPatterns = {"/habilitarProgramaServlet"})
public class habilitarProgramaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioSesion.jsp");
            rd.forward(request, response);
            return;
        }

        GestorBD gestor = new GestorBD();
        ArrayList<Programa> listaPrograma = gestor.obtenerProgramasDeshabilitados();
        request.setAttribute("listaDeshabilitados", listaPrograma);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/programasDeshabilitados.jsp");
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

        GestorBD gestor = new GestorBD();
        String idHabilitar = (String) request.getParameter("id");
        int idPrograma = Integer.parseInt(idHabilitar);

        gestor.habilitarPrograma(idPrograma);

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
