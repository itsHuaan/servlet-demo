<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10-Oct-24
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <title>Cart</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            margin-bottom: 10rem;
            flex-grow: 1;
        }
        .footer {
            margin-top: 5rem;
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 1rem;
            position: fixed;
            bottom: 0;
            width: 100%;
            box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
        }
        .footer h5 {
            margin: 0;
        }
        .btn-footer {
            margin-top: 0.5rem;
        }
    </style>
</head>
<body>

<jsp:include page="component/navbar.jsp"/>

<jsp:include page="component/pricesorting.jsp"/>

<div class="container">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <c:forEach var="item" items="${cart}">
            <div class="col">
                <div class="card h-100">
                    <img src="https://picsum.photos/200?random=${item.productCode}" class="card-img-top"
                         alt="${item.productName}"
                         style="height: 15rem; object-fit: cover;">
                    <div class="card-body d-flex flex-column">
                        <h5 class="productName">${item.productName}</h5>
                        <p class="inStock">In Stock: ${item.quantityInStock}</p>
                        <div class="mt-auto text-end">
                            <p class="price text-success fw-bold">$${item.buyPrice}</p>
                            <a href="#" class="btn btn-primary w-100">Remove from cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <c:set var="totalPrice" value="${totalPrice + item.buyPrice}"/>
        </c:forEach>
    </div>
</div>
<div class="footer">
    <h5>Total Price:
        <c:out value="${totalPrice}"/>
    </h5>
    <div class="btn-group">
        <a href="#" class="btn btn-light btn-footer">Checkout</a>
        <a href="ShopServlet" class="btn btn-secondary btn-footer">Continue Shopping</a>
    </div>
</div>
</body>
</html>
