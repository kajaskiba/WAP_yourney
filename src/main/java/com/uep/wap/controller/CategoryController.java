package com.uep.wap.controller;


import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.model.Category;
import com.uep.wap.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/categories")
    public String addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCategory(categoryDTO);
        return  "Category added!";

    }

    @GetMapping(path = "/categories")
    public Iterable<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/categories/{categoryID}")
    public Category findCategoryByID(@PathVariable long categoryID){
        return categoryService.getCategoryById(categoryID);
    }

    @GetMapping(path = "/categories/{categoryName}")
    public Category findCategoryByName(@PathVariable String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }

    @DeleteMapping(path = "/categories/{categoryID}")
    public void deleteCategoryById(@PathVariable long categoryID){
         categoryService.deleteCategory(categoryID);
    }


}
