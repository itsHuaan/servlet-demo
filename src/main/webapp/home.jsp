<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09-Oct-24
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="get" action="SearchServlet">
        Search by name: <input type="text" name="searchInput" id="searchInput">
        <input type="submit" name="searchButton" id="searchButton">
    </form>
    <table>
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ProductCode</th>
            <th>ProductName</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${list_product}">
            <tr>
                <td><c:out value="${product.productCode}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.buyPrice}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
