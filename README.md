Hi everyone

I would like to present to you my first-ever project in Java(Jakarta) EE Servlet Web App front and back end, I made it back in 2020 as a part of my uni journey projects and I'm hugely proud of this because I wrote every single line of code of it and interface design was own conception and made
This project is about a school system where admins functionalities are managing students and their course attendance add, edit, or delete them also students can access their space and talk to admin in build in chat system and see their absence.





to import project Download it extract it in ur local repo

requirements
 
 Jdk 
 Maven
 Eclipse
 mysql
 Tomcat

in eclipse -> open project from file system -> "browse to project directory " Select Folder -> finish 

to run it 
in your SQL IDE -> create a database called "Gestfid" and go to file "Gestfid.sql" -> copy ->  past in your SQL IDE -> select all and run all 

in the project go to /GestFid/src/metier/SingletonConnection.java and add your SQL connection info URL username and password save and move to the next step

In Eclipse select project right click run as -> Maven clean and repeat Maven build and run with your favorite server 

if you run with Tomcat in Eclipse select project right click run as -> Run on server -> select Tomcat and next move the project to the configured side and click Finish

in your browser http://localhost:8080/GestFid/ you will see the login page to access the User/Student interface in email user@gmail.com password: user for admin interface admin@gmail.com password: admin 

I hope you like this and it benefits you 

Mohamed Hafid


