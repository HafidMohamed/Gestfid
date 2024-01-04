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
<title>GestFid | Student Profile</title>
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
								class="amessage" href="MessagesUser1">
									<div class="notify_icon">
										<span class="icon"><img class="messages_img"
											src="img/hafid1.jpg" width="100%" alt="Sender"></span>
									</div>
									<div class="notify_data">
										<div class="title">
											${etudiantModel.getMessageAdmin().get(status.index).getNomAdmin()}
											${etudiantModel.getMessageAdmin().get(status.index).getPrenomAdmin()}
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
						src="data:image/jpg;base64,${etud.getBase64image()}"
						alt="profile_pic"> <span class="name">${etud.getNomEtudiant()}</span>
					<i class="fas fa-chevron-down"></i>
				</div>

				<div class="profile_dd">
					<ul class="profile_ul">
						<li><a class="address" href="StudentProfile1" id="Profile_dd"><span
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
				<li class="side-nav__item " id="li-0"><a href="Home1"
					class="side-nav__link li-active"> <svg class="side-nav__icon">
						<use xlink:href="img/sprite.svg#icon-home"></use> </svg> <span
						class="side-nav__link-text " id="home">Home</span>
				</a></li>

				<li class="side-nav__item" id="list-1"><a href="#List"
					class="side-nav__link"> <svg class="side-nav__icon"> <use
							xlink:href="img/sprite.svg#icon-file-text"></use> </svg> <span
						class="side-nav__link-text " id="lists">Cours inventory </span>
				</a></li>
			</ul>
		</div>
		<div class="legal" id="legal">© 2020 by GestFid. All rights
			reserved</div>
		</nav>
		<main class="Admin-view">
		<div class="list-view">
			<div class="wrapper">
				<div class="left">
					<img src="data:image/jpg;base64,${etud.getBase64image()}"
						alt="user" width="100">
					<h4>${etudiantModel.etudiant.getNomEtudiant()}
						${etudiantModel.etudiant.getPrenomEtudiant()}</h4>
					<p id="student">Student</p>
				</div>
				<div class="right">
					<div class="info">
						<h3 id="informations">Informations</h3>
						<div class="info_data">
							<div class="data">
								<h4 id="student_nom">Last Name</h4>
								<p>${etudiantModel.etudiant.getNomEtudiant()}</p>
							</div>
							<div class="data">
								<h4 id="student_prenom">First Name</h4>
								<p>${etudiantModel.etudiant.getPrenomEtudiant()}</p>
							</div>
							<div class="data">
								<h4>CNI</h4>
								<p>${etudiantModel.etudiant.getCNE()}</p>
							</div>
							<div class="data">
								<h4>CNE</h4>
								<p>CNI : ${etudiantModel.etudiant.getCNI()}</p>
							</div>
							<div class="data">
								<h4 id="major">Major</h4>
								<p>${etudiantModel.etudiant.getFiliere()}</p>
							</div>
							<div class="data">
								<h4 id="class">Class</h4>
								<p>${etudiantModel.etudiant.getClasse()}</p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="list-view typebottom">
			<h2 class="list-title overview__heading" id="h2_doa">The
				Displaying of the Absences</h2>
			<form method="POST" action="DisplayAbsenceType1">
				<div class="row">
					<div class="row-col">
						<label class="row-text" id="dis_per">Dispalying per :</label>
						<div>

							<select class="select-css" id="DisType" name="DisType">
								<option>Module Total number</option>
								<option>In detail</option>
							</select>
							<div class="select-dropdown"></div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="row-col">
						<label class="row-text" id="la_duratim">duration time :</label>
						<div class="custom-select">
							<select class="select-css" id="Dure" name="Dure">
								<option id="Time" value="0" Selected>Time</option>
								<option id="today" value="1">Today</option>
								<option id="week" value="8">This week</option>
								<option id="month" value="30">Last month</option>
								<option id="thisemster" value="120">This semester</option>
							</select>
							<div class="select-dropdown"></div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="row-col">
						<label class="row-text Orr" id="dis_or">Or</label>
					</div>
				</div>
				<div class="row">
					<div class="row-col">
						<div class="form__group">
							<input type="date" class="form__input" placeholder="Session Date"
								name="FromDate" id="FromDate"> <label for="FromDate"
								class="form__label" id="FromDate_label">From date:</label>
						</div>
					</div>
					<div class="row-col">
						<div class="form__group">
							<input type="date" class="form__input" placeholder="Session Date"
								name="ToDate" id="ToDate"> <label for="FromDate"
								class="form__label" id="ToDate_label">To date:</label>
						</div>
					</div>
					<div class="row-col">
						<button type="submit" class="btn btn__visible">Submit</button>
					</div>
				</div>
			</form>
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

</body>
</html>