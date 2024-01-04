<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<link rel="stylesheet" href="css/UserAdminStyle.css">
<link rel="shortcut icon" type="image/png" href="img/icone-white.png">
<title id="title-up">GestFid | Sessions</title>
</head>
<body>
	<header class="header">
	<div class="navbar">
		<div class="navbar_left">
			<img src="img/icon-blue.png" alt="gestfid" class="logo">

		</div>
		<div class="navbar_center">
			<form action="#" class="search"></form>
			<input type="text" class="search__input" placeholder="Search student"
				id="search_ph">
			<button class="search__button">
				<svg class="search__icon"> <use
					xlink:href="img/sprite.svg#icon-search"></use> </svg>
			</button>
			</form>
		</div>
		<div class="navbar_right">
			<div class="notifications">
				<div class="icon_wrap ">
					<svg class="user__icon "> <use
						xlink:href="img/sprite.svg#icon-envelop"></use> </svg>
					<span class="user-nav__notification">13</span>
				</div>

				<div class="notification_dd">
					<ul class="notification_ul">
						<c:forEach items="${etudiantModel.listAllMessages}" var="e"
							varStatus="status">
							<li class="ppmessage" class="starbucks success"><a
								class="amessage" href="MessagesUser">
									<div class="notify_icon">
										<span class="icon"><img class="messages_img"
											src="img/hafid1.jpg" width="100%" alt="Sender"></span>
									</div>
									<div class="notify_data">
										<div class="title">
											${etudiantModel.getMessageEtudiants().get(status.index).getNomEtudiant()}
											${etudiantModel.getMessageEtudiants().get(status.index).getPrenomEtudiant()}
										</div>
										<div class="sub_title">${e.getMessage()}</div>
									</div>
							</a></li>
						</c:forEach>
						<li class="show_all">
							<p class="link" id="show_all">Show All Messages</p>
						</li>
					</ul>
				</div>

			</div>
			<div class="profile">
				<div class="icon_wrap">
					<img class="messages_img"
						src="data:image/jpg;base64,${Admin.getBase64image()}"
						alt="profile_pic"> <span class="name">${Admin.getNomAdmin()}</span>
					<i class="fas fa-chevron-down"></i>
				</div>

				<div class="profile_dd">
					<ul class="profile_ul">
						<li><a class="address" href="AdminProfile" id="Profile_dd"><span
								class="picon"><i class="fas fa-user"></i></span>Profile</a></li>
						<li><a class="feat-btn" href="#" id="Languages_dd"><span
								class="picon"> <i class="fas fa-globe-europe"></i></span>Languages</a>
							<ul class="feat-show">
								<li><a href="#" id="fr">French</a></li>
								<li><a href="#" id="en">English</a></li>
								<li><a href="#" id="de">German</a></li>
							</ul></li>
						<li><a class="logout" href="Deconnexion" id="Logout_dd"><span
								class="picon"><i class="fas fa-sign-out-alt"></i></span>Logout</a></li>
					</ul>
				</div>
			</div>
		</div>


	</div>

	</header>
	<div class="content">
		<nav class="sidebar">
		<div id="icon-layout">
			<ul class="sid-nav">
				<li class="side-nav__item " id="li-0"><a href="Home"
					onclick="home()" class="side-nav__link"> <svg
							class="side-nav__icon"> <use
							xlink:href="img/sprite.svg#icon-home"></use> </svg> <span
						class="side-nav__link-text " id="home">Home</span>
				</a></li>

				<li class="side-nav__item" id="list-1"><a href="List"
					onclick="ListForm()" class="side-nav__link li-active"> <svg
							class="side-nav__icon"> <use
							xlink:href="img/sprite.svg#icon-file-text"></use> </svg> <span
						class="side-nav__link-text " id="lists">Lists</span>
				</a></li>
				<li class="side-nav__item" id="list-2"><a href="Add"
					onclick="Add()" class="side-nav__link"> <svg
							class="side-nav__icon"> <use
							xlink:href="img/sprite.svg#icon-user-plus"></use> </svg> <span
						class="side-nav__link-text" id="add">Add</span>
				</a></li>
				<li class="side-nav__item" id="list-3"><a
					href="javascript:void(0)" class="side-nav__link"> <svg
							class="side-nav__icon"> <use
							xlink:href="img/sprite.svg#icon-flickr"></use> </svg> <span
						class="side-nav__link-text" id="more">More</span>
				</a></li>
			</ul>
		</div>
		<div class="legal" id="legal">© 2020 by GestFid. All rights
			reserved</div>
		</nav>
		<main class="Admin-view">
		<div class="list">
			<div class="list-form">
				<div class="form__group">
					<h1 class="heading-secondary">Displaying Sessions Information
					</h1>
				</div>
				<div class="form__group">
					<div class="list-view__table">
						<table id="datatable" class="content-table" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th id="n-module">Module</th>
									<th id="t-DateSeance">Session date</th>
									<th id="t-HeureDebut">Start Hour</th>
									<th id="t-HeureFin">End Hour</th>
									<th id="t-TypeSeance">Session Type</th>
									<th id="t-edit">Edit</th>
									<th id="t-delete">Delete</th>
								</tr>
							</thead>



							<tbody>

								<c:forEach items="${etudiantModel.seances}" var="e">

									<tr>
										<td>${e.getModuleLibelle()}</td>
										<td>${e.getDateSeance()}</td>
										<td>${e.getHeureDebut()}</td>
										<td>${e.getHeureFin()}</td>
										<td>${e.getTypeSeance()}</td>
										<td><a href="ModifySeance?IdSeance=${e.getIdSeance()}">
												<button class="btn-table" data-title="Edit"
													data-toggle="modal" data-target="#edit">
													<svg class="icon-table"> <use
														xlink:href="img/sprite.svg#icon-pencil"></use> </svg>
												</button>
										</a></td>
										<td><a href="DeleteSeance?IdSeance=${e.getIdSeance()}">
												<button class="btn-table" data-title="Delete"
													data-toggle="modal" id="AfterDeletingStudent"
													data-target="#delete">
													<svg class="icon-table"> <use
														xlink:href="img/sprite.svg#icon-bin"></use> </svg>
												</button>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>



	<!-- Jquery JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="vendor/jquery/jquery.min.js"></script>


	<!-- Vendor JS-->
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>
	<script src="js/DropDown.js"></script>
	<script src="js/admin.js"></script>
	<script type="text/javascript">
        function DisplayAddAbsenceList(){
            document.title ="GestFid | Add Absence" ;
            listTable[0].innerHTML='<div class="list-view__table">'+
                        '<div class="list">'+
                            '<div class="list-form">'+
                                '<div class="form__group">'+
                                    '<h1 class="heading-secondary Table-header" id="daa_h1">'+
                                         'Displaying Sessions Informations'+
                                    '</h1>'+
                                '</div>'+
                                '<div class="form__group">'+
                        '<div class="list-view__table-one">'+
                            '<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
                                '<thead>'+
                                    '<tr>'+
                                  '<th id="n-module">Module</th>'+
                                  '<th id="t-DateSeance">Session date</th>'+
                                  '<th id="t-HeureDebut">Start Hour</th>'+
                                  '<th id="t-HeureFin">End Hour</th>'+
                                  '<th id="t-TypeSeance">Session Type</th>'+
                                    '</tr>'+
                                '</thead>'+
            
                                
            
                                '<tbody>'+
                                
                                '<c:forEach items="${etudiantModel.listAbsences}" var="e">'+
            
                                        '<tr>'+
                                            '<td>${e.getModuleLibelle()}</td>'+
                                            '<td>${e.getDateSeance()}</td>'+
                                            '<td>${e.getHeureDebut()}</td>'+
                                            '<td>${e.getHeureFin()}</td>'+
                                            '<td>${e.getTypeSeance()}</td>'+
                                        '</tr>'+
                                    '</c:forEach>'+
                                '</tbody>'+
                            '</table>'+
                        '</div>'+
                        '</div>'+
                        '</div>'+
                        '<div class="list-form">'+
                    '<div class="form__group">'+
                        '<h1 class="heading-secondary Table-header" id="daal_h1">'+
                             'Displaying Students Informations'+
                        '</h1>'+
                    '</div>'+
                    '<div class="form__group">'+
                        '<div class="list-view__table-tow">'+
                            '<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
                                '<thead>'+
                                    '<tr>'+
                                  '<th id="t-idEtudiant">id Student</th>'+
                                  '<th id="t-NomEtudiant">NomEtudiant</th>'+
                                  '<th id="t-PrenomEtudiant">PrenomEtudiant</th>'+
                                  '<th>CNI</th>'+
                                  '<th>CNE</th>'+
                                  '<th id="t-state">state</th>'+
                                    '</tr>'+
                                '</thead>'+
                                
                              
                                '<tbody class="mytable" onchange="newtable()">'+
                                
                                '<c:forEach items="${etudiantModel.classeEtudiants}" var="e">'+
                              
                                        '<tr>'+
                                            '<td><a class="idstudent-link" href="StudentProfile?IdEtudiant=${e.getIdEtudiant()}">${e.getIdEtudiantClasse()}</a></td>'+
                                            '<td>${e.getNomEtudiant()}</td>'+
                                            '<td>${e.getPrenomEtudiant()}</td>'+
                                            '<td>${e.getCNI()}</td>'+
                                            '<td>${e.getCNE()}</td>'+
                                            '<td>'+
                                                '<div class="Selectbutton">'+
                                                '<a href="javascript:void(0)?IdEtudiant=${e.getIdEtudiant()}" >'+
                                                    '<button class="btn-table" data-title="Delete" onclick="changeButtonIconeRed()" data-toggle="modal" data-target="#delete" >'+
                                                        '<svg class="icon-table-blue">'+
                                                            '<use xlink:href="img/sprite.svg#icon-user-check"></use>'+
                                                        '</svg>'+
                                                '</button></a>'+
                                            '</div>'+
                                                '</td>'+
                                        '</tr>'+
                                    '</c:forEach>'+
                                '</tbody>'+
                              '</table>'+
                            '</div>'+
                        '</div>'+
                        '</div>'+
                    '</div>'+
                    '</div>' ;
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
        }  

        function AddAbsences(){
            document.title ="GestFid | Lists" ;
            myMain[0].innerHTML='<div class="list-view">'+
            '<div class="horizontal_form">'+
            '<div class="row horizontal_row">'+
        		'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
        	'</div>'+
            '<div class="row horizontal_row">'+
            	'<button class="btn-inline horizontal_btn active" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
            '</div>'+
        '</div>'+
            '<h2 class="list-title overview__heading" id="aa_h2">choose the major and the class to list the students</h2>'+
            '<form method="POST" action="ListAbsences">'+
            '<div class="row">'+
            '<div class="row-col">'+
            
            '<input type="date" class="form__input" placeholder="Session Date" name="DateSeance" id="DateSeance" required>'+
            '<label for="DateSeance" class="form__label" id="Session_label">Session Date</label>'+
            
            '</div>'+

            '<div class="row-col">'+
            
            '<input type="time" class="form__input" placeholder="Session Begin Time" name="HeureDebut" id="HeureDebut" required>'+
            '<label for="HeureDebut" class="form__label" id="Session-begin_label">Session Begin Time</label>'+
            
            '</div>'+

            '<div class="row-col">'+
            
            '<input type="time" class="form__input" placeholder="Session End Time" name="HeureFin" id="HeureFin" required>'+
            '<label for="HeureFin" class="form__label" id="Session-end_label">Session End Time</label>'+
            
            '</div>'+
            '</div>'+
        '<div class="row">'+

            '<div class="row-col">'+
                '<label class="row-text" id="major">Major:</label>'+
            '<div>'+
            
            '<select class="select-css" id="filiere" name="filiere">'+
        '<c:forEach items="${etudiantModel.listfilieres}" var="e">'+

                         '<option>${e.filiere}</option>'+
                         

                    '</c:forEach>'+
        '</select>'+
             '<div class="select-dropdown"></div>'+
         '</div>'+
        '</div>'+
         '<div class="row-col" >'+
         '<label class="row-text" id="class">Class:</label>'+
         '<div class="custom-select">'+
           '<select class="select-css" id="classe" name="classe">'+
        '<c:forEach items="${etudiantModel.listClasses}" var="e">'+

                         '<option>${e.classe}</option>'+

                     '</c:forEach>'+
        '</select>'+
             '<div class="select-dropdown"></div>'+
         '</div>'+
        '</div>'+
        '<div class="row-col" >'+
         '<button type="submit"  class="btn btn__visible" id="submit">Submit</button>'+
        '</div>'+
        '</form>'+
        '</div>'+

        '<div class="list-view__table">'+
        '</div>'+
        '</div>'
        ;
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
        }

        function AddSession(){
                    document.title ="GestFid | Add Session" ;
                    myMain[0].innerHTML='<div class="Add">'+
                                            '<div class="Add__form">'+
                                            '<div class="horizontal_form">'+
                                            '<div class="row horizontal_row">'+
                                				'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn active" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                                			'</div>'+
                                            '<div class="row horizontal_row">'+
                                            	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                            '</div>'+
                                		'</div>'+
                                                    '<div class="form__group">'+
                                                        '<h1 class="heading-secondary" id="as_h1">'+
                                                            'Adding a Session'+
                                                        '</h1>'+
                                                    '</div>'+
                                                    '<div class="form__group">'+
                                                    '<input type="date" class="form__input" placeholder="Session Date" name="DateSeance" id="DateSeance" required>'+
                                                    '<label for="DateSeance" class="form__label" id="Session_label">Session Date</label>'+
                                                '</div>'+
                                                '<div class="form__group">'+
                                                    '<input type="time" class="form__input" placeholder="Session Begin Time" name="HeureDebut" id="HeureDebut" required>'+
                                                    '<label for="HeureDebut" class="form__label" id="Session-begin_label">Session Begin Time</label>'+
                                                '</div>'+
                                                '<div class="form__group">'+
                                                    '<input type="time" class="form__input" placeholder="Session End Time" name="HeureFin" id="HeureFin" required>'+
                                                    '<label for="HeureFin" class="form__label" id="Session-end_label">Session End Time</label>'+
                                                    '</div>'+
                                                    '<div class="form__group">'+
                                                   '<input type="text" class="form__input" placeholder="Session Type" name="TypeSeance" id="TypeSeance" required>'+
                                                    '<label for="TypeSeance" class="form__label" id="Session-type">Session Type</label>'+
                                                    '</div>'+
                                                    '<div class="form__group">'+
                                                    '<div class="row">'+
                                                    '<div class="row-col" >'+
                                                '<label class="row-text" id="module">Module :</label>'+
                                                 '<div class="custom-select">'+
                                                    '<select class="select-css select" id="IdModule" name="IdModule">'+
                                                 '<c:forEach items="${etudiantModel.listModules}" var="e">'+

                                                                  '<option data-id="${e.getIdModule()}">${e.getLibelle()}</option>'+

                                                              '</c:forEach>'+
                                                 '</select>'+
                                                      '<div class="select-dropdown"></div>'+
                                                  '</div>'+
                                                 '</div>'+
                                                 
                                                 '</div>'+
                                            
                                            '</div>'+
                                        '<div class="form__group">'+
                                            '<button type="submit" class="btn btn__visible" id="AfterAddingSession">Add Session</button>'+
                                        '</div>'+
                                        
                                    '</div>'+
                                                
                                '</div>';
                    let obj=new Translate();
                    let translate = obj.translate(localStorage.getItem("Language"));
                    translate(); // l'objet global
        $("#AfterAddingSession").on("click",function() {
                        var DateSeance =$('#DateSeance').val();
                		var HeureDebut = $('#HeureDebut').val();
                		var HeureFin = $('#HeureFin').val();
                        var TypeSeance = $('#TypeSeance').val();
                        var IdModule=$("#IdModule option:selected").data('id');
                        
                	    $.ajax({
                	        url: 'AddSeance',
                	        type: "POST",
                	        data: {
                	        	DateSeance : DateSeance ,
                	        	HeureDebut : HeureDebut,
                	            HeureFin : HeureFin,
                	        	TypeSeance : TypeSeance,
                                IdModule : IdModule
                	        },
                	        success: function(responseText) {
                                document.getElementById('DateSeance').value = '';
                	        	document.getElementById('HeureDebut').value = '';
                	        	document.getElementById('HeureFin').value = '';
                	        	document.getElementById('TypeSeance').value = '';
                	        	document.getElementById('IdModule').value = '';
                	            alert('Adding Session Success');
                                
                	        },
                	        failure: function(responseText) {
                	            alert('Adding Session Failed');
                	        }
                	    });
                	});
                                 }
        function AddModule(){
                    document.title ="GestFid | Add Module" ;
                    myMain[0].innerHTML='<div class="Add">'+
                                            '<div class="Add__form">'+
                                            '<div class="horizontal_form">'+
                                            '<div class="row horizontal_row">'+
                                				'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn active" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                                			'</div>'+
                                			'<div class="row horizontal_row">'+
                                				'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                                			'</div>'+
                                            '<div class="row horizontal_row">'+
                                            	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                            '</div>'+
                                		'</div>'+
                                                    '<div class="form__group">'+
                                                        '<h1 class="heading-secondary" id="am_h1">'+
                                                            'Adding a Module'+
                                                        '</h1>'+
                                                    '</div>'+
                                                    '<div class="form__group">'+
                                                        '<input type="text" class="form__input" placeholder="Module Name" name="Libelle" id="Libelle" required>'+
                                                        '<label for="Libelle" class="form__label" id="module_label">Module Name</label>'+
                                                    '</div>'+
                                                    '<div class="form__group">'+
                                                    '<div class="row">'+

                                                    '<div class="row-col">'+
                                                        '<label class="row-text" id="major">Major :</label>'+
                                                    '<div class="custom-select">'+
                                                    
                                                    '<select class="select-css" id="filiere" name="filiere">'+
                                                '<c:forEach items="${etudiantModel.listfilieres}" var="e">'+

                                                                 '<option>${e.filiere}</option>'+
                                                                 

                                                            '</c:forEach>'+
                                                '</select>'+
                                                     '<div class="select-dropdown"></div>'+
                                                 '</div>'+
                                                '</div>'+

                                                 '<div class="row-col" >'+
                                                 '<label class="row-text" id="class">Class :</label>'+
                                                 '<div class="custom-select">'+
                                                   '<select class="select-css" id="classe" name="classe">'+
                                                '<c:forEach items="${etudiantModel.listClasses}" var="e">'+

                                                                 '<option>${e.classe}</option>'+

                                                             '</c:forEach>'+
                                                '</select>'+
                                                     '<div class="select-dropdown"></div>'+
                                                 '</div>'+
                                                '</div>'+
                                                    '</div>'+

                                                    '<div class="form__group">'+
                                                    '<div class="row">'+
                                                    '<div class="row-col" >'+
                                                 '<label class="row-text" id="teacher">Teacher :</label>'+
                                                 '<div class="custom-select">'+
                                                   '<select class="select-css select" id="idProfesseur" name="idProfesseur">'+
                                                '<c:forEach items="${etudiantModel.listProfesseurs}" var="e">'+

                                                                 '<option data-id="${e.getIdProfesseur()}">${e.getNomProfesseur()}'+' '+'${e.getPrenomProfesseur()}</option>'+

                                                             '</c:forEach>'+
                                                '</select>'+
                                                     '<div class="select-dropdown"></div>'+
                                                 '</div>'+
                                                '</div>'+
                                                
                                                '<div class="row-col" >'+
                                                 '<label class="row-text"id="semester">Semester :</label>'+
                                                 '<div class="custom-select">'+
                                                   '<select class="select-css" id="semester" name="semester">'+
                                                '<c:forEach items="${etudiantModel.listSemesters}" var="e">'+

                                                                 '<option>${e.semester}</option>'+

                                                             '</c:forEach>'+
                                                '</select>'+
                                                     '<div class="select-dropdown"></div>'+
                                                 '</div>'+
                                                '</div>'+
                                                    '</div>'+
                                                '</div>'+
                                                    '<div class="form__group">'+
                                                        '<button type="submit" class="btn btn__visible" id="AfterAddingModule">Add Module</button>'+
                                                    '</div>'+
                                                
                                            '</div>'+
                                        '</div>';
                    let obj=new Translate();
                    let translate = obj.translate(localStorage.getItem("Language"));
                    translate(); // l'objet global
                                        $("#AfterAddingModule").on("click",function() {
                        var Libelle =$('#Libelle').val();
                		var filiere = $('#filiere').val();
                		var classe = $('#classe').val();
                        var semester = $('#semester').val();
                        var idProfesseur=$("#idProfesseur option:selected").data('id');
                        
                	    $.ajax({
                	        url: 'AddModule',
                	        type: "POST",
                	        data: {
                	        	Libelle : Libelle ,
                	            filiere : filiere,
                	        	classe : classe,
                                semester : semester,
                                idProfesseur : idProfesseur
                	        },
                	        success: function(responseText) {
                                document.getElementById('Libelle').value = '';
                	        	document.getElementById('filiere').value = '';
                	        	document.getElementById('classe').value = '';
                	        	document.getElementById('semester').value = '';
                	        	document.getElementById('idProfesseur').value = '';
                	            alert('Adding Module Success');
                                
                	        },
                	        failure: function(responseText) {
                	            alert('Adding Module Failed');
                	        }
                	    });
                	});
                }
        function AddTeatcher(){
                    document.title ="GestFid | Add Teatcher" ;
                    myMain[0].innerHTML='<div class="Add">'+
                                    '<div class="Add__form">'+
                                    '<div class="horizontal_form">'+
                                    '<div class="row horizontal_row">'+
                        				'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn active" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                        			'</div>'+
                                    '<div class="row horizontal_row">'+
                                    	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                    '</div>'+
                        		'</div>'+
                                            '<div class="form__group">'+
                                                '<h1 class="heading-secondary" id="at_h1">'+
                                                    'Adding a Teatcher'+
                                                '</h1>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="Last Name" name="nom" id="nom" required>'+
                                                '<label for="nom" class="form__label" id="teacher_nom">Teatcher Last Name</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="First name" name="prenom" id="prenom" required>'+
                                                '<label for="prenom" class="form__label" id="teacher_prenom">Teatcher First name</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="CNI" name="CNI" id="CNI" required>'+
                                                '<label for="CNI" class="form__label" id="label_CNI">CNI</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<button type="submit" class="btn btn__visible" id="AfterAddingTeatcher">Add Teatcher</button>'+
                                            '</div>'+
                                        
                                    '</div>'+
                                '</div>';
                    let obj=new Translate();
                    let translate = obj.translate(localStorage.getItem("Language"));
                    translate(); // l'objet global
                $("#AfterAddingTeatcher").on("click",function() {
                	var nom =$('#nom').val();
            		var prenom = $('#prenom').val();
            		var CNI = $('#CNI').val();
            	    $.ajax({
            	        url: 'AddProfesseur',
            	        type: "POST",
            	        data: {
            	        	nom : nom ,
            	        	prenom : prenom,
            	        	CNI : CNI
            	        },
            	        success: function(responseText) {
            	        	document.getElementById('nom').value = '';
            	        	document.getElementById('prenom').value = '';
            	        	document.getElementById('CNI').value = '';
            	            alert('Adding Teatcher Success');
            	            
            	        },
            	        failure: function(responseText) {
            	            alert('Adding Teatcher Failed');
            	        }
            	    });
            	});
                }
        function AddClasse(){
                    document.title ="GestFid | Add Class" ;
                    myMain[0].innerHTML='<div class="Add">'+
                                    '<div class="Add__form">'+
                                    '<div class="horizontal_form">'+
                                    '<div class="row horizontal_row">'+
                        				'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn active" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                        			'</div>'+
                                    '<div class="row horizontal_row">'+
                                    	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                    '</div>'+
                        		'</div>'+
                                    '<div class="form__group">'+
                                    '<h1 class="heading-secondary" id="ac_h1">'+
                                        'Adding a Class'+
                                    '</h1>'+
                                '</div>'+
                                        '<div class="form__group">'+
                                            '<input type="text" class="form__input" placeholder="Type The New Class" name="classe" id="classe" required>'+
                                            '<label for="classe" class="form__label" id="class_label">New Class</label>'+
                                        '</div>'+
                                        '<div class="form__group">'+
                                            '<button type="submit" class="btn btn__visible" id="AfterAddingClasse">Add Class</button>'+
                                        '</div>'+

                                    '</div>';
                    let obj=new Translate();
                    let translate = obj.translate(localStorage.getItem("Language"));
                    translate(); // l'objet global
                                    $("#AfterAddingClasse").on("click",function() {
                		var classe = $('#classe').val();
                	    $.ajax({
                	        url: 'AddClasse',
                	        type: "POST",
                	        data: {
                	        	classe : classe
                	        },
                	        success: function(responseText) {
                	        	document.getElementById('classe').value = '';
                	            alert('Adding Classe Success');
                	            
                	            
                	        },
                	        failure: function(responseText) {
                	            alert('Adding Classe Failed');
                	        }
                	    });
                	});

                }
                function AddFiliere(){
                    document.title ="GestFid | Add Major" ;
                    myMain[0].innerHTML='<div class="Add">'+
                                    '<div class="Add__form">'+
                                    '<div class="horizontal_form">'+
                                    '<div class="row horizontal_row">'+
                        				'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn active" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                        			'</div>'+
                                    '<div class="row horizontal_row">'+
                                    	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                    '</div>'+
                        		'</div>'+
                                    '<div class="form__group">'+
                                    '<h1 class="heading-secondary" id="af_h1">'+
                                        'Adding a Major'+
                                    '</h1>'+
                                '</div>'+
                                        '<div class="form__group">'+
                                            '<input type="text" class="form__input" placeholder="Type The New Major" name="filiere" id="filiere" required>'+
                                            '<label for="filiere" class="form__label" id="filiere_label">New Major</label>'+
                                        '</div>'+
                                        '<div class="form__group">'+
                                            '<button type="submit" class="btn btn__visible" id="AfterAddingFiliere">Add Major</button>'+
                                        '</div>'+

                                    '</div>';
                    let obj=new Translate();
                    let translate = obj.translate(localStorage.getItem("Language"));
                    translate(); // l'objet global
                                    $("#AfterAddingFiliere").on("click",function() {
                		var filiere = $('#filiere').val();
                	    $.ajax({
                	        url: 'AddFiliere',
                	        type: "POST",
                	        data: {
                	        	filiere : filiere
                	        },
                	        success: function(responseText) {
                	        	document.getElementById('filiere').value = '';
                	            alert('Adding Filiere Success');
                	        },
                	        failure: function(responseText) {
                	            alert('Adding Filiere Failed');
                	        }
                	    });
                	});
                }
        function AddStudent(){
        	document.title ="GestFid | AddStudent" ;
        	myMain[0].innerHTML='<div class="Add">'+
                                    '<div class="Add__form">'+
                                    '<div class="horizontal_form">'+
                                    '<div class="row horizontal_row">'+
                        				'<a href="AddStudent1"><button class="btn-inline horizontal_btn active"  id="AddEtudiant">Add a Student </button></a>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
                        			'</div>'+
                        			'<div class="row horizontal_row">'+
                        				'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
                        			'</div>'+
                                    '<div class="row horizontal_row">'+
                                    	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
                                    '</div>'+
                        		'</div>'+
                                            '<div class="form__group">'+
                                                '<h1 class="heading-secondary" id="ast_h1">'+
                                                    'Adding a Student'+
                                                '</h1>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder=" Last Name" name="nom" id="nom" required>'+
                                                '<label for="nom" class="form__label" id="student_nom">Student Last Name</label>'+
                                            '</div>'+
                                           '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="First Name" name="prenom" id="prenom" required>'+
                                                '<label for="prenom" class="form__label" id="student_prenom">Student First name</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="CNE" name="CNE" id="CNE" required>'+
                                                '<label for="CNE" class="form__label" id="label_CNE">CNE</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                                '<input type="text" class="form__input" placeholder="CNI" name="CNI" id="CNI" required>'+
                                                '<label for="CNI" class="form__label" id="label_CNI">CNI</label>'+
                                            '</div>'+
                                            '<div class="form__group">'+
                                            '<div class="row">'+

                                            '<div class="row-col">'+
                                                '<label class="row-text" id="major">Major :</label>'+
                                            '<div class="custom-select">'+
                                            
                                            '<select class="select-css" id="filiere" name="filiere">'+
                                        '<c:forEach items="${etudiantModel.listfilieres}" var="e">'+

                                                         '<option>${e.filiere}</option>'+
                                                         

                                                    '</c:forEach>'+
                                        '</select>'+
                                             '<div class="select-dropdown"></div>'+
                                         '</div>'+
                                        '</div>'+
                                         '<div class="row-col" >'+
                                         '<label class="row-text" id="class">Class :</label>'+
                                         '<div class="custom-select">'+
                                           '<select class="select-css" id="classe" name="classe">'+
                                        '<c:forEach items="${etudiantModel.listClasses}" var="e">'+

                                                         '<option>${e.classe}</option>'+

                                                     '</c:forEach>'+
                                        '</select>'+
                                             '<div class="select-dropdown"></div>'+
                                         '</div>'+
                                        '</div>'+
                                            '</div>'+
                                            
                                            '<div class="form__group">'+
                                                '<button type="submit" class="btn btn__visible" id="AfterAddingStudent">Add Student</button>'+
                                            '</div>'+
                                        
                                    '</div>'+
                                '</div>';
        	let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
        $("#AfterAddingStudent").on("click",function() {
        		var nom =$('#nom').val();
        		var prenom = $('#prenom').val();
        		var CNE = $('#CNE').val();
        		var CNI = $('#CNI').val();
        		var filiere = $('#filiere').val();
        		var classe = $('#classe').val();

        	    $.ajax({
        	        url: 'AddStudent',
        	        type: "POST",
        	        data: {
        	        	nom : nom ,
        	        	prenom : prenom,
        	        	CNE : CNE,
        	        	CNI : CNI,
        	        	filiere : filiere,
        	        	classe : classe
        	        },
        	        success: function(responseText) {
        	        	document.getElementById('nom').value = '';
        	        	document.getElementById('prenom').value = '';
        	        	document.getElementById('CNE').value = '';
        	        	document.getElementById('CNI').value = '';
        	        	document.getElementById('filiere').value = '';
        	        	document.getElementById('classe').value = '';
        	            alert('Adding Student Success');
        	            
        	        },
        	        failure: function(responseText) {
        	            alert('Adding Student Failed');
        	        }
        	    });
        	});
                                

                }
        function Add(){
        document.title ="GestFid | Add" ;
        	myMain[0].innerHTML='<div class="Add">'+
        	'<div class="Add__form">'+
              '<div class="form__group">'+
              '<h1 class="heading-secondary" id="a_h1">'+
                  'Select Operation Please!'+
              '</h1>'+
          '</div>'+
          '<div class="horizontal_form">'+
          '<div class="row horizontal_row">'+
        		'<a href="AddStudent1"><button class="btn-inline horizontal_btn"  id="AddEtudiant">Add a Student </button></a>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddModule()" id="AddModule">Add a Module </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddClasse()" id="Addclasse">Add a Class </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddTeatcher()" id="Addteacher">Add a teacher</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddFiliere()" id="Addfiliere">Add a Major </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="AddSession()"id="AddSession">Add a Session </button>'+
        	'</div>'+
          '<div class="row horizontal_row">'+
          	'<button class="btn-inline horizontal_btn" onclick="AddAbsences()"id="Addabsences">Add a Absences </button>'+
          '</div>'+
        '</div>'+
        '</div>'+
                                    '</div>';
        	let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global

                }
        var activeclass=document.querySelectorAll(".side-nav__link");
        for(var i=0;i<activeclass.length;i++){
             activeclass[i].addEventListener('click', activateClass);  
        }
        function activateClass(e){
            for(var i=0;i<activeclass.length;i++){
                activeclass[i].classList.remove('li-active');
            }
            e.target.classList.add('li-active');
        }
        var myMain=document.getElementsByClassName("Admin-view");
        var listTable=document.getElementsByClassName("list-view__table");
        function home(){
          document.title ="GestFid | Home" ;
          myMain[0].innerHTML='<div class="home-view"><div class="overview">'+
          '<h1 class="overview__heading" id="home_h1">'+
              'WELCOME BACK'+
          '</h1>'+
        '</div></div>';
          translate();
         
         }

        var myTable=document.getElementsByClassName("mytable");
        function table(){
        	document.title ="GestFid | Spcefied Students" ;
          listTable[0].innerHTML='<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
          '<thead>'+
              '<tr>'+
            '<th>IdEtudiant</th>'+
            '<th>NomEtudiant</th>'+
            '<th>PrenomEtudiant</th>'+
            '<th>CNI</th>'+
            '<th>CNE</th>'+
              '</tr>'+
          '</thead>'+
          

          '<tbody class="mytable" onchange="newtable()">'+
          
          '<c:forEach items="${etudiantModel.classeEtudiants}" var="e">'+

                  '<tr>'+
                      '<td><a class="idstudent-link" href="StudentProfile?IdEtudiant=${e.getIdEtudiant()}">${e.getIdEtudiantClasse()}</a></td>'+
                      '<td>${e.getNomEtudiant()}</td>'+
                      '<td>${e.getPrenomEtudiant()}</td>'+
                      '<td>${e.getCNI()}</td>'+
                      '<td>${e.getCNE()}</td>'+
                  '</tr>'+
              '</c:forEach>'+
          '</tbody>'+
        '</table>';
          let obj=new Translate();
          let translate = obj.translate(localStorage.getItem("Language"));
          translate(); // l'objet global

        }
        function ListForm(){
            document.title ="GestFid | List " ;
            myMain[0].innerHTML='<div class="Add">'+
        	'<div class="Add__form ">'+
        	'<div class="form__group">'+
        		'<h1 class="heading-secondary" id="a_h1">Select Operation Please!</h1>'+
            '</div>'+
            '<div class="horizontal_form">'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn   active" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        	'</div>'+ 
        '</div>'+

        '</div>'+
        '</div>';
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global

        }
        function list(){
            document.title ="GestFid | Lists" ;
            myMain[0].innerHTML='<div class="list-view">'+
            '<div class="horizontal_form">'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn active" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        	'</div>'+ 
        '</div>'+
            '<h2 class="list-title overview__heading" id="aa_h2">choose the major and the class to list the students</h2>'+
            '<form method="POST" action="ListClass">'+
        '<div class="row">'+

            '<div class="row-col">'+
                '<label class="row-text" id="major">Major :</label>'+
            '<div >'+
            
            '<select class="select-css" id="filiere" name="filiere">'+
        '<c:forEach items="${etudiantModel.listfilieres}" var="e">'+

                         '<option>${e.filiere}</option>'+
                         

                    '</c:forEach>'+
        '</select>'+
             '<div class="select-dropdown"></div>'+
         '</div>'+
        '</div>'+
         '<div class="row-col" >'+
         '<label class="row-text" id="class">Class :</label>'+
         '<div class="custom-select">'+
           '<select class="select-css" id="classe" name="classe">'+
        '<c:forEach items="${etudiantModel.listClasses}" var="e">'+

                         '<option>${e.classe}</option>'+

                     '</c:forEach>'+
        '</select>'+
             '<div class="select-dropdown"></div>'+
         '</div>'+
        '</div>'+
        '<div class="row-col" >'+
         '<button type="submit"  class="btn btn__visible" id="submit">Submit</button>'+
        '</div>'+
        '</form>'+
        '</div>'+

        '<div class="list-view__table">'+
        '</div>'+
        '</div>'
        ;
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
        }
        function displayAllStudents(){
            document.title ="GestFid | Students" ;
            myMain[0].innerHTML='<div class="list">'+
            '<div class="horizontal_form">'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn active" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        	'</div>'+ 
        '</div>'+
                            '<div class="list-form">'+
                                '<div class="form__group">'+
                                    '<h1 class="heading-secondary" id="daal_h1">'+
                                         'Displaying Students Information'+
                                    '</h1>'+
                                '</div>'+
                                '<div class="form__group">'+
                                    '<div class="list-view__table">'+
                                        '<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
                                '<thead>'+
                                    '<tr>'+
                                  '<th id="t-idEtudiant">Id</th>'+
                                  '<th id="t-NomEtudiant">Student Last Name</th>'+
                                  '<th id="t-PrenomEtudiant">Studen First Name</th>'+
                                  '<th >CNI</th>'+
                                  '<th >CNE</th>'+
                                  '<th id="t-major">Major</th>'+
                                  '<th id="t-class">Class</th>'+
                                  '<th id="t-edit">Edit</th>'+
                                  '<th id="t-delete">Delete</th>'+
                                    '</tr>'+
                                '</thead>'+
            
                                
            
                                '<tbody>'+
                                
                                '<c:forEach items="${etudiantModel.listEtudiants}" var="e">'+
            
                                        '<tr>'+
                                            '<td data-id="${e.getIdEtudiant()}"><a class="idstudent-link" href="StudentProfile?IdEtudiant=${e.getIdEtudiant()}">${e.getIdEtudiant()}</a></td>'+
                                            '<td>${e.getNomEtudiant()}</td>'+
                                            '<td>${e.getPrenomEtudiant()}</td>'+
                                            '<td>${e.getCNI()}</td>'+
                                            '<td>${e.getCNE()}</td>'+
                                            '<td>${e.getFiliere()}</td>'+
                                            '<td>${e.getClasse()}</td>'+
                                            '<td>'+
                                                '<a href="ModifyStudent?IdEtudiant=${e.getIdEtudiant()}" >'+ 
                                                    '<button class="btn-table" data-title="Edit" data-toggle="modal" data-target="#edit" >'+
                                                        '<svg class="icon-table">'+
                                                            '<use xlink:href="img/sprite.svg#icon-pencil"></use>'+
                                                        '</svg>'+
                                                '</button></a>'+
                                                '</td>'+
                                                '<td>'+
                                                    '<a href="DeleteStudent?IdEtudiant=${e.getIdEtudiant()}" >'+ 
                                                        '<button class="btn-table" data-title="Delete" data-toggle="modal" id="AfterDeletingStudent" data-target="#delete" >'+
                                                            '<svg class="icon-table">'+
                                                                '<use xlink:href="img/sprite.svg#icon-bin"></use>'+
                                                            '</svg>'+
                                                    '</button></a>'+
                                                    '</td>'+
                                            '</tr>'+
                                        '</c:forEach>'+
                                    '</tbody>'+
                                '</table>'+
                            '</div>'+
                         '</div>'+
                        '</div>'+
                    '</div>';
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
                    
            $("#AfterDeletingStudent").on("click",function() {
        		var IdEtudiant = $("#datatable").data('id');
        		
        		alert(IdEtudiant)
        	    $.ajax({
        	        url: 'DeleteStudent',
        	        type: "POST",
        	        data: {
        	        	IdEtudiant : IdEtudiant
        	        },
        	        success: function(responseText) {
        	            alert('Deleting Student Success');
        	        },
        	        failure: function(responseText) {
        	            alert('Deleting Student Failed');
        	        }
        	    });
        	});
        }
        function displayAllSessions(){
            document.title ="GestFid | Sessions" ;
                myMain[0].innerHTML='<div class="list">'+
                '<div class="horizontal_form">'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn active" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        		'</div>'+ 
            '</div>'+
                                '<div class="list-form">'+
                                    '<div class="form__group">'+
                                        '<h1 class="heading-secondary">'+
                                             'Displaying Sessions Information'+
                                        '</h1>'+
                                    '</div>'+
                                    '<div class="form__group">'+
                            '<div class="list-view__table">'+
                                '<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
                                    '<thead>'+
                                        '<tr>'+
                                        '<th id="n-module">Module</th>'+
                                        '<th id="t-DateSeance">Session date</th>'+
                                        '<th id="t-HeureDebut">Start Hour</th>'+
                                        '<th id="t-HeureFin">End Hour</th>'+
                                        '<th id="t-TypeSeance">Session Type</th>'+
                                        '<th id="t-edit">Edit</th>'+
                                        '<th id="t-delete">Delete</th>'+
                                        '</tr>'+
                                    '</thead>'+
                
                                    
                
                                    '<tbody>'+
                                    
                                    '<c:forEach items="${etudiantModel.seances}" var="e">'+
                
                                            '<tr>'+
                                                '<td>${e.getModuleLibelle()}</td>'+
                                                '<td>${e.getDateSeance()}</td>'+
                                                '<td>${e.getHeureDebut()}</td>'+
                                                '<td>${e.getHeureFin()}</td>'+
                                                '<td>${e.getTypeSeance()}</td>'+
                                                '<td>'+
                                                '<a href="ModifySeance?IdSeance=${e.getIdSeance()}" >'+ 
                                                    '<button class="btn-table" data-title="Edit" data-toggle="modal" data-target="#edit" >'+
                                                        '<svg class="icon-table">'+
                                                            '<use xlink:href="img/sprite.svg#icon-pencil"></use>'+
                                                        '</svg>'+
                                                '</button></a>'+
                                                '</td>'+
                                                '<td>'+
                                                    '<a href="DeleteSeance?IdSeance=${e.getIdSeance()}" >'+ 
                                                        '<button class="btn-table" data-title="Delete" data-toggle="modal" id="AfterDeletingStudent" data-target="#delete" >'+
                                                            '<svg class="icon-table">'+
                                                                '<use xlink:href="img/sprite.svg#icon-bin"></use>'+
                                                            '</svg>'+
                                                    '</button></a>'+
                                                    '</td>'+
                                            '</tr>'+
                                        '</c:forEach>'+
                                    '</tbody>'+
                                '</table>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                        '</div>';
                let obj=new Translate();
                let translate = obj.translate(localStorage.getItem("Language"));
                translate(); // l'objet global
            }
        function displayAllAbsences(){
            document.title ="GestFid | Absences" ;
                myMain[0].innerHTML='<div class="list">'+
                '<div class="horizontal_form">'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn  active" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        		'</div>'+
        		'<div class="row horizontal_row">'+
        			'<button class="btn-inline horizontal_btn" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        		'</div>'+ 
            '</div>'+
                                '<div class="list-form">'+
                                    '<div class="form__group">'+
                                        '<h1 class="heading-secondary" id="dab_h1">'+
                                             'Displaying All absences Information'+
                                        '</h1>'+
                                    '</div>'+
                                    '<div class="form__group">'+
                            '<div class="list-view__table">'+
                                '<table id="datatable" class="content-table" cellspacing="0" width="100%">'+
                                    '<thead>'+
                                        '<tr>'+
                                      '<th id="n-module">Module</th>'+
                                      '<th id="t-DateSeance">Session date</th>'+
                                      '<th id="t-HeureDebut">Start Hour</th>'+
                                      '<th id="t-HeureFin">End Hour</th>'+
                                      '<th id="t-TypeSeance">Session Type</th>'+
                                      '<th id="t-NomEtudiant">Student Last Name</th>'+
                                      '<th id="t-PrenomEtudiant">Student First Name</th>'+
                                      '<th>CNI</th>'+
                                      '<th>CNE</th>'+
                                      '<th id="t-justify">justify</th>'+
                                      '<th id="t-Comment">Comment</th>'+
                                        '</tr>'+
                                    '</thead>'+
                
                                    
                
                                    '<tbody>'+
                                    
                                    '<c:forEach items="${etudiantModel.listAbsences}" var="e">'+
                
                                            '<tr>'+
                                                '<td>${e.getModuleLibelle()}</td>'+
                                                '<td>${e.getDateSeance()}</td>'+
                                                '<td>${e.getHeureDebut()}</td>'+
                                                '<td>${e.getHeureFin()}</td>'+
                                                '<td>${e.getTypeSeance()}</td>'+
                                                '<td><a class="idstudent-link" href="StudentProfile?IdEtudiant=${e.getIdEtudiant()}">${e.getNomEtudiant()}</a></td>'+
                                                '<td>${e.getPrenomEtudiant()}</td>'+
                                                '<td>${e.getCNI()}</td>'+
                                                '<td>${e.getCNE()}</td>'+
                                                '<td>${e.getJustifer()}</td>'+
                                                '<td>${e.getComment()}</td>'+
                                            '</tr>'+
                                        '</c:forEach>'+
                                    '</tbody>'+
                                '</table>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                        '</div>';
                let obj=new Translate();
                let translate = obj.translate(localStorage.getItem("Language"));
                translate(); // l'objet global
                         }
        function displaySpecifiedAbsences(){
            document.title ="GestFid | Absences" ;
            myMain[0].innerHTML='<div class="list-view">'+
            '<div class="horizontal_form">'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="list()" id="DisplaySpecifiedClasse">Display specified Classe </button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllStudents()" id="Displaystudents">Display All Students</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllSessions()" id="DisplaySessions">Display Sessions</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn" onclick="displayAllAbsences()" id="DisplayAbsences">Display Absences</button>'+
        	'</div>'+
        	'<div class="row horizontal_row">'+
        		'<button class="btn-inline horizontal_btn active" onclick="displaySpecifiedAbsences()" id="DisplaySpecifiedAbsences">Display Specified Absences</button>'+
        	'</div>'+ 
        '</div>'+
                                '<div class="form__group">'+
                                    '<h1 class="heading-secondary" id="dsa_h1">'+
                                        'Displaying Specific Absence Class'+
                                    '</h1>'+
                                '</div>'+
                                '<form method="POST" action="ListAbsencesSpecified">'+
                                '<div class="row">'+
                                    '<div class="row-col">'+
                                        '<label class="row-text" id="major">Major :</label>'+
                                    '<div>'+
                                    
                                    '<select class="select-css" id="filiere" name="filiere" value="${fill}">'+
                                '<c:forEach items="${etudiantModel.listfilieres}" var="e">'+
                                
                                                 '<option>${e.filiere}</option>'+
                                                 
                                
                                            '</c:forEach>'+
                                '</select>'+
                                     '<div class="select-dropdown"></div>'+
                                 '</div>'+
                                '</div>'+
                                 '<div class="row-col" >'+
                                 '<label class="row-text" id="class">Class :</label>'+
                                 '<div class="custom-select">'+
                                   '<select class="select-css" id="classe" name="classe" value="${clas}">'+
                                '<c:forEach items="${etudiantModel.listClasses}" var="e">'+
                                
                                                 '<option>${e.classe}</option>'+
                                
                                             '</c:forEach>'+
                                '</select>'+
                                     '<div class="select-dropdown"></div>'+
                                 '</div>'+
                                '</div>'+
                                '<div class="row-col" >'+
                                    '<label class="row-text" id="module">Module :</label>'+
                                    '<div class="custom-select">'+
                                       '<select class="select-css select" id="IdModule" name="IdModule">'+
                                    '<c:forEach items="${etudiantModel.listModules}" var="e">'+

                                                     '<option value="${e.getIdModule()}">${e.getLibelle()}</option>'+

                                                 '</c:forEach>'+
                                    '</select>'+
                                         '<div class="select-dropdown"></div>'+
                                     '</div>'+
                                    '</div>'+
                                
                                '</div>'+
                                '<div class="row">'+
                                    '<div class="row-col" >'+
                                    
                                        '<input type="date" class="form__input" placeholder="Session Date" name="DateSeance" id="DateSeance" required>'+
                                        '<label for="DateSeance" class="form__label" id="Session_label">Session Date</label>'+
                                    
                                '</div>'+
                                    '<div class="row-col" >'+
                                    
                                        '<input type="time" class="form__input" placeholder="Session Begin Time" name="HeureDebut" id="HeureDebut" required>'+
                                        '<label for="HeureDebut" class="form__label" id="Session-begin_label">Session Begin Time</label>'+
                                    
                                '</div>'+
                                    '<div class="row-col" >'+
                                    
                                        '<input type="time" class="form__input" placeholder="Session End Time" name="HeureFin" id="HeureFin" required>'+
                                        '<label for="HeureFin" class="form__label" id="Session-end_label">Session End Time</label>'+
                                    
                                '</div>'+
                                '<div class="row-col" >'+
                                    
                                        '<button type="submit" class="btn btn__visible" id="submit">Submit</button>'+
                                    
                                '</div>'+
                                '</form>'+
                            '</div>'
                                ;
            let obj=new Translate();
            let translate = obj.translate(localStorage.getItem("Language"));
            translate(); // l'objet global
        }










       </script>
</body>
</html>