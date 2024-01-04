package metier.entities;

public class Module {
	private int IdModule;
	private String Libelle;
	private String filiere;
	private String Classe;
	private String Semester;
	private int IdProfesseur;
	
	public Module() {
		super();
	}
	
	public Module(int idModule, String libelle, String filiere, String classe, String semester, int idProfesseur) {
		super();
		IdModule = idModule;
		Libelle = libelle;
		this.filiere = filiere;
		Classe = classe;
		Semester = semester;
		IdProfesseur = idProfesseur;
	}

	public int getIdProfesseur() {
		return IdProfesseur;
	}

	public void setIdProfesseur(int idProfesseur) {
		IdProfesseur = idProfesseur;
	}

	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public int getIdModule() {
		return IdModule;
	}
	public void setIdModule(int idModule) {
		IdModule = idModule;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Module [IdModule=" + IdModule + ", Libelle=" + Libelle + ", filiere=" + filiere + ", Classe=" + Classe
				+ ", Semester=" + Semester + ", IdProfesseur=" + IdProfesseur + "]";
	}
	
	
	
	
}
