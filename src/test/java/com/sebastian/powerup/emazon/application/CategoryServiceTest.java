package com.sebastian.powerup.emazon.application;

import com.sebastian.powerup.emazon.domain.model.Category;
import com.sebastian.powerup.emazon.domain.port.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    private CategoryService categoryService;
    private ICategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(ICategoryRepository.class);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    void save() {
        Category category = new Category();  // Constructor vacío
        category.setName("Electronics");     // Usar setter para establecer el nombre

        // Mockear el comportamiento del repositorio
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // Ejecutar el método
        Category savedCategory = categoryService.save(category);

        // Verificar que el método del repositorio se haya llamado y el resultado sea correcto
        assertEquals("Electronics", savedCategory.getName());
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void findAll() {
        Category category1 = new Category();
        category1.setName("Electronics");

        Category category2 = new Category();
        category2.setName("Books");

        List<Category> categories = List.of(category1, category2);

        // Mockear el comportamiento del repositorio
        when(categoryRepository.findAll()).thenReturn(categories);

        // Ejecutar el método
        Iterable<Category> result = categoryService.findAll();

        // Verificar que el método del repositorio se haya llamado y el resultado sea correcto
        assertEquals(categories, result);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Category category = new Category();
        category.setName("Electronics");

        // Mockear el comportamiento del repositorio
        when(categoryRepository.findById(1)).thenReturn(category);

        // Ejecutar el método
        Category result = categoryService.findById(1);

        // Verificar que el método del repositorio se haya llamado y el resultado sea correcto
        assertEquals(category, result);
        verify(categoryRepository, times(1)).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        // Mockear el comportamiento del repositorio
        when(categoryRepository.findById(2)).thenReturn(null);

        // Ejecutar el método
        Category result = categoryService.findById(2);

        // Verificar que el método del repositorio se haya llamado y no se haya encontrado la categoría
        assertNull(result);
        verify(categoryRepository, times(1)).findById(2);
    }

    @Test
    void delete() {
        // Ejecutar el método
        categoryService.delete(1);

        // Verificar que el método del repositorio se haya llamado correctamente
        verify(categoryRepository, times(1)).deleteById(1);
    }

    @Test
    void testFindAll() {
        // Mockear PageableQuery
        PageableQuery pageableQuery = Mockito.mock(PageableQuery.class);

        // Mockear el resultado esperado de getAll
        Page<Category> mockPage = Mockito.mock(Page.class);

        // Mockear el comportamiento del repositorio
        when(categoryRepository.getAll(any(PageableQuery.class))).thenReturn(mockPage);

        // Ejecutar el método
        Page<Category> result = categoryService.findAll(pageableQuery);

        // Verificar que el método del repositorio se haya llamado correctamente
        assertEquals(mockPage, result);
        verify(categoryRepository, times(1)).getAll(pageableQuery);
    }
}