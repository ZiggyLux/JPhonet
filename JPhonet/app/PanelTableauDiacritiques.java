package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauDiacritiques.java                                         
  Derni�re MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Br�ve description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauDiacritiques extends PanelTableauValeurs {

	protected static JButton[] arrButtonDiacritiques=null; 

	public void remplir(ActionListener al) {
		// Intitul�s des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		buildConstraints(constraints, 0, 1, 1, 1, 100, 100);
		JLabel labelNasalisation = new JLabel("nasalisation");
		gridbag.setConstraints(labelNasalisation, constraints);
		add(labelNasalisation);
				
		buildConstraints(constraints, 0, 2, 1, 1, 100, 100);
		JLabel labelSourdite = new JLabel("sourdit�");
		gridbag.setConstraints(labelSourdite, constraints);
		add(labelSourdite);
				
		buildConstraints(constraints, 0, 3, 1, 1, 100, 100);
		JLabel labelSonorite = new JLabel("sonorit�");
		gridbag.setConstraints(labelSonorite, constraints);
		add(labelSonorite);
				
		buildConstraints(constraints, 0, 4, 1, 1, 100, 100);
		JLabel labelAllongement = new JLabel("allongement");
		gridbag.setConstraints(labelAllongement, constraints);
		add(labelAllongement);
				
		// Intitul� des colonnes
		buildConstraints(constraints, 1, 0, 1, 1, 100, 100);
		JLabel labelDSignes = new JLabel("signes");
		gridbag.setConstraints(labelDSignes, constraints);
		add(labelDSignes);
		
		buildConstraints(constraints, 2, 0, 1, 1, 100, 100);
		JLabel labelDLegende = new JLabel("l�gende");
		gridbag.setConstraints(labelDLegende, constraints);
		add(labelDLegende);
		
		// Chargement du tableau des voyelles
		int i;
		arrButtonDiacritiques = new JButton[Diacritique.arrDiacritiques.length];
		for (i = 0; i < Diacritique.arrDiacritiques.length; i++) {
			int lig = 1 + Diacritique.arrDiacritiques[i].iLigne;
			int col = 1 + Diacritique.arrDiacritiques[i].iColonne;
			buildConstraints(constraints, col, lig,	1, 1, 100, 100);
			arrButtonDiacritiques[i] = new JButton(Diacritique.arrDiacritiques[i].str);
			arrButtonDiacritiques[i].setFont(fontPhonetique);
			arrButtonDiacritiques[i].addActionListener(al);
			gridbag.setConstraints(arrButtonDiacritiques[i], constraints);
			add(arrButtonDiacritiques[i]);
		}

		// Chargement des l�gendes
		
		buildConstraints(constraints, 2, 1, 1, 1, 100, 100);
		JLabel labelDNasalisation = new JLabel("nasalisation (a nasalis� dans fanfan), � nasalis� dans brun, parfum");
		gridbag.setConstraints(labelDNasalisation, constraints);
		add(labelDNasalisation);
				
		buildConstraints(constraints, 2, 2, 1, 1, 100, 100);
		JLabel labelDSourdite = new JLabel("par exemple: sourdit� du l");
		gridbag.setConstraints(labelDSourdite, constraints);
		add(labelDSourdite);
				
		buildConstraints(constraints, 2, 3, 1, 1, 100, 100);
		JLabel labelDSonorite = new JLabel("par exemple: passage du s au z");
		gridbag.setConstraints(labelDSonorite, constraints);
		add(labelDSonorite);
				
		buildConstraints(constraints, 2, 4, 1, 1, 100, 100);
		JLabel labelDAllongement = new JLabel("par exemple: u allong� en anglais");
		gridbag.setConstraints(labelDAllongement, constraints);
		add(labelDAllongement);
				
		constraints.fill = GridBagConstraints.BOTH;
	}
}
