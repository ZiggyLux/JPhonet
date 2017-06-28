package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. Consonne.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/

public class Consonne extends Valeur {
	protected int iMode;
	final static int
		MODE_OCCLUSIVES = 1,
		MODE_NASALES = 2,
		MODE_VIBRANTES_ROULEES = 3,
		MODE_VIBRANTES_BATTUES = 4,
		MODE_FRICATIVES = 5,
		MODE_LATERALES_FRICATIVES = 6,
		MODE_SEMIVOYELLES = 7,
		MODE_LATERALES = 8,
		MODE_EJECTIVES = 9,
		MODE_IMPLOSIVES = 10;
		
	protected int iLieu;
	final static int
		LIEU_BILABIALES = 1,
		LIEU_LABIODENTALES = 2,
		LIEU_DENTALES = 3,
		LIEU_ALVEOLAIRES = 4,
		LIEU_POSTALVEOLAIRES = 5,
		LIEU_RETROFLEXES = 6,
		LIEU_PALATALES = 7,
		LIEU_VELAIRES = 8,
		LIEU_UVULAIRES = 9,
		LIEU_PHARYNGALES = 10,
		LIEU_GLOTTALES = 11;
	
	protected int iSon;
	final static int
		SON_SOURDE = 0,
		SON_SONORE = 1;
	
	public Consonne(String str, int iMode, int iLieu, int iSon) {
		this.str = str;
		this.iMode = iMode;
		this.iLieu = iLieu;
		this.iLigne = iMode - 1;
		this.iColonne = iLieu - 1;
		this.iSon = iSon;
	}
	
	public Consonne(char ch, int iMode, int iLieu, int iSon) {
		this.str = Character.toString(ch);
		this.iMode = iMode;
		this.iLieu = iLieu;
		this.iLigne = iMode - 1;
		this.iColonne = iLieu - 1;
		this.iSon = iSon;
	}
	
