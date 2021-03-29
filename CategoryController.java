package com.example.codeengine.expense.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	private CategoryRepository categoryRepository;
	private List<Category> findAll;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@RequestMapping(value = "/categories",method=RequestMethod.GET)
	ResponseEntity<Collection<Category>> categories(){
		findAll = categoryRepository.findAll();
		ResponseEntity<Collection<Category>> r = ResponseEntity.status(HttpStatus.OK).body(findAll);
		System.out.println(findAll.get(0));
		return r;
	}
	@RequestMapping(value = "/categories",method=RequestMethod.POST)
	ResponseEntity<Category> createcategory(@Valid @RequestBody Category category){
		Category save = categoryRepository.save(category);
		ResponseEntity<Category> r = ResponseEntity.status(HttpStatus.OK).body(save);
		return r;
	
	}
	@RequestMapping(value = "/categories",method=RequestMethod.PUT)
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		Category save = categoryRepository.save(category);
		ResponseEntity<Category> r = ResponseEntity.status(HttpStatus.OK).body(save);
		return r;
	
	}

	@RequestMapping(value = "/categories/{id}",method=RequestMethod.DELETE)
	ResponseEntity<Category> deleteCategory(@PathVariable Long id){
		categoryRepository.deleteById(id);
		//ResponseEntity<Category> r = ResponseEntity.status(HttpStatus.OK).body(save);
		//return r;
		return ResponseEntity.ok().build();
	
	}
}
