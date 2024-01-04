package metier.entities;

public class Absence {
	private int IdAbsence;
	private int IdSeance;
	private int IdEtudiant;
	private String justifer;
	private String comment;
	
	public Absence(int idSeance, int idEtudiant, String justifer, String comment) {
		super();
		IdSeance = idSeance;
		IdEtudiant = idEtudiant;
		this.justifer = justifer;
		this.comment = comment;
	}


	public Absence(int idAbsence, int idSeance, int idEtudiant) {
		super();
		IdAbsence = idAbsence;
		IdSeance = idSeance;
		IdEtudiant = idEtudiant;
	}
	
	
	public Absence(int idSeance, int idEtudiant) {
		super();
		IdSeance = idSeance;
		IdEtudiant = idEtudiant;
	}


	@Override
	public String toString() {
		return "Absence [IdAbsence=" + IdAbsence + ", IdSeance=" + IdSeance + ", IdEtudiant=" + IdEtudiant + "]";
	}


	public Absence() {
		super();
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
	public int getIdSeance() {
		return IdSeance;
	}
	public void setIdSeance(int idSeance) {
		IdSeance = idSeance;
	}
	public int getIdEtudiant() {
		return IdEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		IdEtudiant = idEtudiant;
	}
	

}
