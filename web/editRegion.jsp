<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 18/10/2017
  Time: 07:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Region</title>
</head>
<body>
    <h1>Edit Region</h1>
    <form action="regions" method="post">
        <fieldset>
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="${region.id}"/>
            <jsp:include page="_region_fieldset.jsp"/>
        </fieldset>
    </form>

</body>
</html>
