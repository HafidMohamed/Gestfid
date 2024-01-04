package metier.entities;

public class Seance {
	private int IdSeance;
	private String DateSeance;
	private String HeureDebut;
	private String HeureFin;
	private String TypeSeance;
	private String ModuleLibelle;
	private int IdModule;
	private int IdEtudiant;
	public Seance() {
		super();
	}
	
	public Seance(int idSeance, String dateSeance, String heureDebut, String heureFin, String typeSeance,
			String moduleLibelle, int idModule, int IdEtudiant) {
		super();
		IdSeance = idSeance;
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		IdModule = idModule;
		this.IdEtudiant = IdEtudiant;
	}

	public Seance(String dateSeance, String heureDebut, String heureFin, String typeSeance, String moduleLibelle,
			int IdEtudiant) {
		super();
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		this.IdEtudiant = IdEtudiant;
	}

	public Seance(int idSeance, String dateSeance, String heureDebut, String heureFin, String typeSeance,
			String moduleLibelle, int IdEtudiant) {
		super();
		IdSeance = idSeance;
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		this.IdEtudiant = IdEtudiant;
	}

	public Seance(String dateSeance, String heureDebut, String heureFin, String typeSeance, String moduleLibelle,
			int idModule, int IdEtudiant) {
		super();
		DateSeance = dateSeance;
		HeureDebut = heureDebut;
		HeureFin = heureFin;
		TypeSeance = typeSeance;
		ModuleLibelle = moduleLibelle;
		IdModule = idModule;
		this.IdEtudiant = IdEtudiant;
	}

	public String getModuleLibelle() {
		return ModuleLibelle;
	}

	public void setModuleLibelle(String moduleLibelle) {
		ModuleLibelle = moduleLibelle;
	}

	public int getIdSeance() {
		return IdSeance;
	}
	public void setIdSeance(int idSeance) {
		IdSeance = idSeance;
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
	public int getIdModule() {
		return IdModule;
	}
	public void setIdModule(int idModule) {
		IdModule = idModule;
	}
	public int getIdEtudiant() {
		return IdEtudiant;
	}
	public void setIdEtudiant(int IdEtudiant) {
		this.IdEtudiant = IdEtudiant;
	}
	

}
