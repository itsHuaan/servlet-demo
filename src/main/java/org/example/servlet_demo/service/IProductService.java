package org.example.servlet_demo.service;

import org.example.servlet_demo.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getProducts(String orderBy);

    List<ProductDTO> getLimitProducts(int pageNumber, int pageSize);

    ProductDTO getProductByID(String id);

    List<ProductDTO> getProductByName(String name);

    List<String> getProductColumn(String column_name, String table_name);

    List<ProductDTO> getProductByLine(String line);

    int getProductCount();

    boolean removeProductByID(String id);
}
