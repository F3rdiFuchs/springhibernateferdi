package com.service.Category;

import java.util.List;

import com.model.Category.Category;
import com.model.Category.CategoryDAO;


public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;
	
	public List<Category> listCategory() {
		return this.categoryDAO.listCategory();
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	

}
