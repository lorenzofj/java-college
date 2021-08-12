package Gestor;

import Dto.DtoLibrosOrigenNacional;
import Dto.DtoListadoLibros;
import Dto.DtoNombreAutor;
import Modelo.Autor;
import Modelo.Libro;
import Modelo.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorBD {

    private String CONN = "jdbc:sqlserver://FRANCISCO\\SQLEXPRESS:1433;databaseName=Biblioteca_Lab4";
    private String USER = "sa";
    private String PASS = "francisco123";

    public int cantidadLibrosRegistrados() {
        int cantidadLibros = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) from Libros");

            while (rs.next()) {
                cantidadLibros += rs.getInt(1);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidadLibros;
    }

    public ArrayList<DtoLibrosOrigenNacional> librosDeAutoresNacionales() {
        ArrayList<DtoLibrosOrigenNacional> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select l.id_Libro, descripcion, nombre\n"
                    + "from Libros l join Autores a on l.id_Autor = a.id_Autor\n"
                    + "where nacionalidad = 'Argentina'");

            while (rs.next()) {
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                String nombre = rs.getString(3);

                DtoLibrosOrigenNacional dto = new DtoLibrosOrigenNacional(id, descripcion, nombre);
                lista.add(dto);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<DtoListadoLibros> obtenerListadoLibros() {
        ArrayList<DtoListadoLibros> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select descripcion, a.nombre, a.nacionalidad\n"
                    + "from Libros l join Autores a on l.id_Autor = a.id_Autor");

            while (rs.next()) {
                String descripcion = rs.getString(1);
                String nombre = rs.getString(2);
                String nacionalidad = rs.getString(3);

                DtoListadoLibros dto = new DtoListadoLibros(descripcion, nombre, nacionalidad);
                lista.add(dto);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<DtoNombreAutor> obtenerDatosAutor(String nombreAutor) {
        ArrayList<DtoNombreAutor> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("select nacionalidad, descripcion, tipo\n"
                    + "from Libros l join Autores a on l.id_Autor = a.id_Autor\n"
                    + "join Prestamos p on l.tipo_Prestamo = p.id_Prestamo\n"
                    + "where nombre = ?");

            pstmt.setString(1, nombreAutor);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nacionalidad = rs.getString(1);
                String descripcion = rs.getString(2);
                String tipoPrestamo = rs.getString(3);

                DtoNombreAutor dtoNombreAutor = new DtoNombreAutor(nacionalidad, descripcion, tipoPrestamo);
                lista.add(dtoNombreAutor);
            }

            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Prestamo> obtenerTodosLosPrestamos() {
        ArrayList<Prestamo> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Prestamos");

            while (rs.next()) {
                int idPrestamo = rs.getInt(1);
                String tipo = rs.getString(2);

                Prestamo prestamo = new Prestamo(idPrestamo, tipo);
                lista.add(prestamo);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public void cargarLibro(Libro nuevo) {
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Libros VALUES (?,?,?)");

            pstmt.setString(1, nuevo.getDescripcion());
            pstmt.setInt(2, nuevo.getPrestamo().getIdPrestamo());
            pstmt.setInt(3, nuevo.getAutor().getId_Autor());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Autor> obtenerTodosLosAutores(){
        ArrayList<Autor> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Autores");

            while (rs.next()) {
                int idAutor = rs.getInt(1);
                String nombre = rs.getString(2);

                Autor autor = new Autor(idAutor, nombre);
                lista.add(autor);
            }

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
    public Libro obtenerLibroPorId(int id) {

        Libro resultado = null;

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("SELECT id_Libro, descripcion FROM Libros WHERE id_Libro=?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int idLibro = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                resultado = new Libro(idLibro, descripcion);
            }

            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;

    }
    
    public void actualizarDescripcionDeUnLibro(Libro libro){
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Libros SET descripcion=? WHERE id_Libro=?");
            pstmt.setString(1, libro.getDescripcion());
            pstmt.setInt(2, libro.getIdLibro());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public float porcentajeLibrosSoloLectura(){
        float resultado = 0;
        
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select tipo, count(l.tipo_Prestamo)\n" +
                                             "from Prestamos p join Libros l on l.tipo_Prestamo = p.id_Prestamo\n" +
                                             "group by tipo");

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
}
