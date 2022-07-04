<%@ page import="com.amaan.project.model.User" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
if(session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">
</head>

<body>
    <header>
        <nav class="navbar">
            <img src="/img/Icon.png" alt="">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li class="navElements"><a href= "/MyApp1/index.jsp" class="nav-link px-3 text-white">Home</a></li>
                <li class="navElements"><a href= "/MyApp1/contactus.jsp" class="nav-link px-2 text-white">Contact Us</a></li>
                <li class="navElements"><a href= "/MyApp1/about.jsp" class="nav-link px-2 text-white">About</a></li>
            </ul>
            <form action="logout" method="post">
            <div class="text-end">
                <button type="submit" name="submit" value="Logout"
                    class="btn btn-lg btn-outline-light me-2">Logout</button>
            </div>
            </form>
        </nav>
    </header>
    <section style="align-items: initial;justify-content: left;">
        <div class="about">
            <h1>About Us</h1>
            <p>This is a Login Authentication Project</p>
        </div>
    </section>

    <footer
    id="footer" class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5">
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © <script type="text/javascript">var year = new Date();document.write(year.getFullYear());</script> All rights reserved.
    </div>
    </footer>

</body>

</html>