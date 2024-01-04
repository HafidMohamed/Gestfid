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
<title id="title-up">GestFid | Home</title>
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
		<div class="home-view">
			<div class="overview">
				<h1 class="overview__heading" id="home_h1">WELCOME BACK</h1>
				<h1 class="overview__heading">${etud.getNomEtudiant()}
					${etud.getPrenomEtudiant()}</h1>
			</div>
		</div>
		</main>
	</div>



	<!-- Jquery JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script
		src="http://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"
		defer></script>

	<!-- Vendor JS-->
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>
	<script src="js/DropDown.js"></script>
	<script src="js/admin.js"></script>
</body>
</html>