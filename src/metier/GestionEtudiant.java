package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Absence;
import metier.entities.Admin;
import metier.entities.Classe;
import metier.entities.Etudiant;
import metier.entities.Filiere;
import metier.entities.ListAbsence;
import metier.entities.Messages;
import metier.entities.Module;
import metier.entities.Professeur;
import metier.entities.Seance;
import metier.entities.Semester;
import metier.entities.Users;

public class GestionEtudiant implements InterfaceGestionEtudiant {

	@Override
	public List<Filiere> getFilieres() {
		Connection conn = SingletonConnection.getConnection();
		List<Filiere> filieres=new ArrayList<Filiere>();
		Filiere fil=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select filiere from filiere") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					fil= new Filiere();
					fil.setFiliere(rest.getString("filiere"));
					filieres.add(fil);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return filieres;
	}
	public List<Classe> getClasse(){
		Connection conn = SingletonConnection.getConnection();
		List<Classe> Classes=new ArrayList<Classe>();
		Classe clas=null;
		try { 
			
			//PreparedStatement ps =conn.prepareStatement("select filiere from filiere") ; 
			
			// la selection doit être depuis la table classe et non pas la table filiére
			PreparedStatement ps =conn.prepareStatement("select classe from classe") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					clas= new Classe();
					clas.setClasse(rest.getString("classe"));
					Classes.add(clas); 	
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return Classes;
		
	}

	@Override
	public void addEtudiant(Etudiant e) {
		System.out.println("Add student function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO etudiant(NomEtudiant,PrenomEtudiant,CNI,CNE,filiere,classe,Photo,FK_IdCompte)VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getNomEtudiant());
			ps.setString(2, e.getPrenomEtudiant());
			ps.setString(3, e.getCNI());
			ps.setString(4, e.getCNE());
			ps.setString(5, e.getFiliere());
			ps.setString(6, e.getClasse());
			ps.setBlob(7, e.getInputStream());
			ps.setInt(8, e.getIdCompte());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	

		

	
		
	}

	@Override
	public void deleteEtudiant(int IdEtudiant) {
		Connection conn = SingletonConnection.getConnection();
		System.out.println("delete function");
		
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from etudiant where IdEtudiant=?");
				
				ps.setInt(1,IdEtudiant);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
		
	}

	@Override
	public void modifyEtudiant(Etudiant e) {
		Connection conn = SingletonConnection.getConnection();
		System.out.println("update Student");
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE etudiant SET NomEtudiant =?,PrenomEtudiant=?,CNI=?,CNE=?,filiere=?,classe=? WHERE IdEtudiant = ?");
		
			ps.setString(1, e.getNomEtudiant());
			ps.setString(2, e.getPrenomEtudiant());
			ps.setString(3, e.getCNI());
			ps.setString(4, e.getCNE());
			ps.setString(5, e.getFiliere());
			ps.setString(6, e.getClasse());
			ps.setInt(7, e.getIdEtudiant());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public List<Etudiant> searchEtudiant(String code) {
		List<Etudiant> Etudiants=new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement("select NomEtudiant,PrenomEtudiant,CNI,CNE,filiere,classe from etudiant where ( NomEtudiant like '%?%') or (PrenomEtudiant like '%?%')");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e=new Etudiant();
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				e.setFiliere(rs.getString("filiere"));
				e.setClasse(rs.getString("classe"));
				Etudiants.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Etudiants;
	}

	@Override
	public List<Etudiant> classeEtudiants(String filiere,String classe) {
		List<Etudiant> classes=new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement("select IdEtudiant,@n:=@n+1 , NomEtudiant ,Prenometudiant , CNI  , CNE from etudiant,  (select @n :=0) m where filiere=? and classe=?;");
			ps.setString(1, filiere);
			ps.setString(2, classe);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e=new Etudiant();
				e.setIdEtudiant(rs.getInt("IdEtudiant"));
				e.setIdEtudiantClasse(rs.getInt("@n:=@n+1"));
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				classes.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return classes;
	}
	@Override
	public List<Etudiant> ListEtudiants() {
		List<Etudiant> listEtudiants=new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement("Select IdEtudiant,NomEtudiant,PrenomEtudiant,CNI,CNE,filiere,classe from etudiant");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e=new Etudiant();
				e.setIdEtudiant(rs.getInt("IdEtudiant"));
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				e.setFiliere(rs.getString("filiere"));
				e.setClasse(rs.getString("classe"));
				listEtudiants.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listEtudiants;
		
	}
	@Override
	public Etudiant getEtudiant(int code) {
		System.out.println("get etudiants functions");
		Connection conn = SingletonConnection.getConnection();
		Etudiant e=null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from etudiant WHERE IdEtudiant=? ;");
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e=new Etudiant();
				e.setIdEtudiant(rs.getInt("IdEtudiant"));
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				e.setPhoto(rs.getBytes("Photo"));
				e.setFiliere(rs.getString("filiere"));
				e.setClasse(rs.getString("classe"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(e==null)throw new RuntimeException("Etudiant "+code+" inexistant");
		return e;
	}

	public void addFiliere(Filiere f) {
		// TODO Auto-generated method stub
		System.out.println("Add Filiere function");
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO filiere (filiere) VALUES (?)");
			ps.setString(1, f.getFiliere());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}

	public void addClasse(Classe c) {
		// TODO Auto-generated method stub
		System.out.println("Add Classe function");
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO classe (classe) VALUES (?)");
			ps.setString(1, c.getClasse());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
	public void addModule(Module m) {
		// TODO Auto-generated method stub
		System.out.println("Add student Module");
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO module ( Libelle ,filiere, classe, FK_semester, FK_IdProfesseur) VALUES (?,?,?,?,?)");
			ps.setString(1, m.getLibelle());
			ps.setString(2, m.getFiliere());
			ps.setString(3, m.getClasse());
			ps.setString(4, m.getSemester());
			ps.setInt(5, m.getIdProfesseur());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	
	public void addProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		System.out.println("Add Professeur function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO professeur(NomProfesseur, PrenomProfesseur, CNI )VALUES(?,?,?)");
			ps.setString(1, p.getNomProfesseur());
			ps.setString(2, p.getPrenomProfesseur());
			ps.setString(3, p.getCNI());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	@Override
	public List<Semester> getSemester() {
		// TODO Auto-generated method stub
		System.out.println("get semester method");
		Connection conn = SingletonConnection.getConnection();
		List<Semester> semesters=new ArrayList<Semester>();
		Semester sem=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select Semester from semester") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					sem= new Semester();
					sem.setSemester(rest.getString("Semester"));
					semesters.add(sem);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return semesters;
	}
	@Override
	public void addSemester(Semester s) {
		// TODO Auto-generated method stub
		System.out.println("Add Semester methode");
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO semester (Semester) VALUES (?)");
			ps.setString(1, s.getSemester());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	@Override
	public List<Professeur> getProfesseur() {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<Professeur> Professeurs=new ArrayList<Professeur>();
		Professeur Prof=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select IdProfesseur, NomProfesseur, PrenomProfesseur, CNI from professeur") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					Prof= new Professeur();
					Prof.setIdProfesseur(rest.getInt("IdProfesseur"));
					Prof.setNomProfesseur(rest.getString("NomProfesseur"));
					Prof.setPrenomProfesseur(rest.getString("PrenomProfesseur"));
					Prof.setCNI(rest.getString("CNI"));
					Professeurs.add(Prof);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return Professeurs;
	}
	@Override
	public List<Module> getModule() {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<Module> Modules=new ArrayList<Module>();
		Module mod=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select IdModule, Libelle, filiere, classe, FK_semester, Fk_IdProfesseur from Module") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					mod= new Module();
					mod.setIdModule(rest.getInt("IdModule"));
					mod.setLibelle(rest.getString("Libelle"));
					mod.setFiliere(rest.getString("FK_semester"));
					mod.setClasse(rest.getString("classe"));
					mod.setIdProfesseur(rest.getInt("Fk_IdProfesseur"));
					Modules.add(mod);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Modules;
	}
	@Override
	public List<Seance> getSeance() {
		Connection conn = SingletonConnection.getConnection();
		List<Seance> Seances=new ArrayList<Seance>();
		Seance Sea=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select IdSeance, DateSeance, HeureDebut, HeureFin, TypeSeance, (Select Libelle from module where FK_IdModule=IdModule) , FK_IdModule  from Seance;") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					Sea= new Seance();
					Sea.setIdSeance(rest.getInt("IdSeance"));
					Sea.setDateSeance(rest.getString("DateSeance"));
					Sea.setHeureDebut(rest.getString("HeureDebut"));
					Sea.setHeureFin(rest.getString("HeureFin"));
					Sea.setTypeSeance(rest.getString("TypeSeance"));
					Sea.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					Sea.setIdModule(rest.getInt("FK_IdModule"));
					Seances.add(Sea);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Seances;
	}
	@Override
	public List<Absence> getAbsence() {
		Connection conn = SingletonConnection.getConnection();
		List<Absence> Absences=new ArrayList<Absence>();
		Absence Abs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select IdAbsence, FK_IdSeance, FK_IdEtudiant from Absence ") ; 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					Abs= new Absence();
					Abs.setIdAbsence(rest.getInt("IdAbsence"));
					Abs.setIdSeance(rest.getInt("FK_IdSeance"));
					Abs.setIdEtudiant(rest.getInt("FK_IdEtudiant"));
					
					Absences.add(Abs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Absences;
	}
	@Override
	public void addSeance(Seance s) {
		System.out.println("Add Seance function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Seance(DateSeance, HeureDebut, HeureFin, TypeSeance, FK_IdModule)VALUES(?,?,?,?,?)");
			ps.setString(1, s.getDateSeance());
			ps.setString(2, s.getHeureDebut());
			ps.setString(3, s.getHeureFin());
			ps.setString(4, s.getTypeSeance());
			ps.setInt(5, s.getIdModule());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	@Override
	public void addAbsence(Absence a) {
		// TODO Auto-generated method stub
		System.out.println("Add Absence function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO absence ( FK_IdSeance , FK_IdEtudiant, justifer, comment) VALUES ( ?, ? , ? , ? )");
			ps.setInt(1, a.getIdSeance());
			ps.setInt(2, a.getIdEtudiant());
			ps.setString(3, a.getJustifer());
			ps.setString(4, a.getComment());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	@Override
	public List<ListAbsence> getListAbsences() {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule),DateSeance, HeureDebut, HeureFin, TypeSeance ,NomEtudiant, PrenomEtudiant, CNI, CNE,justifer,comment from etudiant e, seance s , absence a where a.FK_IdEtudiant=e.IdEtudiant and a.FK_IdSeance=s.IdSeance;"); 
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setDateSeance(rest.getString("DateSeance"));
					listAbs.setHeureDebut(rest.getString("HeureDebut"));
					listAbs.setHeureFin(rest.getString("HeureFin"));
					listAbs.setTypeSeance(rest.getString("TypeSeance"));
					listAbs.setNomEtudiant(rest.getString("NomEtudiant"));
					listAbs.setPrenomEtudiant(rest.getString("PrenomEtudiant"));
					listAbs.setCNI(rest.getString("CNI"));
					listAbs.setCNE(rest.getString("CNE"));
					listAbs.setJustifer(rest.getString("justifer"));
					listAbs.setComment(rest.getString("comment"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	public List<ListAbsence> getSpecifiedListAbsences(ListAbsence e) {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select @n:=@n+1,IdEtudiant , NomEtudiant ,Prenometudiant  , CNE , CNI, TypeSeance,justifer,comment from etudiant e, seance s,absence a,(select @n :=0) m where e.IdEtudiant=a.FK_IdEtudiant and e.filiere=? and e.classe=? and s.DateSeance=? and s.HeureDebut=? and s.HeureFin=? and s.FK_IdModule=? and s.IdSeance=a.FK_IdSeance ;"); 
			ps.setString(1, e.getFiliere());
			ps.setString(2, e.getClasse());
			ps.setString(3, e.getDateSeance());
			ps.setString(4, e.getHeureDebut());
			ps.setString(5, e.getHeureFin());
			ps.setInt(6, e.getIdModule());
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setIdEtudiantClasse(rest.getInt("@n:=@n+1"));
					listAbs.setIdEtudiant(rest.getInt("IdEtudiant"));
					listAbs.setNomEtudiant(rest.getString("NomEtudiant"));
					listAbs.setPrenomEtudiant(rest.getString("PrenomEtudiant"));
					listAbs.setCNI(rest.getString("CNI"));
					listAbs.setCNE(rest.getString("CNE"));
					listAbs.setTypeSeance(rest.getString("TypeSeance"));
					listAbs.setJustifer(rest.getString("justifer"));
					listAbs.setComment(rest.getString("comment"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<Seance> getSeanceSelected(String DateSeance, String HeureDebut, String HeureFin) {
		Connection conn = SingletonConnection.getConnection();
		List<Seance> Seances=new ArrayList<Seance>();
		Seance Sea=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select IdSeance, DateSeance, HeureDebut, HeureFin, TypeSeance, (Select Libelle from module where FK_IdModule=IdModule) , FK_IdModule  from Seance where DateSeance=? and HeureDebut=? and HeureFin=?;") ; 
			ps.setString(1, DateSeance);
			ps.setString(2, HeureDebut);
			ps.setString(3, HeureFin);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					Sea= new Seance();
					Sea.setIdSeance(rest.getInt("IdSeance"));
					Sea.setDateSeance(rest.getString("DateSeance"));
					Sea.setHeureDebut(rest.getString("HeureDebut"));
					Sea.setHeureFin(rest.getString("HeureFin"));
					Sea.setTypeSeance(rest.getString("TypeSeance"));
					Sea.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					Sea.setIdModule(rest.getInt("FK_IdModule"));
					Seances.add(Sea);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Seances;
	}
	@Override
	public List<ListAbsence> getEtudiantAbsencesById(int id) {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule), DateSeance, HeureDebut, HeureFin, TypeSeance,justifer,comment  from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance"); 
			ps.setInt(1, id);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setDateSeance(rest.getString("DateSeance"));
					listAbs.setHeureDebut(rest.getString("HeureDebut"));
					listAbs.setHeureFin(rest.getString("HeureFin"));
					listAbs.setTypeSeance(rest.getString("TypeSeance"));
					listAbs.setJustifer(rest.getString("justifer"));
					listAbs.setComment(rest.getString("comment"));
					

					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public Admin getAdmin(int id) {
		System.out.println("get Admin functions");
		Connection conn = SingletonConnection.getConnection();
		Admin a=null;
		try {
			PreparedStatement ps = conn.prepareStatement("select IdAdmin, NomAdmin, PrenomAdmin, CNI, Photo,FK_IdCompte from admin where FK_IdCompte=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a=new Admin();
				a.setIdAdmin(rs.getInt("IdAdmin"));
				a.setNomAdmin(rs.getString("NomAdmin"));
				a.setPrenomAdmin(rs.getString("PrenomAdmin"));
				a.setPhoto(rs.getBytes("Photo"));
				a.setCNI(rs.getString("CNI"));
				a.setIdCompte(rs.getInt("FK_IdCompte"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
		
	}
	@Override
	public int addUser(Users u) {
		int id=0;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (Login, Password, Role) VALUES (?,?,?);");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getMotDePasse());
			ps.setString(3, u.getRole());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps1 = conn.prepareStatement("select IdCompte from compte where Login=? and Password=?;");
			ps1.setString(1, u.getEmail());
			ps1.setString(2, u.getMotDePasse());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				id=rs.getInt("IdCompte");
			}
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return id;
		
		
	}
	@Override
	public Etudiant getEtud(int id) {
		System.out.println("get etudiant functions");
		Connection conn = SingletonConnection.getConnection();
		Etudiant e=null;
		try {
			PreparedStatement ps = conn.prepareStatement("select IdEtudiant, NomEtudiant, PrenomEtudiant, CNI, CNE, Photo,filiere, classe from Etudiant where FK_IdCompte=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e=new Etudiant();
				e.setIdEtudiant(rs.getInt("IdEtudiant"));
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				e.setPhoto(rs.getBytes("Photo"));
				e.setFiliere(rs.getString("filiere"));
				e.setClasse(rs.getString("classe"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	@Override
	public void deleteAbsence(int code) {
		Connection conn = SingletonConnection.getConnection();
		System.out.println("deleteAbsence");
		
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from Absence where IdAbsence=?");
				
				ps.setInt(1,code);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
		
	}
	@Override
	public void deleteSeance(int code) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		System.out.println("deleteSeance");
		System.out.println(code);
			
			try {
				PreparedStatement ps = conn.prepareStatement("DELETE FROM `mywebapp`.`seance` WHERE (`IdSeance` = ?);");
				
				ps.setInt(1,code);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	@Override
	public void modifyAbsence(Absence a) {
		// TODO Auto-generated method stub
		System.out.println("Modify Absence function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE absence SET justifer = ?, comment = ? WHERE IdAbsence = ?");
			ps.setString(1, a.getJustifer());
			ps.setString(2, a.getComment());
			ps.setInt(3, a.getIdAbsence());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
		
	
	@Override
	public void modifySeance(Seance e) {
		// TODO Auto-generated method stub
		System.out.println("Modify Seance function");
		Connection conn = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE seance SET DateSeance =?, HeureDebut = ?, HeureFin =?, TypeSeance = ?, FK_IdModule = ? WHERE IdSeance = ?");
			ps.setString(1, e.getDateSeance());
			ps.setString(2, e.getHeureDebut());
			ps.setString(3, e.getHeureFin());
			ps.setString(4, e.getTypeSeance());
			ps.setInt(5, e.getIdModule());
			ps.setInt(6, e.getIdSeance());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	@Override
	public List<ListAbsence> getListNbrAbsencesParModule(int id) {
		// TODO Auto-generated method stub
		System.out.println("get List Nbr Absences Par Module function");
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule),count(IdAbsence) from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance group by FK_IdModule ;"); 
			ps.setInt(1, id);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setNbrHeureAbsence(rest.getInt("count(IdAbsence)"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public Absence getAbsence(int id) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		Absence a=null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from Absence WHERE IdAbsence=? ;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a=new Absence();
				a.setIdAbsence(rs.getInt("IdAbsence"));
				a.setIdEtudiant(rs.getInt("FK_IdEtudiant"));
				a.setIdSeance(rs.getInt("FK_IdSeance"));
				a.setComment(rs.getString("comment"));
				a.setJustifer(rs.getString("justifer"));
				
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
	}
	@Override
	public Seance getSeance(int id) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		Seance s=null;
		try {
			PreparedStatement ps = conn.prepareStatement("select IdSeance, DateSeance, HeureDebut, HeureFin, TypeSeance, (Select Libelle from module where FK_IdModule=IdModule) , FK_IdModule  from Seance where IdSeance=?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				s=new Seance();
				s.setIdSeance(rs.getInt("IdSeance"));
				s.setDateSeance(rs.getString("DateSeance"));
				s.setHeureDebut(rs.getString("HeureDebut"));
				s.setHeureFin(rs.getString("HeureFin"));
				s.setTypeSeance(rs.getString("TypeSeance"));
				s.setModuleLibelle(rs.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
				s.setIdModule(rs.getInt("FK_IdModule"));
				
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return s;
	}
	@Override
	public List<ListAbsence> getListNbrAbsencesParModuleDetaile(int id, String start, String end) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule), DateSeance, HeureDebut, HeureFin, TypeSeance,justifer,comment  from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance and (s.DateSeance BETWEEN ? AND ?);"); 
			ps.setInt(1, id);
			ps.setString(2, start);
			ps.setString(3, end);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setDateSeance(rest.getString("DateSeance"));
					listAbs.setHeureDebut(rest.getString("HeureDebut"));
					listAbs.setHeureFin(rest.getString("HeureFin"));
					listAbs.setTypeSeance(rest.getString("TypeSeance"));
					listAbs.setJustifer(rest.getString("justifer"));
					listAbs.setComment(rest.getString("comment"));
					

					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<ListAbsence> getListNbrAbsencesParModuleDetaile(int id, int dure) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule), DateSeance, HeureDebut, HeureFin, TypeSeance,justifer,comment  from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance and  DateSeance BETWEEN NOW() - INTERVAL ? DAY AND NOW();"); 
			ps.setInt(1, id);
			ps.setInt(2, dure);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setDateSeance(rest.getString("DateSeance"));
					listAbs.setHeureDebut(rest.getString("HeureDebut"));
					listAbs.setHeureFin(rest.getString("HeureFin"));
					listAbs.setTypeSeance(rest.getString("TypeSeance"));
					listAbs.setJustifer(rest.getString("justifer"));
					listAbs.setComment(rest.getString("comment"));
					

					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<ListAbsence> getListNbrAbsencesParModuleNbrTotal(int id, String start, String end) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule),2*count(IdAbsence) from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance and (s.DateSeance BETWEEN ? AND ?) group by FK_IdModule  ;"); 
			ps.setInt(1, id);
			ps.setString(2, start);
			ps.setString(3, end);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setNbrHeureAbsence(rest.getInt("2*count(IdAbsence)"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<ListAbsence> getListNbrAbsencesParModuleNbrTotal(int id, int dure) {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select (Select Libelle from module where FK_IdModule=IdModule),2*count(IdAbsence) from Absence a ,Seance s where a.FK_IdEtudiant=? and a.FK_IdSeance=s.IdSeance and  DateSeance BETWEEN NOW() - INTERVAL ? DAY AND NOW()  group by FK_IdModule  ;"); 
			ps.setInt(1, id);
			ps.setInt(2, dure);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setModuleLibelle(rest.getString("(Select Libelle from module where FK_IdModule=IdModule)"));
					listAbs.setNbrHeureAbsence(rest.getInt("2*count(IdAbsence)"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<Messages> getLastMessages(int id) {
		Connection conn = SingletonConnection.getConnection();
		List<Messages> Mess=new ArrayList<Messages>();
		Messages mes=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select * from messages join (select user, max(Date_Time) m  from ((select IdMessagae, Id_User_To user, Date_Time   from messages where Id_User_from=? )  union  (select IdMessagae, Id_User_from user, Date_Time  from messages where Id_User_To=?) ) t1 group by user) t2 on ((Id_User_from=? and Id_User_To=user) or  (Id_User_from=user and Id_User_To=?)) and  (Date_Time = m)  order by Date_Time desc;"); 
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setInt(3, id);
			ps.setInt(4, id);
			ResultSet res =ps.executeQuery(); 
			
				while(res.next()) {
					mes=new Messages();
					mes.setMessage(res.getString("Message"));
					mes.setId_user_from(res.getInt("Id_User_From"));
					mes.setId_user_to(res.getInt("Id_User_To"));
					mes.setTime(res.getString("Date_Time"));
					Mess.add(mes);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Mess;
	}
	@Override
	public List<Messages> getAllLastMessages(int id) {
		Connection conn = SingletonConnection.getConnection();
		List<Messages> Mess=new ArrayList<Messages>();
		Messages mes=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("select * from messages join (select user, max(Date_Time) m  from ((select IdMessagae, Id_User_To user, Date_Time   from messages where Id_User_from=? )  union  (select IdMessagae, Id_User_from user, Date_Time  from messages where Id_User_To=?) ) t1 group by user) t2 on ((Id_User_from=? and Id_User_To=user) or  (Id_User_from=user and Id_User_To=?)) and  (Date_Time = m)  order by Date_Time desc;"); 
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setInt(3, id);
			ps.setInt(4, id);
			ResultSet res =ps.executeQuery(); 
			
				while(res.next()) {
					mes=new Messages();
					mes.setMessage(res.getString("Message"));
					mes.setId_user_from(res.getInt("Id_User_From"));
					mes.setId_user_to(res.getInt("Id_User_To"));
					mes.setTime(res.getString("Date_Time"));
					Mess.add(mes);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Mess;
	}
	@Override
	public List<Messages> getCovrBetwnTwUsers(int id_from, int id_to) {
		Connection conn = SingletonConnection.getConnection();
		List<Messages> Mess=new ArrayList<Messages>();
		Messages mes=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("SELECT Message,Id_User_From,Id_User_To,Date_Time FROM messages  WHERE (Id_User_From = ? AND Id_User_To = ?) OR (Id_User_To = ? AND Id_User_From = ?) ORDER BY Date_Time ASC;"); 
			ps.setInt(1, id_from);
			ps.setInt(2, id_to);
			ps.setInt(3, id_from);
			ps.setInt(4, id_to);
			ResultSet res =ps.executeQuery(); 
			
				while(res.next()) {
					mes=new Messages();
					if(res.getInt("Id_User_From")==id_from){
						mes.setMessageRecived(res.getString("Message"));
					}else if(res.getInt("Id_User_From")==id_to){
						mes.setMessageSend(res.getString("Message"));
					}
					mes.setId_user_from(res.getInt("Id_User_From"));
					mes.setId_user_to(res.getInt("Id_User_To"));
					mes.setTime(res.getString("Date_Time"));
					Mess.add(mes);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Mess;
	}
	@Override
	public List<Module> getModuleByFillClasSems(String fill, String clas, String sems) {
		Connection conn = SingletonConnection.getConnection();
		List<Module> Modules=new ArrayList<Module>();
		Module mod=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("Select Libelle from module where filiere=? and classe=? and FK_semester=? order by Libelle ASC;") ; 
			ps.setString(1, fill);
			ps.setString(2, clas);
			ps.setString(3, sems);
		ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					mod= new Module();
					mod.setLibelle(rest.getString("Libelle"));
					Modules.add(mod);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		return Modules;
	}
	@Override
	public List<ListAbsence> getTotalAbsenceSpecifiedClass(int id, int dure,String sems) {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("Select Libelle ,(select 2*count(IdAbsence) from Absence a ,Seance s where a.FK_IdEtudiant=?  and a.FK_IdSeance=s.IdSeance and s.FK_IdModule=m.IdModule and DateSeance BETWEEN NOW() - INTERVAL ? DAY AND NOW()) as absencenbr  from module m where m.FK_semester=? order by Libelle ASC;"); 
			ps.setInt(1, id);
			ps.setInt(2, dure);
			ps.setString(3, sems);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setNbrHeureAbsence(rest.getInt("absencenbr"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public List<ListAbsence> getTotalAbsenceSpecifiedClass(int id, String start, String end,String sems) {
		Connection conn = SingletonConnection.getConnection();
		List<ListAbsence> ListAbsences=new ArrayList<ListAbsence>();
		ListAbsence listAbs=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("Select Libelle ,(select 2*count(IdAbsence) from Absence a ,Seance s where a.FK_IdEtudiant=?  and a.FK_IdSeance=s.IdSeance and s.FK_IdModule=m.IdModule and (s.DateSeance BETWEEN ? AND ?)) as absencenbr from module m where m.FK_semester=? order by Libelle ASC;  ;"); 
			ps.setInt(1, id);
			ps.setString(2, start);
			ps.setString(3, end);
			ps.setString(4, sems);
			ResultSet rest =ps.executeQuery(); 
		
				while(rest.next()) {
					listAbs= new ListAbsence();
					listAbs.setNbrHeureAbsence(rest.getInt("absencenbr"));
					ListAbsences.add(listAbs);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ListAbsences;
	}
	@Override
	public void sendMessage(Messages m) {
		System.out.println("Send Message function");
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO messages (`Message`, `Id_User_From`, `Id_User_To`, `Date_Time`) VALUES ( ? , ?, ? , ?)");
			ps.setString(1, m.getMessage());
			ps.setInt(2, m.getId_user_from());
			ps.setInt(3, m.getId_user_to());
			ps.setString(4, m.getTime());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}
	public List<Messages> getCovrBetwnTwUsersEtudiant(int id_from, int id_to) {
		Connection conn = SingletonConnection.getConnection();
		List<Messages> Mess=new ArrayList<Messages>();
		Messages mes=null;
		try { 
			PreparedStatement ps =conn.prepareStatement("SELECT Message,Id_User_From,Id_User_To,Date_Time FROM messages  WHERE (Id_User_From = ? AND Id_User_To = ?) OR (Id_User_To = ? AND Id_User_From = ?) ORDER BY Date_Time ASC;"); 
			ps.setInt(1, id_from);
			ps.setInt(2, id_to);
			ps.setInt(3, id_from);
			ps.setInt(4, id_to);
			ResultSet res =ps.executeQuery(); 
			
				while(res.next()) {
					mes=new Messages();
					if(res.getInt("Id_User_From")==id_from){
						mes.setMessageRecived(res.getString("Message"));
					}else if(res.getInt("Id_User_From")==id_to){
						mes.setMessageSend(res.getString("Message"));
					}
					mes.setId_user_from(res.getInt("Id_User_From"));
					mes.setId_user_to(res.getInt("Id_User_To"));
					mes.setTime(res.getString("Date_Time"));
					Mess.add(mes);
				}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Mess;
	}
	@Override
	public List<Etudiant> getSearchedEtudiants(String m) {
		List<Etudiant> listEtudiants=new ArrayList<Etudiant>();
		Connection conn = SingletonConnection.getConnection();
		try{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM etudiant WHERE CONCAT_WS(' ', NomEtudiant, PrenomEtudiant) LIKE '%?%';");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etudiant e=new Etudiant();
				e.setIdEtudiant(rs.getInt("IdEtudiant"));
				e.setNomEtudiant(rs.getString("NomEtudiant"));
				e.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
				e.setCNI(rs.getString("CNI"));
				e.setCNE(rs.getString("CNE"));
				e.setFiliere(rs.getString("filiere"));
				e.setClasse(rs.getString("classe"));
				listEtudiants.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listEtudiants;
	}

}
