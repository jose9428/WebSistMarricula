<%@page import="java.util.List"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Curso</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>
            <%
            CursoDao obj = new CursoDao();
            Curso c = obj.BuscarPorId(Integer.parseInt(request.getParameter("id")));
            %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Editar Curso</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlCurso" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Curso : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="nombre" placeholder="Nombres del curso" required="" value="<%=c.getNombreCurso() %>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Cant. Creditos : </label>
                                    <div class="col-sm-10">
                                        <input type="number"  class="form-control" name="creditos" placeholder="Creditos del curso" required="" min="1" value="<%=c.getCreditos()%>">
                                    </div>
                                </div>

                                <input type="hidden" name="opc" value="editar">
                                <input type="hidden" name="idcurso" value="<%=c.getIdCurso()%>">
                                <button type="submit" class="btn btn-info">Editar</button>
                                <button type="reset" class="btn btn-danger">Nuevo</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
