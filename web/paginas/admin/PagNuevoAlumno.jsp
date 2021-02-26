<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nuevo Alumno</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Nuevo Alumno</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlAlumno" method="post">
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
                                    <label class="col-sm-2 col-form-label">Apoderado : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apoderado" placeholder="Apoderado alumno" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Fecha Nacimiento : </label>
                                    <div class="col-sm-10">
                                        <input type="date"  class="form-control" name="fechaNac" required="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Dni : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="dni" placeholder="Documento de identidad" required="" maxlength="8">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Direccion : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="direccion" placeholder="Direccion" required="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Telefono : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="telefono" placeholder="Telefono Movil" required="" maxlength="9">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Email : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="correo" placeholder="Correo Electronico" required="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Estado : </label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="estado">
                                            <option value="1">Activo</option>
                                            <option value="0">Inactivo</option>
                                        </select>
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
