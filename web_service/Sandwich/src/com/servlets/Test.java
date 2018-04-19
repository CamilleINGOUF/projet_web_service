package com.servlets;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.beans.MonGuy;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAuteur = request.getParameter( "auteur" );
		String message = "Transmission de variables : OK ! ";
		request.setAttribute( "test", message );
		
		MonGuy guy = new MonGuy();
		
		guy.setName("Guy");
		guy.setSkin(new Color(50, 20, 89));
		guy.setHeight(190);
		
		request.setAttribute("guy", guy);
		
		List<Integer> premiereListe = new ArrayList<Integer>();
		premiereListe.add( 27 );
		premiereListe.add( 12 );
		premiereListe.add( 138 );
		premiereListe.add( 6 ); 
		
		request.setAttribute("liste", premiereListe);
		
		DateTime dt = new DateTime();
		Integer jourDuMois = dt.getDayOfMonth(); 

		request.setAttribute( "jour", jourDuMois ); 
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
