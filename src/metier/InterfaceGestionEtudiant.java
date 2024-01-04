package metier;

import java.util.List;

import metier.entities.*;
import metier.entities.Module;

public interface InterfaceGestionEtudiant {
	public List<Filiere> getFilieres();
	public List<Classe> getClasse();
	public List<Semester> getSemester();
	public List<Professeur> getProfesseur();
	public List<Module> getModule();
	public List<Seance> getSeance();
	public List<Absence> getAbsence();
	public Admin getAdmin(int id);
	public Etudiant getEtud(int id);
	public Absence getAbsence(int id);
	public Seance getSeance(int id);
	public void addSeance(Seance s);
	public void addAbsence(Absence a);
	public void addFiliere(Filiere f);
	public void addClasse(Classe c);
	public void addSemester(Semester s);
	public void addModule(Module m);
	public void addEtudiant(Etudiant e);
	public void addProfesseur(Professeur p);
	public void deleteEtudiant(int code);
	public void deleteAbsence(int code);
	public void deleteSeance(int code);
	public void modifyEtudiant(Etudiant e);
	public void modifyAbsence(Absence e);
	public void modifySeance(Seance e);
	public int addUser(Users u);
	public void sendMessage(Messages m);
	
	public List<Module> getModuleByFillClasSems(String fill,String clas,String sems);
	public List<ListAbsence> getTotalAbsenceSpecifiedClass(int id, int dure,String sems);
	public List<ListAbsence> getTotalAbsenceSpecifiedClass(int id, String start, String end,String sems);
	public List<Messages> getCovrBetwnTwUsers(int id_from,int id_to);
	public List<Messages> getAllLastMessages(int id);
	public List<Messages> getLastMessages(int id);
	public List<ListAbsence> getEtudiantAbsencesById(int id);
	public List<ListAbsence> getSpecifiedListAbsences(ListAbsence e);
	public List<ListAbsence> getListAbsences();
	public List<Etudiant> ListEtudiants();
	public List<Etudiant> getSearchedEtudiants(String m);
	public List<Etudiant> searchEtudiant(String code);
	public Etudiant getEtudiant(int code);
	public List<Seance> getSeanceSelected(String DateSeance, String HeureDebut,String HeureFin);
	public List<Etudiant> classeEtudiants(String filiere,String classe);
	public List<ListAbsence> getListNbrAbsencesParModule(int id);
	public List<ListAbsence> getListNbrAbsencesParModuleDetaile(int id,String start ,String end);
	public List<ListAbsence> getListNbrAbsencesParModuleDetaile(int id,int dure);
	public List<ListAbsence> getListNbrAbsencesParModuleNbrTotal(int id,String start ,String end);
	public List<ListAbsence> getListNbrAbsencesParModuleNbrTotal(int id,int dure);
	public List<Messages> getCovrBetwnTwUsersEtudiant(int id_from, int id_to);
	
	

}
