package dev.collegue.web.collegue;

import java.time.LocalDate;

public class CollegueResponseMatricule extends CollegueResponseNom {

//	FIELDS
	String prenoms;

	LocalDate dateDeNaissance;

	String photoUrl;

//	CONSTRUCTORS
	public CollegueResponseMatricule() {
	}

	public CollegueResponseMatricule(String matricule, String nom, String prenoms, LocalDate dateDeNaissance,
			String photoUrl) {
		super(nom, matricule);
		this.prenoms = prenoms;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
	}

//	GETTERS & SETTERS
	/**
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
