<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Alumno</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>
            <%
                AlumnoDao obj = new AlumnoDao();
                Alumno a = obj.BuscarPorId(Integer.parseInt(request.getParameter("id")));
            %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Editar Alumno</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlAlumno" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nombres : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="nombre" placeholder="Nombres Completos" required="" value="<%=a.getNombreAlumno()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Paterno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeP" placeholder="Apellido Paterno" required="" value="<%=a.getApePAlumno()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apellido Materno : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apeM" placeholder="Apellido Materno" required="" value="<%=a.getApeMAlumno()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Apoderado : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="apoderado" placeholder="Apoderado alumno" required="" value="<%=a.getApoderado()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Fecha Nacimiento : </label>
                                    <div class="col-sm-10">
                                        <input type="date"  class="form-control" name="fechaNac" required="" value="<%=a.getFechaNac()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Dni : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="dni" placeholder="Documento de identidad" required="" maxlength="8" value="<%=a.getDocumento()%>">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Direccion : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="direccion" placeholder="Direccion" required="" value="<%=a.getDireccion()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Telefono : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="telefono" placeholder="Telefono Movil" required="" maxlength="9" value="<%=a.getTelefono()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Email : </label>
                                    <div class="col-sm-10">
                                        <input type="text"  class="form-control" name="correo" placeholder="Correo Electronico" required="" value="<%=a.getEmail()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Estado : </label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="estado">
                                            <option value="1" <%= a.getEstado() == 1 ? "selected" : ""%>>Activo</option>
                                            <option value="0" <%= a.getEstado() == 0 ? "selected" : ""%>>Inactivo</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Usuario : </label>
                                    <div class="col-sm-10">
                                        <input type="text" readonly=""  class="form-control" name="usuario" required="" value="<%=a.getUsuario()%>">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Fecha Creacion : </label>
                                    <div class="col-sm-10">
                                        <input type="date" readonly=""  class="form-control" name="fechaCreacion" required="" value="<%=a.getFechaCreacion() %>">
                                    </div>
                                </div>
                                <input type="hidden" name="opc" value="editar">
                                 <input type="hidden" name="idalumno" value="<%=a.getIdAlumno() %>">
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
