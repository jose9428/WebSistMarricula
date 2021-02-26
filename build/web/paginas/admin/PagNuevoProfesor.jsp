<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nuevo Profesor</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Nuevo Profesor</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlProfesor" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nombres : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="nombre" placeholder="Nombres Completos" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Paterno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeP" placeholder="Apellido Paterno" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Materno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeM" placeholder="Apellido Materno" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Dni : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="dni" placeholder="Documento de identidad" required="" maxlength="8">
                                    </div>
                                </div>

                                <input type="hidden" name="opc" value="guardar">
                                <button type="submit" class="btn btn-info">Guardar</button>
                                <button type="reset" class="btn btn-danger">Nuevo</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
