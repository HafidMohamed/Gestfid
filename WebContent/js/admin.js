
function setInnerHTML(elementId, innerHTML) {
    var el = document.getElementById(elementId);

    if (el) {
        el.innerHTML = innerHTML;
    }
}
function setPlaceholder(elementId, placeholder) {
    var ph = document.getElementById(elementId);

    if (ph) {
        ph.placeholder = placeholder;
    }
}
class Translate{
	constructor()
	{
		document.getElementById("fr").addEventListener("click",()=>{
			this.translate("fr");
		});
		document.getElementById("en").addEventListener("click",()=>{
			this.translate("en");
		});
		document.getElementById("de").addEventListener("click",()=>{
			this.translate("de");
		});
		this.translate(localStorage.getItem("Language"));
		
	}
	
	translate(language){
		if(language=="fr"){
			setPlaceholder('search_ph','Recherche etudiant');
			setInnerHTML('show_all', 'Afficher tous les messages');
			setInnerHTML('Profile_dd', 'Profil');
			setInnerHTML('Languages_dd', 'Langues');
			setInnerHTML('fr', 'fran&ccedil;ais');
			setInnerHTML('en', 'Anglais');
			setInnerHTML('de', 'Allemande');
			setInnerHTML('Logout_dd', 'Se d&eacute;connecter');
			setInnerHTML('notification_dd', 'Toutes les notifications');
			setInnerHTML('home', 'Accueil');
			setInnerHTML('lists', 'Listes');
			setInnerHTML('add', 'Ajouter');
			setInnerHTML('more', 'Plus');
			setInnerHTML('legal', '&copy; 2020 par GestFid. Tous les droits sont r&eacute;serv&eacute;s');
			setInnerHTML('home_h1', 'Bienvenu');
			setInnerHTML('dsa_h1', "Affichage d'une classe d'absence sp&eacute;cifique");
			setInnerHTML('major', 'Fili&egrave;re :');
			setInnerHTML('class', 'Classe :');
			setInnerHTML('module', 'Module :');
			setPlaceholder('DateSeance','Date Seance');
			setInnerHTML('Session_label', 'Date Seance');
			setPlaceholder('HeureDebut','Heure Debut');
			setInnerHTML('Session-begin_label', 'Heure Debut');
			setPlaceholder('HeureFin','Heure Fin');
			setInnerHTML('Session-end_label', 'Heure Fin');
			setPlaceholder('TypeSeance','Seance Type');
			setInnerHTML('Session-type', 'Seance Type');
			setInnerHTML('submit', 'soumettre');
			setInnerHTML('daa_h1', 'Affichage des Informations sur les Seances');
			setInnerHTML('n-module', 'Module');
			setInnerHTML('t-DateSeance', 'Date Seance');
			setInnerHTML('t-HeureDebut', 'Heure Debut');
			setInnerHTML('t-HeureFin', 'Heure Fin');
			setInnerHTML('t-TypeSeance', 'Seance Type');
			setInnerHTML('t-idEtudiant', 'Student identifiant');
			setInnerHTML('t-NomEtudiant', 'Nom Etudiant');
			setInnerHTML('t-PrenomEtudiant', 'Prenom Etudiant');
			setInnerHTML('daal_h1', 'Affichage des informations des etudiants');
			setInnerHTML('aa_h2', 'choisir la fili&egrave;re et la classe pour lister les etudiants');
			setInnerHTML('dab_h1', 'Affichage de toutes les informations sur les absences');
			setInnerHTML('as_h1', "Ajout d'une Seance");
			setInnerHTML('am_h1', "Ajout d'un Module");
			setInnerHTML('at_h1', "Ajout d'un Professeur");
			setInnerHTML('ac_h1', "Ajout d'un Classe");
			setInnerHTML('af_h1', "Ajout d'un Fili&egrave;re");
			setInnerHTML('ast_h1', "Ajout d'un Etudiant");
			setInnerHTML('mst_h1', "Modification d'un Etudiant");
			setInnerHTML('a_h1', "S&eacute;lectionnez l'op&eacute;ration s'il vous pla&icirc;t!");
			setPlaceholder('nom', "Nom");
			setPlaceholder('prenom', "Prenom");
			setPlaceholder('CNI', 'CNI');
			setInnerHTML('teacher_nom', "Professeur Nom");
			setInnerHTML('teacher_prenom', "Professeur Prenom");
			setInnerHTML('label_CNI', 'CNI');
			setInnerHTML('class_label', "Nouvelle classe");
			setInnerHTML('filiere_label', 'Nouvelle Fili&egrave;re');
			setInnerHTML('student_nom', 'Nom Etudiant');
			setInnerHTML('student_prenom', 'Prenom Etudiant');
			setInnerHTML('label_CNE', 'CNE');
			setInnerHTML('AddEtudiant', 'Ajouter un Etudiant');
			setInnerHTML('AddModule', 'Ajouter un Module');
			setInnerHTML('Addteacher', 'Ajouter un Professeur');
			setInnerHTML('Addclasse', 'Ajouter une Classe');
			setInnerHTML('Addfiliere', 'Ajouter un Fili&egrave;re');
			setInnerHTML('AddSession', 'Ajouter un Seance');
			setInnerHTML('Addabsences', 'Ajouter les Absences');
			setInnerHTML('t-major', 'Fili&egrave;re');
			setInnerHTML('t-class', 'Classe');
			setInnerHTML('t-edit', 'Modifer');
			setInnerHTML('t-delete', 'Supprimer');
			setInnerHTML('DisplaySpecifiedClasse', 'Afficher une Classe Sp&eacute;cifique');
			setInnerHTML('Displaystudents', 'Afficher tous les Etudiants');
			setInnerHTML('DisplaySessions', 'Afficher tous les Seances');
			setInnerHTML('DisplayAbsences', 'Afficher tous les Absences');
			setInnerHTML('DisplaySpecifiedAbsences', 'Afficher les absences sp&eacute;cifi&eacute;es');
			setInnerHTML('AfterAddingSession', 'Ajouter une Seance');
			setInnerHTML('AfterAddingModule', 'Ajouter un Module');
			setInnerHTML('AfterAddingTeacher', 'Ajouter un Professeur');
			setInnerHTML('AfterAddingClasse', 'Ajouter un Classe');
			setInnerHTML('AfterAddingFiliere', 'Ajouter un Fili&egrave;re');
			setInnerHTML('AfterAddingStudent', 'Ajouter un Etudiant');
			setInnerHTML('AfterModifyingStudent', 'Modifer un Etudiant');
			setPlaceholder('module_label','Nom du module');
			setInnerHTML('Libelle', 'Nom du module');
			setInnerHTML('semester', 'Semestre :');
			setInnerHTML('teacher', 'Professeur :');
			setPlaceholder('filiere','Tapez le nouveau Filiere');
			setPlaceholder('classe','Tapez le nouveau Classe');
			setInnerHTML('student', 'Etudiant');
			setInnerHTML('informations', 'Informations');
			setInnerHTML('t-justify', 'Justifier');
			setInnerHTML('t-Comment', 'Commentaire');
			setInnerHTML('t-state', 'Etat');
			setInnerHTML('yes', 'Oui');
			setInnerHTML('no', 'Non');
			setInnerHTML('absenceComment', 'Commentaire pour Abcense:');
			setInnerHTML('AddAbsence', 'Ajouter une absence');
			setInnerHTML('Email-label', 'Address Email');
			setInnerHTML('Pass-label', 'Mot de passe');
			setInnerHTML('Stay-label', 'Rester connect&eacute;?');
			setInnerHTML('Login-label', 'Connexion');
			setInnerHTML('lf_h1', 'Futur Assistant Administratif');
			setPlaceholder('login', ' Address Email');
			setPlaceholder('password', 'Mot de passe');
			setPlaceholder('Libelle', 'Nouveau Nom du Module');
			setInnerHTML('back_home', "&larr; retour &agrave; la page d'accueil");
			setInnerHTML('nom_h', "Nom");
			setInnerHTML('prenom_h', "Prenom");
			
			
			
		}else if(language=="en"){
			setPlaceholder('search_ph','Search student');
			setInnerHTML('show_all', 'Show All Messages');
			setInnerHTML('Profile_dd', 'Profile');
			setInnerHTML('Languages_dd', 'Languages');
			setInnerHTML('fr', 'French');
			setInnerHTML('en', 'English');
			setInnerHTML('de', 'German');
			setInnerHTML('Logout_dd', 'Logout');
			setInnerHTML('notification_dd', 'All Notifications');
			setInnerHTML('home', 'Home');
			setInnerHTML('lists', 'Lists');
			setInnerHTML('add', 'Add');
			setInnerHTML('more', 'More');
			setInnerHTML('legal', '&copy; 2020 by GestFid. All rights reserved');
			setInnerHTML('home_h1', 'WELCOME BACK');
			setInnerHTML('dsa_h1', 'Displaying Specific Absence Class');
			setInnerHTML('major', 'Major :');
			setInnerHTML('class', 'Class :');
			setInnerHTML('module', 'Module :');
			setPlaceholder('DateSeance','Session Date');
			setInnerHTML('Session_label', 'Session Date');
			setPlaceholder('HeureDebut','Session Begin Time');
			setInnerHTML('Session-begin_label', 'Session Begin Time');
			setPlaceholder('HeureFin','Session End Time');
			setInnerHTML('Session-end_label', 'Session End Time');
			setPlaceholder('TypeSeance','Session Type');
			setInnerHTML('Session-type', 'Session Type');
			setInnerHTML('submit', 'Submit');
			setInnerHTML('daa_h1', 'Displaying Sessions Information');
			setInnerHTML('n-module', 'Module');
			setInnerHTML('t-DateSeance', 'Session Date');
			setInnerHTML('t-HeureDebut', 'Start Hour');
			setInnerHTML('t-HeureFin', 'End Hour');
			setInnerHTML('t-TypeSeance', 'Session Type');
			setInnerHTML('t-idEtudiant', 'Student ID');
			setInnerHTML('t-NomEtudiant', 'Student Last Name');
			setInnerHTML('t-PrenomEtudiant', 'Student First Name');
			setInnerHTML('daal_h1', 'Displaying Students Informations');
			setInnerHTML('aa_h2', 'choose the major and the class to list the students');
			setInnerHTML('dab_h1', 'Displaying All absences Information');
			setInnerHTML('as_h1', 'Adding a Session');
			setInnerHTML('am_h1', 'Adding a Module');
			setInnerHTML('at_h1', 'Adding a Teacher');
			setInnerHTML('ac_h1', 'Adding a Class');
			setInnerHTML('af_h1', 'Adding a Major');
			setInnerHTML('ast_h1', 'Adding a Student');
			setInnerHTML('mst_h1', 'Modifying a Student');
			setInnerHTML('a_h1', 'Select Operation Please!');
			setPlaceholder('nom', 'Last Name');
			setPlaceholder('prenom', 'First Name');
			setPlaceholder('CNI', 'CNI');
			setInnerHTML('teacher_nom', 'Teacher Last Name');
			setInnerHTML('teacher_prenom', 'Teacher First Name');
			setInnerHTML('label_CNI', 'CNI');
			setInnerHTML('class_label', 'New Class');
			setInnerHTML('filiere_label', 'New Major');
			setInnerHTML('student_nom', 'Student Last Name');
			setInnerHTML('student_prenom', 'Student First Name');
			setInnerHTML('label_CNE', 'CNE');
			setInnerHTML('AddEtudiant', 'Add a Student');
			setInnerHTML('AddModule', 'Add a Module');
			setInnerHTML('Addteacher', 'Add a Teacher');
			setInnerHTML('Addclasse', 'Add a Classe');
			setInnerHTML('Addfiliere', 'Add a Major');
			setInnerHTML('AddSession', 'Add a Session');
			setInnerHTML('Addabsences', 'Add a Absences');
			setInnerHTML('t-major', 'Major');
			setInnerHTML('t-class', 'Class');
			setInnerHTML('t-edit', 'Edit');
			setInnerHTML('t-delete', 'Delete');
			setInnerHTML('DisplaySpecifiedClasse', 'Display Specific Class');
			setInnerHTML('Displaystudents', 'Display All Students');
			setInnerHTML('DisplaySessions', 'Display Sessions');
			setInnerHTML('DisplayAbsences', 'Display Absences');
			setInnerHTML('DisplaySpecifiedAbsences', 'Display Specified Absences');
			setInnerHTML('AfterAddingSession', 'Add Session');
			setInnerHTML('AfterAddingModule', 'Add Module');
			setInnerHTML('AfterAddingTeacher', 'Add Teacher');
			setInnerHTML('AfterAddingClasse', 'Add Class');
			setInnerHTML('AfterAddingFiliere', 'Add Major');
			setInnerHTML('AfterAddingStudent', 'Add Student');
			setInnerHTML('AfterModifyingStudent', 'Modify Student');
			setPlaceholder('module_label','Module Name');
			setInnerHTML('Libelle', 'Module Name');
			setInnerHTML('semester', 'Semester :');
			setInnerHTML('teacher', 'Teacher :');
			setPlaceholder('filiere','Type The New Major');
			setPlaceholder('classe','Type The New Class');
			setInnerHTML('student', 'Student');
			setInnerHTML('informations', 'Informations');
			setInnerHTML('t-justify', 'justify');
			setInnerHTML('t-Comment', 'Comment');
			setInnerHTML('t-state', 'State');
			setInnerHTML('yes', 'Yes');
			setInnerHTML('no', 'No');
			setInnerHTML('absenceComment', 'Comment For Abcense:');
			setInnerHTML('AddAbsence', 'Add Absence');
			setInnerHTML('Email-label', 'Email Address');
			setInnerHTML('Pass-label', 'Password');
			setInnerHTML('Stay-label', 'Stay logged in?');
			setInnerHTML('Login-label', ' Log in');
			setInnerHTML('lf_h1', 'future Administration assistant');
			setPlaceholder('login', 'Email Address');
			setPlaceholder('password', 'Password');
			setPlaceholder('Libelle', 'New Module Name');
			setInnerHTML('back_home', '&larr; Back to Home');
			setInnerHTML('nom_h', 'Last Name');
			setInnerHTML('prenom_h', 'First Name');
			setInnerHTML('AfterModifyingSession', 'Modify Session');
			setInnerHTML('mms_h1', 'Modifying a Session');
			
			

			
		}else if(language=="de"){
			setPlaceholder('search_ph','Suche');
			setInnerHTML('show_all', 'Alle Nachrichten anzeigen');
			setInnerHTML('Profile_dd', 'Profil');
			setInnerHTML('Languages_dd', 'Sprachen');
			setInnerHTML('fr', 'Franz&ouml;sisch');
			setInnerHTML('en', 'Englisch');
			setInnerHTML('de', 'Deutsch');
			setInnerHTML('Logout_dd', 'Ausloggen');
			setInnerHTML('notification_dd', 'Alle Benachrichtigungen');
			setInnerHTML('home', 'Startseite');
			setInnerHTML('lists', 'Listen');
			setInnerHTML('add', 'Hinzuf&uuml;gen');
			setInnerHTML('more', 'Mehr');
			setInnerHTML('legal', '&copy; 2020 von GestFid. Alle Rechte vorbehalten');
			setInnerHTML('home_h1', 'Willkommen zur&uuml;ck');
			setInnerHTML('dsa_h1', 'Anzeigen einer bestimmten Abwesenheitsklasse');
			setInnerHTML('major', 'Studiengang :');
			setInnerHTML('class', 'Klasse :');
			setInnerHTML('module', 'Kurs :');
			setPlaceholder('DateSeance','Sitzungsdatum');
			setInnerHTML('Session_label', 'Sitzungsdatum');
			setPlaceholder('HeureDebut','Sitzungsdatum Start Zeit');
			setInnerHTML('Session-begin_label', 'Sitzungsdatum Start Zeit');
			setPlaceholder('HeureFin','Sitzungsdatum Ende Zeit');
			setInnerHTML('Session-end_label', 'Sitzungsdatum Ende Zeit');
			setPlaceholder('TypeSeance','Sitzungstyp');
			setInnerHTML('Session-type', 'Sitzungstyp');
			setInnerHTML('submit', 'Einreichen');
			setInnerHTML('daa_h1', 'Anzeigen von Sitzungsinformationen');
			setInnerHTML('n-module', 'Kurs');
			setInnerHTML('t-DateSeance', 'Sitzungsdatum');
			setInnerHTML('t-HeureDebut', 'Startstunde');
			setInnerHTML('t-HeureFin', 'Endstunde');
			setInnerHTML('t-TypeSeance', 'Sitzungstyp');
			setInnerHTML('t-idEtudiant', 'Studenten ID');
			setInnerHTML('t-NomEtudiant', 'Sch&uuml;ler Nachname');
			setInnerHTML('t-PrenomEtudiant', 'Sch&uuml;ler Vorname');
			setInnerHTML('daal_h1', 'Anzeigen von Sch&uuml;lerinformationen');
			setInnerHTML('aa_h2', 'W&auml;hlen Sie das Studiengang und die Klasse aus, um die Sch&uuml;ler aufzulisten');
			setInnerHTML('dab_h1', 'Anzeigen aller Abwesenheitsinformationen');
			setInnerHTML('as_h1', 'Hinzuf&uuml;gen einer Sitzung');
			setInnerHTML('am_h1', 'Hinzuf&uuml;gen einem Modul');
			setInnerHTML('at_h1', 'Hinzuf&uuml;gen einem Lehrer');
			setInnerHTML('ac_h1', 'Hinzuf&uuml;gen einer Klasse');
			setInnerHTML('af_h1', 'Hinzuf&uuml;gen einem Studiengang');
			setInnerHTML('ast_h1', 'Hinzuf&uuml;gen einer Sch&uuml;ler');
			setInnerHTML('mst_h1', 'Bearbeiten einer Sch&uuml;ler');
			setInnerHTML('a_h1', 'W&auml;hlen Sie Operation Bitte!');
			setPlaceholder('nom', 'Nachname');
			setPlaceholder('prenom', 'Nachname');
			setPlaceholder('CNI', 'CNI');
			setInnerHTML('teacher_nom', 'Lehrer Nachname');
			setInnerHTML('teacher_prenom', 'Lehrer Vorname');
			setInnerHTML('label_CNI', 'CNI');
			setInnerHTML('class_label', 'Neue Klass');
			setInnerHTML('filiere_label', 'Neue Studiengang');
			setInnerHTML('student_nom', 'Sch&uuml;ler Nachname');
			setInnerHTML('student_prenom', 'Sch&uuml;ler Vorname');
			setInnerHTML('label_CNE', 'CNE');
			setInnerHTML('AddEtudiant', 'F&uuml;gen Sie ein Sch&uuml;ler hinzu');
			setInnerHTML('AddModule', 'F&uuml;gen Sie ein Modul hinzu');
			setInnerHTML('Addteacher', 'F&uuml;gen Sie einen Lehrer hinzu');
			setInnerHTML('Addclasse', 'F&uuml;gen Sie eine Klasse hinzu');
			setInnerHTML('Addfiliere', 'F&uuml;gen Sie einen Studiengang hinzu');
			setInnerHTML('AddSession', 'F&uuml;gen Sie einen Sitzung hinzu');
			setInnerHTML('Addabsences', 'F&uuml;gen Sie eine Abwesenheit hinzu');
			setInnerHTML('t-major', 'Studiengang');
			setInnerHTML('t-class', 'Klasse');
			setInnerHTML('t-edit', 'Bearbeiten');
			setInnerHTML('t-delete', 'L&ouml;schen');
			setInnerHTML('DisplaySpecifiedClasse', 'Spezifische Klasse anzeigen');
			setInnerHTML('Displaystudents', 'Alle Sch&uuml;ler anzeigen');
			setInnerHTML('DisplaySessions', 'Sitzungen anzeigen');
			setInnerHTML('DisplayAbsences', 'Abwesenheiten anzeigen');
			setInnerHTML('DisplaySpecifiedAbsences', 'Angegebene Abwesenheiten anzeigen');
			setInnerHTML('AfterAddingSession', 'Sitzung hinzuf&uuml;gen');
			setInnerHTML('AfterAddingModule', 'Modul hinzuf&uuml;gen');
			setInnerHTML('AfterAddingTeacher', 'Lehrer hinzuf&uuml;gen');
			setInnerHTML('AfterAddingClasse', 'Klasse hinzuf&uuml;gen');
			setInnerHTML('AfterAddingFiliere', 'Studiengang hinzuf&uuml;gen');
			setInnerHTML('AfterAddingStudent', 'Sch&uuml;ler hinzuf&uuml;gen');
			setInnerHTML('AfterModifyingStudent', 'Sch&uuml;ler Bearbeiten');
			setPlaceholder('module_label','Modulname');
			setInnerHTML('Libelle', 'Modulname');
			setInnerHTML('semester', 'Semester :');
			setInnerHTML('teacher', 'Lehrer :');
			setInnerHTML('student', 'Sch&uuml;ler');
			setPlaceholder('filiere','Geben Sie den neuen Studiengang ein');
			setPlaceholder('classe','Geben Sie den neuen Klasse ein');
			setInnerHTML('informations', 'Informationen');
			setInnerHTML('t-state', 'Zustand');
			setInnerHTML('yes', 'Ja');
			setInnerHTML('no', 'Nein');
			setInnerHTML('t-justify', 'Rechtfertigen');
			setInnerHTML('t-Comment', 'Kommentar');
			setInnerHTML('absenceComment', 'Kommentar f&uuml;r Abwesenheit:');
			setInnerHTML('AddAbsence', 'Abwesenheit hinzuf&uuml;gen');
			setInnerHTML('Email-label', 'E-Mail-Addresse');
			setInnerHTML('Pass-label', 'Passwort');
			setInnerHTML('Stay-label', 'bleib Login?');
			setInnerHTML('Login-label', 'Anmelden');
			setInnerHTML('lf_h1', 'zuk&uuml;nftiger Verwaltungsassistent');
			setPlaceholder('login', 'E-Mail-Addresse');
			setPlaceholder('password', 'Passwort');
			setPlaceholder('Libelle', 'Neu Module Name');
			setInnerHTML('back_home', "&larr; Zur&uuml;ck zur Startseite");
			setInnerHTML('nom_h', 'Nachname');
			setInnerHTML('prenom_h', 'Nachname');
		}
		localStorage.setItem("Language",language);
		
	}
}
onload=new Translate();





















