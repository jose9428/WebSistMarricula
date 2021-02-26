package controlador;

import beans.*;
import com.google.gson.Gson;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlProfesor extends HttpServlet {

    ProfesorDao obj = new ProfesorDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opc = request.getParameter("opc");

        if (opc.equals("guardar")) {
            GuardarProfesor(request, response);
        }

        if (opc.equals("editar")) {
            EditarProfesor(request, response);
        }

        if (opc.equals("eliminar")) {
            EliminarProfesor(request, response);
        }

        if (opc.equals("disponiblesAgreg")) {
            DisponiblesAgreg(request, response);
        }
    }

    protected void DisponiblesAgreg(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String dia = request.getParameter("dia");
        String inicio = request.getParameter("horaInicio");
        String fin = request.getParameter("horaFin");

        List<Profesor> lista = obj.ProfesoresDisponibles(dia, inicio, fin);

        out.print(gson.toJson(lista));
    }

    protected void EliminarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        int res = obj.Eliminar(id);

        request.getSession().setAttribute("eliminar", res);

        response.sendRedirect("./paginas/admin/PagListarProfesores.jsp");
    }

    protected void EditarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Profesor a = new Profesor();
        a.setIdProfesor(Integer.parseInt(request.getParameter("idprofesor")));
        a.setNombreProfesor(request.getParameter("nombre").trim());
        a.setApePaternoProfesor(request.getParameter("apeP").trim());
        a.setApeMaternoProfesor(request.getParameter("apeM").trim());
        a.setDocumento(request.getParameter("dni"));

        int res = obj.Editar(a);

        request.getSession().setAttribute("editar", res);

        response.sendRedirect("./paginas/admin/PagListarProfesores.jsp");
    }

    protected void GuardarProfesor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Profesor a = new Profesor();
        a.setNombreProfesor(request.getParameter("nombre").trim());
        a.setApePaternoProfesor(request.getParameter("apeP").trim());
        a.setApeMaternoProfesor(request.getParameter("apeM").trim());
        a.setDocumento(request.getParameter("dni"));

        int res = obj.Guardar(a);

        request.getSession().setAttribute("guardar", res);

        response.sendRedirect("./paginas/admin/PagListarProfesores.jsp");
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
