<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
	rel="stylesheet">
<style type="text/css">
<%@ include file="/css/style.css" %>
</style>

<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" type="image/png" href="/img/icone-white.png">
<title>GestFid | Log in</title>
</head>
<body>
	<section class="section-login">
		<div class="row">
			<div class="header__logo-box">
				<img src="img/gestfid.png" alt="logo" class="header__logo">
			</div>
			<div class="header__language cf">
				<div class="header__language--wrapper pull-right">



					<button class="btn-lang" type="submit" id="en">English</button>


					<span class="header__language--seperator">|</span>


					<button class="btn-lang" type="submit" id="de">German</button>


					<span class="header__language--seperator">|</span>


					<button class="btn-lang" type="submit" id="fr">French</button>



				</div>
			</div>
			<div class="book">
				<div class="book__form">
					<form class="form" action="Main" method="POST">
						<div class="form__group">
							<h1 class="heading-secondary" id="lf_h1">future
								Administration assistant</h1>
						</div>
						<div class="form__group">
							<input type="email" class="form__input"
								placeholder="Email Address" name="email" id="login" required>
							<label for="login" class="form__label" id="Email-label">Email
								Address</label>
						</div>
						<div class="form__group">
							<input type="password" class="form__input" placeholder="Password"
								data-type="password" name="password" id="password" required>
							<label for="password" class="form__label" id="Pass-label">Password</label>
						</div>
						<div class="form__radio-group">
							<input type="checkbox" class="form__radio-input" id="save"
								name="size"> <label for="save" class="form__radio-label">
								<span class="form__radio-button"></span>
							</label> <label id="Stay-label">Stay Login?</label>
						</div>
						<%
	    Cookie[] cookies=request.getCookies();
	    String userName = "", password = "",rememberVal="";
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("cookuser")) {
	             userName = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookpass")){
	             password = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookrem")){
	             rememberVal = cookie.getValue();
	           }
	        }
	    }
	%>
						<div class="form__group">
							<button type="submit" class="btn btn--blue button"
								id="Login-label">log in</button>
						</div>

					</form>

				</div>

			</div>

		</div>

	</section>
	<script src="js/admin.js"></script>
	<script>
        var activeclass=document.querySelectorAll(".btn-lang");
        for(var i=0;i<activeclass.length;i++){
             activeclass[i].addEventListener('click', activateClass);  
        }
        function activateClass(e){
            for(var i=0;i<activeclass.length;i++){
                activeclass[i].classList.remove('active');
            }
            e.target.classList.add('active');
        }</script>
</body>
</html>