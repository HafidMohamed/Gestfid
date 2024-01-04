package metier.entities;

public class Users {
		private int id;
		private String email;
	    private String motDePasse;
	    private String role;
	    
		public Users() {
			super();
		}
		public Users(String email, String motDePasse, String role) {
			super();
			this.email = email;
			this.motDePasse = motDePasse;
			this.role = role;
		}
		public Users(int id, String role) {
			super();
			this.id = id;
			this.role = role;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMotDePasse() {
			return motDePasse;
		}
		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", email=" + email + ", motDePasse=" + motDePasse + ", role=" + role + "]";
		}
	    
	}