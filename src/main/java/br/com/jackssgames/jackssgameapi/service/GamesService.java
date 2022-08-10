package br.com.jackssgames.jackssgameapi.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.jackssgames.jackssgameapi.models.Games;
import br.com.jackssgames.jackssgameapi.repositories.GamesRepository;

@Service
public class GamesService {
	
	final
    private GamesRepository gamesRepository;
	
	public GamesService(GamesRepository gamesRepository) {
		this.gamesRepository = gamesRepository;
	}
	
	@Transactional
	public Games save(Games games) {
		return gamesRepository.save(games);
	}
	
	public Page<Games> findAll(Pageable pageable) {
		return gamesRepository.findAll(pageable);
	}
	
	public Optional<Games> findById(UUID id) {
		return gamesRepository.findById(id);
	}
	
	@Transactional
	public void delete(Games games) {
		gamesRepository.delete(games);
	}

}
