package metier.entities;

public class ListAbsence {
	private int IdAbsence;
	private int IdEtudiant;
	private int IdModule;
	private int IdEtudiantClasse;
	private int NbrHeureAbsence;
	
	public ListAbsence(int nbrHeureAbsence, String moduleLibelle) {
		super();
		NbrHeureAbsence = nbrHeureAbsence;
		ModuleLibelle = moduleLibelle;
	}
	public int getNbrHeureAbsence() {
		return NbrHeureAbsence;
	}
	public void setNbrHeureAbsence(int nbrHeureAbsence) {
		NbrHeureAbsence = nbrHeureAbsence;
	}
	private String DateSeance;
	private String HeureDebut;
	private String HeureFin;
	private String TypeSeance;
	private String ModuleLibelle;
	private String NomEtudiant;
	private String PrenomEtudiant;
	private String CNI;
	private String CNE;
	private String justifer;
	private String comment;
	private String filiere;
	private String Classe;
	
	public ListAbsence(String dateSeance, String heureDebut, String heureFin, String typeSeance, String moduleLibelle,
			String justifer, String comment) {
		super();
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		this.justifer = justifer;
		this.comment = comment;
	}
	public ListAbsence(int idModule, String dateSeance, String heureDebut, String heureFin, String filiere,
			String classe) {
		super();
		IdModule = idModule;
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		this.filiere = filiere;
		Classe = classe;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String classe) {
		Classe = classe;
	}
	public int getIdModule() {
		return IdModule;
	}
	public void setIdModule(int idModule) {
		IdModule = idModule;
	}
	public ListAbsence(int idAbsence, String dateSeance, String heureDebut, String heureFin, String typeSeance,
			String moduleLibelle, String nomEtudiant, String prenomEtudiant, String cNI, String cNE) {
		super();
		IdAbsence = idAbsence;
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
	}
	public ListAbsence(String dateSeance, String heureDebut, String heureFin, String typeSeance, String moduleLibelle,
			String nomEtudiant, String prenomEtudiant, String cNI, String cNE) {
		super();
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
	}
	
	public ListAbsence() {
		super();
	}
	@Override
	public String toString() {
		return "ListAbsence [IdAbsence=" + IdAbsence + ", DateSeance=" + DateSeance + ", HeureDebut=" + HeureDebut
				+ ", HeureFin=" + HeureFin + ", TypeSeance=" + TypeSeance + ", ModuleLibelle=" + ModuleLibelle
				+ ", NomEtudiant=" + NomEtudiant + ", PrenomEtudiant=" + PrenomEtudiant + ", CNI=" + CNI + ", CNE="
				+ CNE + "]";
	}
	
	public ListAbsence(int idEtudiant, int idEtudiantClasse, String typeSeance, String nomEtudiant,
			String prenomEtudiant, String cNI, String cNE, String justifer, String comment) {
		super();
		IdEtudiant = idEtudiant;
		IdEtudiantClasse = idEtudiantClasse;
		TypeSeance = typeSeance;
		NomEtudiant = nomEtudiant;
		PrenomEtudiant = prenomEtudiant;
		CNI = cNI;
		CNE = cNE;
		this.justifer = justifer;
		this.comment = comment;
	}
	public int getIdEtudiant() {
		return IdEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		IdEtudiant = idEtudiant;
	}
	public int getIdEtudiantClasse() {
		return IdEtudiantClasse;
	}
	public void setIdEtudiantClasse(int idEtudiantClasse) {
		IdEtudiantClasse = idEtudiantClasse;
	}
	public String getJustifer() {
		return justifer;
	}
	public void setJustifer(String justifer) {
		this.justifer = justifer;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getIdAbsence() {
		return IdAbsence;
	}
	public void setIdAbsence(int idAbsence) {
		IdAbsence = idAbsence;
	}
	public String getDateSeance() {
		return DateSeance;
	}
	public void setDateSeance(String dateSeance) {
		DateSeance = dateSeance;
	}
	public String getHeureDebut() {
		return HeureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		HeureDebut = heureDebut;
	}
	public String getHeureFin() {
		return HeureFin;
	}
	public void setHeureFin(String heureFin) {
		HeureFin = heureFin;
	}
	public String getTypeSeance() {
		return TypeSeance;
	}
	public void setTypeSeance(String typeSeance) {
		TypeSeance = typeSeance;
	}
	public String getModuleLibelle() {
		return ModuleLibelle;
	}
	public void setModuleLibelle(String moduleLibelle) {
		ModuleLibelle = moduleLibelle;
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

}
