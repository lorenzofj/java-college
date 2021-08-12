package Servlet;

import GestorBD.GestorBD;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inscribirAlumnoCursoServlet", urlPatterns = {"/inscribirAlumnoCursoServlet"})
public class inscribirAlumnoCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inscribirAlumnoCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }
        
        GestorBD gestor = new GestorBD();
        int idAlumno = Integer.parseInt((String)request.getParameter("cboAlumno"));
        int idCurso = Integer.parseInt((String)request.getParameter("cboCurso"));
        gestor.inscribirAlumnoEnCurso(idAlumno, idCurso);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inscribirAlumnoCurso.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
