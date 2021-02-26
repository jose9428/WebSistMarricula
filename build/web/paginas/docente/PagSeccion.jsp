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

            <%@include file="../../recurso/Navbar.jsp" %>


            <%
                MatriculaDao objMatric = new MatriculaDao();
                Usuario user = (Usuario) request.getSession().getAttribute("usuario");
                int idDocente = user.getCodigo();

            %>

            <div id="page-wrapper">
                <div class="panel panel-primary">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="container">
                                <br>
                                <div class="text-left">
                                    <h2>Mis Secciones | Curso</h2>
                                </div>
                            </div>
                            <%                                for (Matricula m : objMatric.MisCursosDocente(idDocente)) {
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

                                                    <a href="PagAlumnos.jsp?id=<%=m.getIdSeccion()%>" class="btn btn-success">Ver alumnos</a>
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


        </div>
    </body>
</html>
