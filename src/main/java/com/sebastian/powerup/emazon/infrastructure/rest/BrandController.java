package com.sebastian.powerup.emazon.infrastructure.rest;

import com.sebastian.powerup.emazon.application.BrandService;
import com.sebastian.powerup.emazon.domain.model.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/brands")
@Slf4j
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<Brand> save (@RequestBody Brand brand) {
        return new ResponseEntity<>(brandService.save(brand), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <Iterable<Brand>> findAll() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Brand> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }
}
