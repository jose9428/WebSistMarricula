package dao;

import beans.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

public class MatriculaDao {

    public int Guardar(Matricula m, List<Seccion> lista) {
        int idMatricula = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement cs = conn.prepareCall("{call sp_agregar_matricula(?,?)}");
            cs.setInt(1, m.getIdAlumno());
            cs.setInt(2, m.getEstado());
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                idMatricula = rs.getInt(1);

                CallableStatement cs2 = conn.prepareCall("{call sp_agregar_detalleMatricula(?,?)}");

                for (Seccion s : lista) {
                    cs2.setInt(1, idMatricula);
                    cs2.setInt(2, s.getIdSeccion());

                    cs2.executeUpdate();
                }
            } else {
                conn.rollback(); // Deshacer Cambios
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
        return idMatricula;
    }

    public Matricula BuscarPorAlumno(int idAlumno) {
        Matricula m = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from matricula where idAlumno =?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idAlumno);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                m = new Matricula();
                m.setIdMatricula(rs.getInt(1));
                m.setIdAlumno(rs.getInt(2));
                m.setFecha(rs.getString(3));
                m.setEstado(rs.getInt(4));
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
        return m;
    }

    public List<Matricula> MisCursosMatricula(int idAlumno) {
        List<Matricula> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select s.idSeccion ,c.nombre_curso,  CONCAT(p.Nombre ,' ' ,p.Apellido_Paterno , ' ',p.Apellido_Materno ), dia , horaInicio , horaFin ,creditos "
                    + " from seccion s inner join detallematricula d "
                    + " on s.idSeccion = d.idSeccion inner join matricula m "
                    + " on m.idmatricula = d.idmatricula "
                    + " inner join curso  c "
                    + " on c.idcurso = s.idcurso "
                    + " inner join profesor p "
                    + " on p.IdProfesor = s.IdProfesor "
                    + " where idalumno = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idAlumno);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdSeccion(rs.getInt(1));
                m.setNomCurso(rs.getString(2));
                m.setNomProfesor(rs.getString(3));
                m.setDia(rs.getString(4));
                m.setHoraInicio(rs.getString(5));
                m.setHoraFin(rs.getString(6));
                m.setCreditos(rs.getInt(7));
                lista.add(m);
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

    public int EliminarMatricula(int nroMatricula) {
        int res = 0;
        Connection conn = null;

        try {
            conn = MySQLConexion.getConexion();
            CallableStatement cs = conn.prepareCall("{call sp_eliminar_matricula2(?)}");
            cs.setInt(1, nroMatricula);
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
    
      public List<Matricula> MisCursosDocente(int idDocente) {
        List<Matricula> lista = new ArrayList<>();
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select s.idSeccion ,c.nombre_curso,  CONCAT(p.Nombre ,' ' ,p.Apellido_Paterno , ' ',p.Apellido_Materno ), dia , horaInicio , horaFin ,creditos  "
                    + "   from seccion s  inner join curso  c "
                    + " on c.idcurso = s.idcurso "
                    + " inner join profesor p "
                    + "  on p.IdProfesor = s.IdProfesor "
                    + "where p.IdProfesor = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idDocente);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdSeccion(rs.getInt(1));
                m.setNomCurso(rs.getString(2));
                m.setNomProfesor(rs.getString(3));
                m.setDia(rs.getString(4));
                m.setHoraInicio(rs.getString(5));
                m.setHoraFin(rs.getString(6));
                m.setCreditos(rs.getInt(7));
                lista.add(m);
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
