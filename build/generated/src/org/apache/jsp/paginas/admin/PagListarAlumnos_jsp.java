package org.apache.jsp.paginas.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import beans.*;
import dao.*;

public final class PagListarAlumnos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/paginas/admin/../../recurso/recursos.jsp");
    _jspx_dependants.add("/paginas/admin/../../recurso/Navbar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Lista de Alumnos</title>\n");
      out.write("\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../bootstrap/css/bootstrap.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../font-awesome/css/font-awesome.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/local.css\" />\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.10.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://www.prepbootstrap.com/Content/js/gridData.js\"></script>");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");
 String URL = request.getRequestURL().toString();
      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("        </button>\n");
      out.write("        <a class=\"navbar-brand\" href=\"index.html\">Matricula.edu.pe</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse navbar-ex1-collapse\">\n");
      out.write("        <ul class=\"nav navbar-nav side-nav\">\n");
      out.write("            <li class=");
      out.print( URL.contains("PagListarAlumnos") || URL.contains("PagNuevoAlumno")
                    || URL.contains("PagEditarAlumno") ? "active" : "");
      out.write(">\n");
      out.write("                <a href=\"./PagListarAlumnos.jsp\"><i class=\"fa fa-user-md\"></i> Alumnos</a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <li class=");
      out.print( URL.contains("PagListarProfesores") || URL.contains("PagNuevoProfesor")
                        || URL.contains("PagEditarProfesor") ? "active" : "");
      out.write(">\n");
      out.write("                <a href=\"./PagListarProfesores.jsp\"><i class=\"fa fa-user-circle\"></i> Profesores</a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("                <li class=");
      out.print( URL.contains("PagListarCursos") || URL.contains("PagNuevoCurso")
                    || URL.contains("PagEditarCurso") ? "active" : "");
      out.write(">\n");
      out.write("                <a href=\"./PagListarCursos.jsp\"><i class=\"fa fa-tasks\"></i> Cursos</a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("                <li class=");
      out.print( URL.contains("PagListarSecciones") || URL.contains("PagNuevaSeccion")
                        || URL.contains("PagEditarSeccion") ? "active" : "");
      out.write(">\n");
      out.write("                <a href=\"./PagListarSecciones.jsp\"><i class=\"fa fa-table\"></i> Secciones</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- PARTE ALUMNO LOGEADO--> \n");
      out.write("                <li class=");
      out.print( URL.contains("PagCursosDisp")  || URL.contains("PagSeccionesDisp")? "active" : "");
      out.write(">\n");
      out.write("                <a href=\"./PagCursosDisp.jsp\"><i class=\"fa fa-tasks\"></i> Matricula</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right navbar-user\">\n");
      out.write("            <li class=\"dropdown user-dropdown\">\n");
      out.write("                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"fa fa-user\"></i> Steve Miller<b class=\"caret\"></b></a>\n");
      out.write("                <ul class=\"dropdown-menu\">\n");
      out.write("\n");
      out.write("                    <li><a href=\"#\"><i class=\"fa fa-power-off\"></i> Cerrar Sesion</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("                ");

                    String mensaje = "", alerta = "";
                    int res = 0;
                    if (request.getSession().getAttribute("guardar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("guardar").toString());
                        request.getSession().setAttribute("guardar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Alumno registrado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido registrar el alumno";
                        }
                    }

                    if (request.getSession().getAttribute("eliminar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("eliminar").toString());
                        request.getSession().setAttribute("eliminar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Alumno eliminado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido eliminar al alumno. Se ha encontrado que esta registrado en una matricula.";
                        }
                    }

                    if (request.getSession().getAttribute("editar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("editar").toString());
                        request.getSession().setAttribute("editar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Alumno actualizado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido actualizar datos del alumno";
                        }
                    }


                
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <a href=\"PagNuevoAlumno.jsp\" class=\"btn btn-success\">Nuevo alumno</a>\n");
      out.write("\n");
      out.write("                    ");
                        if (!mensaje.equals("")) {
                    
      out.write("\n");
      out.write("                    <div class=\"");
      out.print(alerta);
      out.write(" alert-dismissable\" style=\"margin-top: 20px;\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n");
      out.write("                        ");
      out.print(mensaje);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <table class=\"table table-bordered\" style=\"margin-top: 20px;\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Usuario</th>\n");
      out.write("                                <th>Alumno</th>\n");
      out.write("                                <th>Fecha Nacimiento</th>\n");
      out.write("                                <th>Correo</th>\n");
      out.write("                                <th>Dni</th>\n");
      out.write("                                <th>Estado</th>\n");
      out.write("                                <th>Acciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                AlumnoDao obj = new AlumnoDao();
                                List<Alumno> lista = obj.Listado();
                                
                                for (Alumno a : lista) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(a.getUsuario());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(a.NomCompleto());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(a.getFechaNac());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(a.getEmail());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(a.getDocumento());
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class='label label-");
      out.print(a.getEstado() == 1 ? "success" : "danger");
      out.write('\'');
      out.write('>');
      out.print(a.NomEstado());
      out.write("</span>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"PagEditarAlumno.jsp?id=");
      out.print(a.getIdAlumno());
      out.write("\" class=\"btn btn-info\"><i class=\"fa fa-edit\"></i></a>\n");
      out.write("                                    <a href=\"../../ControlAlumno?opc=eliminar&id=");
      out.print(a.getIdAlumno());
      out.write("\" onclick=\"return confirm('¿Esta seguro que desea eliminar el alumno con id ");
      out.print(a.getIdAlumno());
      out.write("?')\" class=\"btn btn-danger\"><i class=\"fa fa-trash\"></i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }

                                if (lista.size() == 0) {
                                    out.print("<tr><td colspan='7' class='text-center'>No se encontraron registros</td></tr>");
                                }
                            
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
