package Gestor;

import DTO.DTOreporte;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor {
    
    private final String CONN = "jdbc:sqlserver://DESKTOP-L6VL4CS\\FJLORENZO:1433;databaseName=ServiciosWeb";
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
    
    public void insertarServicio(Servicio servicio) {

        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Servicios VALUES (?,?,?)");

            pstmt.setString(1, servicio.getTipo());
            pstmt.setString(2, servicio.getDescripcion());
            pstmt.setFloat(3, servicio.getCosto());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    public ArrayList<Servicio> obtenerTodosLosServicios(){
        ArrayList<Servicio> reportes = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select tipo, descripcion, costo from Servicios");

            while (rs.next()) {
                String tipo = rs.getString(1);
                String descripcion = rs.getString(2);
                float costo = rs.getFloat(3);

                Servicio nuevo = new Servicio(tipo, descripcion, costo);
                reportes.add(nuevo);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return reportes;
    }
    
    public ArrayList<DTOreporte> obtenerCantidadServiciosRegistrados(){
        ArrayList<DTOreporte> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from Servicios");

            if (rs.next()) {
                int cantidad = rs.getInt(1);

                DTOreporte nuevo = new DTOreporte(cantidad);
                lista.add(nuevo);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
}
