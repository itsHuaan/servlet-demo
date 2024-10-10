<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-image {
            max-width: 100%;
            height: auto;
        }

        .price {
            font-size: 2rem;
            color: #28a745;
            font-weight: bold;
        }

        .card-body p {
            font-size: 1.1rem;
        }
    </style>
</head>
<body>

<jsp:include page="component/navbar.jsp"/>

<div class="container my-5">
    <div class="row">
        <div class="col-md-6">
            <img src="https://picsum.photos/500/500?random" alt="Product Image" class="img-fluid product-image">
        </div>
        <div class="col-md-6">
            <div class="card border-0">
                <div class="card-body">
                    <h1 class="card-title">${product.productName}</h1>
                    <p class="text-muted">Category: ${product.productLine}</p>
                    <p class="card-text">${product.productDescription}</p>
                    <p class="price">$${product.buyPrice}</p>
                    <p class="text-muted">Vendor: ${product.productVendor}</p>
                    <p class="text-muted">Scale: ${product.productScale}</p>
                    <p class="text-success">In Stock: ${product.quantityInStock}</p>
                    <p class="text-muted">MSRP: $${product.MSRP}</p>
                    <div class="d-flex justify-content-start mb-3">
                        <a href="AddtocartServlet?productCode=${product.productCode}"
                           class="btn btn-success btn-lg me-3" onclick="addedToCard(${message})">
                            Add to Cart</a>
                        <button class="btn btn-primary btn-lg me-3">Buy Now</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function addedToCard(alertmessage) {
        alert(${alertmessage})
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
