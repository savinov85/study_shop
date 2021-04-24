package ru.savinov.spring.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.savinov.spring.shop.entities.Product;
import ru.savinov.spring.shop.repositories.ProductRepository;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional (readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void addProduct(String addTitle, Integer addPrice) {
        productRepository.save(new Product(addTitle, addPrice));

    }

    @Transactional
    public void updateTitleById(Long idUpdate, String newTitle, Integer newPrice) {
        Product product = getProductById(idUpdate);
        product.setTitle(newTitle);
        product.setPrice(newPrice);

      //  productRepository.updateById(idUpdate, newTitle, newPrice);
    }
}


