package controlador;

import beans.Alumno;
import beans.Matricula;
import beans.Profesor;
import beans.Seccion;
import beans.Usuario;
import dao.AlumnoDao;
import dao.MatriculaDao;
import dao.ProfesorDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlLogin extends HttpServlet {

    UsuarioDao objUsuario = new UsuarioDao();
    AlumnoDao objAlumno = new AlumnoDao();
    ProfesorDao objProf = new ProfesorDao();
    MatriculaDao objMatricula = new MatriculaDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("iniciarSesion")) {
            IniciarSesion(request, response);
        }

        if (opc.equals("cerrarSesion")) {
            CerrarSesion(request, response);
        }
    }

    protected void CerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute("usuario", null);
        request.getSession().setAttribute("carrito", new ArrayList<>());

        response.sendRedirect("./index.jsp");
    }

    protected void IniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String usuario = request.getParameter("username");
        String pass = request.getParameter("pass");

        String pagina = "";
        Usuario user = null;

        if (usuario.equals("admin") && pass.equals("admin")) {
            user = new Usuario();
            user.setPerfil("admin");
            user.setUsuario("admin");
            user.setNombreCompleto("Administrador");
            pagina = "./paginas/admin/PagListarSecciones.jsp";
        } else {

            user = objUsuario.IniciarSesion(usuario, pass);

            if (user != null) {
                if (user.getPerfil().trim().equals("ALUMNO")) {
                    Alumno a = objAlumno.BuscarPorIdUsuario(user.getIdUsuario());

                    Matricula m = objMatricula.BuscarPorAlumno(a.getIdAlumno());

                    user.setEstado(m == null ? 0 : 1); // Cero no cuenta con con matricula | 1 si tiene matricula
                    user.setCodigo(a.getIdAlumno());
                    user.setNombreCompleto(a.getNombreAlumno() + " " + a.getApePAlumno() + " " + a.getApeMAlumno());

                    CrearSesionCarrito(request);

                    if (user.getEstado() == 0) {
                        pagina = "./paginas/matricula/PagCursosDisp.jsp";
                    } else {
                        pagina = "./paginas/matricula/PagMiHorario.jsp";
                    }

                } else if (user.getPerfil().trim().equals("PROFESOR")) {
                    Profesor p = objProf.BuscarPorIdUsuario(user.getIdUsuario());

                    user.setCodigo(p.getIdProfesor());
                    user.setNombreCompleto(p.getNombreProfesor() + " " + p.getApePaternoProfesor() + " " + p.getApeMaternoProfesor());

                    pagina = "./paginas/docente/PagSeccion.jsp";
                }
            } else {
                pagina = "index.jsp";
            }

        }
        request.getSession().setAttribute("usuario", user);
        response.sendRedirect(pagina);
    }

    public void CrearSesionCarrito(HttpServletRequest request) {
        List<Seccion> lista = new ArrayList<>();

        request.getSession().setAttribute("carrito", lista);
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
