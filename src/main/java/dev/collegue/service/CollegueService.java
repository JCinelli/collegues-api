package dev.collegue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.collegue.entity.Collegue;
import dev.collegue.repository.CollegueRepository;
import dev.collegue.web.collegue.CollegueResponse;

@Service
public class CollegueService {

//	FIELD
	CollegueRepository collegueRepo;

//	CONSTRUCTOR
	public CollegueService(CollegueRepository collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

//	METHODS
	public List<CollegueResponse> findByName(String nom) {

		List<CollegueResponse> collRes = new ArrayList<>();

		List<Optional<Collegue>> listCollegue = collegueRepo.findByNom(nom);

		if (!listCollegue.isEmpty()) {
			for (Optional<Collegue> collegue : listCollegue) {

				collRes.add(new CollegueResponse(collegue.get().getNom(), collegue.get().getMatricule()));

			}
		}

		return collRes;

	}

}
