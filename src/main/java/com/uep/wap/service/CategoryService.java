package com.uep.wap.service;

import com.uep.wap.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.Category;
import com.uep.wap.repository.CategoryRepository;

import java.util.List;

    @Service
    public class CategoryService {
        @Autowired
        private CategoryRepository categoryRepository;

        public void addCategory(CategoryDTO categoryDTO){
            Category category = new Category();
            category.setName(categoryDTO.getName());
            categoryRepository.save(category);
            System.out.println("Category added!");
        }

        public Iterable<Category> getAllCategories() {
            return categoryRepository.findAll();
        }

        public Category getCategoryById(Long id) {
            return categoryRepository.findById(id).orElse(null);
        }


        public Category getCategoryByName(String categoryName){
            return categoryRepository.findByName(categoryName);

        }

        public void deleteCategory(Long id) {
            categoryRepository.deleteById(id);
        }
    }


