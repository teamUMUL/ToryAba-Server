package inu.thebite.toryaba.controller;

import inu.thebite.toryaba.entity.Category;
import inu.thebite.toryaba.model.image.AddCategoryRequest;
import inu.thebite.toryaba.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // add category
    @PostMapping("/category/add")
    public ResponseEntity addCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        Category category = categoryService.addCategory(addCategoryRequest);
        return ResponseEntity.ok(category);
    }

    // get category list
    @GetMapping("/category/list")
    public ResponseEntity getCategoryList() {
        List<Category> categoryList = categoryService.getCategoryList();
        return ResponseEntity.ok(categoryList);
    }

    // delete category
    @DeleteMapping("/category/{categoryId}/delete")
    public ResponseEntity deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
