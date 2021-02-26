package dao;

import beans.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class ProfesorDao {

    public List<Profesor> Listado() {
        List<Profesor> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from profesor p inner join usuario u on p.Idusuario = u.Idusuario";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Profesor a = new Profesor();
                a.setIdProfesor(rs.getInt(1));
                a.setNombreProfesor(rs.getString(2));
                a.setApePaternoProfesor(rs.getString(3));
                a.setApeMaternoProfesor(rs.getString(4));
                a.setDocumento(rs.getString(5));
                a.setIdUsuario(rs.getInt(6));
                a.setPerfil(rs.getString(8));
                a.setUsuario(rs.getString(9));
                a.setContraseia(rs.getString(10));
                a.setFechaCreacion(rs.getString(11));
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

    public int Guardar(Profesor a) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement cs = conn.prepareCall("{call sp_agregar_profesor(?,?,?,?)}");
            cs.setString(1, a.getNombreProfesor());
            cs.setString(2, a.getApePaternoProfesor());
            cs.setString(3, a.getApeMaternoProfesor());
            cs.setString(4, a.getDocumento());
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

    public int Editar(Profesor a) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "update profesor  set Nombre = ? , Apellido_Paterno = ? , Apellido_Materno = ? ,  Documento = ? "
                    + " where idprofesor = ?";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, a.getNombreProfesor());
            cs.setString(2, a.getApePaternoProfesor());
            cs.setString(3, a.getApeMaternoProfesor());
            cs.setString(4, a.getDocumento());
            cs.setInt(5, a.getIdProfesor());

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
            String sql = "delete from profesor where idprofesor = ?";
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

    public Profesor BuscarPorId(int id) {
        Profesor a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from profesor a inner join usuario u on a.Idusuario = u.Idusuario where idprofesor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Profesor();
                a.setIdProfesor(rs.getInt(1));
                a.setNombreProfesor(rs.getString(2));
                a.setApePaternoProfesor(rs.getString(3));
                a.setApeMaternoProfesor(rs.getString(4));
                a.setDocumento(rs.getString(5));
                a.setIdUsuario(rs.getInt(6));
                a.setPerfil(rs.getString(8));
                a.setUsuario(rs.getString(9));
                a.setContraseia(rs.getString(10));
                a.setFechaCreacion(rs.getString(11));
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

    public List<Profesor> ProfesoresDisponibles(String dia, String inicio, String fin) {
        List<Profesor> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from profesor "
                    + " where idProfesor not in (select idProfesor from seccion "
                    + " where dia = ? and ((HoraInicio >= ? and HoraInicio <= ?) or (HoraFin >= ? and HoraFin <= ?)))"
                    + " order by Apellido_Paterno asc , Apellido_Materno asc";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dia);
            st.setString(2, inicio);
            st.setString(3, fin);
            st.setString(4, inicio);
            st.setString(5, fin);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Profesor a = new Profesor();
                a.setIdProfesor(rs.getInt(1));
                a.setNombreProfesor(rs.getString(2));
                a.setApePaternoProfesor(rs.getString(3));
                a.setApeMaternoProfesor(rs.getString(4));
                a.setDocumento(rs.getString(5));
                a.setIdUsuario(rs.getInt(6));
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
    
      public Profesor BuscarPorIdUsuario(int id) {
        Profesor a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from profesor a inner join usuario u on a.Idusuario = u.Idusuario where u.idusuario = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Profesor();
                a.setIdProfesor(rs.getInt(1));
                a.setNombreProfesor(rs.getString(2));
                a.setApePaternoProfesor(rs.getString(3));
                a.setApeMaternoProfesor(rs.getString(4));
                a.setDocumento(rs.getString(5));
                a.setIdUsuario(rs.getInt(6));
                a.setPerfil(rs.getString(8));
                a.setUsuario(rs.getString(9));
                a.setContraseia(rs.getString(10));
                a.setFechaCreacion(rs.getString(11));
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
