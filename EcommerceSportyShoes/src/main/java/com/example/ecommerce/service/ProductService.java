package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.ProductShoe;
import com.example.ecommerce.repository.ProductRepository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> listProducts() {
        List<ProductShoe> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(ProductShoe product : products) {
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

    public static ProductShoe getProductFromDto(ProductDto productDto, Category category) {
        ProductShoe product = new ProductShoe();
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }


    public void addProduct(ProductDto productDto, Category category) {
        ProductShoe product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public void updateProduct(Integer productID, ProductDto productDto, Category category) {
        ProductShoe product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }


//    public Product getProductById(Integer productId) throws ProductNotExistException {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//        if (!optionalProduct.isPresent())
//            throw new ProductNotExistException("Product id is invalid " + productId);
//        return optionalProduct.get();
//    }



}
