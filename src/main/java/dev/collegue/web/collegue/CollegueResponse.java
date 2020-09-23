package dev.collegue.web.collegue;

public class CollegueResponse {

//	FIELDS
	String nom;

	String matricule;

//	CONSTRUCTORS
	public CollegueResponse() {
	}

	public CollegueResponse(String nom, String matricule) {
		this.nom = nom;
		this.matricule = matricule;
	}

//	GETTERS & SETTERS
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
