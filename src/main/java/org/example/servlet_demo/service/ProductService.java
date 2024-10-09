package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductService implements IProductService {

    @Override
    public List<ProductDTO> getProducts(String orderBy) {
        List<ProductDTO> products = new ArrayList<>();
        DatabaseUtil dbConnector = new DatabaseUtil();
        String query = "select * from products";
        if (Objects.equals(orderBy, "0")) {
            query += "";
        }
        if (Objects.equals(orderBy, "asc") || Objects.equals(orderBy, "desc")) {
            query += " order by buyPrice " + orderBy;
        }
        try {
            Connection connection = dbConnector.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String productCode = resultSet.getString(1);
                String productName = resultSet.getString(2);
                String productLine = resultSet.getString(3);
                String productScale = resultSet.getString(4);
                String productVendor = resultSet.getString(5);
                String productDescription = resultSet.getString(6);
                int quantityInStock = resultSet.getInt(7);
                double buyPrice = resultSet.getDouble(8);
                double MSRP = resultSet.getDouble(9);
                products.add(new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP));
            }
            dbConnector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        List<ProductDTO> products = new ArrayList<>();
        DatabaseUtil dbConnector = new DatabaseUtil();
        try {
            Connection connection = dbConnector.openConnection();
            String query = "select * from products where productName like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String productCode = resultSet.getString(1);
                String productName = resultSet.getString(2);
                String productLine = resultSet.getString(3);
                String productScale = resultSet.getString(4);
                String productVendor = resultSet.getString(5);
                String productDescription = resultSet.getString(6);
                int quantityInStock = resultSet.getInt(7);
                double buyPrice = resultSet.getDouble(8);
                double MSRP = resultSet.getDouble(9);
                products.add(new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP));
            }
            dbConnector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<String> getProductColumn(String column_name, String table_name) {
        List<String> lines = new ArrayList<>();
        DatabaseUtil dbConnector = new DatabaseUtil();
        try {
            Connection connection = dbConnector.openConnection();
            String query = "select " + column_name + " from " + table_name;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                lines.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

}
