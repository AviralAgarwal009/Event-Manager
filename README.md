You can view the running project on the url : https://eventmanager009.herokuapp.com/

This url opens home page where user can register themselves in the event.

If you want to see the admin page add "/admin" at the end of the given url i.e use url  “https://eventmanager009.herokuapp.com/admin”  
where you can use username as "admin" and password as "admin" to log in
which will redirect you to admin dashboard where admin can see the graph displaying details about each registration type as asked in the question , and a table displaying registration number along with other information asked in the question 
and by clicking on registration number admin can see full details of the participant.

<-------------------------------------------------------->

To run this program on your computer , some steps has to be followed given below : 
1) Run sql script in MySQL Workbench attached in the zip file.
2) Then in ide like eclipse import maven project and select the folder given by our team. 
3) Run the project (main method is present in (EventManagerApplication.java).
4) Open "http://localhost:5000" as port number used in the project is 5000 this will open homepage where user can register themselves
5) For admin screen open "http://localhost:5000/admin"


*Project will be executed slow on the Url given above i.e. https://eventmanager009.herokuapp.com/ as our team is using free tier from Heroku to present the project

#Background Picture in the application can be changed according to the requirement of the hosts.


