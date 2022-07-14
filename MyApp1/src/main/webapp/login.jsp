<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <!-- Main css -->
    <link rel="stylesheet" href="css/loginstyle.css">
    

  </head>

  <body>




    <section class="vh-100" style="background-color: #eee;">
      <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-lg-12 col-xl-11">
            <div class="card text-black" style="border-radius: 25px;">
              <div class="card-body p-md-5">
                <div class="row justify-content-center">
                  <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                    <!-- hidden field  -->
                    <input type="hidden" id="loginStatus" value="<%=request.getAttribute("loginStatus")%>">
                    <input type="hidden" id="deleteStatus" value="<%=request.getAttribute("deleteStatus")%>">
                    
                    <p class="text-left h1 fw-bold mb-5 mx-1 mx-md-4 mt-4" id="title">Sign in</p>

                    <!-- form  -->

                    <form method="post" action="login">

                      <!-- username input -->
                      <div class="form-outline mb-4">
                        <label class="form-label" for="form3Example3">Username:</label>
                        <input type="text" name="username" id="form3Example3" class="form-control form-control-lg"
                          placeholder="Enter a valid Username" required />

                      </div>

                      <!-- Password input -->
                      <div class="form-outline mb-3">
                        <label class="form-label" for="form3Example4">Password:</label>
                        <input type="password" name="password" id="form3Example4" class="form-control form-control-lg"
                          placeholder="Enter password" required/>

                      </div>

                      <!-- login button  -->
                      <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" name="signin" id="loginButton" class="btn btn-primary btn-lg"
                          style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>

                        <!-- Register link button  -->
                        <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account?
                          <a href="/MyApp1/registration.jsp" id="register">Register</a>
                        </p>
                      </div>
                    </form>

                  </div>
                  <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                    <img src="img/Pic1.png" class="img-fluid" alt="Sample image">

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    </section>

    <script type="text/javascript">
      var loginStatus = document.getElementById("loginStatus").value;
      var deleteStatus = document.getElementById("deleteStatus").value;
      if (loginStatus === "failed") {
        alert("Oops!, Wrong Username or Password, please try again.");
      }
      if (deleteStatus === "success") {
          alert("Your Account has been delete successfully!!!");
      }
    </script>

  </body>

  </html>