package metier.entities;

import java.io.InputStream;

public class Etudiant {
	private int IdEtudiant;
	private int IdEtudiantClasse;
	private String NomEtudiant;
	private String PrenomEtudiant;
	private String CNI;
	private String CNE;
	private String filiere;
	private String Classe;
	private int IdCompte;
	private byte[] Photo;
	private InputStream inputStream;
	private String Base64image;
	
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String cNI, String cNE, String filiere,
			String classe, byte[] photo, String base64image) {
		super();
		IdEtudiant = idEtudiant;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
		this.filiere = filiere;
		Classe = classe;
		Photo = photo;
		Base64image = base64image;
	}
	public Etudiant(String nomEtudiant, String prenomEtudiant, String cNI, String cNE, String filiere, String classe,
			int idCompte, byte[] photo) {
		super();
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
		this.filiere = filiere;
		Classe = classe;
		IdCompte = idCompte;
		Photo = photo;
	}
	public Etudiant(int idEtudiant, int idEtudiantClasse, String nomEtudiant, String prenomEtudiant, String cNI,
			String cNE) {
		super();
		IdEtudiant = idEtudiant;
		IdEtudiantClasse = idEtudiantClasse;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
	}
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String cNI, String cNE) {
		super();
		IdEtudiant = idEtudiant;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
	}

	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String cNI, String cNE, String filiere,
			String classe) {
		super();
		IdEtudiant = idEtudiant;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
		this.filiere = filiere;
		Classe = classe;
	}

	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String cNE) {
		super();
		IdEtudiant = idEtudiant;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNE = cNE;
	}


	public Etudiant(String nomEtudiant, String prenomEtudiant, String cNI, String cNE, String filiere, String classe) {
		super();
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
		this.filiere = filiere;
		Classe = classe;
	}


	public Etudiant() {
		super();
	}

	public int getIdEtudiant() {
		return IdEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		IdEtudiant = idEtudiant;
	}
	public String getNomEtudiant() {
		return NomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		NomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return PrenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		PrenomEtudiant = prenomEtudiant;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getCNI() {
		return CNI;
	}
	public void setCNI(String cNI) {
		CNI = cNI;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public int getIdCompte() {
		return IdCompte;
	}
	public void setIdCompte(int idCompte) {
		IdCompte = idCompte;
	}
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}

	@Override
	public String toString() {
		return "Etudiant [IdEtudiant=" + IdEtudiant + ", NomEtudiant=" + NomEtudiant + ", PrenomEtudiant="
				+ PrenomEtudiant + ", Photo=" + Photo + ", filiere=" + filiere + ", Classe=" + Classe
				+ ", CNI=" + CNI + ", CNE=" + CNE + ", IdCompte=" + IdCompte + "]";
	}

	public int getIdEtudiantClasse() {
		return IdEtudiantClasse;
	}

	public void setIdEtudiantClasse(int idEtudiantClasse) {
		IdEtudiantClasse = idEtudiantClasse;
	}
	public String getBase64image() {
		return Base64image;
	}
	public void setBase64image(String base64image) {
		Base64image = base64image;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
	

}
