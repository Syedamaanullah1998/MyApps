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
import com.amaan.project.DAO.UserDataDAO;
import com.amaan.project.model.User;

@WebServlet("/delete")
public class AccountDeletionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao=new UserDAO();
	private UserDataDAO userDataDao = new UserDataDAO();
    
    public AccountDeletionController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		RequestDispatcher dispatcher =null;
		
		int rowsDeleted = userDao.delete(user);
		userDataDao.delete(user);
		
		if(rowsDeleted>0) {
			dispatcher=request.getRequestDispatcher("login.jsp");
			request.setAttribute("deleteStatus", "success");
			session.invalidate();
		}else {
			dispatcher=request.getRequestDispatcher("index.jsp");
			request.setAttribute("deleteStatus", "failed");
		}
		dispatcher.forward(request, response);
		
	}
}
