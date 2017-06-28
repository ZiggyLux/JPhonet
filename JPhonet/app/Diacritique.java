package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Diacritique.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Diacritique extends Valeur {
	protected int iType;
	final static int
		TYPE_NASALISATION = 1,
		TYPE_SOURDITE = 2,
		TYPE_SONORITE = 3,
		TYPE_ALLONGEMENT = 4;
		
	public Diacritique(String str, int iType) {
		this.str = str;
		this.iType = iType;
		this.iLigne = iType - 1;
	}
	
	public Diacritique(char ch, int iType) {
		this.str = Character.toString(ch);
		this.iType = iType;
		this.iLigne = iType - 1;
	}
	
	public static Diacritique[] arrDiacritiques = {
		new Diacritique('\u0303', TYPE_NASALISATION),
		new Diacritique('\u0325', TYPE_SOURDITE),
		new Diacritique('\u032C', TYPE_SONORITE),
		new Diacritique('\u02D0', TYPE_ALLONGEMENT)
		
	};
	
}
