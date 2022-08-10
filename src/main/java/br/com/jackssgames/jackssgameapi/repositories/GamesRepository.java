package br.com.jackssgames.jackssgameapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jackssgames.jackssgameapi.models.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, UUID>{

}
