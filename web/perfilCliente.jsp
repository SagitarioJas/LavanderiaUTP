<%--
  Created by IntelliJ IDEA.
  User: Sergio.Aguirre
  Date: 24/11/2017
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creacion de Cliente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
</head>
<body>
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel"><i class='glyphicon glyphicon-edit'></i> Agregar nuevo cliente</h4>
            </div>

                <form class="form-horizontal" method="post" id="guardar_cliente" name="guardar_cliente">
                    <div class="form-group">
                        <label for="nombre" class="col-sm-3 control-label">Nombre</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telefono" class="col-sm-3 control-label">Teléfono</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="telefono" name="telefono" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="email" name="email" >

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="direccion" class="col-sm-3 control-label">Dirección</label>
                        <div class="col-sm-8">
                            <textarea class="form-control" id="direccion" name="direccion"   maxlength="255" ></textarea>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="estado" class="col-sm-3 control-label">Estado</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="estado" name="estado" required>
                                <option value="">-- Selecciona estado --</option>
                                <option value="1" selected>Activo</option>
                                <option value="0">Inactivo</option>
                            </select>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary" id="guardar_datos">Guardar datos</button>
                    </div>
                </form>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</body>
</html>
