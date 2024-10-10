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
            align-content: center;
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
    <a href="ProductServlet">Home</a>
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
    <a href="addnew.jsp">Add new product</a>
    <script>
        function submitDropdown() {
            document.getElementById("dropdownForm").submit();
        }
        function changingMessage() {
            var message = "${status}";
            if (message) {
                alert(message);
            }
        }
    </script>
    <table>
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ProductCode</th>
            <th>ProductName</th>
            <th>ProductLine</th>
            <th>Price</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${list_product}">
            <tr>
                <td><c:out value="${product.productCode}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productLine}"/></td>
                <td><c:out value="${product.buyPrice}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${product.status}">
                            <c:out value="Active"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="Inactive"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="">Edit</a>
                    &nbsp;
                    <a href="${pageContext.request.contextPath}/DeleteServlet?productCode=${product.productCode}"
                       onclick="changingMessage()">
                        <c:choose>
                            <c:when test="${product.status}">
                                Deactivate
                            </c:when>
                            <c:otherwise>
                                Activate
                            </c:otherwise>
                        </c:choose>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">Back to menu</a>
</div>
</body>
</html>
