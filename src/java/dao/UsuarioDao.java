package dao;

import beans.*;
import java.sql.*;
import util.MySQLConexion;

public class UsuarioDao {

    public Usuario IniciarSesion(String user, String pass) {
        Usuario a = null;
        Connection conn = null;
        try {

            conn = MySQLConexion.getConexion();
            String sql = "select * from usuario where usuario = ? and contrasena = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                a = new Usuario();
                a.setIdUsuario(rs.getInt(1));
                a.setPerfil(rs.getString(2));
                a.setUsuario(rs.getString(3));
                a.setContraseia(rs.getString(4));
                a.setFechaCreacion(rs.getString(5));
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
