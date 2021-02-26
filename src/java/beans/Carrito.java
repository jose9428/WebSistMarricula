package beans;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Carrito {

    public static List<Seccion> ObtenerCarrito(HttpServletRequest request) {
        List<Seccion> lista = null;
        HttpSession session = request.getSession();

        if (session.getAttribute("carrito") == null) {
            lista = new ArrayList<>();
        } else {
            lista = (ArrayList<Seccion>) session.getAttribute("carrito");
        }
        return lista;
    }

    public static boolean ExisteCurso(List<Seccion> lista, int idCurso) {

        for (Seccion s : lista) {
            if (s.getIdCurso() == idCurso) {
                return true;
            }
        }

        return false;
    }

    public static List<Seccion> EliminarPorCurso(List<Seccion> lista, int idCurso) {

        for (int i = 0; i < lista.size(); i++) {
            Seccion s = lista.get(i);
            if (s.getIdCurso() == idCurso) {
                lista.remove(i);
            }
        }

        return lista;
    }

    public static int SumaCreditos(List<Seccion> lista) {
        int suma = 0;
        for (Seccion s : lista) {
            suma += s.getCreditos();
        }

        return suma;
    }

    public static boolean ExisteCruce(List<Seccion> lista, String dia, String horaInicio, String horaFin) {
        int inicioEvaluar = TotalEntero(horaInicio);
        int finEvaluar = TotalEntero(horaFin);
        int contador = 0;

        if (lista.size() == 0) {
            return false;
        }

        for (int i = 0; i < lista.size(); i++) {
            Seccion s = lista.get(i);
            int inicioSecc = TotalEntero(s.getHoraInicio());
            int finSecc = TotalEntero(s.getHoraFin());

            //  boolean cruce1 = inicioSecc >= inicioEvaluar && inicioEvaluar <= finSecc;
            // boolean cruce2 = inicioSecc >= finEvaluar && finEvaluar <= finSecc;
            boolean cruce1 = inicioEvaluar >= inicioSecc && inicioEvaluar <= finSecc; // si es falso no hay cruce
            boolean cruce2 = finEvaluar >= inicioSecc && finEvaluar <= finSecc;// si es falso no hay cruce

            // Si hay cruce
            if (cruce1 == true || cruce2 == true) {
                if (s.getDia().equalsIgnoreCase(dia)) {
                    contador++;
                }
            }
        }

        if (contador > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int TotalEntero(String hora) {
        String rangoHora[] = hora.split(":");

        return Integer.parseInt(rangoHora[0]) * 60 + Integer.parseInt(rangoHora[1]);
    }

}
