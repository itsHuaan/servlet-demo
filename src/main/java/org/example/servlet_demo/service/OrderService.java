package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.OrderDTO;
import org.example.servlet_demo.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    DatabaseUtil dbConnector = new DatabaseUtil();
    Connection connection = null;

    public int maxOrderNumber() {
        int id = 0;
        try {
            connection = dbConnector.openConnection();
            String query = "select max(orders.orderNumber) from orders";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = new ArrayList<>();
        try {
            connection = dbConnector.openConnection();
            String query = "select * from orders order by orders.orderNumber asc";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(new OrderDTO(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getDate(3),
                        resultSet.getDate(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public boolean createOrder(OrderDTO order) {
        try {
            connection = dbConnector.openConnection();
            String query = "insert into orders value (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order.getOrderNumber());
            preparedStatement.setDate(2, order.getOrderDate());
            preparedStatement.setDate(3, order.getRequiredDate());
            preparedStatement.setDate(4, order.getShippedDate());
            preparedStatement.setString(5, order.getStatus());
            preparedStatement.setString(6, order.getComment());
            preparedStatement.setInt(7, order.getCustomerNumber());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
