<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Cursos Disponibles</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%
                HttpSession sesion = request.getSession();
                List<Seccion> carrito = (ArrayList<Seccion>) sesion.getAttribute("carrito");
            %>
            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Cursos a Matricular</div>
                            <div class="panel-body">
                                <p>Aqui encontraras la lista de cursos aptos para matricularte.</p>

                                <div class="col-lg-12">
                                    <table class="table table-bordered text-center" style="margin-top: 20px;">
                                        <thead class="bg-primary">
                                            <tr >
                                                <th class="text-center">Item</th>
                                                <th class="text-center">Curso</th>
                                                <th class="text-center">Creditos</th>
                                                <th class="text-center">Accion</th>
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
                                                    <%
                                                        if (Carrito.ExisteCurso(carrito, a.getIdCurso())) {
                                                    %>
                                                    <a href="../../ControlCarrito?opc=eliminar&id=<%=a.getIdCurso()%>" class="btn btn-danger" title="Quitar curso">Quitar</a>

                                                    <%
                                                    } else {
                                                    %>
                                                    <a href="PagSeccionesDisp.jsp?id=<%=a.getIdCurso()%>" class="btn btn-success" title="Buscar Sesiones disponibles">Agregar</a>
                                                    <%
                                                        }
                                                    %>


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
                    </div>
                    <div class="col-sm-3">
                        <%@include file="../../recurso/ResumenMatricula.jsp" %>
                    </div>

                </div>
            </div>

        </div>
    </body>
</html>
