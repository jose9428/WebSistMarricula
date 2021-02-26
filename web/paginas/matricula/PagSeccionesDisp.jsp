<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Secciones Disponibles</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%
                HttpSession sesion = request.getSession();
                List<Seccion> carrito = (ArrayList<Seccion>) sesion.getAttribute("carrito");
            %>
            <%@include file="../../recurso/Navbar.jsp" %>
            <%
                int id = Integer.parseInt(request.getParameter("id"));

                CursoDao objCurso = new CursoDao();
                Curso c = objCurso.BuscarPorId(id);
            %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Sesiones Disponibles</div>
                            <div class="panel-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <td class="bg-primary">Curso</td>
                                        <td class="bg-info"><%=c.getNombreCurso()%></td>
                                    </tr>
                                    <tr>
                                        <td class="bg-primary">Creditos</td>
                                        <td class="bg-info"><%=c.getIdCurso()%></td>
                                    </tr>
                                </table>

                                <p>Selecciona el turno y la seccion de tu preferencia. Elige la opcion seleccionar en la fila de la seccion deseada. Si el horario de la seccion se cruza con otros que hayas elegido previamentem no podras elegirla.</p>

                                <div class="col-lg-12">
                                    <table class="table table-bordered text-center" style="margin-top: 20px;">
                                        <thead class="bg-primary">
                                            <tr >
                                                <th class="text-center">Seccion</th>
                                                <th class="text-center">Horario</th>
                                                <th class="text-center">Docente</th>
                                                <th class="text-center">Vacantes</th>
                                                <th class="text-center">Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                SeccionDao objSeccion = new SeccionDao();
                                                List<Seccion> lista = objSeccion.SeccionesDisp(c.getIdCurso());
                                                for (Seccion a : lista) {
                                            %>
                                            <tr>
                                                <td><%=a.getIdSeccion()%></td>
                                                <td><%=a.getDia() + " " + a.getHoraInicio() + "-" + a.getHoraFin()%></td>
                                                <td><%=a.getNomProfesor()%></td>
                                                <td>
                                                    <%

                                                        if (a.getVacantes() == 1) {
                                                            out.print("<span class='label label-danger'>Ultima Vacante</span>");
                                                        } else if (a.getVacantes() <= 10) {
                                                            out.print(a.getVacantes() + "<br><span class='label label-danger'>Pocas Vacantes</span>");
                                                        } else {
                                                            out.print(a.getVacantes());
                                                        }
                                                    %>
                                                </td>
                                                <td>
                                                    <%
                                                        if (Carrito.ExisteCruce(carrito, a.getDia() , a.getHoraInicio() , a.getHoraFin()) == true) {
                                                    %>
                                                    <a href="javascript:void(0)" class="btn btn-danger">Tiene Cruce</a>
                                                    <%
                                                    } else {
                                                    %>
                                                    <a href="../../ControlCarrito?opc=agregar&id=<%=a.getIdSeccion()%>" class="btn btn-success">Seleccionar</a>
                                                    <%
                                                        }
                                                    %>

                                                </td>
                                            </tr>
                                            <%
                                                }

                                                if (lista.size() == 0) {
                                                    out.print("<tr><td colspan='7' class='text-center'>No se encontraron secciones disponibles</td></tr>");
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
