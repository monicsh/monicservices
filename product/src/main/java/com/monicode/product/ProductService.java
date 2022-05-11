package com.monicode.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductRequest request){
        Product product = Product.builder()
                ._id(request._id())
                .productName(request.productName())
                .brand(request.brand())
                .sport(request.sport())
                .price(request.price())
                .sport(request.sport())
                .gender(request.gender())
                .size(request.size())
                .color(request.color())
                .quantity(request.quantity())
                .image(request.image())
                .productDetail(request.productDetail())
                .build();
        Product p = productRepository.save(product);
    }

    public List<Product> findAllByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> findAllByBrandAndSizeAndGender(String brand, String size, String gender) {
        return productRepository.findAllByBrandAndSizeAndGender(brand, size, Gender.valueOf(gender));
    }
}
