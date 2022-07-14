package com.amaan.project.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.amaan.project.DAO.UserDAO;
import com.amaan.project.model.User;
import com.amaan.project.util.PasswordEncryptionUtil;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao=new UserDAO();
 
    public RegistrationController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("fName");
		String lastName=request.getParameter("lName");
		String userName=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String encryptedPassword = PasswordEncryptionUtil.encrypt(password);
		RequestDispatcher dispatcher =null;
		

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(userName);
		user.setEmail(email);
		user.setPassword(encryptedPassword);
		
	
		
		boolean saved = userDao.save(user);
		dispatcher=request.getRequestDispatcher("registration.jsp");
		if(saved) {
			request.setAttribute("registerStatus", "success");
		}else {
			request.setAttribute("registerStatus", "failed");
		}
		dispatcher.forward(request, response);
		
	}

}
