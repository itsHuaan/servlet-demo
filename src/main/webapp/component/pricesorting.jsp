<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10-Oct-24
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String orderBy = request.getParameter("orderBy");
  if (orderBy == null) {
    orderBy = "default";
  }
%>
<form id="sortForm" action="./ShopServlet" method="get" class="d-flex justify-content-end mb-3">
  <select name="orderBy" id="orderBy" class="form-select w-auto" onChange="submitDropdown()">
    <option value="default" <%= orderBy.equals("default") ? "selected" : "" %>>Sort by Price</option>
    <option value="asc" <%= orderBy.equals("asc") ? "selected" : "" %>>Low to High</option>
    <option value="desc" <%= orderBy.equals("desc") ? "selected" : "" %>>High to Low</option>
  </select>
</form>


<script>
  function submitDropdown() {
    document.getElementById("sortForm").submit();
  }
</script>
