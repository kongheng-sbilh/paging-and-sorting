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
    public Product add(@RequestBody ProductRequest productRequest) {
        return productService.add(productRequest);
    }

    @GetMapping
    public List<Product> findProduct(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
                                     @RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
        Sort sort = Sort.by("price");
        PageRequest pageRequest;
        if (pageNumber == -1 && pageSize == -1) {
            pageRequest = PageRequest.of(0, Integer.MAX_VALUE, sort);
        } else {
            pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        }
        return productService.findProduct(pageRequest);
    }
}
