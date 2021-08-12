package GestorBD;

import DTO.DtoConsultaCurso;
import Modelo.Alumno;
import Modelo.Aula;
import Modelo.Curso;
import Modelo.Descuento;
import Modelo.Programa;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.math.*;

public class GestorBD {

    private final String CONN = "jdbc:sqlserver://DESKTOP-L6VL4CS\\FJLORENZO:1433;databaseName=AcademiaLab4";
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

    public void insertarAlumno(Alumno alumno) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Alumno VALUES (?,?,?)");

            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getApellido());
            pstmt.setString(3, alumno.getDireccion());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void insertarPrograma(Programa programa) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Programa (nombre, tamaño, version, habilitado, alumno, ruta_descarga) VALUES (?,?,?,?,?,?)");

            pstmt.setString(1, programa.getNombre());
            pstmt.setString(2, programa.getTamanio());
            pstmt.setString(3, programa.getVersion());
            pstmt.setBoolean(4, programa.isHabilitado());
            pstmt.setInt(5, programa.getAlumno().getId());
            pstmt.setString(6, programa.getRutaDescarga());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void insertarCurso(Curso curso) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Curso VALUES (?,?,?,?)");

            pstmt.setString(1, curso.getNombre());
            pstmt.setInt(2, curso.getAula().getId());
            pstmt.setInt(3, curso.getDescuento().getId());
            pstmt.setFloat(4, curso.getPrecio());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void modificarAlumno(Alumno alumno) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Alumno SET nombre=?, apellido=?, direccion=? WHERE id=?");
            pstmt.setString(1, alumno.getNombre());
            pstmt.setString(2, alumno.getApellido());
            pstmt.setString(3, alumno.getDireccion());
            pstmt.setInt(4, alumno.getId());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void modificarCurso(Curso curso) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Curso SET nombre=?, aula=?, descuento=?, precio=? WHERE id=?");
            pstmt.setString(1, curso.getNombre());
            pstmt.setInt(2, curso.getAula().getId());
            pstmt.setInt(3, curso.getDescuento().getId());
            pstmt.setFloat(4, curso.getPrecio());
            pstmt.setInt(5, curso.getId());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Aula> obtenerTodasLasAulas() {
        ArrayList<Aula> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Aula");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);

                Aula aula = new Aula(id, nombre);
                lista.add(aula);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<Descuento> obtenerTodosLosDescuentos() {
        ArrayList<Descuento> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Descuento");

            while (rs.next()) {
                int id = rs.getInt(1);
                int porcentaje = rs.getInt(2);

                Descuento descuento = new Descuento(id, porcentaje);
                lista.add(descuento);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<Alumno> obtenerTodosLosAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Alumno");

            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String direccion = rs.getString(4);

                Alumno alumno = new Alumno(id, nombre, apellido, direccion);
                lista.add(alumno);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DtoConsultaCurso> obtenerTodosLosCursos() {
        ArrayList<DtoConsultaCurso> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select c.id, c.nombre, a.nombre, d.porcentaje, precio\n"
                    + "from Curso c join Descuento d on c.descuento = d.id\n"
                    + "join Aula a on a.id = c.aula");

            while (rs.next()) {
                int idCurso = rs.getInt(1);
                String nombreCurso = rs.getString(2);
                String nombreAula = rs.getString(3);
                int porcentaje = rs.getInt(4);
                float precio = rs.getFloat(5);

                DtoConsultaCurso dtoConsulta = new DtoConsultaCurso(idCurso, nombreCurso, nombreAula, porcentaje, precio);
                lista.add(dtoConsulta);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public void eliminarUnCurso(int idCurso) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM CursoAlumnos WHERE curso=?");
            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();

            pstmt = conexion.prepareStatement("DELETE FROM Curso WHERE id=?");
            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void eliminarUnAlumno(int idAlumno) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM CursoAlumnos WHERE alumno=?");
            pstmt.setInt(1, idAlumno);
            pstmt.executeUpdate();

            pstmt = conexion.prepareStatement("DELETE FROM Programa WHERE alumno=?");
            pstmt.setInt(1, idAlumno);
            pstmt.executeUpdate();

            pstmt = conexion.prepareStatement("DELETE FROM Alumno WHERE id=?");
            pstmt.setInt(1, idAlumno);
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void insertarAlumnoEnCurso(Alumno alumno, Curso curso) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO CursoAlumnos VALUES (?,?)");

            pstmt.setInt(1, alumno.getId());
            pstmt.setInt(2, curso.getId());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Curso> obtenerTotalFacturadoPorCurso() {
        ArrayList<Curso> listaFacturado = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select c.nombre 'Curso', porcentaje, c.precio, count(ca.alumno)\n"
                    + "from Curso c join CursoAlumnos ca on c.id = ca.curso\n"
                    + "join Descuento d on d.id = c.descuento\n"
                    + "group by c.nombre, porcentaje, c.precio");

            while (rs.next()) {
                String nombreCurso = rs.getString(1);
                float porcentaje = rs.getFloat(2);
                float precio = rs.getFloat(3);
                int cantAlumnos = rs.getInt(4);

                float totalFacturadoConDescuento = cantAlumnos * (precio - (precio * (porcentaje / 100)));

                Curso curso = new Curso(nombreCurso, totalFacturadoConDescuento);
                listaFacturado.add(curso);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaFacturado;
    }

    public ArrayList<Alumno> obtenerAlumnosConDescuento() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct a.nombre + ' ' + a.apellido 'Alumno'\n"
                    + "from Alumno a join CursoAlumnos ca on a.id = ca.alumno\n"
                    + "join Curso c on c.id = ca.curso\n"
                    + "where descuento <> 1");

            while (rs.next()) {
                String nombreAlumno = rs.getString(1);

                Alumno alumno = new Alumno(nombreAlumno);
                listaAlumnos.add(alumno);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaAlumnos;
    }

    public float obtenerSumatoriaTotalDescuentosRealizados() {
        float sumatoriaTotal = 0;

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select ca.alumno, d.porcentaje, precio\n"
                    + "from Curso c join Descuento d on c.descuento = d.id\n"
                    + "     join CursoAlumnos ca on ca.curso = c.id\n"
                    + "where c.descuento <> 1");

            while (rs.next()) {
                float porcentaje = rs.getInt(2);
                float precio = rs.getFloat(3);

                sumatoriaTotal += precio - (precio * (porcentaje / 100));
                sumatoriaTotal = Math.round(sumatoriaTotal);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return sumatoriaTotal;
    }

    public Alumno obtenerAlumnoPorId(int idAlumno) {
        Alumno alumno = null;
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select * from Alumno where id = ?");
            pstmt.setInt(1, idAlumno);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String direccion = rs.getString(4);

                alumno = new Alumno(idAlumno, nombre, apellido, direccion);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return alumno;
    }

    public Curso obtenerCursoPorId(int idCurso) {
        Curso curso = null;
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select * from Curso where id = ?");
            pstmt.setInt(1, idCurso);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString(2);
                int idAula = rs.getInt(3);
                int idDescuento = rs.getInt(4);
                float precio = rs.getFloat(5);

                Aula aula = obtenerAulaPorId(idAula);
                Descuento descuento = obtenerDescuentoPorId(idDescuento);

                curso = new Curso(idCurso, nombre, aula, descuento, precio);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return curso;
    }

    public Aula obtenerAulaPorId(int idAula) {
        Aula aula = null;
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select * from Aula where id = ?");
            pstmt.setInt(1, idAula);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString(2);

                aula = new Aula(idAula, nombre);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return aula;
    }

    public Descuento obtenerDescuentoPorId(int idDescuento) {
        Descuento descuento = null;
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select * from Descuento where id = ?");
            pstmt.setInt(1, idDescuento);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int porcentaje = rs.getInt(2);

                descuento = new Descuento(idDescuento, porcentaje);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return descuento;
    }

    public ArrayList<Programa> obtenerTodosLosProgramas() {
        ArrayList<Programa> listaProgramas = new ArrayList<>();

        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select p.id, p.nombre, tamaño, version, a.nombre, a.apellido, descargas, ruta_descarga\n"
                    + "from Programa p join Alumno a on a.id = p.alumno\n"
                    + "where habilitado = 1");

            while (rs.next()) {
                int idPrograma = rs.getInt(1);
                String nombre = rs.getString(2);
                String tamanio = rs.getString(3);
                String version = rs.getString(4);
                String nombreAlumno = rs.getString(5);
                String apellidoAlumno = rs.getString(6);
                int descargas = rs.getInt(7);
                String rutaDescarga = rs.getString(8);

                Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
                Programa programa = new Programa(idPrograma, nombre, tamanio, version, alumno, descargas, rutaDescarga);
                listaProgramas.add(programa);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaProgramas;
    }

    public ArrayList<Programa> obtenerTop5Programas() {
        ArrayList<Programa> listaTop5 = new ArrayList<>();
        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select top 5 p.nombre, a.nombre, a.apellido\n"
                    + "from Programa p join Alumno a on a.id = p.alumno\n"
                    + "where habilitado = 1\n"
                    + "order by descargas desc");

            while (rs.next()) {
                String nombre = rs.getString(1);
                String nombreAlumno = rs.getString(2);
                String apellidoAlumno = rs.getString(3);

                Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
                Programa programa = new Programa(nombre, alumno);
                listaTop5.add(programa);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaTop5;
    }

    public ArrayList<Programa> obtenerProgramasDeshabilitados() {
        ArrayList<Programa> listaDeshabilitados = new ArrayList<>();
        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select p.id, p.nombre, tamaño, version, a.nombre, a.apellido\n"
                    + "from Programa p join Alumno a on a.id = p.alumno\n"
                    + "where habilitado = 0");

            while (rs.next()) {
                int idPrograma = rs.getInt(1);
                String nombre = rs.getString(2);
                String tamanio = rs.getString(3);
                String version = rs.getString(4);
                String nombreAlumno = rs.getString(5);
                String apellidoAlumno = rs.getString(6);

                Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
                Programa programa = new Programa(idPrograma, nombre, tamanio, version, alumno);
                listaDeshabilitados.add(programa);
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaDeshabilitados;
    }

    public void habilitarPrograma(int idPrograma) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Programa SET habilitado=1 WHERE id=?");
            pstmt.setInt(1, idPrograma);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void agregarDescarga(int idPrograma, int descargas) {
        try {
            descargas += 1;
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("UPDATE Programa SET descargas=? WHERE id=?");
            pstmt.setInt(1, descargas);
            pstmt.setInt(2, idPrograma);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void inscribirAlumnoEnCurso(int idAlumno, int idCurso) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO CursoAlumnos VALUES (?,?)");

            pstmt.setInt(1, idAlumno);
            pstmt.setInt(2, idCurso);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void insertarUsuario(String nombre, String contraseña) {
        try {
            abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("INSERT INTO Usuario VALUES (?,?)");

            pstmt.setString(1, nombre);
            pstmt.setString(2, contraseña);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public boolean ingresoUsuario(String nombre, String contraseña) {
        boolean sesionCorrecta = false;
        try {
            abrirConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Usuario");

            while (rs.next()) {
                String nombreUsuario = rs.getString(1);
                String contraseñaUsuario = rs.getString(2);

                if (nombreUsuario.equals(nombre) & contraseñaUsuario.equals(contraseña)) {
                    sesionCorrecta = true;
                    break;
                }
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return sesionCorrecta;
    }

    public ArrayList<Alumno> obtenerAlumnosEnCursoSeleccionado(int idCurso) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        try {
             abrirConexion();
            PreparedStatement pstmt = conexion.prepareStatement("select a.nombre, a.apellido\n"
                                                                +"from CursoAlumnos ca join Alumno a on a.id = ca.alumno\n"
                                                                +"where ca.curso=?");
            pstmt.setInt(1, idCurso);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                String nombreAlumno = rs.getString(1);
                String apellidoAlumno = rs.getString(2);

                Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno);
                listaAlumnos.add(alumno);
            }

            pstmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return listaAlumnos;
    }
}
