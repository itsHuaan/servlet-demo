<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11-Oct-24
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .sidebar {
            position: sticky;
            top: 0;
            height: 100vh;
            padding-top: 20px;
        }

        a {
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="col-md-3 sidebar bg-light">
    <h4>Categories</h4>
    <ul class="list-group">
        <c:forEach var="line" items="${product_lines}">
            <li class="list-group-item"><a href="ShopServlet?productLine=${line}">${line}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
