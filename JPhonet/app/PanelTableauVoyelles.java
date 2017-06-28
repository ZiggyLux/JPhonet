package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauVoyelles.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauVoyelles extends PanelTableauValeurs {

	protected static JButton[] arrButtonVoyelles=null; 

	public void remplir(ActionListener al) {
		// Intitulés des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		buildConstraints(constraints, 0, 1, 2, 2, 100, 100);
		JLabel labelFermees = new JLabel("fermées");
		gridbag.setConstraints(labelFermees, constraints);
		add(labelFermees);
				
		buildConstraints(constraints, 0, 3, 2, 2, 100, 100);
		JLabel labelSemifermees = new JLabel("semi-fermées");
		gridbag.setConstraints(labelSemifermees, constraints);
		add(labelSemifermees);
				
		buildConstraints(constraints, 0, 5, 2, 2, 100, 100);
		JLabel labelSemiouvertes = new JLabel("semi-ouvertes");
		gridbag.setConstraints(labelSemiouvertes, constraints);
		add(labelSemiouvertes);
				
		buildConstraints(constraints, 0, 7, 2, 2, 100, 100);
		JLabel labelOuvertes = new JLabel("ouvertes");
		gridbag.setConstraints(labelOuvertes, constraints);
		add(labelOuvertes);
		
		// Intitulé des colonnes
		buildConstraints(constraints, 2, 0, 5, 1, 100, 100);
		JLabel labelVPalatales = new JLabel("palatales");
		gridbag.setConstraints(labelVPalatales, constraints);
		add(labelVPalatales);
		
		buildConstraints(constraints, 8, 0, 4, 1, 100, 100);
		JLabel labelVCentrales = new JLabel("centrales");
		gridbag.setConstraints(labelVCentrales, constraints);
		add(labelVCentrales);
		
		buildConstraints(constraints, 12, 0, 2, 1, 100, 100);
		JLabel labelVVelaires = new JLabel("vélaires");
		gridbag.setConstraints(labelVVelaires, constraints);
		add(labelVVelaires);
		
		// Chargement du tableau des voyelles
		int i;
		arrButtonVoyelles = new JButton[Voyelle.arrVoyelles.length];
		for (i = 0; i < Voyelle.arrVoyelles.length; i++) {
			int lig = 1 + Voyelle.arrVoyelles[i].iLigne;
			int col = 3 + Voyelle.arrVoyelles[i].iColonne;
			buildConstraints(constraints, col, lig,	1, 1, 100, 100);
			arrButtonVoyelles[i] = new JButton(Voyelle.arrVoyelles[i].str);
			arrButtonVoyelles[i].setFont(fontPhonetique);
			arrButtonVoyelles[i].addActionListener(al);
			gridbag.setConstraints(arrButtonVoyelles[i], constraints);
			add(arrButtonVoyelles[i]);
		}
		
		constraints.fill = GridBagConstraints.BOTH;
	}
}
