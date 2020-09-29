package dev.collegue.web.collegue;

public class CollegueGalerie {

//	FIELDS
	private String matricule;
	private String photoUrl;

//	CONSTRUCTORS
	public CollegueGalerie() {
	}

	public CollegueGalerie(String matricule, String photoUrl) {
		this.matricule = matricule;
		this.photoUrl = photoUrl;
	}

//	GETTERS & SETTERS
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
