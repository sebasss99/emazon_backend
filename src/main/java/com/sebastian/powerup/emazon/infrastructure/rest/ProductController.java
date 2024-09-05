package com.sebastian.powerup.emazon.infrastructure.rest;

import com.sebastian.powerup.emazon.application.CategoryService;
import com.sebastian.powerup.emazon.application.PageableQuery;
import com.sebastian.powerup.emazon.application.ProductService;
import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity <Product> save (@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Product>> findAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "asc") String order) {
        PageableQuery pageableQuery = new PageableQuery() {
            @Override
            public Integer getPageNumber() {
                return page;
            }

            @Override
            public Integer getPageSize() {
                return size;
            }

            @Override
            public String getSort() {
                return sort;
            }

            @Override
            public String getOrder() {
                return order;
            }
        };
        return ResponseEntity.ok(productService.findAll(pageableQuery));
    }

}
