package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Client;

/**
 * Servlet implementation class creationClient
 */
@WebServlet("/CreationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("nomClient");
		String firstname = request.getParameter("prenomClient");
		String email = request.getParameter("emailClient");
		
		Client cli = new Client();
		cli.setName(name);
		cli.setFirstname(firstname);
		cli.setEmail(email);
		
		String message = new String();
		
		if(name.isEmpty() || firstname.isEmpty() || email.isEmpty())
			message = "Manque une case Guy.";
		else
			message = "Nice Guy.";
		
		request.setAttribute("client", cli);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
