package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Client;
import com.forms.ConnexionForm;

/**
 * Servlet implementation class ConnexionClient
 */
@WebServlet("/ConnexionClient")
public class ConnexionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_FORM = "form";
	public static final String ATT_CLIENT = "client";
	public static final String ATT_SESSION_CLIENT = "sessionClient";


	public static final String VUE = "/connexionClient.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionClient() {
		super();
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

		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm form = new ConnexionForm();
		Client client = form.connecterClient(request);
		HttpSession session = request.getSession(); 

		if ( form.getErreurs().isEmpty() ) {
			session.setAttribute(ATT_SESSION_CLIENT, client);
		} else {
			session.setAttribute(ATT_SESSION_CLIENT, null );
		}

		request.setAttribute( ATT_FORM, form);
		request.setAttribute( ATT_CLIENT, client);

		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}
}
