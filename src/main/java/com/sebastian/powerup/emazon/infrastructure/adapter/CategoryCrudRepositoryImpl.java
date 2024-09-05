package com.sebastian.powerup.emazon.infrastructure.adapter;

import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.port.ICategoryRepository;
import com.sebastian.powerup.emazon.infrastructure.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.sebastian.powerup.emazon.application.PageableQuery;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {
    private final ICategoryCrudRepository iCategoryCrudRepository;
    private final CategoryMapper categoryMapper;
    private final ICategoryPageRepository iCategoryPageRepository;


    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper, ICategoryPageRepository iCategoryPageRepository) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
        this.iCategoryPageRepository = iCategoryPageRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryMapper.toCategory( iCategoryCrudRepository.save(categoryMapper.toCategoryEntity(category)));
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoryList( iCategoryCrudRepository.findAll() );
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory( iCategoryCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Categoria con id: " + id + " no existe")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        iCategoryCrudRepository.deleteById(id);
    }

    @Override
    public Page<Category> getAll(PageableQuery pageableQuery) {
        Pageable pageable = PageRequest.of(
                pageableQuery.getPageNumber(),
                pageableQuery.getPageSize(),
                Sort.by(Sort.Direction.fromString(pageableQuery.getOrder()), pageableQuery.getSort())
        );
        return iCategoryPageRepository.findAll(pageable)
                .map(categoryMapper::toCategory);
    }

}
