package com.amaan.project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.amaan.project.DAO.UserDataDAO;

@WebServlet("/deleteData")
public class DataDeletionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDataDAO userDataDao=new UserDataDAO();;

    public DataDeletionController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		int deletedData = userDataDao.delete(title);
		if(deletedData>0) {
			request.setAttribute("task", "deleted");
			RequestDispatcher dispatcher=request.getRequestDispatcher("notesRead");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("notes.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
