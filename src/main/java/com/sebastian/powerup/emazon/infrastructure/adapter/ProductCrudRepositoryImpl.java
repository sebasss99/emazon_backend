package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.application.PageableQuery;
import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.model.Product;
import com.sebastian.powerup.emazon.domain.port.IProductRepository;
import com.sebastian.powerup.emazon.infrastructure.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {
    private IProductCrudRepository iProductCrudRepository;
    private ProductMapper productMapper;
    private IProductPageRepository iProductPageRepository;

    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper, IProductPageRepository iProductPageRepository) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
        this.iProductPageRepository = iProductPageRepository;
    }


    @Override
    public Product save(Product product) {
        return productMapper.toProduct( iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {return productMapper.toProductList( iProductCrudRepository.findAll() );
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct( iProductCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoria con id: " + id + " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iProductCrudRepository.deleteById(id);
    }

    @Override
    public Page<Product> getAll(PageableQuery pageableQuery) {
        Pageable pageable = PageRequest.of(
                pageableQuery.getPageNumber(),
                pageableQuery.getPageSize(),
                Sort.by(Sort.Direction.fromString(pageableQuery.getOrder()), pageableQuery.getSort())
        );
        return iProductPageRepository.findAll(pageable)
                .map(productMapper::toProduct);
    }
}
