package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.*;
import metier.entities.Module;

public class EtudiantModel {
	Etudiant etudiant;
	Admin admin;
	Absence absence;
	Seance seance;
	public Absence getAbsence() {
		return absence;
	}
	public void setAbsence(Absence absence) {
		this.absence = absence;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	private List<Classe> listClasses=new ArrayList<Classe>();
	private List<Filiere> listfilieres=new ArrayList<Filiere>();
	private List<Etudiant> listEtudiants=new ArrayList<Etudiant>();
	private List<Etudiant> classeEtudiants=new ArrayList<Etudiant>();
	private List<Professeur> listProfesseurs=new ArrayList<Professeur>();
	private List<Module> listModules=new ArrayList<Module>();
	private List<Semester> listSemesters=new ArrayList<Semester>();
	private List<ListAbsence> listAbsences=new ArrayList<ListAbsence>();
	private List<Absence> absences=new ArrayList<Absence>();
	private List<Seance> seances=new ArrayList<Seance>();
	private List<Messages> listMessages=new ArrayList<Messages>();
	private List<Messages> listAllMessages=new ArrayList<Messages>();
	private List<Messages> ConversationPage=new ArrayList<Messages>();
	private List<Etudiant> MessageEtudiants=new ArrayList<Etudiant>();
	private List<Admin> MessageAdmin=new ArrayList<Admin>();
	private List<Messages> ConversationStudent=new ArrayList<Messages>();
	private List<List<ListAbsence>> list=new ArrayList<List<ListAbsence>>();
	
	
	public List<ListAbsence> getListAbsences() {
		return listAbsences;
	}
	public void setListAbsences(List<ListAbsence> listAbsences) {
		this.listAbsences = listAbsences;
	}
	
	public List<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public List<Seance> getSeances() {
		return seances;
	}
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	public List<Professeur> getListProfesseurs() {
		return listProfesseurs;
	}
	public void setListProfesseurs(List<Professeur> professeurs) {
		this.listProfesseurs = professeurs;
	}
	public List<Module> getListModules() {
		return listModules;
	}
	public void setListModules(List<Module> modules) {
		listModules = modules;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public List<Classe> getListClasses() {
		return listClasses;
	}
	public void setListClasses(List<Classe> listClasses) {
		this.listClasses = listClasses;
	}
	public List<Filiere> getListfilieres() {
		return listfilieres;
	}
	public void setListfilieres(List<Filiere> listfilieres) {
		this.listfilieres = listfilieres;
	}
	public List<Etudiant> getListEtudiants() {
		return listEtudiants;
	}
	public void setListEtudiants(List<Etudiant> listEtudiants) {
		this.listEtudiants = listEtudiants;
	}
	public List<Etudiant> getClasseEtudiants() {
		return classeEtudiants;
	}
	public void setClasseEtudiants(List<Etudiant> classeEtudiants) {
		this.classeEtudiants = classeEtudiants;
	}
	public List<Semester> getListSemesters() {
		return listSemesters;
	}
	public void setListSemesters(List<Semester> listSemesters) {
		this.listSemesters = listSemesters;
	}
	public List<Messages> getListMessages() {
		return listMessages;
	}
	public void setListMessages(List<Messages> listMessages) {
		this.listMessages = listMessages;
	}
	public List<Messages> getListAllMessages() {
		return listAllMessages;
	}
	public void setListAllMessages(List<Messages> listAllMessages) {
		this.listAllMessages = listAllMessages;
	}
	public List<Messages> getConversationPage() {
		return ConversationPage;
	}
	public void setConversationPage(List<Messages> conversationPage) {
		ConversationPage = conversationPage;
	}
	public List<Etudiant> getMessageEtudiants() {
		return MessageEtudiants;
	}
	public void setMessageEtudiants(List<Etudiant> messageEtudiants) {
		MessageEtudiants = messageEtudiants;
	}
	public List<List<ListAbsence>> getList() {
		return list;
	}
	public void setList(List<List<ListAbsence>> list) {
		this.list = list;
	}
	public List<Admin> getMessageAdmin() {
		return MessageAdmin;
	}
	public void setMessageAdmin(List<Admin> messageAdmin) {
		MessageAdmin = messageAdmin;
	}
	public List<Messages> getConversationStudent() {
		return ConversationStudent;
	}
	public void setConversationStudent(List<Messages> conversationStudent) {
		ConversationStudent = conversationStudent;
	}
	

	
	
	
	

	

}
