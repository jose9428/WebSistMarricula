package controlador;

import beans.*;
import dao.SeccionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlSeccion extends HttpServlet {

    SeccionDao obj = new SeccionDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("guardar")) {
            GuardarSeccion(request, response);
        }

        if (opc.equals("eliminar")) {
            EliminarSeccion(request, response);
        }

    }

    protected void EliminarSeccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        int res = obj.Eliminar(id);

        request.getSession().setAttribute("eliminar", res);

        response.sendRedirect("./paginas/admin/PagListarSecciones.jsp");
    }

    protected void GuardarSeccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Seccion a = new Seccion();
        a.setIdCurso(Integer.parseInt(request.getParameter("idcurso")));
        a.setHoraInicio(request.getParameter("horaInicio"));
        a.setHoraFin(request.getParameter("horaFin"));
        a.setIdProfesor(Integer.parseInt(request.getParameter("idProfesor")));
        a.setVacantes(Integer.parseInt(request.getParameter("vacantes")));
        a.setDia(request.getParameter("dia"));

        int res = obj.GuardarSeccion(a);

        request.getSession().setAttribute("guardar", res);

        response.sendRedirect("./paginas/admin/PagListarSecciones.jsp");
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
