<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Secciones</title>

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
                            mensaje = "Seccion registrado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido registrar el seccion";
                        }
                    }

                    if (request.getSession().getAttribute("eliminar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("eliminar").toString());
                        request.getSession().setAttribute("eliminar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Seccion eliminado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido eliminar al seccion. Se ha encontrado que hay alumnos matriculados.";
                        }
                    }

                    if (request.getSession().getAttribute("editar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("editar").toString());
                        request.getSession().setAttribute("editar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Seccion actualizado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido actualizar datos de la seccion";
                        }
                    }


                %>

                <div class="col-lg-12">
                    <a href="PagNuevaSeccion.jsp" class="btn btn-success">Nueva Seccion</a>

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
                                <th># Seccion</th>
                                <th>Profesor</th>
                                <th>Curso</th>
                                <th>Vacantes</th>
                                <th>Dia</th>
                                <th>Horario</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                SeccionDao obj = new SeccionDao();
                                List<Seccion> lista = obj.Listado();
                                for (Seccion a : lista) {
                            %>
                            <tr>
                                <td><%=a.getIdSeccion()%></td>
                                <td><%=a.getNomProfesor()%></td>
                                <td><%=a.getNomCurso()%></td>
                                <td><%=a.getVacantes()%></td>
                                <td><%=a.getDia()%></td>
                                <td><%=a.getHoraInicio() + "-" + a.getHoraFin()%></td>

                                <td>
                                    <a href="../../ControlSeccion?opc=eliminar&id=<%=a.getIdSeccion()%>" onclick="return confirm('¿Esta seguro que desea eliminar la sesion con id <%=a.getIdSeccion()%>?')" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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
