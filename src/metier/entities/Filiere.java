package metier.entities;

public class Filiere {
	private String filiere;

	public Filiere() {
		super();
	}

	public Filiere(String filiere) {
		super();
		this.filiere = filiere;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Filiere [filiere=" + filiere +"]";
	}
	
	

}
