package com.amaan.project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.amaan.project.DAO.UserDataDAO;
import com.amaan.project.model.User;
import com.amaan.project.model.UserData;

@WebServlet("/addNotes")
public class NotesAdditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDataDAO userDataDao=new UserDataDAO();;
       

    public NotesAdditionController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int userId = user.getId();
		String title= request.getParameter("title");
		String content = request.getParameter("content");
		RequestDispatcher dispatcher =null;
		
		UserData userData = new UserData();
		userData.setTitle(title);
		userData.setContent(content);
		userData.setUser(userId);
		
		int dataSaved = userDataDao.save(userData);
		
		if(dataSaved>0) {
			request.setAttribute("task", "added");
			dispatcher=request.getRequestDispatcher("notesRead");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher=request.getRequestDispatcher("index.js");
			dispatcher.forward(request, response);
		}
		
	}
}
