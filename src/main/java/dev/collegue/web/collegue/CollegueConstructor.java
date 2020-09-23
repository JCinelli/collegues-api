package dev.collegue.web.collegue;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegue.service.CollegueService;

@RestController
@RequestMapping("collegues")
public class CollegueConstructor {

//	FIELD
	CollegueService collegueServ;

//	CONSTRUCTOR
	public CollegueConstructor(CollegueService collegueServ) {
		this.collegueServ = collegueServ;
	}

//	METHODS
	@GetMapping()
	public ResponseEntity<?> getClientByNom(@RequestParam String nom) {

		List<CollegueResponse> listCollResp = collegueServ.findByName(nom);

		if (!listCollResp.isEmpty()) {

			return ResponseEntity.status(HttpStatus.OK).body(listCollResp);

		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nNom de client introuvable . . .");

		}

	}

}
