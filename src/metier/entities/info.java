package metier.entities;

public class info {
	private String email,password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public info(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public info() {
		super();
	}
	

}
