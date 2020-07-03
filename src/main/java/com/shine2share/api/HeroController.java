package com.shine2share.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shine2share.dao.HeroRepository;
import com.shine2share.dao.HeroRepositoryCustom;
import com.shine2share.model.Hero;

@RestController
@RequestMapping(path = "/hero", produces = "application/json")
@CrossOrigin(origins = "*")
public class HeroController {

	private HeroRepository heroRepository;
	private HeroRepositoryCustom heroRepositoryCustom;

	public HeroController(HeroRepository heroRepository, HeroRepositoryCustom heroRepositoryCustom) {
		this.heroRepository = heroRepository;
		this.heroRepositoryCustom = heroRepositoryCustom;
	}

	@GetMapping("/recent")
	public Iterable<Hero> getHero() {
		return heroRepository.findAll();
	}

	@GetMapping("/{id}")
	public Hero getHeroById(@PathVariable("id") Long id) {
		Optional<Hero> optHero = heroRepository.findById(id);
		if (optHero.isPresent()) {
			return optHero.get();
		}
		return null;
	}
	
//	@GetMapping("/name/{name}")
//	public Iterable<Hero> getHeroByName(@PathVariable("name") String name) {
//		Iterable<Hero> heros = heroRepository.findByName(name);
//		if (heros != null) {
//			return heros;
//		}
//		return null;
//	}
	
	@GetMapping("/name/{name}")
	public List<Hero> getHeroByNames(@PathVariable("name") String name) {
		List<Hero> heros = heroRepositoryCustom.findHeroByNames(name);
		if (heros != null) {
			return heros;
		}
		return null;
	}

	@PostMapping(consumes = "application/json")
	public Hero save(@RequestBody Hero hero) {
		return heroRepository.save(hero);
	}

	@PutMapping(consumes = "application/json")
	public Hero update(@RequestBody Hero hero) {
		return heroRepository.save(hero);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody void delete(@PathVariable("id") Long id) {
		if (id != null) {
			heroRepository.deleteById(id);
		}
	}

}
