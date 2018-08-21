package com.matthieurb.recipeproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.matthieurb.recipeproject.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	
	Optional<UnitOfMeasure> findByUnit(String unit);

}
