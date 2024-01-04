
$(".profile .icon_wrap").click(function(){
    $(this).parent().toggleClass("active");
    $(".notifications").removeClass("active");
  });
  
  $(".notifications .icon_wrap").click(function(){
    $(this).parent().toggleClass("active");
     $(".profile").removeClass("active");
  });

  $(".show_all .link").click(function(){
  $(".notifications").removeClass("active");
  $(".popup").show();
});

$(".close, .shadow").click(function(){
  $(".popup").hide();
});



$('.sidebar').toggleClass("show");
$('.feat-btn').click(function(){
  $('nav ul .feat-show').toggleClass("show");
  $('nav ul .first').toggleClass("rotate");
});

$('.profile_dd').toggleClass("show");
$('.feat-btn').click(function(){
  $('ul .feat-show').toggleClass("show");
  $('ul .first').toggleClass("rotate");
});
$(".btn-table").click(function(){
  $(".ppabsence").show();
});

$(".close, .shabsence").click(function(){
  $(".ppabsence").hide();
});
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
$("form").on("change", ".file-upload-field", function(){ 
	  $(this).parent(".file-upload-wrapper").attr("data-text",$(this).val().replace(/.*(\/|\\)/, '') );
	});

$(".account_btn").click(function(){
	  $(".ppaccount").show();
	});

	$(".close").click(function(){
	  $(".ppaccount").hide();
	});