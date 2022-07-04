<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <link rel="stylesheet" href="css/register.css">

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
                                    <input type="hidden" id="status" value="<%=request.getAttribute("registerStatus")%>">
                                    <p id="title" class="text-left h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Create account</p>

                                    <form method="post" action="register" class="mx-1 mx-md-4">

                                        <!-- firstName  -->
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" name="fName" placeholder="First Name"
                                                    id="form3Example1c" class="form-control" />
                                            </div>
                                        </div>

                                        <!-- lastName  -->
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" name="lName" placeholder="Last Name"
                                                    id="form3Example1c" class="form-control" />
                                            </div>
                                        </div>

                                        <!-- username  -->
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" name="username" placeholder="Username"
                                                    id="form3Example1c" class="form-control" />
                                            </div>
                                        </div>

                                        <!-- email  -->
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="email" name="email" placeholder="Email" id="form3Example1c"
                                                    class="form-control" />
                                            </div>
                                        </div>

                                        <!-- password  -->
                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" name="password" placeholder="Password"
                                                    id="form3Example1c" class="form-control" />
                                            </div>
                                        </div>



                                        <!-- Reguister button  -->
                                        <div class="text-center text-lg-start mt-4 pt-2">
                                            <button type="submit" name="signup" id="registerButton"
                                                class="btn btn-primary btn-lg"
                                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>

                                            <!-- login link   -->
                                            <p class="small fw-bold mt-2 pt-1 mb-0">Already have an account?
                                                <a href="/MyApp1/login.jsp" id="register">Login</a>
                                            </p>
                                        </div>

                                    </form>

                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                    <img src="img/Register Pic.png" class="img-fluid" alt="Sample image">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </section>
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status === "success") {
            alert("congrats, Account Created Successfully, please login to continue");
        } else if(status==="failed"){
            alert("Oops!, Account could not be created, please try again.");
        }
    </script>
</body>

</html>