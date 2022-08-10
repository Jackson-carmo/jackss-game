package br.com.jackssgames.jackssgameapi.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jackssgames.jackssgameapi.dtos.GamesDTO;
import br.com.jackssgames.jackssgameapi.models.Games;
import br.com.jackssgames.jackssgameapi.service.GamesService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/games")
public class GamesController {
	
	final 
	private	GamesService gamesService;
	
	public GamesController(GamesService gamesService) {
		this.gamesService = gamesService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> saveGames(@RequestBody @Valid GamesDTO dto){
		Games games = new Games();
		BeanUtils.copyProperties(dto, games);
		return ResponseEntity.status(HttpStatus.CREATED).body(gamesService.save(games));
	}
	
	@GetMapping
	public ResponseEntity<Page<Games>> getAllGames(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(gamesService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneGames(@PathVariable(value = "id") UUID id){
		Optional<Games> gamesOptional = gamesService.findById(id);
		if(!gamesOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(gamesOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGames(@PathVariable(value = "id") UUID id){
		Optional<Games> gamesOptional = gamesService.findById(id);
		if (!gamesOptional.isPresent()) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontrado!");
		}
		gamesService.delete(gamesOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Game deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateGames(@PathVariable(value = "id") UUID id,
											  @RequestBody @Valid GamesDTO gamesDTO) {
		Optional<Games> gamesOptional = gamesService.findById(id);
		if (!gamesOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontrado!");
		}
		var games = new Games();
		BeanUtils.copyProperties(gamesDTO, games);
		games.setId(gamesOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(gamesService.save(games));
	}

}
