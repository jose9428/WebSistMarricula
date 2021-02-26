<%@page import="beans.Usuario"%>
<% String URL = request.getRequestURL().toString();%>

<%
    Usuario userLogeado = (Usuario) request.getSession().getAttribute("usuario");
%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:void(0)">Matricula.edu.pe</a>
    </div>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <%
                if (userLogeado.getPerfil().equalsIgnoreCase("admin")) {
            %>

                <li class=<%= URL.contains("PagListarAlumnos") || URL.contains("PagNuevoAlumno")
                    || URL.contains("PagEditarAlumno") ? "active" : ""%>>
                <a href="./PagListarAlumnos.jsp"><i class="fa fa-user-md"></i> Alumnos</a>
            </li>

                <li class=<%= URL.contains("PagListarProfesores") || URL.contains("PagNuevoProfesor")
                        || URL.contains("PagEditarProfesor") ? "active" : ""%>>
                <a href="./PagListarProfesores.jsp"><i class="fa fa-user-circle"></i> Profesores</a>
            </li>

            <li class=<%= URL.contains("PagListarCursos") || URL.contains("PagNuevoCurso")
                        || URL.contains("PagEditarCurso") ? "active" : ""%>>
                <a href="./PagListarCursos.jsp"><i class="fa fa-tasks"></i> Cursos</a>
            </li>

                <li class=<%= URL.contains("PagListarSecciones") || URL.contains("PagNuevaSeccion")
                    || URL.contains("PagEditarSeccion") ? "active" : ""%>>
                <a href="./PagListarSecciones.jsp"><i class="fa fa-table"></i> Secciones</a>
            </li>
            <%
                }
            %>


            <!-- PARTE ALUMNO LOGEADO--> 
            <%

                if (userLogeado.getPerfil().equalsIgnoreCase("ALUMNO")) {

                    if (userLogeado.getEstado() == 0) {

            %>
            <li class=<%= URL.contains("PagCursosDisp") || URL.contains("PagSeccionesDisp") ? "active" : ""%>>
                <a href="./PagCursosDisp.jsp"><i class="fa fa-tasks"></i> Matricula</a>
            </li>

            <%
                }
            %>

            <li class=<%= URL.contains("PagMiHorario") || URL.contains("PagSeccionAlumnos") ? "active" : ""%>>
                <a href="./PagMiHorario.jsp"><i class="fa fa-book"></i> Horario</a>
            </li>

            <%
                }
            %>

            <%
                if (userLogeado.getPerfil().equalsIgnoreCase("PROFESOR")) {
            %>
            <!--DOCENTE-->
            <li class=<%= URL.contains("PagSeccion") || URL.contains("PagAlumnos") ? "active" : ""%>>
                <a href="./PagSeccion.jsp"><i class="fa fa-book"></i> Secciones</a>
            </li>
            <%
                }
            %>

        </ul>
        <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown user-dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%=userLogeado.getNombreCompleto()%><b class="caret"></b></a>
                <ul class="dropdown-menu">

                    <li><a href="./../../ControlLogin?opc=cerrarSesion"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>