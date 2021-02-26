package dao;

import beans.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class CursoDao {

    public List<Curso> Listado() {
        List<Curso> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from curso";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                c.setIdCurso(rs.getInt(1));
                c.setNombreCurso(rs.getString(2));
                c.setCreditos(rs.getInt(3));
                lista.add(c);
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
    
     public int Guardar(Curso c) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "insert into curso values(null  , ? , ? )";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, c.getNombreCurso());
            cs.setInt(2, c.getCreditos());
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

    public int Editar(Curso c) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "update curso set Nombre_curso = ? , Creditos = ? where IdCurso = ?";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setString(1, c.getNombreCurso());
            cs.setInt(2, c.getCreditos());
            cs.setInt(3, c.getIdCurso());
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
            String sql = "delete from Curso where IdCurso = ?";
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

    public Curso BuscarPorId(int id) {
        Curso c = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from Curso where idcurso = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                c = new Curso();
                c.setIdCurso(rs.getInt(1));
                c.setNombreCurso(rs.getString(2));
                c.setCreditos(rs.getInt(3));

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
        return c;
    }

      public List<Curso> ListadoOrdenadoByCurso() {
        List<Curso> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from curso order by Nombre_Curso asc";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                c.setIdCurso(rs.getInt(1));
                c.setNombreCurso(rs.getString(2));
                c.setCreditos(rs.getInt(3));
                lista.add(c);
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
}
