package com.amaan.project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.amaan.project.DAO.UserDAO;
import com.amaan.project.DAO.UserDataDAO;
import com.amaan.project.model.User;
import com.amaan.project.model.UserData;

@WebServlet("/notesRead")
public class NotesReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDataDAO userDataDao=new UserDataDAO();
	
    public NotesReadController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<UserData> userDataList = userDataDao.read(user);
		session.setAttribute("userDataList", userDataList);
		RequestDispatcher dispatcher =null;
		if(request.getAttribute("task").equals("deleted")) {
			dispatcher=request.getRequestDispatcher("notes.jsp");
		}
		else {
			dispatcher=request.getRequestDispatcher("index.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}

}
