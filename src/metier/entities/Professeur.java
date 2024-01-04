package metier.entities;



public class Professeur {
	private int IdProfesseur;
	private String NomProfesseur;
	private String PrenomProfesseur;
	private String CNI;
	private int IdCompte;
	private String Photo;
	
	public Professeur() {
		super();
	}
	public Professeur(String nomProfesseur, String prenomProfesseur, String cNI) {
		super();
		NomProfesseur = nomProfesseur;
		PrenomProfesseur = prenomProfesseur;
		CNI = cNI;
	}
	public Professeur(String nomProfesseur, String prenomProfesseur, String cNI, int idCompte) {
		super();
		NomProfesseur = nomProfesseur;
		PrenomProfesseur = prenomProfesseur;
		CNI = cNI;
		IdCompte = idCompte;
	}
	public Professeur(int idProfesseur, String nomProfesseur, String prenomProfesseur, String cNI, String Photo) {
		super();
		IdProfesseur = idProfesseur;
		NomProfesseur = nomProfesseur;
		PrenomProfesseur = prenomProfesseur;
		CNI = cNI;
		this.Photo = Photo;
	}
	public int getIdProfesseur() {
		return IdProfesseur;
	}
	public void setIdProfesseur(int idProfesseur) {
		IdProfesseur = idProfesseur;
	}
	public String getNomProfesseur() {
		return NomProfesseur;
	}
	public void setNomProfesseur(String nomProfesseur) {
		NomProfesseur = nomProfesseur;
	}
	public String getPrenomProfesseur() {
		return PrenomProfesseur;
	}
	public void setPrenomProfesseur(String prenomProfesseur) {
		PrenomProfesseur = prenomProfesseur;
	}
	public String getCNI() {
		return CNI;
	}
	public void setCNI(String cNI) {
		CNI = cNI;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public int getIdCompte() {
		return IdCompte;
	}
	public void setIdCompte(int idCompte) {
		IdCompte = idCompte;
	}
	public String toString() {
		return "Professeur [IdProfesseur=" + IdProfesseur + ", NomProfesseur=" + NomProfesseur + ", PrenomProfesseur="
				+ PrenomProfesseur + ", CNI=" + CNI + ", photo=" + Photo + ", IdCompte=" + IdCompte
				+ "]";
	}
}
