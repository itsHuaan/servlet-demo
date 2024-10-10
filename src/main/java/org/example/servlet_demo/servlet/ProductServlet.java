package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.IProductService;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private final IProductService _productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderBy = request.getParameter("orderBy");
        List<ProductDTO> list_product = _productService.getProducts(orderBy);
        HttpSession session = request.getSession();
        List<String> lines = (List<String>) session.getAttribute("product_lines");
        if (lines == null) {
            lines = _productService.getProductColumn("productLine", "productlines");
            session.setAttribute("product_lines", lines);
        }
        request.setAttribute("product_lines", lines);
        request.setAttribute("list_product", list_product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("management.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}