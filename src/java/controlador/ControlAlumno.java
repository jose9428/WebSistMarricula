package controlador;

import beans.Alumno;
import dao.AlumnoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlAlumno extends HttpServlet {

    AlumnoDao obj = new AlumnoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("guardar")) {
            GuardarAlumno(request, response);
        }

        if (opc.equals("editar")) {
            EditarAlumno(request, response);
        }

        if (opc.equals("eliminar")) {
            EliminarAlumno(request, response);
        }
    }

    protected void EliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

      int id = Integer.parseInt(request.getParameter("id"));

        int res = obj.Eliminar(id);

        request.getSession().setAttribute("eliminar", res);

        response.sendRedirect("./paginas/admin/PagListarAlumnos.jsp");
    }

    protected void EditarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Alumno a = new Alumno();
        a.setIdAlumno(Integer.parseInt(request.getParameter("idalumno")));
        a.setNombreAlumno(request.getParameter("nombre").trim());
        a.setApePAlumno(request.getParameter("apeP").trim());
        a.setApeMAlumno(request.getParameter("apeM").trim());
        a.setApoderado(request.getParameter("apoderado").trim());
        a.setFechaNac(request.getParameter("fechaNac"));
        a.setDocumento(request.getParameter("dni"));
        a.setDireccion(request.getParameter("direccion").trim());
        a.setTelefono(request.getParameter("telefono").trim());
        a.setEmail(request.getParameter("correo").trim());
        a.setEstado(Integer.parseInt(request.getParameter("estado")));

        int res = obj.Editar(a);

        request.getSession().setAttribute("editar", res);

        response.sendRedirect("./paginas/admin/PagListarAlumnos.jsp");
    }

    protected void GuardarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Alumno a = new Alumno();
                a.setNombreAlumno(request.getParameter("nombre").trim());
        a.setApePAlumno(request.getParameter("apeP").trim());
        a.setApeMAlumno(request.getParameter("apeM").trim());
        a.setApoderado(request.getParameter("apoderado").trim());
        a.setFechaNac(request.getParameter("fechaNac"));
        a.setDocumento(request.getParameter("dni"));
        a.setDireccion(request.getParameter("direccion").trim());
        a.setTelefono(request.getParameter("telefono").trim());
        a.setEmail(request.getParameter("correo").trim());
        
        a.setEstado(Integer.parseInt(request.getParameter("estado")));

        int res = obj.Guardar(a);

        request.getSession().setAttribute("guardar", res);

        response.sendRedirect("./paginas/admin/PagListarAlumnos.jsp");
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
