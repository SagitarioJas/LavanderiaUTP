<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 18/10/2017
  Time: 07:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Region</title>
</head>
<body>
    <h1>New Region</h1>
    <form action="regions" method="post">
        <fieldset>
            <input type="hidden" name="action" value="create"/>
            <jsp:include page="_region_fieldset.jsp"/>
        </fieldset>
    </form>
    <p><a href="regions">Regions List</a></p>
</body>
</html>
