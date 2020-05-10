package ru.savinov.spring.study_shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.savinov.spring.study_shop.entities.Product;
import ru.savinov.spring.study_shop.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;



    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void addProduct(String add_Title, String addPrice) {
        int add_Price = Integer.parseInt(addPrice);
        productRepository.save(new Product(add_Title,add_Price));
    }


}