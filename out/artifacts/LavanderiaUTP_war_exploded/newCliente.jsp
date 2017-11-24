<%--
  Created by IntelliJ IDEA.
  User: Sergio.Aguirre
  Date: 24/11/2017
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Nuevo Cliente</h1>
<form action="LoginUsu" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <input type="hidden" name="user_perfil" value="2"/>
        <label for="_name">Name</label>
        <input type="text" name="user_name" id="_name" />
        <label for="_clave">Clave</label>
        <input type="password" name="user_password" id="_clave" />
        <input type="submit"/>

    </fieldset>
</form>
</body>
</html>
