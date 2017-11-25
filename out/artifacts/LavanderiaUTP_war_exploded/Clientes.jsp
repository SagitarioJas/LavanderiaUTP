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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clientes</title>
</head>
<body>
<form action="LoginUsu" method="search">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <label for="distrito">Distrito</label>
        <input type="text" name="distrito" id="distrito" value=""/>
        <input type="submit" value="Buscar"/>
    </fieldset>
</form>

        <table>
            <tr>
                <th>Cliente</th>
                <th>Telefono</th>
                <th>Distrito</th>
                <th>Direccion</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td><c:out value="${cliente.name}"/> </td>
                    <td><c:out value="${cliente.telefono}"/> </td>
                    <td><c:out value="${cliente.distrito}"/> </td>
                    <td><c:out value="${cliente.direccion}"/> </td>
                </tr>
            </c:forEach>
        </table>


</body>
</html>
