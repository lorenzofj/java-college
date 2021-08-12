
package GestorBD;

import Dto.DtoMascotaDueño;
import Dto.DtoPerrosDueños;
import Dto.DtoPromedioEdades;
import Modelo.Cliente;
import Modelo.Mascota;
import Modelo.TipoEspecie;
import java.sql.*;
import java.util.ArrayList;

public class GestorBD {
    
    private String CONN = "jdbc:sqlserver://FRANCISCO\\SQLEXPRESS:1433;databaseName=Veterinaria";
    private String USER = "sa";
    private String PASS = "francisco123";
    
    public void insertarNuevaMascota(Mascota mascota){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Mascotas VALUES (?,?,?,?)");

            pstmt.setString(1, mascota.getNombre());
            pstmt.setInt(2, mascota.getCliente().getIdCliente());
            pstmt.setInt(3, mascota.getTipoEspecie().getIdEspecie());
            pstmt.setInt(4, mascota.getNacimiento());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<DtoMascotaDueño> obtenerMascotasDueños(){
        ArrayList<DtoMascotaDueño> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.Nombre, c.Nombre, c.Telefono\n" +
                                             "from Mascotas m join Clientes c on m.IdCliente = c.IdCliente\n" +
                                             "order by c.Nombre");

            while (rs.next()) {
                String nombreMascota = rs.getString(1);
                String nombreCliente = rs.getString(2);
                String telefono = rs.getString(3);

                DtoMascotaDueño nuevoDto = new DtoMascotaDueño(nombreMascota, nombreCliente, telefono);
                lista.add(nuevoDto);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<DtoPerrosDueños> obtenerPerrosDueños(){
        ArrayList<DtoPerrosDueños> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.Nombre, c.Nombre, m.Nacimiento\n" +
                                             "from Mascotas m join Especies e on m.IdEspecie = e.IdEspecie\n" +
                                             "join Clientes c on c.IdCliente = m.IdCliente\n" +
                                             "where e.Denominacion like 'Perro%'");

            while (rs.next()) {
                String nombreMascota = rs.getString(1);
                String nombreCliente = rs.getString(2);
                String tipoEspecie = rs.getString(3);

                DtoPerrosDueños nuevoDto = new DtoPerrosDueños(nombreMascota, nombreCliente, tipoEspecie);
                lista.add(nuevoDto);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<Cliente> obtenerTodosLosCliente(){
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Clientes");

            while (rs.next()) {
                int idCliente = rs.getInt(1);
                String nombreCliente = rs.getString(2);
                String telefono = rs.getString(3);

                Cliente nuevo = new Cliente(idCliente, nombreCliente, telefono);
                lista.add(nuevo);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<TipoEspecie> obtenerTodasLasEspecies(){
        ArrayList<TipoEspecie> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Especies");

            while (rs.next()) {
                int idEspecie = rs.getInt(1);
                String denominacion = rs.getString(2);


                TipoEspecie nueva = new TipoEspecie(idEspecie, denominacion);
                lista.add(nueva);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
/*    public ArrayList<DtoPromedioEdades> promedioEdadesMascotas(){
        ArrayList<DtoPromedioEdades> lista = null;
        
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*), (Nacimiento - year(getdate()))\n" +
                                             "from Mascotas\n" +
                                             "group by (Nacimiento - year(getdate()))");

            while (rs.next()) {
                int edadPromediada = rs.getInt(2);
                int cantidadMascotas = rs.getInt(1);

                DtoPromedioEdades dtoPromedio = new DtoPromedioEdades(edadPromediada, cantidadMascotas);
                lista.add(dtoPromedio);

            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }*/
}
