package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.application.PageableQuery;
import com.sebastian.powerup.emazon.domain.model.Brand;
import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.port.IBrandRepository;
import com.sebastian.powerup.emazon.infrastructure.mapper.BrandMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class BrandCrudRepositoryImpl implements IBrandRepository {
    private final IBrandCrudRepository iBrandCrudRepository;
    private final BrandMapper brandMapper;
    private final IBrandPageRepository iBrandPageRepository;

    public BrandCrudRepositoryImpl(IBrandCrudRepository iBrandCrudRepository, BrandMapper brandMapper, IBrandPageRepository iBrandPageRepository) {
        this.iBrandCrudRepository = iBrandCrudRepository;
        this.brandMapper = brandMapper;
        this.iBrandPageRepository = iBrandPageRepository;
    }

    @Override
    public Brand save(Brand brand) {
        return brandMapper.toBrand( iBrandCrudRepository.save(brandMapper.toBrandEntity(brand)));
    }

    @Override
    public Iterable<Brand> findAll() {
        return brandMapper.toBrandList( iBrandCrudRepository.findAll() );
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.toBrand( iBrandCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Marca con id: " + id + " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iBrandCrudRepository.deleteById(id);
    }

    @Override
    public Page<Brand> getAll(PageableQuery pageableQuery) {
        Pageable pageable = PageRequest.of(
                pageableQuery.getPageNumber(),
                pageableQuery.getPageSize(),
                Sort.by(Sort.Direction.fromString(pageableQuery.getOrder()), pageableQuery.getSort())
        );
        return iBrandPageRepository.findAll(pageable)
                .map(brandMapper::toBrand);
    }
}
