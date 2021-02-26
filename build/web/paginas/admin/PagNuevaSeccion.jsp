<%@page import="java.util.*"%>
<%@page import="beans.*"%>
<%@page import="dao.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nueva Seccion</title>

        <%@include file="../../recurso/recursos.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="../../recurso/Navbar.jsp" %>
            <%
                CursoDao cursoDao = new CursoDao();
            %>

            <div id="page-wrapper">

                <div class="col-lg-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Nueva Seccion</h3>
                        </div>
                        <div class="panel-body">
                            <form action="../../ControlSeccion" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Curso : </label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="idcurso"  onchange="ListarProfesores()">
                                            <%
                                                for (Curso c : cursoDao.ListadoOrdenadoByCurso()) {
                                            %>
                                            <option value="<%=c.getIdCurso()%>"><%=c.getNombreCurso()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Dia Semana : </label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="dia" id="dia" onchange="ListarProfesores()">
                                            <%
                                                String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

                                                for (String dia : semana) {
                                            %>
                                            <option value="<%=dia%>"><%=dia%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Hora Inicio : </label>
                                    <div class="col-sm-10">
                                        <input type="time"  class="form-control" name="horaInicio" id="horaInicio" required="" onchange="ListarProfesores()">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Hora Fin : </label>
                                    <div class="col-sm-10">
                                        <input type="time"  class="form-control" name="horaFin" id="horaFin" required="" onchange="ListarProfesores()">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Profesor : </label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="idProfesor" id="idProfesor">
                                            <option value="0">No se encontraron docentes disponibles</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nro Vacantes : </label>
                                    <div class="col-sm-10">
                                        <input type="number"  class="form-control" name="vacantes" placeholder="Numero de vacantes disponibles" required="" min ="1">
                                    </div>
                                </div>



                                <input type="hidden" name="opc" value="guardar">
                                <button type="submit" class="btn btn-info" id="BtnGuardar">Guardar</button>
                                <button type="reset" class="btn btn-danger">Nuevo</button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#BtnGuardar").attr('disabled', 'disabled');

        });

        function ListarProfesores() {
            var dia = $("#dia").val();
            var horaInicio = $("#horaInicio").val();
            var horaFin = $("#horaFin").val();

            var profesores = $("#idProfesor");
            profesores.find("option").remove();

            $.ajax({
                type: "GET",
                data: {
                    dia: dia,
                    horaInicio: horaInicio,
                    horaFin: horaFin
                },
                dataType: 'json',
                url: "../../ControlProfesor?opc=disponiblesAgreg",
                success: function (data, textStatus, xhr) {
                    console.log(data);
                    if (data.length === 0) {
                        profesores.append("<option>No se encontraron docentes disponibles</option>");
                        $("#BtnGuardar").attr('disabled', 'disabled');
                    } else {
                        for (var i in data) {
                            profesores.append("<option value='" + data[i].idProfesor + "'>" + data[i].apePaternoProfesor + " " + data[i].apeMaternoProfesor + " , " + data[i].nombreProfesor + "</option>");
                        }
                        $("#BtnGuardar").removeAttr("disabled");
                    }
                }
            });
        }
    </script>
</html>
