package Servlet;

import GestorBD.GestorBD;
import Modelo.Alumno;
import Modelo.Programa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "nuevoProgramaServlet", urlPatterns = {"/nuevoProgramaServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Usuario\\Dropbox\\Facultad\\Laboratorio de Computacíon IV\\Proyecto Final\\AcademiaProgramacion\\web\\ProgramasDeAlumnos"
)
public class nuevoProgramaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoPrograma.jsp");
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

        String nombre = request.getParameter("txtNombre");
        String tamanio = request.getParameter("txtTamanio");
        String version = request.getParameter("txtVersion");
        boolean habilitado = Boolean.parseBoolean(request.getParameter("rbHabilitado"));
        int idAlumno = Integer.parseInt(request.getParameter("cboAlumno"));
        String rutaDescarga2;

        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (!fileName.isEmpty()) {
                part.write(fileName);
            }
        }

        String rutaDescarga = request.getParameter("agregarPrograma");
        

        Alumno alumno = new Alumno(idAlumno);

        Programa programa = new Programa(nombre, tamanio, version, habilitado, alumno, rutaDescarga);
        gestor.insertarPrograma(programa);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoPrograma.jsp");
        rd.forward(request, response);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
