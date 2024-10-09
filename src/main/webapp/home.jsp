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
    <title>Product List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th {
            background-color: rgba(128, 128, 128, 0.5);
        }

        table, th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<div>
    <form method="get" action="SearchServlet">
        Search by name: <input type="text" name="searchInput" id="searchInput">
        <input type="submit" name="searchButton" id="searchButton">
    </form>
    <form id="dropdownForm" method="get" action="ProductServlet">
        <select name="productLine" id="productLine">
            <option value="0" selected>-------Select-------</option>
            <c:forEach var="line" items="${product_lines}">
                <option value="${line}">${line}</option>
            </c:forEach>
        </select>
        <select name="orderBy" id="orderBy" onChange="submitDropdown()">
            <option value="0">Order by price</option>
            <option value="asc">Price: Low to high</option>
            <option value="desc">Price: High to low</option>
        </select>
    </form>
    <script>
        function submitDropdown() {
            document.getElementById("dropdownForm").submit();
        }
    </script>
    <table>
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ProductCode</th>
            <th>ProductName</th>
            <th>ProductLine</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${list_product}">
            <tr>
                <td><c:out value="${product.productCode}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productLine}"/></td>
                <td><c:out value="${product.buyPrice}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
