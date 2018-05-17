package com.forms;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.beans.Client;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_NOM = "nom";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public Client connecterClient( HttpServletRequest request ) {
		String name = getValeurChamp(request, CHAMP_NOM);
		String email = getValeurChamp( request, CHAMP_EMAIL );
		Client Client = new Client();
		
		try {
			validationEmail( email );
		} catch ( Exception e ) {
			setErreur( CHAMP_EMAIL, e.getMessage() );
		}
		
		try {
			validationNom( name );
		} catch ( Exception e ) {
			setErreur( CHAMP_NOM, e.getMessage() );
		}
		
		Client.setName(name);
		Client.setEmail(email);
		
		if ( erreurs.isEmpty() ) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}
		
		return Client;
	}

	private void validationEmail( String email ) throws Exception {
		if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
			throw new Exception( "Merci de saisir une adresse mail valide." );
		}
	}
	
	private void validationNom(String name) throws Exception {
		if(name.isEmpty())
			throw new Exception("Veuillez inserer un nom.");
	}

	private void setErreur( String champ, String message ) {
		erreurs.put( champ, message );
	}

	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
		String valeur = request.getParameter( nomChamp );
		if ( valeur == null || valeur.trim().length() == 0 ) {
			return null;
		} else {
			return valeur;
		}
	}
} 