package web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;


import metier.GestionEtudiant;
import metier.InterfaceGestionEtudiant;
import metier.LoginMetier;
import metier.entities.*;
import metier.entities.Module;


@WebServlet(
		name="ws",
		urlPatterns= {"*.cc","/LoginServlet","*.php","/Main","/Login","/ListClass",
		"/AddStudent","/AddStudent1","/AddFiliere","/AddClasse","/AddProfesseur","/AddModule"
		,"/DeleteStudent","/DeleteStudentFromSpecifiedClass","/ModifyStudent","/UpdateStudent"
		,"/Home","/Add","/List","/AddSeance","/ListAbsences","/AddAbsence","/ListAbsencesSpecified"
		,"/StudentProfile","/AdminProfile","/AddCompteEtudiant","/DeleteSeance","/ModifySeance",
		"/UpdateSeance","/DisplayAbsenceType","/MessagesUser","/ConversationPp","/DisplaySpecifiedClassAbsence",
		"/SendMessage","/Deconnexion","/StudentProfile1","/DisplayAbsenceType1","/Home1","/MessagesUser1","/ConversationPp1"
		,"/SendMessage1","/SeatchedUsers"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String role = null ;
	LoginMetier metier ;
    Users user=null;
	InterfaceGestionEtudiant metierE;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        metierE = new GestionEtudiant();
        metier = new LoginMetier();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path= request.getServletPath();
		
		
		HttpSession  session = request.getSession();
		
		List<Filiere> filieres=new ArrayList<Filiere>();
		List<Classe> classes=new ArrayList<Classe>();
		List<Etudiant> Etudiants=new ArrayList<Etudiant>();
		List<Etudiant> classeEtudiants=new ArrayList<Etudiant>();
		List<Professeur> professeurs=new ArrayList<Professeur>();
		List<Module> modules=new ArrayList<Module>();
		List<Semester> semesters=new ArrayList<Semester>();
		List<ListAbsence> listAbsences=new ArrayList<ListAbsence>();
		List<Absence> absences=new ArrayList<Absence>();
		List<Seance> seances=new ArrayList<Seance>();
		EtudiantModel etudiantM=new EtudiantModel();
		List<Messages> listMessages=new ArrayList<Messages>();
		List<Messages> listAllMessages=new ArrayList<Messages>();
		List<Messages> Conversation=new ArrayList<Messages>();
		List<Etudiant> MessageEtudiants=new ArrayList<Etudiant>();
		List<Admin> MessageAdmin=new ArrayList<Admin>();
		List<Messages> ConversationStudent=new ArrayList<Messages>();
		new ArrayList<Etudiant>();
		Admin admin=null;
		Etudiant etud=null;
		filieres=metierE.getFilieres();
		classes=metierE.getClasse();
		Etudiants=metierE.ListEtudiants();
		professeurs=metierE.getProfesseur();
		modules=metierE.getModule();
		semesters=metierE.getSemester();
		listAbsences=metierE.getListAbsences();
		absences=metierE.getAbsence();
		seances=metierE.getSeance();
		
		
		
		
		
		
		
		etudiantM.setListfilieres(filieres);
		etudiantM.setListClasses(classes);
		etudiantM.setListEtudiants(Etudiants);
		etudiantM.setClasseEtudiants(classeEtudiants);
		etudiantM.setListProfesseurs(professeurs);
		etudiantM.setListModules(modules);
		etudiantM.setListSemesters(semesters);
		etudiantM.setAbsences(absences);
		etudiantM.setSeances(seances);
		etudiantM.setListAbsences(listAbsences);
		
		
        String email="";
        String password="";
		System.out.println("path : " + path);
		
		
		//Problem continue
		
		if(path.equals("/")) {
			System.out.println("hey1");
			request.getRequestDispatcher("Form2.jsp").forward(request, response);
			System.out.println("hey1");
		}else if(path.equals("/Login")) {
			System.out.println("hey4");
			request.getRequestDispatcher("Form2.jsp").forward(request, response);
			System.out.println("hey");
		}else if(path.equals("/list.php")) {
			Etudiants=metierE.ListEtudiants();
			etudiantM.setListEtudiants(Etudiants);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("listProd.jsp").forward(request,response);
		}
		else if(path.equals("/Main")) {
			
			
			
			email = request.getParameter("email");
	        password = request.getParameter("password"); 
	        
			try {
				user = metier.validation(password, email);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
	        /* Validation du champ email. */
	        try {
	           role = user.getRole(); 
	        } catch ( Exception e ) {
	            metier.setErreur( "tttt", e.getMessage() );
	        }
	       System.out.println("-- metier.getErreurs() : " + metier.getErreurs());
	        
	        /* Initialisation du resultat global de la validation. */
	        if ( metier.getErreurs().isEmpty() ) {
	        	session.setAttribute("role",user.getRole());
	        	session.setAttribute("user", user);
	        } else {
	        	System.out.println("failed");
	        	session.setAttribute("role",null);
				request.setAttribute("loginModel", metier );
	        	request.getRequestDispatcher("Form2.jsp").forward(request, response);
	        	
	        }

			//probleme Start Here
	        
	        
		if(session.getAttribute("role").equals("Admin"))	{
			
			Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        session.setAttribute("MessageEtudiants",MessageEtudiants);
	        session.setAttribute("listAllMessages",listAllMessages);
	        session.setAttribute("listMessages",listMessages);
            session.setAttribute("Admin",admin);
            request.setAttribute("Admin",admin);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/userAdmin.jsp").forward(request, response);
			
		}
		else if(session.getAttribute("role").equals("Etudiant")) {
			Admin ad=null;
			etud=metierE.getEtud(user.getId());
			
            String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());
            System.out.println(etud.getIdEtudiant());
            listAllMessages=metierE.getLastMessages(user.getId());
            System.out.println(listAllMessages);
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
	        		
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
	        	}
	        	MessageAdmin.add(ad);
            }
	        etudiantM.setListAllMessages(listAllMessages);
	        System.out.println(etudiantM.getListAllMessages());
	        etudiantM.setMessageAdmin(MessageAdmin);
	        session.setAttribute("MessageAdmin",MessageAdmin);
	        session.setAttribute("listAllMessages",listAllMessages);
            session.setAttribute("etud",etud);
            etud.setBase64image(base64Encoded);
            request.setAttribute("etud",etud);
            request.setAttribute("etudiantModel", etudiantM);
            request.getRequestDispatcher("Etudiant/Home.jsp").forward(request, response);
		}
		}else if(path.equals("/AddCompteEtudiant")) {
			String email1=request.getParameter("email");
			String password1=request.getParameter("password");
			String date=request.getParameter("date");
			String role="Etudiant";
			Users u=new Users();
			u.setEmail(email1);
			u.setMotDePasse(password1);
			u.setRole(role);
			int id=metierE.addUser(u);
			session.setAttribute("idcompte", id);
			session.setAttribute("date", date);
			
		}else if(path.equals("/AdminProfile")) {
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AdminProfile.jsp").forward(request,response);
		}else if(path.equals("/Add")) {
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/Add.jsp").forward(request,response);
		}else if(path.equals("/List")) {
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            System.out.println(MessageEtudiants1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/List.jsp").forward(request,response);
		}
		else if(path.equals("/Home")) {
			Admin admin1=(Admin) session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
            etudiantM.setListAllMessages(listAllMessages1);
    		///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
    		
    		
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/Home.jsp").forward(request,response);
		}else if(path.equals("/Deconnexion")) {
			session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("Form2.jsp").forward(request,response);
		}else if(path.equals("/AddStudent")){
			Admin admin1=(Admin) session.getAttribute("Admin");
			Messages m=new Messages();
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String CNI=request.getParameter("CNI");
			String CNE=request.getParameter("CNE");
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			
			int idcompte=(int) session.getAttribute("idcompte");
			String date=(String) session.getAttribute("date");
			InputStream inputStream = null;
			Part filePart = request.getPart("photo");
			if (filePart != null) {
	            // debug messages
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());

	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	        }
			Etudiant e=new Etudiant();
			System.out.println(date);
			e.setNomEtudiant(nom);
			e.setPrenomEtudiant(prenom);
			e.setCNI(CNI);
			e.setCNE(CNE);
			e.setFiliere(filiere);
			e.setClasse(classe);
			e.setIdCompte(idcompte);
			e.setInputStream(inputStream);
			metierE.addEtudiant(e);
			Etudiants=metierE.ListEtudiants();
			m.setMessage("Welcome to GestFid");
			m.setId_user_from(admin1.getIdAdmin());
			m.setId_user_to(idcompte);
			m.setTime(date);
			metierE.sendMessage(m);
			etudiantM.setListEtudiants(Etudiants);
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e4=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e4);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AddStudent.jsp").forward(request, response);

		}else if(path.equals("/AddFiliere")){
			String filiere=request.getParameter("filiere");
			Filiere f=new Filiere();
			f.setFiliere(filiere);
			metierE.addFiliere(f);
			filieres=metierE.getFilieres();
			etudiantM.setListfilieres(filieres);
			
		}else if(path.equals("/AddClasse")){
			String classe=request.getParameter("classe");
			Classe c=new Classe();
			c.setClasse(classe);
			metierE.addClasse(c);
			classes=metierE.getClasse();
			etudiantM.setListClasses(classes);
			
			
		}else if(path.equals("/AddProfesseur")){
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String CNI=request.getParameter("CNI");
			Professeur p=new Professeur();
			p.setNomProfesseur(nom);
			p.setPrenomProfesseur(prenom);
			p.setCNI(CNI);
			metierE.addProfesseur(p);
			professeurs=metierE.getProfesseur();
			etudiantM.getListProfesseurs();

					
			
		}else if(path.equals("/AddModule")){
			String libelle=request.getParameter("Libelle");
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			String semester=request.getParameter("semester");
			int idProfesseur=Integer.parseInt(request.getParameter("idProfesseur"));
			Module mod=new Module();
			mod.setLibelle(libelle);
			mod.setFiliere(filiere);
			mod.setClasse(classe);
			mod.setSemester(semester);
			mod.setIdProfesseur(idProfesseur);
			metierE.addModule(mod);
			modules=metierE.getModule();
			etudiantM.setListModules(modules);
			
			
		}else if(path.equals("/AddSeance")){
			String DateSeance=request.getParameter("DateSeance");
			String HeureDebut=request.getParameter("HeureDebut");
			String HeureFin=request.getParameter("HeureFin");
			String TypeSeance=request.getParameter("TypeSeance");
			int IdModule=Integer.parseInt(request.getParameter("IdModule"));
			Seance sea=new Seance();
			sea.setDateSeance(DateSeance);
			sea.setHeureDebut(HeureDebut);
			sea.setHeureFin(HeureFin);
			sea.setTypeSeance(TypeSeance);
			sea.setIdModule(IdModule);
			metierE.addSeance(sea);
			seances=metierE.getSeance();
			etudiantM.setSeances(seances);
			
			
		}else if(path.equals("/AddAbsence")){
			int IdSeance=Integer.parseInt(request.getParameter("IdSeance"));
			int IdEtudiant=Integer.parseInt(request.getParameter("IdEtudiant"));
			String justify=request.getParameter("justify");
			String comment=request.getParameter("comment");
			Absence abs=new Absence();
			abs.setIdSeance(IdSeance);
			abs.setIdEtudiant(IdEtudiant);
			abs.setJustifer(justify);
			abs.setComment(comment);
			
			metierE.addAbsence(abs);
			absences=metierE.getAbsence();
			etudiantM.setAbsences(absences);
			
			
			
		}else if(path.equals("/StudentProfile")){
			int IdEtudiant = Integer.parseInt(request.getParameter("IdEtudiant"));
			Etudiant e=new Etudiant();
			e=metierE.getEtudiant(IdEtudiant);
			Admin admin1=(Admin) session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e4=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e4);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
            String base64Encoded1 = Base64.getEncoder().encodeToString(e.getPhoto());

            System.out.println(base64Encoded1);
            e.setBase64image(base64Encoded1);
	        etudiantM.setEtudiant(e);
	        
	        session.setAttribute("etud",e);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/StudentProfile.jsp").forward(request,response);
			
			
		}else if(path.equals("/StudentProfile1")){
			Etudiant etud12=(Etudiant) session.getAttribute("etud");
            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setEtudiant(etud12);
    		etudiantM.setListAllMessages(listAllMessages1);
            etudiantM.setMessageAdmin(MessageAdmin1);
            Admin ad=null;
			etud=metierE.getEtud(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());

            System.out.println(etud.getIdEtudiant());
            listAllMessages=metierE.getLastMessages(user.getId());
            System.out.println(listAllMessages);
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
	        		
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
	        	}
	        	MessageAdmin.add(ad);
            }
	        etudiantM.setListAllMessages(listAllMessages);
	        System.out.println(etudiantM.getListAllMessages());
	        etudiantM.setMessageAdmin(MessageAdmin);
            etud.setBase64image(base64Encoded);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Etudiant/StudentProfile1.jsp").forward(request,response);
			
			
		}else if(path.equals("/ModifyStudent")){
			
			int IdEtudiant = Integer.parseInt(request.getParameter("IdEtudiant"));
			System.out.println("IdEtudiant "+ IdEtudiant);
			Etudiant e=new Etudiant();
			e=metierE.getEtudiant(IdEtudiant);
            String base64Encoded1 = Base64.getEncoder().encodeToString(e.getPhoto());

            System.out.println(base64Encoded1);
            session.setAttribute("base64Encoded1", base64Encoded1);
            e.setBase64image(base64Encoded1);
			etudiantM.setEtudiant(e);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e4=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e4);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/UpdateStudent.jsp").forward(request,response);
			
			
		}else if(path.equals("/ModifyAbsence")){
			
			int IdAbsence = Integer.parseInt(request.getParameter("IdAbsence"));
			Absence a=new Absence();
			a=metierE.getAbsence(IdAbsence);
			etudiantM.setEtudiant(metierE.getEtud(a.getIdEtudiant()));
			etudiantM.setSeance(metierE.getSeance(a.getIdSeance()));
			etudiantM.setAbsence(a);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/UpdateAbsence.jsp").forward(request,response);
			
			
		}else if(path.equals("/ModifySeance")){
			
			int IdSeance = Integer.parseInt(request.getParameter("IdSeance"));
			Seance s=new Seance();
			s=metierE.getSeance(IdSeance);
			etudiantM.setSeance(s);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/UpdateSeance.jsp").forward(request,response);
			
			
		}else if(path.equals("/UpdateSeance")){
			int IdSeance=Integer.parseInt(request.getParameter("IdSeance"));
			String DateSeance=request.getParameter("DateSeance");
			String HeureDebut=request.getParameter("HeureDebut");
			String HeureFin=request.getParameter("HeureFin");
			String TypeSeance=request.getParameter("TypeSeance");
			int IdModule=Integer.parseInt(request.getParameter("IdModule"));
			Seance sea=new Seance();
			sea.setIdSeance(IdSeance);
			sea.setDateSeance(DateSeance);
			sea.setHeureDebut(HeureDebut);
			sea.setHeureFin(HeureFin);
			sea.setTypeSeance(TypeSeance);
			sea.setIdModule(IdModule);
			metierE.modifySeance(sea);
			seances=metierE.getSeance();
			etudiantM.setSeances(seances);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/ListSeances.jsp").forward(request,response);
		
		
		
		}else if(path.equals("/UpdateStudent")){
			
			System.out.println("update controller");
			int id=Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String CNI=request.getParameter("CNI");
			String CNE=request.getParameter("CNE");
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			Etudiant e=new Etudiant();
			e.setIdEtudiant(id);
			e.setNomEtudiant(nom);
			e.setPrenomEtudiant(prenom);
			e.setCNI(CNI);
			e.setCNE(CNE);
			e.setFiliere(filiere);
			e.setClasse(classe);
			metierE.modifyEtudiant(e);
			
			Etudiants=metierE.ListEtudiants();
			String photo=(String)session.getAttribute("base64Encoded1");
			e.setBase64image(photo);
			etudiantM.setEtudiant(e);
			etudiantM.setListEtudiants(Etudiants);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e4=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e4=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e4);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/StudentInformations.jsp").forward(request,response);
			
			
		}else if(path.equals("/DeleteStudentFromSpecifiedClass")){
			
			int IdEtudiant=Integer.parseInt(request.getParameter("IdEtudiant"));
			metierE.deleteEtudiant(IdEtudiant);
			
			String filiere=request.getParameter("filiere");
			System.out.println(filiere);
			String classe=request.getParameter("classe");
			System.out.println(classe);
			Etudiants=metierE.classeEtudiants(filiere,classe);
			System.out.println(Etudiants);
			etudiantM.setClasseEtudiants(Etudiants);
			Admin admin1=(Admin) session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/ListSpecified.jsp").forward(request, response);
		}
		else if(path.equals("/DeleteStudent")){
			int IdEtudiant=Integer.parseInt(request.getParameter("IdEtudiant"));
			metierE.deleteEtudiant(IdEtudiant);
			Etudiants=metierE.ListEtudiants();
			etudiantM.setListEtudiants(Etudiants);
			Admin admin1=(Admin) session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AllStudents.jsp").forward(request, response);
		}
		else if(path.equals("/addStudent.php")){
			System.out.println("test :/addStudent.php");
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("ajoutProd1.jsp").forward(request,response);
		}else if(path.equals("/DeleteSeance")){
			int IdSeance=Integer.parseInt(request.getParameter("IdSeance"));
			metierE.deleteSeance(IdSeance);
			seances=metierE.getSeance();
			etudiantM.setSeances(seances);
			Admin admin1=(Admin) session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin1);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/ListSeances.jsp").forward(request,response);
			
			
		}else if(path.equals("/DisplaySpecifiedClassAbsence")){
			List<List<ListAbsence>> list=new ArrayList<List<ListAbsence>>();
			List<ListAbsence> listAbsencess=new ArrayList<ListAbsence>();
			String filiere=request.getParameter("filiere");
			request.setAttribute("filiere",filiere);
			String classe=request.getParameter("classe");
			request.setAttribute("classe",classe);
			String semester=request.getParameter("semester");
			request.setAttribute("semester",semester);
			Etudiants=metierE.classeEtudiants(filiere,classe);
			modules=metierE.getModuleByFillClasSems(filiere, classe, semester);
			
			etudiantM.setListModules(modules);
			etudiantM.setClasseEtudiants(Etudiants);
			
			int Dure = 0;
			try {
				Dure=Integer.parseInt(request.getParameter("Dure"));
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			System.out.println(Dure);
			if(Dure==0){
				String FromDate=request.getParameter("FromDate");
				String ToDate=request.getParameter("ToDate");
				for(int i=0;i<etudiantM.getClasseEtudiants().size();i++){
					listAbsencess=metierE.getTotalAbsenceSpecifiedClass(etudiantM.getClasseEtudiants().get(i).getIdEtudiant(), FromDate, ToDate,semester);
					list.add(listAbsencess);
				}
				etudiantM.setList(list);
				Admin admin1=(Admin) session.getAttribute("Admin");
	            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
	            request.setAttribute("Admin",admin1);
	            etudiantM.setMessageEtudiants(MessageEtudiants1);
				 List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setListAllMessages(listAllMessages1);
		    		etudiantM.setListMessages(listMessages1);
		    		///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
				request.setAttribute("etudiantModel", etudiantM);
				request.getRequestDispatcher("Admin/AbsenceListSpecified.jsp").forward(request,response);
			}else{
				for(int i=0;i<etudiantM.getClasseEtudiants().size();i++){
					listAbsencess=metierE.getTotalAbsenceSpecifiedClass(etudiantM.getClasseEtudiants().get(i).getIdEtudiant(), Dure,semester);
					list.add(listAbsencess);
				}
				etudiantM.setList(list);
				Admin admin1=(Admin) session.getAttribute("Admin");
	            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
	            request.setAttribute("Admin",admin1);
	            etudiantM.setMessageEtudiants(MessageEtudiants1);
				 List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setListAllMessages(listAllMessages1);
		    		etudiantM.setListMessages(listMessages1);
		    		///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
				request.setAttribute("etudiantModel", etudiantM);
				request.getRequestDispatcher("Admin/AbsenceListSpecified.jsp").forward(request,response);
			}
			
		}else if(path.equals("/DisplayAbsenceType")){
			Etudiant et=(Etudiant) session.getAttribute("etud");
			String DisType=request.getParameter("DisType");
			System.out.println(DisType);
			if(DisType.equals("Module Total number")){
				int Dure = 0;
				try {
					Dure=Integer.parseInt(request.getParameter("Dure"));
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println(Dure);
				if(Dure==0){
					String FromDate=request.getParameter("FromDate");
					String ToDate=request.getParameter("ToDate");
					listAbsences=metierE.getListNbrAbsencesParModuleNbrTotal(et.getIdEtudiant(), FromDate, ToDate);
					etudiantM.setListAbsences(listAbsences);
					Admin admin1=(Admin) session.getAttribute("Admin");
		            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
		            request.setAttribute("Admin",admin1);
		            etudiantM.setMessageEtudiants(MessageEtudiants1);
					 List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
			    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
			    		etudiantM.setListAllMessages(listAllMessages1);
			    		etudiantM.setListMessages(listMessages1);
					
					request.setAttribute("Etudiant",et);
					///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Admin/StudentProfileNbr.jsp").forward(request,response);
				}else{
					listAbsences=metierE.getListNbrAbsencesParModuleNbrTotal(et.getIdEtudiant(), Dure);
					etudiantM.setListAbsences(listAbsences);
					Admin admin1=(Admin) session.getAttribute("Admin");
		            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
		            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setListAllMessages(listAllMessages1);
		    		etudiantM.setListMessages(listMessages1);
		            request.setAttribute("Admin",admin1);
		            etudiantM.setMessageEtudiants(MessageEtudiants1);
					request.setAttribute("Etudiant",et);
					///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Admin/StudentProfileNbr.jsp").forward(request,response);
				}
			}else if(DisType.equals("In detail")){
				int Dure = 0;
				try {;
					Dure=Integer.parseInt(request.getParameter("Dure"));
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println(Dure);
				if(Dure==0){
					String FromDate=request.getParameter("FromDate");
					String ToDate=request.getParameter("ToDate");
					listAbsences=metierE.getListNbrAbsencesParModuleDetaile(et.getIdEtudiant(), FromDate, ToDate);
					etudiantM.setListAbsences(listAbsences);
					Admin admin1=(Admin) session.getAttribute("Admin");
		            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
		            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setListAllMessages(listAllMessages1);
		    		etudiantM.setListMessages(listMessages1);
		            request.setAttribute("Admin",admin1);
		            etudiantM.setMessageEtudiants(MessageEtudiants1);
					request.setAttribute("Etudiant",et);
					///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Admin/StudentProfileDetail.jsp").forward(request,response);
				}else{
					listAbsences=metierE.getListNbrAbsencesParModuleDetaile(et.getIdEtudiant(), Dure);
					etudiantM.setListAbsences(listAbsences);
					 List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
			    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
			    		etudiantM.setListAllMessages(listAllMessages1);
			    		etudiantM.setListMessages(listMessages1);
					Admin admin1=(Admin) session.getAttribute("Admin");
		            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
		            request.setAttribute("Admin",admin1);
		            etudiantM.setMessageEtudiants(MessageEtudiants1);
					request.setAttribute("Etudiant",et);
					///
		    		Etudiant e=null;
					admin=metierE.getAdmin(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());

		            admin.setBase64image(base64Encoded);
		            listMessages=metierE.getLastMessages(user.getId());
		            listAllMessages=metierE.getAllLastMessages(user.getId());
		            etudiantM.setListAllMessages(listAllMessages);
		            etudiantM.setListMessages(listMessages);
		            
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
			        	}
		            	MessageEtudiants.add(e);
		            }
			        etudiantM.setMessageEtudiants(MessageEtudiants);
			        ///////
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Admin/StudentProfileDetail.jsp").forward(request,response);
				}
			}
			
			
			
		}else if(path.equals("/Home1")) {
			Etudiant etud12=(Etudiant) session.getAttribute("etud");
            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setEtudiant(etud12);
    		etudiantM.setListAllMessages(listAllMessages1);
            etudiantM.setMessageAdmin(MessageAdmin1);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Etudiant/Home.jsp").forward(request,response);
		}else if(path.equals("/DisplayAbsenceType1")){
			Etudiant et=(Etudiant) session.getAttribute("etud");
			String DisType=request.getParameter("DisType");
			System.out.println(DisType);
			if(DisType.equals("Module Total number")){
				int Dure = 0;
				try {
					Dure=Integer.parseInt(request.getParameter("Dure"));
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println(Dure);
				if(Dure==0){
					String FromDate=request.getParameter("FromDate");
					String ToDate=request.getParameter("ToDate");
					listAbsences=metierE.getListNbrAbsencesParModuleNbrTotal(et.getIdEtudiant(), FromDate, ToDate);
					etudiantM.setListAbsences(listAbsences);
					Etudiant etud12=(Etudiant) session.getAttribute("etud");
		            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setEtudiant(etud12);
		    		etudiantM.setListAllMessages(listAllMessages1);
		            etudiantM.setMessageAdmin(MessageAdmin1);
					
					request.setAttribute("Etudiant",et);
					Admin ad=null;
					etud=metierE.getEtud(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());

		            System.out.println(etud.getIdEtudiant());
		            listAllMessages=metierE.getLastMessages(user.getId());
		            System.out.println(listAllMessages);
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
			        		
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
			        	}
			        	MessageAdmin.add(ad);
		            }
			        etudiantM.setListAllMessages(listAllMessages);
			        System.out.println(etudiantM.getListAllMessages());
			        etudiantM.setMessageAdmin(MessageAdmin);
		            etud.setBase64image(base64Encoded);
		            request.setAttribute("etud",etud);
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Etudiant/DisplayAbsenceType2.jspp").forward(request,response);
				}else{
					listAbsences=metierE.getListNbrAbsencesParModuleNbrTotal(et.getIdEtudiant(), Dure);
					etudiantM.setListAbsences(listAbsences);
					Etudiant etud12=(Etudiant) session.getAttribute("etud");
		            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setEtudiant(etud12);
		    		etudiantM.setListAllMessages(listAllMessages1);
		            etudiantM.setMessageAdmin(MessageAdmin1);
					request.setAttribute("Etudiant",et);
					Admin ad=null;
					etud=metierE.getEtud(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());

		            System.out.println(etud.getIdEtudiant());
		            listAllMessages=metierE.getLastMessages(user.getId());
		            System.out.println(listAllMessages);
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
			        		
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
			        	}
			        	MessageAdmin.add(ad);
		            }
			        etudiantM.setListAllMessages(listAllMessages);
			        System.out.println(etudiantM.getListAllMessages());
			        etudiantM.setMessageAdmin(MessageAdmin);
		            etud.setBase64image(base64Encoded);
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Etudiant/DisplayAbsenceType2.jsp").forward(request,response);
				}
			}else if(DisType.equals("In detail")){
				int Dure = 0;
				try {;
					Dure=Integer.parseInt(request.getParameter("Dure"));
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				System.out.println(Dure);
				if(Dure==0){
					String FromDate=request.getParameter("FromDate");
					String ToDate=request.getParameter("ToDate");
					listAbsences=metierE.getListNbrAbsencesParModuleDetaile(et.getIdEtudiant(), FromDate, ToDate);
					etudiantM.setListAbsences(listAbsences);
					Etudiant etud12=(Etudiant) session.getAttribute("etud");
		            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setEtudiant(etud12);
		    		etudiantM.setListAllMessages(listAllMessages1);
		            etudiantM.setMessageAdmin(MessageAdmin1);
					request.setAttribute("Etudiant",et);
					Admin ad=null;
					etud=metierE.getEtud(user.getId());
		            String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());

		            System.out.println(etud.getIdEtudiant());
		            listAllMessages=metierE.getLastMessages(user.getId());
		            System.out.println(listAllMessages);
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
			        		
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
			        	}
			        	MessageAdmin.add(ad);
		            }
			        etudiantM.setListAllMessages(listAllMessages);
			        System.out.println(etudiantM.getListAllMessages());
			        etudiantM.setMessageAdmin(MessageAdmin);
		            etud.setBase64image(base64Encoded);
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Etudiant/DisplayAbsenceType1.jsp").forward(request,response);
				}else{
					listAbsences=metierE.getListNbrAbsencesParModuleDetaile(et.getIdEtudiant(), Dure);
					etudiantM.setListAbsences(listAbsences);
					Etudiant etud12=(Etudiant) session.getAttribute("etud");
		            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
		    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
		    		etudiantM.setEtudiant(etud12);
		    		etudiantM.setListAllMessages(listAllMessages1);
		            etudiantM.setMessageAdmin(MessageAdmin1);
					request.setAttribute("Etudiant",et);
					Admin ad=null;
					etud=metierE.getEtud(user.getId());
					String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());
		            System.out.println(etud.getIdEtudiant());
		            listAllMessages=metierE.getLastMessages(user.getId());
		            System.out.println(listAllMessages);
			        for(int i=0;i<listAllMessages.size();i++){
			        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
			        		
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
			        	}else{
			        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
			        	}
			        	MessageAdmin.add(ad);
		            }
			        etudiantM.setListAllMessages(listAllMessages);
			        System.out.println(etudiantM.getListAllMessages());
			        etudiantM.setMessageAdmin(MessageAdmin);
		            etud.setBase64image(base64Encoded);
					request.setAttribute("etudiantModel", etudiantM);
					request.getRequestDispatcher("Etudiant/DisplayAbsenceType1.jsp").forward(request,response);
				}
			}
			
			
			
		}else if (path.equals("/SeatchedUsers")){
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(request.getInputStream()));
					
					String json = "";
					if(br != null){
						json = br.readLine();
						System.out.println(json);
					}
		Etudiants=metierE.getSearchedEtudiants(json);
				JSONObject json1 = new JSONObject();
				try {
					json1.put("SearchedUsers1", Etudiants);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(json1);
			
			
		} else if(path.equals("/SendMessage")){
			Users user1=(Users) session.getAttribute("user");
			String message=request.getParameter("Message");
			int id_from=Integer.parseInt(request.getParameter("id_from"));
			int id_to=Integer.parseInt(request.getParameter("id_to"));
			String time=request.getParameter("time");
			if(id_from!=user1.getId()){
				Messages m=new Messages();
				m.setMessage(message);
				m.setId_user_from(id_to);
				m.setId_user_to(id_from);
				m.setTime(time);
				metierE.sendMessage(m);
			}else if(id_from==user1.getId()){
				Messages m=new Messages();
				m.setMessage(message);
				m.setId_user_from(id_from);
				m.setId_user_to(id_to);
				m.setTime(time);
				metierE.sendMessage(m);
			}
			
			Admin admin1=(Admin) session.getAttribute("Admin");
			request.setAttribute("Admin",admin1);
			listMessages=metierE.getLastMessages(admin1.getIdCompte());
			listAllMessages=metierE.getAllLastMessages(admin1.getIdCompte());
		}
		if(path.equals("/SendMessage1")){
			Users user1=(Users) session.getAttribute("user");
			Etudiant etud12=(Etudiant) session.getAttribute("etud");
            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setEtudiant(etud12);
    		etudiantM.setListAllMessages(listAllMessages1);
            etudiantM.setMessageAdmin(MessageAdmin1);
			String message=request.getParameter("Message");
			int id_from=Integer.parseInt(request.getParameter("id_from"));
			int id_to=Integer.parseInt(request.getParameter("id_to"));
			String time=request.getParameter("time");
			if(id_from!=user1.getId()){
				Messages m=new Messages();
				m.setMessage(message);
				m.setId_user_from(id_to);
				m.setId_user_to(id_from);
				m.setTime(time);
				metierE.sendMessage(m);
			}else if(id_from==user1.getId()){
				Messages m=new Messages();
				m.setMessage(message);
				m.setId_user_from(id_from);
				m.setId_user_to(id_to);
				m.setTime(time);
				metierE.sendMessage(m);
			}
			
		}else if(path.equals("/MessagesUser")){
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
    		///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
	        
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/MessageUsers.jsp").forward(request, response);
			
		}else if(path.equals("/ConversationPp")){
			session.getAttribute("Admin");
			Users user1=(Users) session.getAttribute("user");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
			int id_from=Integer.parseInt(request.getParameter("id_from"));
			int id_to=Integer.parseInt(request.getParameter("id_to"));
			request.setAttribute("id_from", id_from);
			request.setAttribute("id_to",id_to );
			if(id_from!=user1.getId()){
				Conversation=metierE.getCovrBetwnTwUsers(id_from,id_to);
			}else if(id_from==user1.getId()){
				Conversation=metierE.getCovrBetwnTwUsers(id_to,id_from);
			}
			 List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
	    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
	    		etudiantM.setListAllMessages(listAllMessages1);
	    		etudiantM.setListMessages(listMessages1);
	        etudiantM.setConversationPage(Conversation);
	      ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/MessageUserInbox.jsp").forward(request, response);
			
		}else if(path.equals("/MessagesUser1")){
			Etudiant etud12=(Etudiant) session.getAttribute("etud");
            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setEtudiant(etud12);
    		etudiantM.setListAllMessages(listAllMessages1);
            etudiantM.setMessageAdmin(MessageAdmin1);
            Admin ad=null;
			etud=metierE.getEtud(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(etud.getPhoto());
            System.out.println(etud.getIdEtudiant());
            listAllMessages=metierE.getLastMessages(user.getId());
            System.out.println(listAllMessages);
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==etud.getIdEtudiant()){
	        		
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		ad=metierE.getAdmin(listAllMessages.get(i).getId_user_from());
	        	}
	        	MessageAdmin.add(ad);
            }
	        etudiantM.setListAllMessages(listAllMessages);
	        System.out.println(etudiantM.getListAllMessages());
	        etudiantM.setMessageAdmin(MessageAdmin);
            etud.setBase64image(base64Encoded);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Etudiant/MessageStudents.jsp").forward(request, response);
			
		}else if(path.equals("/ConversationPp1")){
			Users user1=(Users) session.getAttribute("user");
			Etudiant etud12=(Etudiant) session.getAttribute("etud");
            List<Admin> MessageAdmin1=(List<Admin>) session.getAttribute("MessageAdmin");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setEtudiant(etud12);
    		etudiantM.setListAllMessages(listAllMessages1);
            etudiantM.setMessageAdmin(MessageAdmin1);
			int id_from=Integer.parseInt(request.getParameter("id_from"));
			int id_to=Integer.parseInt(request.getParameter("id_to"));
			request.setAttribute("id_from",id_from);
			request.setAttribute("id_to",id_to );
			if(id_from!=user1.getId()){
				ConversationStudent=metierE.getCovrBetwnTwUsersEtudiant(id_from,id_to);
			}else if(id_from==user1.getId()){
				ConversationStudent=metierE.getCovrBetwnTwUsersEtudiant(id_to,id_from);
			}
			
	        etudiantM.setConversationStudent(ConversationStudent);
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Etudiant/MessageStudentInbox.jsp").forward(request, response);
			
		}else if(path.equals("/ListClass")){
			
			
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			
			Etudiants=metierE.classeEtudiants(filiere,classe);
			System.out.println(Etudiants);
			etudiantM.setClasseEtudiants(Etudiants);
			request.setAttribute("fill", filiere);
			request.setAttribute("clas", classe);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/ListSpecified.jsp").forward(request, response);
			
		} else if(path.equals("/ListAbsences")){
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			String DateSeance=request.getParameter("DateSeance");
			String HeureDebut=request.getParameter("HeureDebut");
			String HeureFin=request.getParameter("HeureFin");
			
			
			Etudiants=metierE.classeEtudiants(filiere,classe);
			seances=metierE.getSeanceSelected(DateSeance, HeureDebut, HeureFin);
			System.out.println(Etudiants);
			etudiantM.setClasseEtudiants(Etudiants);
			etudiantM.setSeances(seances);
			request.setAttribute("fill", filiere);
			request.setAttribute("clas", classe);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AddAbsence.jsp").forward(request, response);
			
		} else if(path.equals("/ListAbsencesSpecified")){
			String filiere=request.getParameter("filiere");
			String classe=request.getParameter("classe");
			String DateSeance=request.getParameter("DateSeance");
			String HeureDebut=request.getParameter("HeureDebut");
			String HeureFin=request.getParameter("HeureFin");
			int IdModule=Integer.parseInt(request.getParameter("IdModule"));
			ListAbsence l=new ListAbsence();
			l.setClasse(classe);
			l.setFiliere(filiere);
			l.setDateSeance(DateSeance);
			l.setHeureDebut(HeureDebut);
			l.setHeureFin(HeureFin);
			l.setIdModule(IdModule);
			listAbsences=metierE.getSpecifiedListAbsences(l);
			etudiantM.setListAbsences(listAbsences);
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AbsenceListSpecified.jsp").forward(request, response);
			
		}else if(path.equals("/AddStudent1")) {
			session.getAttribute("Admin");
            List<Etudiant> MessageEtudiants1=(List<Etudiant>) session.getAttribute("MessageEtudiants");
            List<Messages> listMessages1=(List<Messages>) session.getAttribute("listMessages");
    		List<Messages> listAllMessages1=(List<Messages>) session.getAttribute("listAllMessages");
    		etudiantM.setListAllMessages(listAllMessages1);
    		etudiantM.setListMessages(listMessages1);
            request.setAttribute("Admin",admin);
            etudiantM.setMessageEtudiants(MessageEtudiants1);
          ///
    		Etudiant e=null;
			admin=metierE.getAdmin(user.getId());
			String base64Encoded = Base64.getEncoder().encodeToString(admin.getPhoto());
            admin.setBase64image(base64Encoded);
            listMessages=metierE.getLastMessages(user.getId());
            listAllMessages=metierE.getAllLastMessages(user.getId());
            etudiantM.setListAllMessages(listAllMessages);
            etudiantM.setListMessages(listMessages);
            
	        for(int i=0;i<listAllMessages.size();i++){
	        	if(listAllMessages.get(i).getId_user_from()==user.getId()){
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_to());
	        	}else{
	        		e=metierE.getEtud(listAllMessages.get(i).getId_user_from());
	        	}
            	MessageEtudiants.add(e);
            }
	        etudiantM.setMessageEtudiants(MessageEtudiants);
	        ///////
			request.setAttribute("etudiantModel", etudiantM);
			request.getRequestDispatcher("Admin/AddStudent.jsp").forward(request, response);
		}
	}
	
}
