package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.ProductDTO;
import org.example.servlet_demo.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductService implements IProductService {

    DatabaseUtil dbConnector = new DatabaseUtil();
    Connection connection = null;

    @Override
    public List<ProductDTO> getProducts(String orderBy) {
        List<ProductDTO> products = new ArrayList<>();
        String query = "select * from products";
        if (Objects.equals(orderBy, "default")) {
            query += "";
        }
        if (Objects.equals(orderBy, "asc") || Objects.equals(orderBy, "desc")) {
            query += " order by buyPrice " + orderBy;
        }
        try {
            connection = dbConnector.openConnection();
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
                boolean status = resultSet.getBoolean(10);
                products.add(new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP,
                        status));
            }
            dbConnector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public ProductDTO getProductByID(String id) {
        ProductDTO product = new ProductDTO();
        try {
            connection = dbConnector.openConnection();
            String query = "select * from products where productCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String productCode = resultSet.getString(1);
                String productName = resultSet.getString(2);
                String productLine = resultSet.getString(3);
                String productScale = resultSet.getString(4);
                String productVendor = resultSet.getString(5);
                String productDescription = resultSet.getString(6);
                int quantityInStock = resultSet.getInt(7);
                double buyPrice = resultSet.getDouble(8);
                double MSRP = resultSet.getDouble(9);
                boolean status = resultSet.getBoolean(10);
                product = new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP,
                        status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        List<ProductDTO> products = new ArrayList<>();
        try {
            connection = dbConnector.openConnection();
            String query = "select * from products where productName like ? and status = 1";
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
                boolean status = resultSet.getBoolean(10);
                products.add(new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP,
                        status));
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
        try {
            connection = dbConnector.openConnection();
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

    @Override
    public List<ProductDTO> getProductByLine(String line) {
        List<ProductDTO> products = new ArrayList<>();
        String query = "select * from products where productLine = ?";
        try {
            connection = dbConnector.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, line);
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
                boolean status = resultSet.getBoolean(10);
                products.add(new ProductDTO(productCode,
                        productName,
                        productLine,
                        productScale,
                        productVendor,
                        productDescription,
                        quantityInStock,
                        buyPrice,
                        MSRP,
                        status));
            }
            dbConnector.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean removeProductByID(String id) {
        ProductDTO product = getProductByID(id);
        boolean status = product.isStatus();
        try {
            connection = dbConnector.openConnection();
            String query = "update products set status = ? where productCode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, !status);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
