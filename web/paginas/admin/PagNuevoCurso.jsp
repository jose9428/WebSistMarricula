<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nuevo Curso</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Nuevo Curso</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlCurso" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Curso : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="nombre" placeholder="Nombres del curso" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Cant. Creditos : </label>
                                    <div class="col-sm-10">
                                        <input type="number"  class="form-control" name="creditos" placeholder="Creditos del curso" required="" min ="1">
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
