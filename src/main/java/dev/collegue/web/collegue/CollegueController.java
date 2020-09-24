package dev.collegue.web.collegue;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.entity.Collegue;
import dev.collegue.service.CollegueService;

@RestController
@RequestMapping("collegues")
public class CollegueController {

//	FIELD
	CollegueService collegueServ;

//	CONSTRUCTOR
	public CollegueController(CollegueService collegueServ) {
		this.collegueServ = collegueServ;
	}

//	METHODS
	@GetMapping()
	public ResponseEntity<?> getCollegueByName(@RequestParam String nom) {

		List<CollegueResponseNom> listCollResp = collegueServ.findByName(nom);

		if (!listCollResp.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(listCollResp);

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nom de client introuvable . . .");

		}

	}

	@GetMapping("{matricule}")
	public ResponseEntity<?> getCollegueByMatricule(@PathVariable String matricule) {

		CollegueResponseMatricule collResponse = collegueServ.findByMatricule(matricule);

		if (collResponse != null) {

			return ResponseEntity.status(HttpStatus.OK).body(collResponse);

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Collegue non trouvé . . .");

		}

	}

	@PostMapping
	public CollegueResponseComplet postCollegue(@RequestBody CollegueRequest collReq) {
		Collegue newColl = this.collegueServ.postCollegue(collReq);

		return new CollegueResponseComplet(newColl);
	}

}
