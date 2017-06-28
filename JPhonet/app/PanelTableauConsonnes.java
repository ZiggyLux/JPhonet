package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauConsonnes.java                                         
  Derni�re MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Br�ve description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauConsonnes extends PanelTableauValeurs {

	protected static JButton[] arrButtonConsonnes=null; 

	public void remplir(ActionListener al) {
		// Intitul�s des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		buildConstraints(constraints, 0, 1, 2, 1, 100, 100);
		JLabel labelOcclusives = new JLabel("occlusives");
		gridbag.setConstraints(labelOcclusives, constraints);
		add(labelOcclusives);
				
		buildConstraints(constraints, 0, 2, 2, 1, 100, 100);
		JLabel labelNasales = new JLabel("nasales");
		gridbag.setConstraints(labelNasales, constraints);
		add(labelNasales);
				
		buildConstraints(constraints, 0, 3, 2, 1, 100, 100);
		JLabel labelVibrantesRoulees = new JLabel("vibrantes roul�es");
		gridbag.setConstraints(labelVibrantesRoulees, constraints);
		add(labelVibrantesRoulees);
				
		buildConstraints(constraints, 0, 4, 2, 1, 100, 100);
		JLabel labelVibrantesBattues = new JLabel("vibrantes battues");
		gridbag.setConstraints(labelVibrantesBattues, constraints);
		add(labelVibrantesBattues);
				
		buildConstraints(constraints, 0, 5, 2, 1, 100, 100);
		JLabel labelFricatives = new JLabel("fricatives");
		gridbag.setConstraints(labelFricatives, constraints);
		add(labelFricatives);
				
		buildConstraints(constraints, 0, 6, 2, 1, 100, 100);
		JLabel labelLateralesFricatives = new JLabel("lat�rales fricatives");
		gridbag.setConstraints(labelLateralesFricatives, constraints);
		add(labelLateralesFricatives);
				
		buildConstraints(constraints, 0, 7, 2, 1, 100, 100);
		JLabel labelSemiVoyelles = new JLabel("semi-voyelles");
		gridbag.setConstraints(labelSemiVoyelles, constraints);
		add(labelSemiVoyelles);
				
		buildConstraints(constraints, 0, 8, 2, 1, 100, 100);
		JLabel labelLaterales = new JLabel("lat�rales");
		gridbag.setConstraints(labelLaterales, constraints);
		add(labelLaterales);
				
		buildConstraints(constraints, 0, 9, 2, 1, 100, 100);
		JLabel labelEjectives = new JLabel("�jectives");
		gridbag.setConstraints(labelEjectives, constraints);
		add(labelEjectives);
				
		buildConstraints(constraints, 0, 10, 2, 1, 100, 100);
		JLabel labelImplosives = new JLabel("implosives");
		gridbag.setConstraints(labelImplosives, constraints);
		add(labelImplosives);
		
		// Intitul� des colonnes
		buildConstraints(constraints, 2, 0, 2, 1, 100, 100);
		JLabel labelBilabiales = new JLabel("bilabiales");
		gridbag.setConstraints(labelBilabiales, constraints);
		add(labelBilabiales);
		
		buildConstraints(constraints, 4, 0, 2, 1, 100, 100);
		JLabel labelLabioDentales = new JLabel("labio-dentales");
		gridbag.setConstraints(labelLabioDentales, constraints);
		add(labelLabioDentales);
		
		buildConstraints(constraints, 6, 0, 2, 1, 100, 100);
		JLabel labelDentales = new JLabel("dentales");
		gridbag.setConstraints(labelDentales, constraints);
		add(labelDentales);
		
		buildConstraints(constraints, 8, 0, 2, 1, 100, 100);
		JLabel labelAlveolaires = new JLabel("alv�olaires");
		gridbag.setConstraints(labelAlveolaires, constraints);
		add(labelAlveolaires);
		
		buildConstraints(constraints, 10, 0, 2, 1, 100, 100);
		JLabel labelPostAlveolaires = new JLabel("post-alv�olaires");
		gridbag.setConstraints(labelPostAlveolaires, constraints);
		add(labelPostAlveolaires);
		
		buildConstraints(constraints, 12, 0, 2, 1, 100, 100);
		JLabel labelRetroflexes = new JLabel("r�troflexes");
		gridbag.setConstraints(labelRetroflexes, constraints);
		add(labelRetroflexes);
		
		buildConstraints(constraints, 14, 0, 2, 1, 100, 100);
		JLabel labelPalatales = new JLabel("palatales");
		gridbag.setConstraints(labelPalatales, constraints);
		add(labelPalatales);
		
		buildConstraints(constraints, 16, 0, 2, 1, 100, 100);
		JLabel labelVelaires = new JLabel("v�laires");
		gridbag.setConstraints(labelVelaires, constraints);
		add(labelVelaires);
		
		buildConstraints(constraints, 18, 0, 2, 1, 100, 100);
		JLabel labelUvulaires = new JLabel("uvulaires");
		gridbag.setConstraints(labelUvulaires, constraints);
		add(labelUvulaires);
		
		buildConstraints(constraints, 20, 0, 2, 1, 100, 100);
		JLabel labelPharyngales = new JLabel("Pharyngales");
		gridbag.setConstraints(labelPharyngales, constraints);
		add(labelPharyngales);
		
		buildConstraints(constraints, 22, 0, 2, 1, 100, 100);
		JLabel labelGlottales = new JLabel("Glottales");
		gridbag.setConstraints(labelGlottales, constraints);
		add(labelGlottales);
		
		// L�gende
		buildConstraints(constraints, 0, 11, 24, 1, 100, 100);
		JLabel labelLegende = new JLabel("L� o� les symboles apparaissent en paire, celui de droite repr�sente la consonne sonore.");
		gridbag.setConstraints(labelLegende, constraints);
		add(labelLegende);
		
		// Chargement du tableau des consonnes
		int i;
		arrButtonConsonnes = new JButton[Consonne.arrConsonnes.length];
		for (i = 0; i < Consonne.arrConsonnes.length; i++) {
			int lig = 1 + Consonne.arrConsonnes[i].iLigne;
			int col = 2 * (1 + Consonne.arrConsonnes[i].iColonne)  + Consonne.arrConsonnes[i].iSon;
			buildConstraints(constraints, col, lig,	1, 1, 100, 100);
			arrButtonConsonnes[i] = new JButton(Consonne.arrConsonnes[i].str);
			arrButtonConsonnes[i].setFont(fontPhonetique);
			arrButtonConsonnes[i].addActionListener(al);
			gridbag.setConstraints(arrButtonConsonnes[i], constraints);
			add(arrButtonConsonnes[i]);
		}
		
		constraints.fill = GridBagConstraints.BOTH;
	}
}
