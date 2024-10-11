package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getProducts(String orderBy);
    ProductDTO getProductByID(String id);
    List<ProductDTO> getProductByName(String name);
    List<String> getProductColumn(String column_name, String table_name);
    List<ProductDTO> getProductByLine(String line);
    boolean removeProductByID(String id);
}
