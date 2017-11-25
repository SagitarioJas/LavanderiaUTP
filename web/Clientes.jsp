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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Clientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="css/custom.css">
    <link rel=icon href='images/logo-icon.png' sizes="32x32" type="image/png">
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
            <table>
                <tr>
                    <th>Id</th>
                    <th></th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="clientes" items="${clientes}">
                    <tr>
                        <td><c:out value="${region.id}"/> </td>
                        <td><c:out value="${region.name}"/> </td>
                        <td>
                            <a href="regions?action=edit&id=${region.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<hr>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/clientes.js"></script>
</body>
</html>
