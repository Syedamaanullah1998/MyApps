package com.amaan.project.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.amaan.project.DAO.UserDAO;
import com.amaan.project.model.User;
import com.amaan.project.util.PasswordEncryptionUtil;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao=new UserDAO();

       
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		String encryptedPassword=PasswordEncryptionUtil.encrypt(password);
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher =null;
		
	
		
		User user = userDao.findUser(username, encryptedPassword);
		
		if(user!=null) {
			session.setAttribute("user", user);
			dispatcher=request.getRequestDispatcher("index.jsp");
		}else {
			request.setAttribute("loginStatus", "failed");
			
			dispatcher=request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request,response);
		
		
	}

}
