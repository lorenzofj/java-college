package Servlet;

import GestorBD.GestorBD;
import Modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "eliminarCursoServlet", urlPatterns = {"/eliminarCursoServlet"})
public class eliminarCursoServlet extends HttpServlet {

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
        
        Curso curso = gestor.obtenerCursoPorId(id);
        request.setAttribute("curso", curso);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminarCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();
        int id = Integer.parseInt((String) request.getParameter("txtIdCurso"));
        gestor.eliminarUnCurso(id);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/todosLosCursosServlet");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
