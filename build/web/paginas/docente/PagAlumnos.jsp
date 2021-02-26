<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Alumnos | Seccion</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%
                AlumnoDao objAlumno = new AlumnoDao();
                SeccionDao objSeccion = new SeccionDao();
                int idSeccion = Integer.parseInt(request.getParameter("id"));
                Seccion s = objSeccion.BuscarPorId(idSeccion);
            %>

            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">
                <div class="panel panel-primary">

                    <div class="container-fluid">
                        <br>
                        <div class="text-left">
                            <h2>Seccion : <%=idSeccion%></h2>
                            <h4>Docente : <%=s.getNomProfesor()%></h4>
                            <h4>Curso : <%=s.getNomCurso()%></h4>
                            <h4>Horario : <%=s.getDia() + " " + s.getHoraInicio() + "-" + s.getHoraFin()%></h4>
                        </div>
                        <hr>

                        <table class="table table-bordered text-center table-responsive">
                            <thead class="bg-primary">
                                <tr >
                                    <th class="text-center">#</th>
                                    <th class="text-center">Usuario</th>
                                    <th class="text-center">Nombres Completos</th>
                                    <th class="text-center">Email</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Alumno> listaALu = objAlumno.AlumnosPorSeccion(idSeccion);

                                    int cuenta = 0;
                                    for (Alumno a : listaALu) {
                                        cuenta++;
                                %>
                                <tr> 
                                    <td><%=cuenta%></td>
                                    <td><%=a.getUsuario()%></td>
                                    <td><%=a.getNombreAlumno() + " " + a.getApePAlumno() + " " + a.getApeMAlumno()%></td>
                                    <td><%=a.getEmail()%></td>
                                </tr>
                                <%
                                    }

                                    if (listaALu.size() == 0) {
                                        out.print("<tr><td colspan='4' class='text-center'>No se encontraron alumnos matriculados</td></tr>");
                                    }
                                %>
                            </tbody>
                        </table>

                    </div>


                </div>

            </div>

        </div>
    </body>
</html>
