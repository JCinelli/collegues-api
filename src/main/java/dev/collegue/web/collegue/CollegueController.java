package dev.collegue.web.collegue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entity.Collegue;
import dev.collegue.service.CollegueService;

@CrossOrigin
@RestController
@RequestMapping("collegues")
public class CollegueController {

	private CollegueService colServ;

	public CollegueController(CollegueService colServ) {
		this.colServ = colServ;
	}

	@GetMapping
	public List<String> listCollegue(@RequestParam String nom) {
		return colServ.getByNom(nom).stream().map(Collegue::getMatricule).collect(Collectors.toList());

	}

	@GetMapping("photos")
	public List<CollegueGalerie> findAllGalerie() {
		return colServ.getList().stream().map(c -> new CollegueGalerie(c.getMatricule(), c.getPhotoUrl()))
				.collect(Collectors.toList());
	}

	/**
	 * url : [SERVER]/collegue/getMatricule?nom={nom}
	 * 
	 * @return un json de tous les matricules en bdd
	 */
	@GetMapping("{matricule}")
	public ResponseEntity<?> findByMatricule(@PathVariable String matricule) {
		Optional<Collegue> byMatricule = colServ.getByMatricule(matricule);

		if (byMatricule.isPresent()) {
			return ResponseEntity.ok(byMatricule.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * url : [SERVER]/collegue
	 * 
	 * @param collegueDto un objet collegueDto au format json
	 * @return un objet collegueDto au format json
	 */
	@PostMapping
	public ResponseEntity<?> newCollegue(@RequestBody CollegueDto collegueDto) {
		Collegue newCollegue = colServ.addCollegue(collegueDto.getNom(), collegueDto.getPrenom(),
				collegueDto.getEmail(), collegueDto.getDateNaissance(), collegueDto.getPhotoUrl());

		return ResponseEntity.ok(newCollegue);
	}

	/**
	 * 
	 * @param collegueDto un objet collegueDto au format json
	 * @return un objet collegueDto au format json
	 */
	@PutMapping
	public ResponseEntity<?> editUser(@RequestBody CollegueDto collegueDto) {
		Collegue editCollegue = colServ.updateCollegue(collegueDto.getId(), collegueDto.getMatricule(),
				collegueDto.getNom(), collegueDto.getPrenom(), collegueDto.getEmail(), collegueDto.getDateNaissance(),
				collegueDto.getPhotoUrl());
		return ResponseEntity.ok(editCollegue);
	}

	/**
	 * 
	 * @param id id du collegue a remove
	 * @return une String
	 */
	@DeleteMapping
	public ResponseEntity<?> remUser(@RequestParam Integer id) {
		return ResponseEntity.ok(colServ.remUser(id));
	}

}
