package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Client;

/**
 * Servlet implementation class ConnexionClient
 */
@WebServlet("/ConnexionClient")
public class ConnexionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nomClient");
		String email = request.getParameter("emailClient");
		
		Client cli = new Client();
		cli.setName(name);
		cli.setEmail(email);
		
		String message = new String();
		
		if(name.isEmpty() || email.isEmpty())
			message = "Manque une case Guy.";
		else
			message = "Nice Guy t'es connecté.";
		
		request.setAttribute("client", cli);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher( "/afficherConnexion.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
