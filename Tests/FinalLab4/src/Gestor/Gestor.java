package Gestor;

import DTO.DTOreporte;
import DTO.DTOreporte2;
import Modelo.Prestacion;
import Modelo.Turno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor {

    private final String CONN = "jdbc:sqlserver://DESKTOP-L6VL4CS\\FJLORENZO:1433;databaseName=ClinicaFinal";
    private final String USER = "sa";
    private final String PASS = "francisco123";
    private Connection conexion;

    private void abrirConexion() {
        try {
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

    public void insertarTurno(Turno turno) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Turno VALUES (?,?,?,?,?)");

            pstmt.setString(1, turno.getNombrePaciente());
            pstmt.setInt(2, turno.getEdad());
            pstmt.setInt(3, turno.getMes());
            pstmt.setInt(4, turno.getAnio());
            pstmt.setInt(5, turno.getPrestacion().getId());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Prestacion> obtenerTodasLasPrestaciones() {
        ArrayList<Prestacion> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Prestacion");

            while (rs.next()) {
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                float costo = rs.getFloat(3);

                Prestacion prestacion = new Prestacion(id, descripcion, costo);
                lista.add(prestacion);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DTOreporte> obtenerReporte1() {
        ArrayList<DTOreporte> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select p.descripcion, sum(monto)\n"
                    + "from Turno t join Prestacion p on p.id = t.idPrestacion\n"
                    + "where idPrestacion in (select p.id \n"
                    + "					  from Prestacion p  join Turno t on p.id = t.idPrestacion \n"
                    + "					  where anio = year(getdate())-1\n"
                    + "					  )\n"
                    + "group by p.descripcion\n"
                    + "having count(t.id) > 5");

            while (rs.next()) {
                String descripcion = rs.getString(1);
                float costo = rs.getFloat(2);

                DTOreporte reporte = new DTOreporte(descripcion, costo);
                lista.add(reporte);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DTOreporte2> obtenerReporte2(int mes, String prestacion) {
        ArrayList<DTOreporte2> lista = new ArrayList<>();
        
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select descripcion, sum(t.id)\n"
                    + "from Prestacion p join Turno t on t.idPrestacion = p.id\n"
                    + "where descripcion = ? and mes = ? and anio = year(getdate())\n"
                    + "group by descripcion");
            pstmt.setString(1, prestacion);
            pstmt.setInt(2, mes);            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String descripcion = rs.getString(1);
                int cantidad = rs.getInt(2);

                DTOreporte2 reporte = new DTOreporte2(descripcion, cantidad);
                lista.add(reporte);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }
}
