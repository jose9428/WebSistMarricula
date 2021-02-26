<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%
    HttpSession sesionRes = request.getSession();
    List<Seccion> listaSeccion = (ArrayList<Seccion>) sesionRes.getAttribute("carrito");
%>
<div class="panel panel-primary">
    <div class="panel-heading">Resumen</div>
    <div class="panel-body">
        <div class="bs-example">
            <ul class="list-group">
                <li class="list-group-item">
                    <span class="badge"><%=listaSeccion.size()%></span>
                    Cursos Seleccionados
                </li>

                <li class="list-group-item">
                    <span class="badge"><%=Carrito.SumaCreditos(listaSeccion)%></span>
                    Creditos Seleccionados
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="panel panel-primary">
    <div class="panel-heading">Importante</div>
    <div class="panel-body">
        <div class="bs-example">
            <p>No olvides usar el boton Procesar Matricula para registrar los cursos y horarios seleccionados.</p>
            <form action="../../ControlCarrito">
                <input type="hidden" name="opc" value="procesar">
                <%
                    if (listaSeccion.size() == 0) {
                %>
                <button type="button" class="btn btn-success btn-block" title="Procesar Matricula" disabled="">Procesar Matricula</button>
                <%
                } else {
                %>
                <button type="submit" class="btn btn-success btn-block" title="Procesar Matricula">Procesar Matricula</button>
                <%
                    }
                %>

            </form>

        </div>
    </div>
</div>