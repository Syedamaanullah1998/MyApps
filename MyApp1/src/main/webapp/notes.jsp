<%@ page import="com.amaan.project.model.User" import="com.amaan.project.model.UserData" import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
User user = (User)session.getAttribute("user");
String firstName=null;
String lastName=null;
List<UserData> userDataList=new ArrayList<UserData>();

if(user==null){
	response.sendRedirect("login.jsp");
}else{
	firstName=user.getFirstName();
	lastName=user.getLastName();
	userDataList=(List<UserData>)session.getAttribute("userDataList");
}
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Notes</title>
    <link font-family: "Montserrat", sans-serif;
    href="https://fonts.googleapis.com/css?family=McLaren|Montserrat&display=swap"rel="stylesheet" />
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
</head>

<body>
    <header>
        <nav class="navbar">
        	<!-- hidden field  -->
            <h1>Notes</h1>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li class="navElements"><a href= "/MyApp1/notes.jsp" class="nav-link px-3 text-white">My Notes</a></li>
                <li class="navElements"><a href= "/MyApp1/index.jsp" class="nav-link px-3 text-white">Add Notes</a></li>
                <li class="navElements"><a href= "/MyApp1/contactus.jsp" class="nav-link px-2 text-white">Contact Us</a></li>
                <li class="navElements"><a href= "/MyApp1/about.jsp" class="nav-link px-2 text-white">About</a></li>
            </ul>

            <form action="logout" method="post" class="text-end">
                <button type="submit" name="submit" value="Logout"class="btn btn-md btn-outline-light me-2">Logout</button>
            </form>
            <form action="delete" method="post" class="text-end">
                <button type="submit" name="submit" value="Delete" class="btn btn-md btn-outline-light me-2">Delete Account</button>
            </form>
        </nav>
    </header>
    
    <section >
        
        <%
        if(userDataList.isEmpty()){
        	%><p>No notes to Display!</p><%
        }
        
        for(UserData userData:userDataList){
        	String title=userData.getTitle();
        	String content = userData.getContent();%>
        		<form method="post" action="deleteData" class="note">
        			<h2><%=title%></h2>
	        		<p><%=content%></p>
	        		<input type="hidden" name="title" value="<%=title%>" ">
	        		<input  type="submit" name="submit" value="DELETE" class="delete btn btn-sm btn-outline-dark me-2">
	        		
        		</form>

       	<%}%>

        
        
        
    </section>

    <footer>
        <p>Copyright © <script type="text/javascript">var year = new Date();document.write(year.getFullYear());</script> All rights reserved.</p>
    </footer>
    

</body>

</html>