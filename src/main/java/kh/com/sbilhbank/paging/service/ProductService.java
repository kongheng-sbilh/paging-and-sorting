package kh.com.sbilhbank.paging.service;

import kh.com.sbilhbank.paging.entity.Product;
import kh.com.sbilhbank.paging.model.ProductRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    Product add(ProductRequest productRequest);
    List<Product> findProduct(PageRequest pageRequest);
}
