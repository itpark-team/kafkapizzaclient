package org.example.kafkapizzatgclient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PizzaOrder {
    private int id;
    private int userId;
    private String productItems;
    private String comments;
    private int totalPrice;
}
