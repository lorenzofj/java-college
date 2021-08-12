package GestorBD;
import Dto.DtoTransacciones;
import Modelo.TipoInmueble;
import Modelo.TipoOperacion;
import Modelo.Transaccion;
import Modelo.Vendedor;
import java.sql.*;
import java.util.ArrayList;

public class GestorBD {
    
    private String CONN = "jdbc:sqlserver://FRANCISCO\\SQLEXPRESS:1433;databaseName=Inmobiliaria_Lab4";
    private String USER = "sa";
    private String PASS = "francisco123";
    
    public ArrayList<Vendedor> obtenerTodosLosVendedores() {
        ArrayList<Vendedor> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Vendedores");

            while (rs.next()) {
                int idVendedor = rs.getInt(1);
                String nombreCompleto = rs.getString(2);

                Vendedor vendedor = new Vendedor(idVendedor, nombreCompleto);
                lista.add(vendedor);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<TipoInmueble> obtenerTodosLosTiposInmuebles() {
        ArrayList<TipoInmueble> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Inmuebles");

            while (rs.next()) {
                int idTipoInmueble = rs.getInt(1);
                String tipo = rs.getString(2);

                TipoInmueble tipoInmueble = new TipoInmueble(idTipoInmueble, tipo);
                lista.add(tipoInmueble);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<TipoOperacion> obtenerTodosLosTiposOperacion() {
        ArrayList<TipoOperacion> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Operaciones");

            while (rs.next()) {
                int idTipoOperacion = rs.getInt(1);
                String tipo = rs.getString(2);

                TipoOperacion tipoOperacion = new TipoOperacion(idTipoOperacion, tipo);
                lista.add(tipoOperacion);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public void insertarTransaccion (Transaccion transaccion){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Transacciones VALUES (?,?,?,?,?)");

            pstmt.setString(1, transaccion.getFecha());
            pstmt.setInt(2, transaccion.getIdVendedor());
            pstmt.setInt(3, transaccion.getTipoOperacion());
            pstmt.setInt(4, transaccion.getTipoInmueble());
            pstmt.setFloat(5, transaccion.getMonto());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<DtoTransacciones> obtenerTodasLasTransacciones(){
        ArrayList<DtoTransacciones> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select fecha, nombre_completo, o.tipo, i.tipo, monto\n" +
                                             "from Transacciones t join Vendedores v on t.id_vendedor = v.id_vendedor\n" +
                                             "join Operaciones o on t.tipo_operacion = o.id_operacion\n" +
                                             "join Inmuebles i on t.tipo_inmueble = i.id_inmueble");

            while (rs.next()) {
                String fecha = rs.getString(1);
                String nombreCompleto = rs.getString(2);
                String tipoOperacion = rs.getString(3);
                String tipoInmueble = rs.getString(4);
                float monto = rs.getFloat(5);

                DtoTransacciones DtoTransaccion = new DtoTransacciones(fecha, nombreCompleto, tipoOperacion, tipoInmueble, monto);
                lista.add(DtoTransaccion);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public DtoTransacciones obtenerTransaccionVentaMayorValor(){
        
        DtoTransacciones DtoTransaccion = null;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select fecha, nombre_completo, o.tipo, i.tipo ,max(monto)\n" +
                                             "from Transacciones t join Vendedores v on t.id_vendedor=v.id_vendedor\n" +
                                             "join Operaciones o on t.tipo_operacion = o.id_operacion\n" +
                                             "join Inmuebles i on t.tipo_inmueble = i.id_inmueble\n" +
                                             "where o.tipo = 'Venta'\n" +
                                             "group by fecha, nombre_completo, o.tipo, i.tipo\n" +
                                             "having max(monto)>=(select max(monto)\n" +
                                             "from Transacciones t2 join Operaciones o2 on t2.tipo_operacion = o2.id_operacion\n" +
                                             "where o.tipo = 'Venta')");

            if (rs.next()) {
                String fecha = rs.getString(1);
                String nombreCompleto = rs.getString(2);
                String tipoOperacion = rs.getString(3);
                String tipoInmueble = rs.getString(4);
                float monto = rs.getFloat(5);

                DtoTransaccion = new DtoTransacciones(fecha, nombreCompleto, tipoOperacion, tipoInmueble, monto);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return DtoTransaccion;
    }
    
    public float porcentajeTransaccionesTipoAlquiler(){
        float resultado = 0;
        
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select o.tipo, ((count(o.tipo)*100)/(select count(*) from Transacciones)) 'Porcentaje'\n" +
                                             "from Transacciones t join Operaciones o on t.tipo_operacion = o.id_operacion\n" +
                                             "where o.tipo = 'Alquiler'\n" +
                                             "group by o.tipo");

            while (rs.next()) {
                resultado = rs.getFloat(2);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public ArrayList<DtoTransacciones> obtenerTransaccionesTipoOficina(){
        ArrayList<DtoTransacciones> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select fecha, nombre_completo, o.tipo, i.tipo, monto\n" +
                                             "from Transacciones t join Vendedores v on t.id_vendedor = v.id_vendedor\n" +
                                             "join Operaciones o on t.tipo_operacion = o.id_operacion\n" +
                                             "join Inmuebles i on t.tipo_inmueble = i.id_inmueble\n" +
                                             "where i.tipo = 'Oficina'");

            while (rs.next()) {
                String fecha = rs.getString(1);
                String nombreCompleto = rs.getString(2);
                String tipoOperacion = rs.getString(3);
                String tipoInmueble = rs.getString(4);
                float monto = rs.getFloat(5);

                DtoTransacciones DtoTransaccion = new DtoTransacciones(fecha, nombreCompleto, tipoOperacion, tipoInmueble, monto);
                lista.add(DtoTransaccion);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
}
