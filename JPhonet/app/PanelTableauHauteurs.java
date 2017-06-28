package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauHauteurs.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauHauteurs extends PanelTableauValeurs {

	protected static JButton[] arrButtonHauteurs=null; 

	public void remplir(ActionListener al) {
		// Intitulés des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		buildConstraints(constraints, 0, 1, 1, 1, 100, 100);
		JLabel labelTreshautmontant = new JLabel("très haut montant");
		gridbag.setConstraints(labelTreshautmontant, constraints);
		add(labelTreshautmontant);
				
		buildConstraints(constraints, 0, 2, 1, 1, 100, 100);
		JLabel labelHautmontant = new JLabel("haut montant");
		gridbag.setConstraints(labelHautmontant, constraints);
		add(labelHautmontant);
				
		buildConstraints(constraints, 0, 3, 1, 1, 100, 100);
		JLabel labelHaut = new JLabel("haut");
		gridbag.setConstraints(labelHaut, constraints);
		add(labelHaut);
				
		buildConstraints(constraints, 0, 4, 1, 1, 100, 100);
		JLabel labelBas = new JLabel("bas");
		gridbag.setConstraints(labelBas, constraints);
		add(labelBas);
				
		buildConstraints(constraints, 0, 5, 1, 1, 100, 100);
		JLabel labelTresbas = new JLabel("très bas");
		gridbag.setConstraints(labelTresbas, constraints);
		add(labelTresbas);
				
		buildConstraints(constraints, 0, 6, 1, 1, 100, 100);
		JLabel labelBasmontant = new JLabel("bas montant");
		gridbag.setConstraints(labelBasmontant, constraints);
		add(labelBasmontant);
				
		buildConstraints(constraints, 0, 7, 1, 1, 100, 100);
		JLabel labelBasdescendant = new JLabel("bas descendant");
		gridbag.setConstraints(labelBasdescendant, constraints);
		add(labelBasdescendant);
				
		buildConstraints(constraints, 0, 8, 1, 1, 100, 100);
		JLabel labelHautdescendant = new JLabel("haut descendant");
		gridbag.setConstraints(labelHautdescendant, constraints);
		add(labelHautdescendant);
				
		buildConstraints(constraints, 0, 9, 1, 1, 100, 100);
		JLabel labelMontantdescendant = new JLabel("montant descendant");
		gridbag.setConstraints(labelMontantdescendant, constraints);
		add(labelMontantdescendant);
				
		buildConstraints(constraints, 0, 10, 1, 1, 100, 100);
		JLabel labelDescendantmontant = new JLabel("descendant montant");
		gridbag.setConstraints(labelDescendantmontant, constraints);
		add(labelDescendantmontant);
				
		// Intitulé des colonnes
		buildConstraints(constraints, 1, 0, 1, 1, 100, 100);
		JLabel labelHSignes = new JLabel("signes");
		gridbag.setConstraints(labelHSignes, constraints);
		add(labelHSignes);
		
		// Chargement du tableau des hauteurs
		int i;
		arrButtonHauteurs = new JButton[Hauteur.arrHauteurs.length];
		for (i = 0; i < Hauteur.arrHauteurs.length; i++) {
			int lig = 1 + Hauteur.arrHauteurs[i].iLigne;
			int col = 1 + Hauteur.arrHauteurs[i].iColonne;
			buildConstraints(constraints, col, lig,	1, 1, 100, 100);
			arrButtonHauteurs[i] = new JButton(Hauteur.arrHauteurs[i].str);
			arrButtonHauteurs[i].setFont(fontPhonetique);
			arrButtonHauteurs[i].addActionListener(al);
			gridbag.setConstraints(arrButtonHauteurs[i], constraints);
			add(arrButtonHauteurs[i]);
		}

		constraints.fill = GridBagConstraints.BOTH;
	}
}
