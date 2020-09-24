package dev.collegue.web.collegue;

import dev.collegue.entity.Collegue;

public class CollegueResponseComplet extends CollegueRequest {

//	FIELDS
	Integer id;

//	CONSTRUCTOR
	public CollegueResponseComplet(Collegue coll) {
		this.setId(coll.getId());
		this.setDateDeNaissance(coll.getDateDeNaissance());
		this.setEmail(coll.getEmail());
		this.setMatricule(coll.getMatricule());
		this.setNom(coll.getNom());
		this.setPhotoUrl(coll.getPhotoUrl());
		this.setPrenoms(coll.getPrenoms());
	}

//	GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
