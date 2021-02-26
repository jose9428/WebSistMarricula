package controlador;

import beans.*;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlCurso extends HttpServlet {

    CursoDao obj = new CursoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("guardar")) {
            GuardarCurso(request, response);
        }

        if (opc.equals("editar")) {
            EditarCurso(request, response);
        }

        if (opc.equals("eliminar")) {
            EliminarCurso(request, response);
        }
    }

    protected void EliminarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        int res = obj.Eliminar(id);

        request.getSession().setAttribute("eliminar", res);

        response.sendRedirect("./paginas/admin/PagListarCursos.jsp");
    }

    protected void EditarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Curso c = new Curso();
        c.setNombreCurso(request.getParameter("nombre").trim());
        c.setCreditos(Integer.parseInt(request.getParameter("creditos")));
        c.setIdCurso(Integer.parseInt(request.getParameter("idcurso")));
        
        int res = obj.Editar(c);

        request.getSession().setAttribute("editar", res);

        response.sendRedirect("./paginas/admin/PagListarCursos.jsp");
    }

    protected void GuardarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Curso c = new Curso();
        c.setNombreCurso(request.getParameter("nombre").trim());
        c.setCreditos(Integer.parseInt(request.getParameter("creditos")));

        int res = obj.Guardar(c);

        request.getSession().setAttribute("guardar", res);

        response.sendRedirect("./paginas/admin/PagListarCursos.jsp");
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
