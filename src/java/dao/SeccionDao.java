package dao;

import beans.*;
import java.sql.*;
import java.util.*;
import util.MySQLConexion;

public class SeccionDao {

    public List<Seccion> Listado() {
        List<Seccion> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT idSeccion , CONCAT(p.Nombre ,' ' ,p.Apellido_Paterno , ' ',p.Apellido_Materno ), "
                    + " Nombre_Curso , Vacantes , dia , horaInicio , horaFin "
                    + " FROM Seccion s inner join profesor p on s.idProfesor = p.idProfesor "
                    + " inner join curso c on c.idCurso = s.idCurso";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Seccion a = new Seccion();
                a.setIdSeccion(rs.getInt(1));
                a.setNomProfesor(rs.getString(2));
                a.setNomCurso(rs.getString(3));
                a.setVacantes(rs.getInt(4));
                a.setDia(rs.getString(5));
                a.setHoraInicio(rs.getString(6));
                a.setHoraFin(rs.getString(7));
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

    public int GuardarSeccion(Seccion s) {
        int res = 0;
        Connection conn = null;

        try {
            String sql = "insert into seccion values(null , ?,?,?,?,?,?)";
            conn = MySQLConexion.getConexion();
            PreparedStatement cs = conn.prepareStatement(sql);
            cs.setInt(1, s.getIdProfesor());
            cs.setInt(2, s.getIdCurso());
            cs.setInt(3, s.getVacantes());
            cs.setString(4, s.getDia());
            cs.setString(5, s.getHoraInicio());
            cs.setString(6, s.getHoraFin());
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
            String sql = "delete from Seccion where idSeccion = ?";
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

    public List<Seccion> SeccionesDisp(int idCurso) {
        List<Seccion> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT idSeccion , CONCAT(p.Nombre ,' ' ,p.Apellido_Paterno , ' ',p.Apellido_Materno ), "
                    + " Nombre_Curso , Vacantes , dia , horaInicio , horaFin ,  c.idCurso ,   p.idProfesor, c.creditos "
                    + " FROM Seccion s inner join profesor p on s.idProfesor = p.idProfesor "
                    + " inner join curso c on c.idCurso = s.idCurso where s.idcurso = ? and s.vacantes > 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idCurso);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Seccion a = new Seccion();
                a.setIdSeccion(rs.getInt(1));
                a.setNomProfesor(rs.getString(2));
                a.setNomCurso(rs.getString(3));
                a.setVacantes(rs.getInt(4));
                a.setDia(rs.getString(5));
                a.setHoraInicio(rs.getString(6));
                a.setHoraFin(rs.getString(7));
                a.setIdCurso(rs.getInt(8));
                a.setIdProfesor(rs.getInt(9));
                a.setCreditos(rs.getInt(10));
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

    public Seccion BuscarPorId(int idSeccion) {
        Seccion a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "SELECT idSeccion , CONCAT(p.Nombre ,' ' ,p.Apellido_Paterno , ' ',p.Apellido_Materno ), "
                    + " Nombre_Curso , Vacantes , dia , horaInicio , horaFin  ,  c.idCurso  , p.idProfesor , c.creditos "
                    + " FROM Seccion s inner join profesor p on s.idProfesor = p.idProfesor "
                    + " inner join curso c on c.idCurso = s.idCurso where s.idSeccion = ? and s.vacantes > 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idSeccion);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Seccion();
                a.setIdSeccion(rs.getInt(1));
                a.setNomProfesor(rs.getString(2));
                a.setNomCurso(rs.getString(3));
                a.setVacantes(rs.getInt(4));
                a.setDia(rs.getString(5));
                a.setHoraInicio(rs.getString(6));
                a.setHoraFin(rs.getString(7));
                a.setIdCurso(rs.getInt(8));
                a.setIdProfesor(rs.getInt(9));
                a.setCreditos(rs.getInt(10));
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
