package com.cg.category.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.category.exceptions.IdNotFoundException;
import com.cg.category.pojos.Category;
import com.cg.category.repository.CategoryRepo;


@Component
public class CategoryServicesImpl implements CategoryServices {
	@Autowired  CategoryRepo repo;

	@Override
	public Category addCategory(Category category) {
		return repo.save(category);
		
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public Category updateCategory(int id,String names) {
		// TODO Auto-generated method stub
		Category category = repo.findById(id).get();
		category.setCategoryName(names);
		return repo.save(category);
		
	}

	@Override
	public Category getCategory(int id) throws IdNotFoundException
{
		// TODO Auto-generated method stub
		Category category = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Category Id not found"));
		return category;
		
		
	}

}
