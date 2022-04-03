<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/2/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sach lop</title>
</head>
<body>
<center>
<h1>Danh sach cac lop</h1>
</center>
    <div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>Danh sach lop 1</h2>
        </caption>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
            <th>Show list</th>
        </tr>
        <c:forEach var="classe" items="${listClassManager}">
            <tr>
                <td><c:out value="${classe.id}"/> </td>
                <td><c:out value="${classe.name}" /></td>
                <td><c:out value="${classe.description}" /></td>
<%--                <td>--%>
<%--                    <a href="class?action=edit&id=${classes.id}">edit</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
