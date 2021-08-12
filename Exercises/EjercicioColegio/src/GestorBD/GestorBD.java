package GestorBD;

import Dto.DtoAlumnosInscriptos;
import Modelo.Alumno;
import Modelo.Curso;
import Modelo.Titulo;
import java.util.ArrayList;
import java.sql.*;

public class GestorBD {

    private String CONN = "jdbc:sqlserver://FRANCISCO\\SQLEXPRESS:1433;databaseName=Colegio_Lab4";
    private String USER = "sa";
    private String PASS = "francisco123";

    public ArrayList<Titulo> obtenerTodosLosTitulos() {
        ArrayList<Titulo> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Titulo");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);

                Titulo titulo = new Titulo(id, nombre);
                lista.add(titulo);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public ArrayList<Curso> obtenerTodosLosCursos() {
        ArrayList<Curso> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_Curso, nombreCurso FROM Curso");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombreCurso = rs.getString(2);

                Curso curso = new Curso(id, nombreCurso);
                lista.add(curso);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public void insertarNuevoAlumno(Alumno alumno){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Alumno VALUES (?,?,?)");
            pstmt.setString(1, alumno.getNombreApellido());
            pstmt.setInt(2, alumno.getTituloNivelMedio());
            pstmt.setInt(3, alumno.getIdCurso());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void insertarNuevoCurso(Curso curso){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Curso VALUES (?,?,?)");
            pstmt.setString(1, curso.getNombreCurso());
            pstmt.setString(2, curso.getTurno());
            pstmt.setInt(3, curso.getCupoMax());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<DtoAlumnosInscriptos> reportesAlumnosInscriptos(String curso){
        ArrayList<DtoAlumnosInscriptos> listaAlumnos = new ArrayList<>();
        
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("select a.nombreApellido, t.titulo, c.nombreCurso\n" +
                                                           "from Alumno a join Curso c on a.id_Curso = c.id_Curso\n" +
                                                           "join Titulo t on t.id_Titulo = a.tituloNivelMedio\n" +
                                                           "where nombreCurso = ?");
            
            pstmt.setString(1, curso);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombreApellido = rs.getString("nombreApellido");
                String tituloNivelMedio = rs.getString("titulo");
                String nombreCurso = rs.getString("nombreCurso");
                
                DtoAlumnosInscriptos dto = new DtoAlumnosInscriptos(nombreApellido, tituloNivelMedio, nombreCurso);
                listaAlumnos.add(dto);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaAlumnos;
    }
    
    public ArrayList<DtoAlumnosInscriptos> reportesAlumnosYCursos(String turno){
        ArrayList<DtoAlumnosInscriptos> listaAlumnosYCursos = new ArrayList<>();
        
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("select nombreApellido, t.titulo, c.nombreCurso\n" +
                                                            "from Alumno a join Curso c on a.id_Curso = c.id_Curso\n" +
                                                            "join Titulo t on t.id_Titulo = a.tituloNivelMedio\n" +
                                                            "where turno = ?");
            
            pstmt.setString(1, turno);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombreApellido = rs.getString("nombreApellido");
                String tituloNivelMedio = rs.getString("titulo");
                String nombreCurso = rs.getString("nombreCurso");
                
                DtoAlumnosInscriptos dto = new DtoAlumnosInscriptos(nombreApellido, tituloNivelMedio, nombreCurso);
                listaAlumnosYCursos.add(dto);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaAlumnosYCursos;
    }
}
