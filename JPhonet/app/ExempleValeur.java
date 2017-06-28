package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.B                                                   
  Plateforme.......... *                                                     
  Source.............. ExempleValeur.java                                         
  Dernière MAJ........ 21/07/07                                                      
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description... Exemple illustrant l'emploi d'une valeur phonétique                                                      
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.util.*;

public class ExempleValeur {
	protected String val;
	protected String lng;
	protected boolean fExiste;
	protected String exemples;
	
	// Base d'exemples
	static HashMap hmap;
	
	// Chargement
	
	// Sauvegarde

	public ExempleValeur(String val, String lng, boolean fExiste, String exemples) {
		this.val = val;
		this.lng = lng;
		this.fExiste = fExiste;
		this.exemples = exemples;
	}
	
	private String cle() { return val + ":" + lng; }

	public void ecrit() {
		hmap.remove(cle());
		hmap.put(cle(), exemples);
	}
	
	public void lit() {
		ExempleValeur ex = (ExempleValeur) hmap.get(cle());
	}
}
