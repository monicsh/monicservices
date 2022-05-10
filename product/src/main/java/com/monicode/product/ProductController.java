package com.monicode.product;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getProductsByBrand(@RequestParam(name="brand") String brand,
                                            @RequestParam(name="size") String size,
                                            @RequestParam(name="gender") String gender){
        return productService.findAllByBrandAndSizeAndGender(brand, size, gender);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequest request){
        log.info("Adding new product {}", request);
        productService.addProduct(request);
    }

}
