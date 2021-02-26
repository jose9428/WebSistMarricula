<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Cursos</title>

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
                            mensaje = "Curso registrado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido registrar el curso";
                        }
                    }

                    if (request.getSession().getAttribute("eliminar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("eliminar").toString());
                        request.getSession().setAttribute("eliminar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Curso eliminado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido eliminar al curso. Se ha encontrado docentes impartiendo en el curso seleccionado.";
                        }
                    }

                    if (request.getSession().getAttribute("editar") != null) {
                        res = Integer.parseInt(request.getSession().getAttribute("editar").toString());
                        request.getSession().setAttribute("editar", null);

                        if (res > 0) {
                            alerta = "alert alert-success";
                            mensaje = "Curso actualizado correctamente";
                        } else {
                            alerta = "alert alert-danger";
                            mensaje = "No se ha podido actualizar datos del curso";
                        }
                    }


                %>

                <div class="col-lg-12">
                    <a href="PagNuevoCurso.jsp" class="btn btn-success">Nuevo Curso</a>

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
                    <table class="table table-bordered text-center" style="margin-top: 20px;">
                        <thead>
                            <tr >
                                <th class="text-center">Codigo</th>
                                <th class="text-center">Curso</th>
                                <th class="text-center">Creditos</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                CursoDao obj = new CursoDao();
                                List<Curso> lista = obj.Listado();
                                for (Curso a : lista) {
                            %>
                            <tr>
                                <td><%=a.getIdCurso()%></td>
                                <td><%=a.getNombreCurso()%></td>
                                <td><%=a.getCreditos()%></td>

                                <td>
                                    <a href="PagEditarCurso.jsp?id=<%=a.getIdCurso()%>" class="btn btn-info"><i class="fa fa-edit"></i></a>
                                    <a href="../../ControlCurso?opc=eliminar&id=<%=a.getIdCurso()%>" onclick="return confirm('¿Esta seguro que desea eliminar el curso con id <%=a.getIdCurso()%>?')" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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
