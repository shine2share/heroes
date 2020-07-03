package com.shine2share.dao;

import org.springframework.data.repository.CrudRepository;

import com.shine2share.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long>{
	
	Iterable<Hero> findByName(String name);
	
}
