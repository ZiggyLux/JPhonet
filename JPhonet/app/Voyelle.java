package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Voyelle.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Voyelle extends Valeur {
	protected int iMode;
	final static int
		MODE_FERMEES_1 = 1,
		MODE_FERMEES_2 = 2,
		MODE_SEMIFERMEES_1 = 3,
		MODE_SEMIFERMEES_2 = 4,
		MODE_SEMIOUVERTES_1 = 5,
		MODE_SEMIOUVERTES_2 = 6,
		MODE_OUVERTES = 7;
		
	protected int iLieu;
	final static int
		LIEU_PALATALES_1 = 1,
		LIEU_PALATALES_2 = 2,
		LIEU_PALATALES_3 = 3,
		LIEU_PALATALES_4 = 4,
		LIEU_PALATALES_5 = 5,
		LIEU_CENTRALES_1 = 6,
		LIEU_CENTRALES_2 = 7,
		LIEU_CENTRALES_3 = 8,
		LIEU_CENTRALES_4 = 9,
		LIEU_VELAIRES_1 = 10,
		LIEU_VELAIRES_2 = 11;
	
	public Voyelle(String str, int iMode, int iLieu) {
		this.str = str;
		this.iMode = iMode;
		this.iLieu = iLieu;
		this.iLigne = iMode - 1;
		this.iColonne = iLieu - 1;
	}
	
	public Voyelle(char ch, int iMode, int iLieu) {
		this.str = Character.toString(ch);
		this.iMode = iMode;
		this.iLieu = iLieu;
		this.iLigne = iMode - 1;
		this.iColonne = iLieu - 1;
	}
	
	public static Voyelle[] arrVoyelles = {
		new Voyelle('i', MODE_FERMEES_1, LIEU_PALATALES_1),
		new Voyelle('y', MODE_FERMEES_1, LIEU_PALATALES_2),
		new Voyelle('\u0268', MODE_FERMEES_1, LIEU_CENTRALES_1),
		new Voyelle('\u0289', MODE_FERMEES_1, LIEU_CENTRALES_2),
		new Voyelle('\u026F', MODE_FERMEES_1, LIEU_VELAIRES_1),
		new Voyelle('u', MODE_FERMEES_1, LIEU_VELAIRES_2),
		new Voyelle('\u026A', MODE_FERMEES_2, LIEU_PALATALES_3),
		new Voyelle('Y', MODE_FERMEES_2, LIEU_PALATALES_4),
		new Voyelle('\u028A', MODE_FERMEES_2, LIEU_CENTRALES_4),
		new Voyelle('e', MODE_SEMIFERMEES_1, LIEU_PALATALES_2),
		new Voyelle('\u00F8', MODE_SEMIFERMEES_1, LIEU_PALATALES_4),
		new Voyelle('\u0264', MODE_SEMIFERMEES_1, LIEU_VELAIRES_1),
		new Voyelle('o', MODE_SEMIFERMEES_1, LIEU_VELAIRES_2),
		new Voyelle('\u0259', MODE_SEMIFERMEES_2, LIEU_CENTRALES_2),
		new Voyelle('\u0275', MODE_SEMIFERMEES_2, LIEU_CENTRALES_3),
		new Voyelle('\u03B5', MODE_SEMIOUVERTES_1, LIEU_PALATALES_4),
		new Voyelle('\u0153', MODE_SEMIOUVERTES_1, LIEU_CENTRALES_1),
		new Voyelle('\u028C', MODE_SEMIOUVERTES_1, LIEU_VELAIRES_1),
		new Voyelle('\u0254', MODE_SEMIOUVERTES_1, LIEU_VELAIRES_2),
		new Voyelle('\u00E6', MODE_SEMIOUVERTES_2, LIEU_PALATALES_5),
		new Voyelle('\u0250', MODE_SEMIOUVERTES_2, LIEU_CENTRALES_3),
		new Voyelle('a', MODE_OUVERTES, LIEU_CENTRALES_1),
		new Voyelle('\u0152', MODE_OUVERTES, LIEU_CENTRALES_2),
		new Voyelle('\u0251', MODE_OUVERTES, LIEU_VELAIRES_1),
		new Voyelle('\u0252', MODE_OUVERTES, LIEU_VELAIRES_2)
	};
	
}
