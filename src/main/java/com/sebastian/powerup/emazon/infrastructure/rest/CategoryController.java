package com.sebastian.powerup.emazon.infrastructure.rest;

import com.sebastian.powerup.emazon.application.CategoryService;
import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.application.PageableQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/categories")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity <Category> save (@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <Iterable<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Category>> findAllPaged(
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
        return ResponseEntity.ok(categoryService.findAll(pageableQuery));
    }

}
