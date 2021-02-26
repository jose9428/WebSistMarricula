package dao;

import beans.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class AlumnoDao {

    public List<Alumno> Listado() {
        List<Alumno> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from alumnos a inner join usuario u on a.Idusuario = u.Idusuario";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setIdUsuario(rs.getInt(2));
                a.setNombreAlumno(rs.getString(3));
                a.setApePAlumno(rs.getString(4));
                a.setApeMAlumno(rs.getString(5));
                a.setFechaNac(rs.getString(6));
                a.setDireccion(rs.getString(7));
                a.setTelefono(rs.getString(8));
                a.setEmail(rs.getString(9));
                a.setDocumento(rs.getString(10));
                a.setEstado(rs.getShort(11));
                a.setApoderado(rs.getString(12));
                a.setPerfil(rs.getString(14));
                a.setUsuario(rs.getString(15));
                a.setContraseia(rs.getString(16));
                a.setFechaCreacion(rs.getString(17));
                lista.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    public int Guardar(Alumno a) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement cs = conn.prepareCall("{call sp_agregar_alumno(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, a.getNombreAlumno());
            cs.setString(2, a.getApePAlumno());
            cs.setString(3, a.getApeMAlumno());
            cs.setString(4, a.getFechaNac());
            cs.setString(5, a.getDireccion());
            cs.setString(6, a.getTelefono());
            cs.setString(7, a.getEmail());
            cs.setString(8, a.getDocumento());
            cs.setInt(9, a.getEstado());
            cs.setString(10, a.getApoderado());

            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return res;
    }

    public int Editar(Alumno a) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "update alumnos  set Nombre = ? , Apellido_Paterno = ? , Apellido_Materno = ? , FecNac = ? , Direccion = ? ,"
                    + " Telefono = ? , Email = ? , Documento = ? , Estado = ? , Apoderado = ? where idalumno = ?";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, a.getNombreAlumno());
            cs.setString(2, a.getApePAlumno());
            cs.setString(3, a.getApeMAlumno());
            cs.setString(4, a.getFechaNac());
            cs.setString(5, a.getDireccion());
            cs.setString(6, a.getTelefono());
            cs.setString(7, a.getEmail());
            cs.setString(8, a.getDocumento());
            cs.setInt(9, a.getEstado());
            cs.setString(10, a.getApoderado());
            cs.setInt(11, a.getIdAlumno());
            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return res;
    }

    public int Eliminar(int id) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "delete from alumnos where idalumno = ?";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setInt(1, id);
            res = cs.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return res;
    }

    public Alumno BuscarPorId(int id) {
        Alumno a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from alumnos a inner join usuario u on a.Idusuario = u.Idusuario where idalumno = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setIdUsuario(rs.getInt(2));
                a.setNombreAlumno(rs.getString(3));
                a.setApePAlumno(rs.getString(4));
                a.setApeMAlumno(rs.getString(5));
                a.setFechaNac(rs.getString(6));
                a.setDireccion(rs.getString(7));
                a.setTelefono(rs.getString(8));
                a.setEmail(rs.getString(9));
                a.setDocumento(rs.getString(10));
                a.setEstado(rs.getShort(11));
                a.setApoderado(rs.getString(12));
                a.setPerfil(rs.getString(14));
                a.setUsuario(rs.getString(15));
                a.setContraseia(rs.getString(16));
                a.setFechaCreacion(rs.getString(17));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return a;
    }

    public List<Alumno> AlumnosPorSeccion(int idSeccion) {
        List<Alumno> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select idalumno , usuario , nombre , apellido_paterno , Apellido_Materno , email "
                    + " from alumnos a inner join usuario u "
                    + " on a.idusuario = u.idusuario "
                    + " where idalumno in (select idalumno from detallematricula d inner join matricula m "
                    + " on m.IdMatricula = d.IdMatricula where idSeccion = ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idSeccion);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setUsuario(rs.getString(2));
                a.setNombreAlumno(rs.getString(3));
                a.setApePAlumno(rs.getString(4));
                a.setApeMAlumno(rs.getString(5));
                a.setEmail(rs.getString(6));
                lista.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lista;
    }
    
      public Alumno BuscarPorIdUsuario(int id) {
        Alumno a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from alumnos a inner join usuario u on a.Idusuario = u.Idusuario where u.idusuario = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setIdUsuario(rs.getInt(2));
                a.setNombreAlumno(rs.getString(3));
                a.setApePAlumno(rs.getString(4));
                a.setApeMAlumno(rs.getString(5));
                a.setFechaNac(rs.getString(6));
                a.setDireccion(rs.getString(7));
                a.setTelefono(rs.getString(8));
                a.setEmail(rs.getString(9));
                a.setDocumento(rs.getString(10));
                a.setEstado(rs.getShort(11));
                a.setApoderado(rs.getString(12));
                a.setPerfil(rs.getString(14));
                a.setUsuario(rs.getString(15));
                a.setContraseia(rs.getString(16));
                a.setFechaCreacion(rs.getString(17));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return a;
    }

}
