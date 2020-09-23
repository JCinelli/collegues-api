package dev.collegue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.collegue.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Optional<Collegue>> findByNom(String nom);

}
