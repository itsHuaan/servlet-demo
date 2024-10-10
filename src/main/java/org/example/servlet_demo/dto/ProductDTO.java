package org.example.servlet_demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;
    private boolean status;
}
