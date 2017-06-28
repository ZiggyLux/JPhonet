package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Intensite.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Intensite extends Valeur {
	protected int iAccent;
	final static int
		ACCENT_PRIMAIRE = 1,
		ACCENT_SECONDAIRE = 2;
		
	public Intensite(String str, int iAccent) {
		this.str = str;
		this.iAccent = iAccent;
		this.iLigne = iAccent - 1;
	}
	
	public Intensite(char ch, int iAccent) {
		this.str = Character.toString(ch);
		this.iAccent = iAccent;
		this.iLigne = iAccent - 1;
	}
	
	public static Intensite[] arrIntensites = {
		new Intensite('\u02C8', ACCENT_PRIMAIRE),
		new Intensite('\u02CC', ACCENT_SECONDAIRE)
	};
	
}
