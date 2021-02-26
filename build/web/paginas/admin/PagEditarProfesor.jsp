<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Profesor</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>
            <%
            ProfesorDao obj = new ProfesorDao();
            Profesor p = obj.BuscarPorId(Integer.parseInt(request.getParameter("id")));
            %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Editar Profesor</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlProfesor" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nombres : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="nombre" placeholder="Nombres Completos" required="" value="<%=p.getNombreProfesor() %>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Paterno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeP" placeholder="Apellido Paterno" required="" value="<%=p.getApePaternoProfesor()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Materno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeM" placeholder="Apellido Materno" required="" value="<%=p.getApeMaternoProfesor()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Dni : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="dni" placeholder="Documento de identidad" required="" maxlength="8" value="<%=p.getDocumento()%>">
                                    </div>
                                </div>
                      <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Usuario : </label>
                                    <div class="col-sm-10">
                                        <input type="text" readonly=""  class="form-control" name="usuario" required="" value="<%=p.getUsuario()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Fecha Creacion : </label>
                                    <div class="col-sm-10">
                                        <input type="date" readonly=""  class="form-control" name="fechaCreacion" required="" value="<%=p.getFechaCreacion() %>">
                                    </div>
                                </div>
                                <input type="hidden" name="opc" value="editar">
                                <input type="hidden" name="idprofesor" value="<%=p.getIdProfesor() %>">
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
