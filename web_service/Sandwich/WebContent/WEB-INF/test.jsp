<%@page import="com.beans.MonGuy"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YES</title>
</head>
<body>
	JSP ABéé
	<p>
		<% 
            String attribut = (String) request.getAttribute("test");
            out.println(attribut);
            %>
	</p>
	${param.auteur }
	<br />
	<p>
		<jsp:useBean id="guy" class="com.beans.MonGuy" scope="request" />
		<jsp:getProperty name="guy" property="name" />
		<jsp:setProperty name="guy" property="name" value="Jean-Guy" />
		${ guy.name }<br />
	</p>
	<p>
		${8/3}<br />
	</p>
	<p>
		Récupération de la liste :
		<c:forEach var="item" items="${liste}">
			<c:out value="${item}" />
		</c:forEach>
	</p>
	 <p>
            Récupération du jour du mois :
            <%
            Integer jourDuMois = (Integer) request.getAttribute( "jour" );
            if ( jourDuMois % 2 == 0 ){
                out.println("Jour pair : " + jourDuMois);
            } else {
                out.println("Jour impair : " + jourDuMois);
            }
            %>
        </p>
</body>
</html>