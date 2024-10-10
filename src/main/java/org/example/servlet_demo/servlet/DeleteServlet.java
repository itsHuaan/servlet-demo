package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private final ProductService _productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productCode");
        ProductDTO product = _productService.getProductByID(id);

        boolean isCurrentlyActive = product.isStatus();
        boolean isRemoved = _productService.removeProductByID(id);
        String status = null;

        String isRemovedStr = isCurrentlyActive ? "Activate" : "Deactivate";
        if(isRemoved) {
            status = "Deactivated";
        } else {
            status = "Activated";
        }
        request.setAttribute("status", status);
        request.setAttribute("isRemovedStr", isRemovedStr);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProductServlet");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}