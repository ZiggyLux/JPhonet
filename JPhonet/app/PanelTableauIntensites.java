package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauIntensite.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauIntensites extends PanelTableauValeurs {

	protected static JButton[] arrButtonIntensites=null; 

	public void remplir(ActionListener al) {
		// Intitulés des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		buildConstraints(constraints, 0, 1, 1, 1, 100, 100);
		JLabel labelAccentprimaire = new JLabel("accent primaire");
		gridbag.setConstraints(labelAccentprimaire, constraints);
		add(labelAccentprimaire);
				
		buildConstraints(constraints, 0, 2, 1, 1, 100, 100);
		JLabel labelAccentsecondaire = new JLabel("accent secondaire");
		gridbag.setConstraints(labelAccentsecondaire, constraints);
		add(labelAccentsecondaire);
				
		// Intitulé des colonnes
		buildConstraints(constraints, 1, 0, 1, 1, 100, 100);
		JLabel labelISignes = new JLabel("signes");
		gridbag.setConstraints(labelISignes, constraints);
		add(labelISignes);
		
		// Chargement du tableau des hauteurs
		int i;
		arrButtonIntensites = new JButton[Intensite.arrIntensites.length];
		for (i = 0; i < Intensite.arrIntensites.length; i++) {
			int lig = 1 + Intensite.arrIntensites[i].iLigne;
			int col = 1 + Intensite.arrIntensites[i].iColonne;
			buildConstraints(constraints, col, lig,	1, 1, 100, 100);
			arrButtonIntensites[i] = new JButton(Intensite.arrIntensites[i].str);
			arrButtonIntensites[i].setFont(fontPhonetique);
			arrButtonIntensites[i].addActionListener(al);
			gridbag.setConstraints(arrButtonIntensites[i], constraints);
			add(arrButtonIntensites[i]);
		}

		constraints.fill = GridBagConstraints.BOTH;
	}
}
