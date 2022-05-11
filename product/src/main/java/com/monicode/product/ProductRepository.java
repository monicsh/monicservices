package com.monicode.product;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends MongoRepository<Product, String> {
    List<Product> findByBrand(String b);

    List<Product> findAllByBrandAndSizeAndGender(String brand, String size, Gender gender);
}
