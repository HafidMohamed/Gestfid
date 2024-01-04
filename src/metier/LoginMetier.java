package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import metier.entities.*;

public class LoginMetier {
	String login = null,password=null,role = null;
	  private Map<String, String> erreurs= new HashMap<String, String>();
	public  Users validation( String pass,String email) throws Exception {
		Users user = null;
		Connection conn = SingletonConnection.getConnection();
		
		
		System.out.println("validation !! ");
		System.out.println("pass : " + pass);
		System.out.println("email : " + email);

		if ( pass != null && email!=null) {
			
				PreparedStatement ps;

				try {
					user=new Users();
					ps = conn.prepareStatement("select IdCompte,login,password,role  from compte where login =? and password=? ");
					ps.setString(1,email);
					ps.setString(2,pass);
					ResultSet res = ps.executeQuery();
					while(res.next()) {
						login = res.getString("login");
						password = res.getString("password");
						role = res.getString("role");
						user.setId(res.getInt("IdCompte"));
						user.setRole(res.getString("role"));
						}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		                if(login == null || password ==null) {
			 			throw new Exception( " Email ou mot de passe invalide !!" );
			        }


		} else {
			System.out.println("password or email is null !!");
			throw new Exception( "Merci de saisir votre mot de passe ou votre email." );
		}
		return user;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	public void setErreur( String champ, String message ) {
		erreurs.put( champ, message );
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	
	
	
	
	
	
	
	
	
	
	
}
