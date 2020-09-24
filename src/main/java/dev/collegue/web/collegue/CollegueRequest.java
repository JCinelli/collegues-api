package dev.collegue.web.collegue;

import java.time.LocalDate;

public class CollegueRequest extends CollegueResponseMatricule {

	String email;

	public CollegueRequest(String matricule, String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl,
			String email) {
		super(matricule, nom, prenoms, dateDeNaissance, photoUrl);
		this.email = email;
	}

	public CollegueRequest() {
		super();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
