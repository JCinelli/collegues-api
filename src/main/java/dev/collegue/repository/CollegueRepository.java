package dev.collegue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import dev.collegue.entity.Collegue;

@CrossOrigin
public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Optional<Collegue>> findByNom(String nom);

	Optional<Collegue> findByMatricule(String matricule);

}
