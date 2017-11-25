<%--
  Created by IntelliJ IDEA.
  User: Sergio.Aguirre
  Date: 24/11/2017
  Time: 14:36
  To change this template use File | Settings | File Templates.

  	$active_buscar="active";
	$active_reporte="";
	$active_visitas="";
	$title="Clientes | Lavanderia";
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <div class="btn-group pull-right">
                <button type='button' class="btn btn-info" data-toggle="modal" data-target="#nuevoCliente"><span class="glyphicon glyphicon-plus" ></span> Nuevo Cliente</button>
            </div>
            <h4><i class='glyphicon glyphicon-search'></i> Buscar Clientes</h4>
        </div>
        <div class="panel-body">
            <jsp:include page="modal/registro_clientes.jsp"></jsp:include>
            <jsp:include page="modal/editar_clientes.jsp"></jsp:include>
            <form class="form-horizontal" role="form" id="datos_cotizacion">
                <div class="form-group row">
                    <label for="q" class="col-md-2 control-label">Cliente</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="q" placeholder="Nombre del cliente" onkeyup='load(1);'>
                    </div>
                    <div class="col-md-3">
                        <button type="button" class="btn btn-default" onclick='load(1);'>
                            <span class="glyphicon glyphicon-search" ></span> Buscar</button>
                        <span id="loader"></span>
                    </div>
                </div>
            </form>
            <div id="resultados"></div><!-- Carga los datos ajax -->
            <div class='outer_div'></div><!-- Carga los datos ajax -->
        </div>
    </div>
</div>
<hr>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/clientes.js"></script>
</body>
</html>
