package kh.com.sbilhbank.paging.service;

import kh.com.sbilhbank.paging.entity.Product;
import kh.com.sbilhbank.paging.model.ProductRequest;
import kh.com.sbilhbank.paging.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .price(productRequest.getPrice())
            .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> findProduct(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest).getContent();
    }
}
