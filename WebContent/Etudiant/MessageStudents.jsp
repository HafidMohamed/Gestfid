<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
<link rel="stylesheet" href="css/UserAdminStyle.css">
<link rel="stylesheet" href="css/chat.css">
<link rel="shortcut icon" type="image/png" href="img/icone-white.png">
<title id="title-up">GestFid | Home</title>
</head>

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
<body>
	<div class="content">
		<div class="container">
			<h3 class=" text-center">Messaging</h3>
			<div class="messaging">
				<div class="inbox_msg">
					<div class="inbox_people">
						<div class="headind_srch">
							<div class="recent_heading">
								<h4>Recent</h4>
							</div>
							<div class="srch_bar">
								<div class="stylish-input-group">
									<input type="text" class="search-bar" placeholder="Search">
									<span class="input-group-addon">
										<button type="button">
											<i class="fa fa-search" aria-hidden="true"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="inbox_chat">
							<lu class="messageNav"> <c:forEach
								items="${etudiantModel.listAllMessages}" var="e"
								varStatus="status">
								<li class="chat">
									<div class="chat_list">
										<div class="chat_people">
											<a class="amessage"
												href="ConversationPp1?id_from=${e.getId_user_from()}&id_to=${e.getId_user_to()}">
												<div class="chat_img">
													<img src="https://ptetutorials.com/images/user-profile.png"
														alt="sunil">
												</div>
												<div class="chat_ib">
													<h5 class="Userheading">
														${etudiantModel.getMessageAdmin().get(status.index).getNomAdmin()}
														${etudiantModel.getMessageAdmin().get(status.index).getPrenomAdmin()}
														<span class="chat_date">${e.getTime()}</span>
													</h5>
													<p>${e.getMessage()}</p>
												</div>
											</a>
										</div>
									</div>
								</li>
							</c:forEach> </lu>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
<script src="js/DropDown.js"></script>
<script src="js/admin.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>