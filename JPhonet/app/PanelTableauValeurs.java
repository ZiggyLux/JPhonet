package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauValeurs.java                                         
  Derni�re MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Br�ve description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelTableauValeurs extends JPanel {

	static final Font fontPhonetique = new Font("Lucida Sans Unicode", Font.PLAIN, 14);

	protected void buildConstraints(GridBagConstraints gbc,
			int gx,	// Indice colonne du bord gauche (zero-bas�)
			int gy,	// Indice ligne du bord haut (z�ro-bas�)
			int gw,	// Nombre de cellules en largeur 
			int gh, // Nombre de cellules en hauteur
			int wx, // Proportion% en largeur
			int wy	// Proportion% en hauteur
			) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.weightx = wx;
		gbc.weighty = wy;
	}
	
	public void remplir(ActionListener al) {}

}
