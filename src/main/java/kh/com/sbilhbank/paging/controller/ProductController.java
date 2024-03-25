package kh.com.sbilhbank.paging.controller;

import kh.com.sbilhbank.paging.entity.Product;
import kh.com.sbilhbank.paging.model.ProductRequest;
import kh.com.sbilhbank.paging.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product add(@RequestBody ProductRequest product) {
        return productService.add(product);
    }

    @GetMapping
    public List<Product> findProduct(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("price"));
        return productService.findProduct(pageRequest);
    }
}