	public static Consonne[] arrConsonnes = {
		new Consonne('p', MODE_OCCLUSIVES, LIEU_BILABIALES, SON_SOURDE),
		new Consonne('b', MODE_OCCLUSIVES, LIEU_BILABIALES, SON_SONORE),
		new Consonne('t', MODE_OCCLUSIVES, LIEU_ALVEOLAIRES, SON_SOURDE),
		new Consonne('d', MODE_OCCLUSIVES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u0288', MODE_OCCLUSIVES, LIEU_RETROFLEXES, SON_SOURDE),
		new Consonne('\u0256', MODE_OCCLUSIVES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('c', MODE_OCCLUSIVES, LIEU_PALATALES, SON_SOURDE),
		new Consonne('\u025F', MODE_OCCLUSIVES, LIEU_PALATALES, SON_SONORE),
		new Consonne('k', MODE_OCCLUSIVES, LIEU_VELAIRES, SON_SOURDE),
		new Consonne('g', MODE_OCCLUSIVES, LIEU_VELAIRES, SON_SONORE),
		new Consonne('q', MODE_OCCLUSIVES, LIEU_UVULAIRES, SON_SOURDE),
		new Consonne('\u0262', MODE_OCCLUSIVES, LIEU_UVULAIRES, SON_SONORE),
		new Consonne('\u0294', MODE_OCCLUSIVES, LIEU_GLOTTALES, SON_SOURDE),
		new Consonne('m', MODE_NASALES, LIEU_BILABIALES, SON_SONORE),
		new Consonne('\u0271', MODE_NASALES, LIEU_LABIODENTALES, SON_SONORE),
		new Consonne('n', MODE_NASALES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u0273', MODE_NASALES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('\u0272', MODE_NASALES, LIEU_PALATALES, SON_SONORE),
		new Consonne('\u014B', MODE_NASALES, LIEU_VELAIRES, SON_SONORE),
		new Consonne('N', MODE_NASALES, LIEU_UVULAIRES, SON_SONORE),
		new Consonne('B', MODE_VIBRANTES_ROULEES, LIEU_BILABIALES, SON_SONORE),
		new Consonne('r', MODE_VIBRANTES_ROULEES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('R', MODE_VIBRANTES_ROULEES, LIEU_UVULAIRES, SON_SONORE),
		new Consonne('\u027E', MODE_VIBRANTES_BATTUES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u027D', MODE_VIBRANTES_BATTUES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('\u0278', MODE_FRICATIVES, LIEU_BILABIALES, SON_SOURDE),
		new Consonne('\u03B2', MODE_FRICATIVES, LIEU_BILABIALES, SON_SONORE),
		new Consonne('f', MODE_FRICATIVES, LIEU_LABIODENTALES, SON_SOURDE),
		new Consonne('v', MODE_FRICATIVES, LIEU_LABIODENTALES, SON_SONORE),
		new Consonne('\u03B8', MODE_FRICATIVES, LIEU_DENTALES, SON_SOURDE),
		new Consonne('\u00F0', MODE_FRICATIVES, LIEU_DENTALES, SON_SONORE),
		new Consonne('s', MODE_FRICATIVES, LIEU_ALVEOLAIRES, SON_SOURDE),
		new Consonne('z', MODE_FRICATIVES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u0283', MODE_FRICATIVES, LIEU_POSTALVEOLAIRES, SON_SOURDE),
		new Consonne('\u0292', MODE_FRICATIVES, LIEU_POSTALVEOLAIRES, SON_SONORE),
		new Consonne('\u0282', MODE_FRICATIVES, LIEU_RETROFLEXES, SON_SOURDE),
		new Consonne('\u0290', MODE_FRICATIVES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('ç', MODE_FRICATIVES, LIEU_PALATALES, SON_SOURDE),
		new Consonne('\u029D', MODE_FRICATIVES, LIEU_PALATALES, SON_SONORE),
		new Consonne('x', MODE_FRICATIVES, LIEU_VELAIRES, SON_SOURDE),
		new Consonne('\u0264', MODE_FRICATIVES, LIEU_VELAIRES, SON_SONORE),
		new Consonne('\u03C7', MODE_FRICATIVES, LIEU_UVULAIRES, SON_SOURDE),
		new Consonne('\u0281', MODE_FRICATIVES, LIEU_UVULAIRES, SON_SONORE),
		new Consonne('\u0127', MODE_FRICATIVES, LIEU_PHARYNGALES, SON_SOURDE),
		new Consonne('\u0295', MODE_FRICATIVES, LIEU_PHARYNGALES, SON_SONORE),
		new Consonne('h', MODE_FRICATIVES, LIEU_GLOTTALES, SON_SOURDE),
		new Consonne('\u0266', MODE_FRICATIVES, LIEU_GLOTTALES, SON_SONORE),
		new Consonne('\u026C', MODE_LATERALES_FRICATIVES, LIEU_ALVEOLAIRES, SON_SOURDE),
		new Consonne('\u026E', MODE_LATERALES_FRICATIVES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u0265', MODE_SEMIVOYELLES, LIEU_BILABIALES, SON_SOURDE),
		new Consonne('\u028B', MODE_SEMIVOYELLES, LIEU_LABIODENTALES, SON_SONORE),
		new Consonne('\u0279', MODE_SEMIVOYELLES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u027B', MODE_SEMIVOYELLES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('j', MODE_SEMIVOYELLES, LIEU_PALATALES, SON_SONORE),
		new Consonne('\u0270', MODE_SEMIVOYELLES, LIEU_VELAIRES, SON_SONORE),
		new Consonne('l', MODE_LATERALES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u026D', MODE_LATERALES, LIEU_RETROFLEXES, SON_SONORE),
		new Consonne('\u028E', MODE_LATERALES, LIEU_PALATALES, SON_SONORE),
		new Consonne('L', MODE_LATERALES, LIEU_VELAIRES, SON_SONORE),
		new Consonne("p´", MODE_EJECTIVES, LIEU_BILABIALES, SON_SOURDE),
		new Consonne("t´", MODE_EJECTIVES, LIEU_ALVEOLAIRES, SON_SOURDE),
		new Consonne("\u0288´", MODE_EJECTIVES, LIEU_RETROFLEXES, SON_SOURDE),
		new Consonne("c´", MODE_EJECTIVES, LIEU_PALATALES, SON_SOURDE),
		new Consonne("k´", MODE_EJECTIVES, LIEU_VELAIRES, SON_SOURDE),
		new Consonne("q´", MODE_EJECTIVES, LIEU_UVULAIRES, SON_SOURDE),
		new Consonne('\u01A5', MODE_IMPLOSIVES, LIEU_BILABIALES, SON_SOURDE),
		new Consonne('\u0253', MODE_IMPLOSIVES, LIEU_BILABIALES, SON_SONORE),
		new Consonne('\u01AD', MODE_IMPLOSIVES, LIEU_ALVEOLAIRES, SON_SOURDE),
		new Consonne('\u0257', MODE_IMPLOSIVES, LIEU_ALVEOLAIRES, SON_SONORE),
		new Consonne('\u0188', MODE_IMPLOSIVES, LIEU_PALATALES, SON_SOURDE),
		new Consonne('\u0284', MODE_IMPLOSIVES, LIEU_PALATALES, SON_SONORE),
		new Consonne('\u0199', MODE_IMPLOSIVES, LIEU_VELAIRES, SON_SOURDE),
		new Consonne('\u0260', MODE_IMPLOSIVES, LIEU_VELAIRES, SON_SONORE),
		new Consonne('\u02A0', MODE_IMPLOSIVES, LIEU_UVULAIRES, SON_SOURDE),
		new Consonne('\u029B', MODE_IMPLOSIVES, LIEU_UVULAIRES, SON_SONORE)
	};
	
}
