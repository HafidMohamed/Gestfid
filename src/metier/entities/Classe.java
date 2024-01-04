package metier.entities;

public class Classe {
	private String Classe;
	
	public Classe() {
		super();
	}
	public Classe(String classe) {
		super();
		Classe = classe;
	}
	
	public String getClasse() {
		return Classe;
	}
	public void setClasse(String Classe) {
		this.Classe = Classe;
	}
	@Override
	public String toString() {
		return "Classe [Classe=" + Classe + "]";
	}
	
	

}
