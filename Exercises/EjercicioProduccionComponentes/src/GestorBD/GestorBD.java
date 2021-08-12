package GestorBD;

import Dto.DtoConsulta;
import Modelo.Componente;
import Modelo.Produccion;
import Modelo.Responsable;
import java.util.ArrayList;
import java.sql.*;

public class GestorBD {

    private String CONN = "jdbc:sqlserver://FRANCISCO\\SQLEXPRESS:1433;databaseName=Producciones_Lab4";
    private String USER = "sa";
    private String PASS = "francisco123";

    public ArrayList<Responsable> obtenerTodosLosResponsables() {
        ArrayList<Responsable> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Responsable");

            while (rs.next()) {
                int idResponsable = rs.getInt(1);
                String nombre = rs.getString(2);

                Responsable responsable = new Responsable(idResponsable, nombre);
                lista.add(responsable);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public ArrayList<Componente> obtenerTodosLosComponentes() {
        ArrayList<Componente> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Componente");

            while (rs.next()) {
                int idComponente = rs.getInt(1);
                String descripcion = rs.getString(2);

                Componente componente = new Componente(idComponente, descripcion);
                lista.add(componente);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public void insertarNuevaProduccion(Produccion produccion) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Produccion VALUES (?,?,?,?)");

            pstmt.setString(1, produccion.getFecha());
            pstmt.setInt(2, produccion.getCantidadProduccion());
            pstmt.setInt(3, produccion.getIdResponsable());
            pstmt.setInt(4, produccion.getIdComponente());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Produccion> obtenerTodasLasProducciones() {
        ArrayList<Produccion> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Produccion");

            while (rs.next()) {
                int idProduccion = rs.getInt(1);
                String fecha = rs.getString(2);
                int cantidad = rs.getInt(3);
                int idResponsable = rs.getInt(4);
                int idComponente = rs.getInt(5);

                Produccion produccion = new Produccion(idProduccion, idResponsable, fecha, cantidad, idComponente);
                lista.add(produccion);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public DtoConsulta obtenerConsulta(String nombre) {

        DtoConsulta DtoConsulta = null;

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("select nombre, sum(cantidad_produccion) 'total'\n"
                                                            + "from Produccion p join Responsable r on p.id_responsable = r.id_responsable\n"
                                                            + "where nombre = ?\n"
                                                            + "group by nombre");
            pstmt.setString(1, nombre);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombreResponsable = rs.getString(1);
                float cantidad = rs.getFloat(2);

                DtoConsulta = new DtoConsulta(nombreResponsable, cantidad);
            }

            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return DtoConsulta;
    }
    
    public Produccion obtenerProduccionPorId(int id){
        Produccion resultado = null;

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("SELECT id_produccion, fecha, cantidad_produccion FROM Produccion WHERE id_produccion = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int idProduccion = rs.getInt(1);
                String fecha = rs.getString(2);
                int cantidad = rs.getInt(3);
                
                resultado = new Produccion(idProduccion, fecha, cantidad);
            }

            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public void actualizarProduccion(Produccion produccion){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Produccion SET fecha=?, cantidad_produccion=? WHERE id_produccion=?");
            pstmt.setString(1, produccion.getFecha());
            pstmt.setInt(2, produccion.getCantidadProduccion());
            pstmt.setInt(3, produccion.getIdProduccion());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
