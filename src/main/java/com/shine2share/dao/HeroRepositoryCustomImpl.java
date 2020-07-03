package com.shine2share.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.shine2share.model.Hero;
@Repository
public class HeroRepositoryCustomImpl implements HeroRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hero> findHeroByNames(String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Hero> query = cb.createQuery(Hero.class);
		Root<Hero> hero = query.from(Hero.class);

		Path<String> namePath = hero.get("name");

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(namePath, "%"+name+"%"));
		query.select(hero).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

		return entityManager.createQuery(query).getResultList();
	}

}
