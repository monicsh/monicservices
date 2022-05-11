package com.monicode.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    @Id
    private String _id;
    private String productName;
    private String brand;
    private Double price;
    private String sport;
    private Gender gender;
    private String size;
    private String color;
    private int quantity;
    private String image;
    private String productDetail;

//    public Product(String productName, String brand) {
//        this.productName = productName;
//        this.brand = brand;
//    }


    public Product(String productName,
                   String brand,
                   Double price,
                   String sport,
                   Gender gender,
                   String size,
                   String color,
                   int quantity,
                   String image,
                   String productDetail) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.sport = sport;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.image = image;
        this.productDetail = productDetail;
    }
}


