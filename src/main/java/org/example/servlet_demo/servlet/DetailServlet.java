package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.IProductService;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDTO product = productService.getProductByID(request.getParameter("productCode"));
        request.setAttribute("product", product);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}