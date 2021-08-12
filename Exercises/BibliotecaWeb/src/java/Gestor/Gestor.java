package Gestor;

import DTO.DTOreporte;
import Modelo.Alumno;
import Modelo.Prestamo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor {

    private final String CONN = "jdbc:sqlserver://DESKTOP-L6VL4CS\\FJLORENZO:1433;databaseName=BibliotecaWeb";
    private final String USER = "sa";
    private final String PASS = "francisco123";
    private Connection conexion;

    private void abrirConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            conexion = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {

            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarPrestamo(Prestamo prestamo) {

        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Prestamos VALUES (?,?,?,?,?)");

            pstmt.setString(1, prestamo.getFechaPrestamo());
            pstmt.setInt(2, prestamo.getLegajoAlumno());
            pstmt.setString(3, prestamo.getTituloLibro());
            pstmt.setInt(4, prestamo.getTematicaLibro());
            pstmt.setInt(5, prestamo.getTipoLibro());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Alumno> obtenerTodosLosAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumnos");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);

                Alumno nuevo = new Alumno(id, nombre);
                lista.add(nuevo);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DTOreporte> obtenerTodosLosPrestamos() {
        ArrayList<DTOreporte> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select fechaPrestamo, nombreCompleto, tituloLibro, tipoLibro\n"
                                             +"from Prestamos p join Alumnos a on a.id = p.legajoAlumno\n"
                                             +"where tematicaLibro = 2");

            while (rs.next()) {
                String fechaPrestamo = rs.getString(1);
                String nombreAlumno = rs.getString(2);
                String tituloLibro = rs.getString(3);
                int tipoLibro = rs.getInt(4);

                DTOreporte nuevo = new DTOreporte(fechaPrestamo, nombreAlumno, tituloLibro, tipoLibro);
                lista.add(nuevo);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }
}
