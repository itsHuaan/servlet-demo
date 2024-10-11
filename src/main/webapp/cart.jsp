<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10-Oct-24
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>Your Cart</title>
    <style>
        @media (min-width: 1025px) {
            .h-custom {
                height: 100vh !important;
            }
        }

        body {
            background-color: #eee;
            font-family: Arial, sans-serif;
        }

        .card {
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .btn-remove {
            color: #cecece;
        }

        .btn-remove:hover {
            color: #ff4d4d;
        }

        .footer {
            background-color: #343a40;
            color: white;
            padding: 1rem;
            text-align: center;
        }

        .total-price {
            font-size: 1.5rem;
            font-weight: bold;
            color: #ffd700;
        }
    </style>
</head>
<body>

<jsp:include page="component/navbar.jsp"/>

<section class="h-100 h-custom" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card">
                    <div class="card-body p-4">

                        <div class="row">

                            <div class="col-lg-7">
                                <h5 class="mb-3"><a href="ShopServlet" class="text-body"><i
                                        class="fas fa-long-arrow-alt-left me-2"></i>Continue shopping</a></h5>
                                <hr>

                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <div>
                                        <p class="mb-1">Shopping cart</p>
                                        <p class="mb-0">You have ${cart.size()} items in your cart</p>
                                    </div>
                                    <div>
                                        <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!"
                                                                                                    class="text-body">price
                                            <i class="fas fa-angle-down mt-1"></i></a></p>
                                    </div>
                                </div>

                                <c:forEach var="item" items="${cart}">
                                    <div class="card mb-3">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex flex-row align-items-center">
                                                    <div>
                                                        <img
                                                                src="https://picsum.photos/200?random=${item.productCode}"
                                                                class="img-fluid rounded-3" alt="Shopping item"
                                                                style="width: 65px;">
                                                    </div>
                                                    <div class="ms-3">
                                                        <h5>${item.productName}</h5>
                                                        <p class="small mb-0"></p>
                                                    </div>
                                                </div>
                                                <div class="d-flex flex-row align-items-center">
                                                    <div style="width: 50px;">
                                                        <h5 class="fw-normal mb-0">${item.quantityInStock}</h5>
                                                    </div>
                                                    <div style="width: 80px;">
                                                        <h5 class="mb-0">$${item.buyPrice}</h5>
                                                    </div>
                                                    <a href="RemovecartServlet?productCode=${item.productCode}">
                                                        <i class="fas fa-trash-alt btn-remove"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:set var="totalPrice" value="${totalPrice + item.buyPrice}"/>
                                </c:forEach>
                            </div>

                            <div class="col-lg-5">
                                <div class="card bg-primary text-white rounded-3">
                                    <div class="card-body">
                                        <div class="d-flex justify-content-between align-items-center mb-4">
                                            <h5 class="mb-0">Card details</h5>
                                            <img src="https://avatars.githubusercontent.com/u/130011188?v=4"
                                                 class="img-fluid rounded-3" style="width: 45px;" alt="Avatar">
                                        </div>

                                        <p class="small mb-2">Card type</p>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-mastercard fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-visa fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-amex fa-2x me-2"></i></a>
                                        <a href="#!" type="submit" class="text-white"><i
                                                class="fab fa-cc-paypal fa-2x"></i></a>

                                        <form class="mt-4">
                                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                                <label class="form-label" for="typeName">Cardholder's Name</label>
                                                <input type="text" id="typeName"
                                                       class="form-control form-control-lg" siez="17"
                                                       placeholder="Cardholder's Name"/>
                                            </div>

                                            <div data-mdb-input-init class="form-outline form-white mb-4">
                                                <label class="form-label" for="typeText">Card Number</label>
                                                <input type="text"
                                                       class="form-control form-control-lg" siez="17"
                                                       placeholder="1234 5678 9012 3457" minlength="19"
                                                       maxlength="19"/>
                                            </div>

                                            <div class="row mb-4">
                                                <div class="col-md-6">
                                                    <div data-mdb-input-init class="form-outline form-white">
                                                        <label class="form-label" for="typeExp">Expiration</label>
                                                        <input type="text" id="typeExp"
                                                               class="form-control form-control-lg"
                                                               placeholder="MM/YYYY" size="7" id="exp" minlength="7"
                                                               maxlength="7"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div data-mdb-input-init class="form-outline form-white">
                                                        <label class="form-label" for="typeText">CCV/CVV</label>
                                                        <input type="password" id="typeText"
                                                               class="form-control form-control-lg"
                                                               placeholder="&#9679;&#9679;&#9679;" size="1"
                                                               minlength="3" maxlength="3"/>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Subtotal</p>
                                            <p class="mb-2">$<c:out value="${totalPrice}"/></p>
                                        </div>

                                        <div class="d-flex justify-content-between">
                                            <p class="mb-2">Shipping</p>
                                            <p class="mb-2">$20.00</p>
                                        </div>

                                        <div class="d-flex justify-content-between mb-4">
                                            <p class="mb-2">Total(Incl. taxes)</p>
                                            <p class="mb-2">$<c:out value="${totalPrice + 20}"/></p>
                                        </div>

                                        <button data-mdb-button-init data-mdb-ripple-init type="button"
                                                class="btn btn-info btn-lg w-100">
                                            <div class="d-flex justify-content-between">
                                                <span>$<c:out value="${totalPrice + 20}"/></span>
                                                <span>Checkout <i class="fas fa-long-arrow-alt-right ms-2"></i></span>
                                            </div>
                                        </button>


                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
