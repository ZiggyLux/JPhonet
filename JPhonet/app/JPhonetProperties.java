package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/****************************************************************************
Application......... JPhonet                                                 
Version............. 1.B 1.1                                                   
Plateforme.......... *                                                     
Source.............. JPhonetProperties.java                                         
Derni�re MAJ........ 13/06/17                                                      
Auteur.............. Marc CESARINI                                         
Remarque............ Standard Java                                         
Br�ve description... Classe des propri�t�s g�n�rales de l'application                                                      
                                                                           
Emplacement.........                                                       
*****************************************************************************/

public class JPhonetProperties {

	// Base de donn�es
	String strDBname;
	public String getDBname() { return strDBname; }

	// Etiquette d'environnement
	String strEtiqEnvir;
	public String getEtiqEnvir() { return strEtiqEnvir; }
	
	// Propri�t�s
	Properties defaultProps;
	
	// Constructeur
	public JPhonetProperties() {
		try {
			FileInputStream in =
				new FileInputStream("JPhonet.properties");
			defaultProps = new Properties();
			defaultProps.load(in);
			strDBname = defaultProps.getProperty("Database_Name");
			strEtiqEnvir = defaultProps.getProperty("Environment_Tag");
			in.close();

		} catch (IOException ex) {
			// handle any errors
            System.out.println("IOException: " + ex.getMessage());
		}
	}
	

}
