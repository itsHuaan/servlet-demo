package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.IProductService;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    private ProductService _productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchInput = request.getParameter("searchInput");
        List<ProductDTO> searched_list_product = _productService.getProductsByName(searchInput);
        request.setAttribute("list_product", searched_list_product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}