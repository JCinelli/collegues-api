package dev.collegue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.collegue.entity.Collegue;
import dev.collegue.repository.CollegueRepository;
import dev.collegue.web.collegue.CollegueRequest;
import dev.collegue.web.collegue.CollegueResponseMatricule;
import dev.collegue.web.collegue.CollegueResponseNom;

@Service
public class CollegueService {

//	FIELD
	CollegueRepository collegueRepo;

//	CONSTRUCTOR
	public CollegueService(CollegueRepository collegueRepo) {
		this.collegueRepo = collegueRepo;
	}

//	METHODS
	public List<CollegueResponseNom> findByName(String nom) {

		List<CollegueResponseNom> collRes = new ArrayList<>();

		List<Optional<Collegue>> listCollegue = collegueRepo.findByNom(nom);

		if (!listCollegue.isEmpty()) {
			for (Optional<Collegue> collegue : listCollegue) {

				collRes.add(new CollegueResponseNom(collegue.get().getNom(), collegue.get().getMatricule()));

			}
		}

		return collRes;

	}

	public CollegueResponseMatricule findByMatricule(String matricule) {

		Optional<Collegue> optCollegue = collegueRepo.findByMatricule(matricule);

		CollegueResponseMatricule collegueResponseMatricule = new CollegueResponseMatricule();

		if (optCollegue.isPresent()) {
			collegueResponseMatricule.setDateDeNaissance(optCollegue.get().getDateDeNaissance());
			collegueResponseMatricule.setMatricule(optCollegue.get().getMatricule());
			collegueResponseMatricule.setNom(optCollegue.get().getNom());
			collegueResponseMatricule.setPhotoUrl(optCollegue.get().getPhotoUrl());
			collegueResponseMatricule.setPrenoms(optCollegue.get().getPrenoms());
			return collegueResponseMatricule;
		} else {
			return null;
		}

	}

	public Collegue postCollegue(CollegueRequest collReq) {

		Collegue newColl = new Collegue();
		newColl.setDateDeNaissance(collReq.getDateDeNaissance());
		newColl.setEmail(collReq.getEmail());
		newColl.setMatricule(collReq.getMatricule());
		newColl.setNom(collReq.getNom());
		newColl.setPhotoUrl(collReq.getPhotoUrl());
		newColl.setPrenoms(collReq.getPrenoms());

		return collegueRepo.save(newColl);
	}

}
