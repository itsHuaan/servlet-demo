package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddtocartServlet", value = "/AddtocartServlet")
public class AddtocartServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        List<ProductDTO> cart = (List<ProductDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        ProductDTO product = productService.getProductByID(productCode);
        if (product != null) {
            cart.add(product);
        }
        session.setAttribute("cart", cart);
        String message = "Added to cart";
        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DetailServlet?productCode=" + productCode);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}