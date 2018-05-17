<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="connexionClient">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="nomClient">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomClient" name="nom" value="" size="20" maxlength="20" />
                    <span class="erreur">${form.erreurs['nom']}</span>
                    <br />
  
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="email" value="" size="20" maxlength="60" />
                    <span class="erreur">${form.erreurs['email']}</span>
                    <br />
                    
                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                    
                    <c:if test="${!empty sessionScope.sessionClient}">
                    	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionClient.email}</p>
                	</c:if>
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>