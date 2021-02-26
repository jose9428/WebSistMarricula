package util;

import beans.Alumno;
import beans.Matricula;
import beans.Seccion;
import dao.AlumnoDao;
import dao.MatriculaDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prueba {


    public static void main(String[] args) {
        MySQLConexion.getConexion();

      AlumnoDao obj = new AlumnoDao();
        Alumno a = obj.BuscarPorIdUsuario(1);
        System.out.println(a.toString());

    }

}
