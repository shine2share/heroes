package com.shine2share.dao;

import java.util.List;

import com.shine2share.model.Hero;

public interface HeroRepositoryCustom {
	List<Hero> findHeroByNames(String name);
}
