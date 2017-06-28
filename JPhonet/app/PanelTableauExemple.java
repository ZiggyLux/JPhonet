package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.A                                                   
  Plateforme.......... *                                                     
  Source.............. PanelTableauExemple.java                                         
  Dernière MAJ........                                                       
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description...                                                       
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.*;

import dbutil.JPhonetDBConn;

public class PanelTableauExemple extends JPanel {

	JButton arrBouton[];
	JCheckBox arrCheckboxExiste[];
	JTextField arrTxtExemples[];
	
	protected void buildConstraints(GridBagConstraints gbc,
			int gx,	// Indice colonne du bord gauche (zero-basé)
			int gy,	// Indice ligne du bord haut (zéro-basé)
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

	public void setToutBoutonActif(boolean f) {
		int i;
		for (i = 0; i < Langue.arrLangue.length; i++) {
			arrBouton[i].setEnabled(f);
		}		
	}
	
	public void remplir(ActionListener al) {
		// Intitulés des lignes
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		setLayout(gridbag);
		
		// Chargement des exemples de langues
		int i;
		arrBouton = new JButton[Langue.arrLangue.length];
		arrCheckboxExiste = new JCheckBox[Langue.arrLangue.length];
		arrTxtExemples = new  JTextField[Langue.arrLangue.length];
		for (i = 0; i < Langue.arrLangue.length; i++) {
			// Construction de chaque ligne d'exemples
			
			// Le bouton
			buildConstraints(constraints, 0, i, 1, 1, 100, 100);
			arrBouton[i] = new JButton(Langue.arrLangue[i].strIso);
			arrBouton[i].setEnabled(false);
			gridbag.setConstraints(arrBouton[i], constraints);
			arrBouton[i].addActionListener(al);
			add(arrBouton[i]);
			
			// L'indicateur d'existence
			buildConstraints(constraints, 1, i, 1, 1, 100, 100);
			arrCheckboxExiste[i] = new JCheckBox();
			arrCheckboxExiste[i].setSelected(true);
			arrCheckboxExiste[i].setEnabled(false);
			gridbag.setConstraints(arrCheckboxExiste[i], constraints);
			add(arrCheckboxExiste[i]);
			
			// Le texte des exemples
			buildConstraints(constraints, 2, i, 50, 1, 100, 100);
			arrTxtExemples[i] = new JTextField("");
			arrTxtExemples[i].setColumns(50);
			arrTxtExemples[i].setEnabled(false);
			arrTxtExemples[i].setFont(PanelTableauValeurs.fontPhonetique);
			gridbag.setConstraints(arrTxtExemples[i], constraints);
			add(arrTxtExemples[i]);
		}
		constraints.fill = GridBagConstraints.BOTH;
	}
	
	
	public void rafraichirExemples(Connection conn, String strVal, int iLangue) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			// Récupération de la valeur
			pstmt = conn.prepareStatement(
					"SELECT str_langueiso, str_valeur, str_exemples"
					+ " FROM exemple"
            		+ " WHERE str_langueiso= ?"
            		+ "   AND str_valeur=\'" + strVal + "\'",
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);

			int iFrom = (iLangue == -1)? 0: iLangue;
			int iTo = (iLangue == -1)? Langue.arrLangue.length: iLangue + 1;
            for (int i=iFrom; i < iTo; i++) {
            	pstmt.setString(1, Langue.arrLangue[i].strIso);
                rs = pstmt.executeQuery();
            	
        		String strExemples="";
                if (rs.next()) {
               		strExemples = rs.getString("str_exemples");
                }
            	arrTxtExemples[i].setText(strExemples);
            }
            
		} catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        
		} finally {
        	if (rs!=null) {
        		try { rs.close(); } catch(SQLException sqlEx) { /* ignore */ }
        		rs=null;
        	}
        	if (pstmt!=null) {
        		try { pstmt.close(); } catch(SQLException sqlEx) { /* ignore */ }
        		pstmt=null;
        	}
        }
	}
	
	public void rafraichirExemples(String strVal, int iLangue) {
		// Connexion à la base de données
		Connection conn=null;

		conn = JPhonet.etablirConnectionDB();
		if (conn==null) return;
		
		rafraichirExemples(conn, strVal, iLangue);
			
   		try { conn.close(); } catch(SQLException sqlEx) { /* ignore */ }
        conn=null;
	}

}
