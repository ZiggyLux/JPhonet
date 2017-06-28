package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Hauteur.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Hauteur extends Valeur {
	protected int iTon;
	final static int
		TON_TRESHAUT_MONTANT = 1,
		TON_HAUT_MONTANT = 2,
		TON_HAUT = 3,
		TON_BAS = 4,
		TON_TRESBAS = 5,
		TON_BAS_MONTANT = 6,
		TON_BAS_DESCENDANT = 7,
		TON_HAUT_DESCENDANT = 8,
		TON_MONTANT_DESCENDANT = 9,
		TON_DESCENDANT_MONTANT = 10;
		
	public Hauteur(String str, int iTon) {
		this.str = str;
		this.iTon = iTon;
		this.iLigne = iTon - 1;
	}
	
	public Hauteur(char ch, int iTon) {
		this.str = Character.toString(ch);
		this.iTon = iTon;
		this.iLigne = iTon - 1;
	}
	
	public static Hauteur[] arrHauteurs = {
		new Hauteur('\u030B', TON_TRESHAUT_MONTANT),
		new Hauteur('\u0301', TON_HAUT_MONTANT),
		new Hauteur('\u0304', TON_HAUT),
		new Hauteur('\u0331', TON_BAS),
		new Hauteur('\u0333', TON_TRESBAS),
		new Hauteur('\u0317', TON_BAS_MONTANT),
		new Hauteur('\u0316', TON_BAS_DESCENDANT),
		new Hauteur('\u0300', TON_HAUT_DESCENDANT),
		new Hauteur('\u0302', TON_MONTANT_DESCENDANT),
		new Hauteur('\u030C', TON_DESCENDANT_MONTANT)
	};
	
}
