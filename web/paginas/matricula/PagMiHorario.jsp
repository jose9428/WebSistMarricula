<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi Horario</title>

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
                MatriculaDao objMatric = new MatriculaDao();
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
  
                int idAlumno = user.getCodigo();
                Matricula mat = objMatric.BuscarPorAlumno(idAlumno);

                //Ya tiene matricula
                if (mat != null) {
            %>

            <div id="page-wrapper">
                <div class="panel panel-primary">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="container">
                                <br>
                                <div class="text-left">
                                    <a href="../../ControlCarrito?opc=anularMatricula&nro=<%=mat.getIdMatricula() %>" class="btn btn-danger" onclick="return confirm('¿Estas seguro que deseas anular tu matricula?.Si das en aceptar se anulará todos tus cursos seleccionados hasta el momento.')">Anular matricula</a><br>
                                    <h1>Mis Cursos</h1>
                                </div>
                            </div>
                            <%
                                for (Matricula m : objMatric.MisCursosMatricula(idAlumno)) {
                            %>
                            <div  class="col-sm-6">
                                <div class="panel panel-primary">
                                    <div class="panel-heading"><%=m.getNomCurso().toUpperCase()%></div>
                                    <div class="panel-body">
                                        <div class="list-group">
                                            <div class="list-group">

                                                <div class="d-flex w-100 justify-content-between">
                                                    <h4 class="mb-1">Docente :</h4>
                                                    <small class="text-muted"><%=m.getNomProfesor()%></small>

                                                    <br>
                                                    <h4 class="mb-1">Horario :     <small class="text-muted"><%=m.getDia() + " " + m.getHoraInicio() + "-" + m.getHoraFin()%></small></h4>
                                                    <h4 class="mb-1">Seccion :     <small class="text-muted"><%=m.getIdSeccion()%></small></h4>

                                                    <h4 class="mb-1">Creditos :     <small class="text-muted"><%=m.getCreditos()%></small></h4>

                                                    <a href="PagSeccionAlumnos.jsp?id=<%=m.getIdSeccion() %>" class="btn btn-success">Ver alumnos</a>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                </div>

            </div>

            <%
            } else {
            %>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="panel panel-primary">
                            <div class="panel-heading">Mi Horario por dia/semana</div>
                            <div class="panel-body">
                                <div class="col-lg-12">
                                    <table class="table table-bordered text-center" style="margin-top: 20px;">
                                        <thead class="bg-primary">
                                            <tr >
                                                <%
                                                    String dia[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
                                                    for (String x : dia) {
                                                        out.print("<th class='text-center'>" + x + "</th>");
                                                    }
                                                %>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                if (carrito.size() == 0) {
                                                    out.print("<tr><td colspan='7' class='text-center'>No se encontraron cursos seleccionados</td></tr>");
                                                } else {
                                                    out.print("<tr>");
                                                    for (String x : dia) {
                                                        out.print("<td>");
                                                        for (Seccion s : carrito) {

                                                            if (x.toUpperCase().equals(s.getDia().toUpperCase())) {
                                                                out.print(s.getHoraInicio() + "-" + s.getHoraFin() + "<br>"
                                                                        + s.getNomCurso() + "</br><hr>");
                                                            }
                                                        }
                                                        out.print("</td>");
                                                    }
                                                    out.print("</tr>");
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



            <%                }
            %>




        </div>
    </body>
</html>
