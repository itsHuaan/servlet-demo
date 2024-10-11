package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.IProductService;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    private final IProductService _productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderBy = request.getParameter("orderBy");
        String line = request.getParameter("productLine");
        List<ProductDTO> list_product = _productService.getProducts(orderBy);
        List<ProductDTO> list_product_by_line = _productService.getProductByLine(line);
        HttpSession session = request.getSession();
        List<ProductDTO> cart = (List<ProductDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        List<String> lines = (List<String>) session.getAttribute("product_lines");
        if (lines == null) {
            lines = _productService.getProductColumn("productLine", "productlines");
            session.setAttribute("product_lines", lines);
        }
        request.setAttribute("product_lines", lines);
        if (line == null || lines.isEmpty()) {
            request.setAttribute("productLine", "");
            request.setAttribute("list_product", list_product);
        } else {
            request.setAttribute("productLine", line);
            request.setAttribute("list_product", list_product_by_line);
        }
        session.setAttribute("cart", cart);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}