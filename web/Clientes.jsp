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
