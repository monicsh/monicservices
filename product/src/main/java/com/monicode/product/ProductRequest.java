package com.monicode.product;

public record ProductRequest(
        String _id,
        String productName,
        String brand,
        Double price,
        String sport,
        Gender gender,
        String size,
        String color,
        int quantity,
        String image,
        String productDetail
){
}
