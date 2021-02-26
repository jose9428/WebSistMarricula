package controlador;

import beans.Alumno;
import beans.Carrito;
import beans.Matricula;
import beans.Seccion;
import beans.Usuario;
import dao.AlumnoDao;
import dao.MatriculaDao;
import dao.SeccionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlCarrito extends HttpServlet {

    SeccionDao objSeccion = new SeccionDao();
    MatriculaDao objMatricula = new MatriculaDao();
    AlumnoDao objAlumno = new AlumnoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("agregar")) {
            Guardar(request, response);
        }

        if (opc.equals("eliminar")) {
            Eliminar(request, response);
        }

        if (opc.equals("procesar")) {
            Procesar(request, response);
        }

        if (opc.equals("anularMatricula")) {
            AnularMatricula(request, response);
        }
    }

    protected void AnularMatricula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int nro = Integer.parseInt(request.getParameter("nro"));

        objMatricula.EliminarMatricula(nro);

        //Actualizar estado de la matricula
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        Alumno a = objAlumno.BuscarPorIdUsuario(user.getIdUsuario());
        Matricula m = objMatricula.BuscarPorAlumno(a.getIdAlumno());
        user.setEstado(m == null ? 0 : 1); // Cero no cuenta con con matricula | 1 si tiene matricula
        request.getSession().setAttribute("usuario", user);

        response.sendRedirect("./paginas/matricula/PagMiHorario.jsp");
    }

    protected void Procesar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        List<Seccion> lista = Carrito.ObtenerCarrito(request);
        Matricula m = new Matricula();
        m.setIdAlumno(user.getCodigo());
        m.setEstado(1);

        int idMatricula = objMatricula.Guardar(m, lista);

        if (idMatricula > 0) {
            request.getSession().setAttribute("carrito", new ArrayList<>());

            //Actualizar estado de la matricula
            Alumno a = objAlumno.BuscarPorIdUsuario(user.getIdUsuario());
            m = objMatricula.BuscarPorAlumno(a.getIdAlumno());

            user.setEstado(m == null ? 0 : 1); // Cero no cuenta con con matricula | 1 si tiene matricula
            request.getSession().setAttribute("usuario", user);
        }

        response.sendRedirect("./paginas/matricula/PagMiHorario.jsp");
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int idCurso = Integer.parseInt(request.getParameter("id"));

        List<Seccion> lista = Carrito.ObtenerCarrito(request);

        lista = Carrito.EliminarPorCurso(lista, idCurso);

        request.getSession().setAttribute("carrito", lista);

        response.sendRedirect("./paginas/matricula/PagCursosDisp.jsp");
    }

    protected void Guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int idSeccion = Integer.parseInt(request.getParameter("id"));
        Seccion s = objSeccion.BuscarPorId(idSeccion);

        List<Seccion> lista = Carrito.ObtenerCarrito(request);

        lista.add(s);

        request.getSession().setAttribute("carrito", lista);

        response.sendRedirect("./paginas/matricula/PagCursosDisp.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
