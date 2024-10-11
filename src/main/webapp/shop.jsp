<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <title>Product Shop</title>
</head>
<body>

<jsp:include page="component/navbar.jsp"/>


<div class="container-fluid">
    <div class="row">
        <jsp:include page="component/sidebar.jsp"/>
        <div class="col-md-9">
            <div class="row">
                <div class="container mt-4" style="display: flex; flex-direction: row; justify-content: space-between">
                    <h3>
                        <c:choose>
                            <c:when test="${not empty productLine}">
                                Products in "${productLine}"
                            </c:when>
                            <c:otherwise>
                                All products
                            </c:otherwise>
                        </c:choose>
                    </h3>
                    <jsp:include page="component/pricesorting.jsp"/>
                </div>
            </div>
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
                <c:forEach var="item" items="${list_product}">
                    <div class="col">
                        <div class="card h-100">
                            <img src="https://picsum.photos/500/500?random=${item.productCode}" class="card-img-top"
                                 alt="${item.productName}"
                                 style="height: 15rem; object-fit: cover;">
                            <div class="card-body d-flex flex-column">
                                <h5 class="productName">${item.productName}</h5>
                                <p class="inStock">In Stock: ${item.quantityInStock}</p>
                                <div class="mt-auto text-end">
                                    <p class="price text-success fw-bold">$${item.buyPrice}</p>
                                    <a href="DetailServlet?productCode=${item.productCode}"
                                       class="btn btn-primary w-100">Detail</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

</body>
</html>
