<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15-Oct-24
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Navigation</title>
    <style>
        .pagination {
            margin-top: 2em;
            display: flex;
            list-style: none;
            padding: 0;
            justify-content: center;
        }

        .pagination li {
            margin: 0 5px;
        }

        .pagination a {
            text-decoration: none;
            color: #007bff;
            padding: 8px 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .pagination a:hover {
            background-color: #ddd;
        }

        .pagination .active {
            background-color: #007bff;
            color: white;
            border: 1px solid #007bff;
        }
    </style>
</head>
<body>

<div class="row">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="?page=${currentPage - 1}" aria-label="Previous"
               <c:if test="${currentPage == 1}">disabled</c:if>>
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>

        <c:forEach var="i" begin="1" end="${noOfPages}">
            <li class="page-item <c:if test='${i == currentPage}'>active</c:if>">
                <a class="page-link" href="?page=${i}">${i}</a>
            </li>
        </c:forEach>

        <li class="page-item">
            <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next"
               <c:if test="${currentPage == totalPages}">disabled</c:if>>
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</div>

</body>
</html>

