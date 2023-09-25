package com.cg.category.services;

import com.cg.category.exceptions.IdNotFoundException;
import com.cg.category.pojos.Category;

public interface CategoryServices {
	public Category addCategory(Category category);
	public void deleteCategory(int id);
	public Category updateCategory(int id,String names);
	public Category getCategory(int id) throws IdNotFoundException;

}
