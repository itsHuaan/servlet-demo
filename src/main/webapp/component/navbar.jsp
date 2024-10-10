<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10-Oct-24
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">ShopBrand</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ShopServlet">Shop</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="cart.jsp">Cart</a>
        </li>
      </ul>
      <form class="d-flex" action="SearchServlet" method="get">
        <input class="form-control me-2" type="search" name="searchInput" placeholder="Search products" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
