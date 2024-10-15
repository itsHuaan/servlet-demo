package org.example.servlet_demo.servlet;

import org.example.servlet_demo.dto.OrderDTO;
import org.example.servlet_demo.dto.OrderDetailsDTO;
import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.service.OrderService;
import org.example.servlet_demo.util.DatabaseUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "CheckoutServlet", value = "/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        HttpSession session = request.getSession();
        List<ProductDTO> cart = (List<ProductDTO>) session.getAttribute("cart");
        HashMap<String, OrderDetailsDTO> cartItems = new HashMap<>();
        for (ProductDTO product : cart) {
            if (cartItems.containsKey(product.getProductCode())) {
                OrderDetailsDTO existingItem = cartItems.get(product.getProductCode());
                existingItem.setQuantityOrdered(existingItem.getQuantityOrdered() + 1);
            } else {
                cartItems.put(product.getProductCode(), new OrderDetailsDTO(orderNumber, product.getProductCode(), 1, product.getBuyPrice(), 1));
            }
        }
        List<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>(cartItems.values());
        OrderDTO orderDTO = new OrderDTO(
                orderNumber,
                new java.sql.Date(new java.util.Date().getTime()),
                new java.sql.Date(new java.util.Date().getTime()),
                null,
                "Oke",
                null,
                103
        );
        if (InsertRecordToOrders(orderDTO)) {
            int count = 0;
            for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
                if (InsertRecordToOrderDetails(orderDetailsDTO)) {
                    cart.clear();
                    count++;
                } else {
                    System.out.println("Insert failed");
                }
            }
            System.out.println(count + " rows inserted");
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("ShopServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    boolean InsertRecordToOrders(OrderDTO orderDTO) {
        DatabaseUtil db = new DatabaseUtil();
        try {
            Connection connection = db.openConnection();
            String query = "insert into orders value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderDTO.getOrderNumber());
            preparedStatement.setDate(2, orderDTO.getOrderDate());
            preparedStatement.setDate(3, orderDTO.getRequiredDate());
            preparedStatement.setDate(4, orderDTO.getShippedDate());
            preparedStatement.setString(5, orderDTO.getStatus());
            preparedStatement.setString(6, orderDTO.getComment());
            preparedStatement.setInt(7, orderDTO.getCustomerNumber());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    boolean InsertRecordToOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        DatabaseUtil db = new DatabaseUtil();
        try {
            Connection connection = db.openConnection();
            String query = "insert into orderdetails value (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderDetailsDTO.getOrderNumber());
            preparedStatement.setString(2, orderDetailsDTO.getProductCode());
            preparedStatement.setInt(3, orderDetailsDTO.getQuantityOrdered());
            preparedStatement.setDouble(4, orderDetailsDTO.getPriceEach());
            preparedStatement.setInt(5, orderDetailsDTO.getOrderLineNumber());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}