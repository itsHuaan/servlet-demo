package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    public List<ProductDTO> getProductsByName(String name) {
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
    public List<ProductDTO> getProducts() {
        List<ProductDTO> products = new ArrayList<>();
        DatabaseUtil dbConnector = new DatabaseUtil();
        try {
            Connection connection = dbConnector.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");
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
}
