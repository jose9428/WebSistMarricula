<%@page import="beans.Profesor"%>
<%@page import="dao.ProfesorDao"%>
<%@page import="java.util.List"%>
<%@page import="beans.Alumno"%>
<%@page import="dao.AlumnoDao"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Profesores</title>

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
                            mensaje = "Profesor registrado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido registrar el profesor";
                        }
                    }

                    if (request.getSession().getAttribute("eliminar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("eliminar").toString());
                        request.getSession().setAttribute("eliminar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Profesor eliminado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido eliminar al profesor. Se ha encontrado que tiene secciones registrados.";
                        }
                    }

                    if (request.getSession().getAttribute("editar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("editar").toString());
                        request.getSession().setAttribute("editar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Profesor actualizado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido actualizar datos del profesor";
                        }
                    }


                %>

                <div class="col-lg-12">
                    <a href="PagNuevoProfesor.jsp" class="btn btn-success">Nuevo profesor</a>

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
                                <th>Profesor</th>
                                <th>Dni</th>
                                <th>Fecha Ingreso</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ProfesorDao obj = new ProfesorDao();
                                List<Profesor> lista = obj.Listado();
                                for (Profesor p : lista) {
                            %>
                            <tr>
                                <td><%=p.getUsuario()%></td>
                                <td><%=p.NomCompleto()%></td>
                                <td><%=p.getDocumento()%></td>
                                <td><%=p.getFechaCreacion()%></td>
                                <td>
                                    <a href="PagEditarProfesor.jsp?id=<%=p.getIdProfesor()%>" class="btn btn-info"><i class="fa fa-edit"></i></a>
                                    <a href="../../ControlProfesor?opc=eliminar&id=<%=p.getIdProfesor()%>" onclick="return confirm('¿Esta seguro que desea eliminar el profesor con id <%=p.getIdProfesor()%>?')" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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


        <script type="text/javascript">
        </script>
    </body>
</html>
