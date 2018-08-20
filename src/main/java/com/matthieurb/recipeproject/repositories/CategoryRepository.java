package com.matthieurb.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.recipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
