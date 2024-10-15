package org.example.servlet_demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailsDTO {
    int orderNumber;
    String productCode;
    int quantityOrdered;
    double priceEach;
    int orderLineNumber;
}
