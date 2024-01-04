package metier.entities;



public class Admin {
	private int IdAdmin;
	private String NomAdmin;
	private String PrenomAdmin;
	private String CNI;
	private byte[] Photo;
	private String Base64image;
	private int IdCompte;
	
	public Admin(String base64image) {
		super();
		Base64image = base64image;
	}
	public Admin() {
		super();
	}
	public Admin(String nomAdmin, String prenomAdmin, String cNI, byte[] photo, int idCompte) {
		super();
		NomAdmin = nomAdmin;
		PrenomAdmin = prenomAdmin;
		CNI = cNI;
		Photo = photo;
		IdCompte = idCompte;
	}
	public Admin(int idAdmin, String nomAdmin, String prenomAdmin, String cNI,byte[] Photo) {
		super();
		IdAdmin = idAdmin;
		NomAdmin = nomAdmin;
		PrenomAdmin = prenomAdmin;
		CNI = cNI;
		this.Photo = Photo;
	}
	public int getIdAdmin() {
		return IdAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		IdAdmin = idAdmin;
	}
	public String getNomAdmin() {
		return NomAdmin;
	}
	public void setNomAdmin(String nomAdmin) {
		NomAdmin = nomAdmin;
	}
	public String getPrenomAdmin() {
		return PrenomAdmin;
	}
	public void setPrenomAdmin(String prenomAdmin) {
		PrenomAdmin = prenomAdmin;
	}
	public String getCNI() {
		return CNI;
	}
	public void setCNI(String cNI) {
		CNI = cNI;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] b) {
		Photo = b;
	}
	public int getIdCompte() {
		return IdCompte;
	}
	public void setIdCompte(int idCompte) {
		IdCompte = idCompte;
	}
	@Override
	public String toString() {
		return "Admin [IdAdmin=" + IdAdmin + ", NomAdmin=" + NomAdmin + ", PrenomAdmin=" + PrenomAdmin + ", CNI=" + CNI
				+ ", photo=" +Photo + ", IdCompte=" + IdCompte + "]";
	}
	public String getBase64image() {
		return Base64image;
	}
	public void setBase64image(String base64image) {
		Base64image = base64image;
	}
	

}
