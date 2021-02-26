<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Alumnos</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">
                <%
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


                %>

                <div class="col-lg-12">
                    <a href="PagNuevoAlumno.jsp" class="btn btn-success">Nuevo alumno</a>

                    <%                        if (!mensaje.equals("")) {
                    %>
                    <div class="<%=alerta%> alert-dismissable" style="margin-top: 20px;">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <%=mensaje%>
                    </div>
                    <%
                        }
                    %>

                </div>

                <div class="col-lg-12">
                    <table class="table table-bordered" style="margin-top: 20px;">
                        <thead>
                            <tr>
                                <th>Usuario</th>
                                <th>Alumno</th>
                                <th>Fecha Nacimiento</th>
                                <th>Correo</th>
                                <th>Dni</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                AlumnoDao obj = new AlumnoDao();
                                List<Alumno> lista = obj.Listado();
                                
                                for (Alumno a : lista) {
                            %>
                            <tr>
                                <td><%=a.getUsuario()%></td>
                                <td><%=a.NomCompleto()%></td>
                                <td><%=a.getFechaNac()%></td>
                                <td><%=a.getEmail()%></td>
                                <td><%=a.getDocumento()%></td>
                                <td>
                                    <span class='label label-<%=a.getEstado() == 1 ? "success" : "danger"%>'><%=a.NomEstado()%></span>
                                </td>
                                <td>
                                    <a href="PagEditarAlumno.jsp?id=<%=a.getIdAlumno()%>" class="btn btn-info"><i class="fa fa-edit"></i></a>
                                    <a href="../../ControlAlumno?opc=eliminar&id=<%=a.getIdAlumno()%>" onclick="return confirm('¿Esta seguro que desea eliminar el alumno con id <%=a.getIdAlumno()%>?')" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>
                            <%
                                }

                                if (lista.size() == 0) {
                                    out.print("<tr><td colspan='7' class='text-center'>No se encontraron registros</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>


            </div>
        </div>

    </body>
</html>
