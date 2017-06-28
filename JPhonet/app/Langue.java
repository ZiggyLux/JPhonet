package app;
/****************************************************************************
  Application......... LangSQL2                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Langue.java                                         
  Derni�re MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Br�ve description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Langue {
	protected String strNom;
	protected String strIso;
	
	public Langue(String strNom, String strIso) {
		this.strNom = strNom;
		this.strIso = strIso;
	}
	
	public static Langue[] arrLangue = {
		new Langue("Fran�ais", "fr"),
		new Langue("Anglais", "en"),
		new Langue("Allemand", "de"),
		new Langue("Espagnol", "es"),
		new Langue("Russe", "ru"),
		new Langue("Italien", "it"),
		new Langue("Autres", "**")
	};
	
}
