package org.example.servlet_demo.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    int orderNumber;
    Date orderDate;
    Date requiredDate;
    Date shippedDate;
    String status;
    String comment;
    int customerNumber;
}
