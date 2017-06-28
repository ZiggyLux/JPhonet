
package app;
/****************************************************************************
  Application......... JPhonet                                                 
  Version............. 1.B 1.1                                                   
  Plateforme.......... *                                                     
  Source.............. JPhonet.java                                         
  Dernière MAJ........ 13/06/17                                                      
  Auteur.............. Marc CESARINI                                         
  Remarque............ Standard Java                                         
  Brève description... Classe principale de l'application                                                      
                                                                             
  Emplacement.........                                                       
*****************************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;

import dbutil.JPhonetDBConn;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

public class JPhonet extends JFrame
	implements ActionListener, ClipboardOwner {

	// Exemple
	ExempleValeur exVal;
	
	// Libellés
	static String strTitre = new String("JPhonet");
	
	// Subdivision de l'écran principal de l'application
	
	PanelTableauConsonnes panelTableauConsonnes = new PanelTableauConsonnes();
	JScrollPane scrollTableauConsonnes;
	PanelTableauVoyelles panelTableauVoyelles = new PanelTableauVoyelles();
	JScrollPane scrollTableauVoyelles;
	PanelTableauDiacritiques panelTableauDiacritiques = new PanelTableauDiacritiques();
	JScrollPane scrollTableauDiacritiques;
	PanelTableauHauteurs panelTableauHauteurs = new PanelTableauHauteurs();
	JScrollPane scrollTableauHauteurs;
	PanelTableauIntensites panelTableauIntensites = new PanelTableauIntensites();
	JScrollPane scrollTableauIntensites;
	
	JPanel panelFiltresEtExemplesBas = new JPanel();

	JPanel panelFiltres = new JPanel();
	JCheckBox arrCheckBox[];

	JPanel panelBarreBoutonsBas = new JPanel();
	
	JButton buttonEffacer = new JButton("Effacer");
	
	JButton buttonCopier = new JButton("Copier");
	private Clipboard clipboard;
	
	JTextField txtfldMot = new JTextField();
	
	String strValeur;
	JButton buttonQuitter = new JButton("Quitter");
	PanelTableauExemple panelExemples = new PanelTableauExemple();
	JScrollPane scrollTableauExemples;
	
	// Enumération des tableaux de valeurs
	static final int
		iTableauConsonnes = 0,
		iTableauVoyelles = 1,
		iTableauDiacritiques = 2,
		iTableauIntensité = 3,
		iTableauHauteur = 4;
	int iTableau = iTableauVoyelles; // iTableauConsonnes;

	// Propriétés générales
	public static JPhonetProperties defaultProps;
	
	// Données de connection à la BD
	static String strDBname;
	
	JPhonet(String strTit) {
		super(strTit);
		setSize(1150, 700);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		// Préparation des tableau de valeurs
		panelTableauConsonnes.remplir(this);
		scrollTableauConsonnes = new JScrollPane(panelTableauConsonnes,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);
		
		panelTableauVoyelles.remplir(this);
		scrollTableauVoyelles = new JScrollPane(panelTableauVoyelles,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);

		panelTableauDiacritiques.remplir(this);
		scrollTableauDiacritiques = new JScrollPane(panelTableauDiacritiques,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);

		panelTableauHauteurs.remplir(this);
		scrollTableauHauteurs = new JScrollPane(panelTableauHauteurs,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);

		panelTableauIntensites.remplir(this);
		scrollTableauIntensites = new JScrollPane(panelTableauIntensites,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);

		// Préparation des onglets
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Consonnes", null, scrollTableauConsonnes, "Tableau des consonnes");
		tabbedPane.addTab("Voyelles", null, scrollTableauVoyelles, "Tableau des voyelles");
		tabbedPane.addTab("Diacritiques", null, scrollTableauDiacritiques, "Tableau des diacritiques");
		tabbedPane.addTab("Hauteurs", null, scrollTableauHauteurs, "Tableau des hauteurs");
		tabbedPane.addTab("Intensités", null, scrollTableauIntensites, "Tableau des intensités");
		
		p.add("Center", tabbedPane);
		
		// Préparation de la zone Filtres et exemples
		panelFiltres.setLayout(new GridLayout(5, 1, 5, 5));
		// Chargement des boîtes de langues
		int i;
		arrCheckBox = new JCheckBox[Langue.arrLangue.length];
		for (i = 0; i < arrCheckBox.length; i++) {
			arrCheckBox[i] = new JCheckBox(Langue.arrLangue[i].strNom, true);
			panelFiltres.add(arrCheckBox[i]);
		}
		
		panelBarreBoutonsBas.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		buttonEffacer.setEnabled(false);
		buttonEffacer.addActionListener(this);
		panelBarreBoutonsBas.add(buttonEffacer);
		
		clipboard = getToolkit().getSystemClipboard();
		buttonCopier.setEnabled(false);
		buttonCopier.addActionListener(this);
		panelBarreBoutonsBas.add(buttonCopier);
		
		txtfldMot.setFont(PanelTableauValeurs.fontPhonetique);
		txtfldMot.setColumns(20);
		panelBarreBoutonsBas.add(txtfldMot);
		
		panelBarreBoutonsBas.add(buttonQuitter);
		
		panelFiltresEtExemplesBas.setLayout(new BorderLayout());
		panelFiltresEtExemplesBas.add("North", panelBarreBoutonsBas);
		panelFiltresEtExemplesBas.add("West", panelFiltres);
		
		panelExemples.remplir(this);
		scrollTableauExemples = new JScrollPane(panelExemples,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
				);
		panelFiltresEtExemplesBas.add("Center", scrollTableauExemples);
		
		p.add("South", panelFiltresEtExemplesBas);

		setContentPane(p);
	}
	
	// -- Gestionnaire d'évènements
	
	// Edition des exemples liés à une valeur phonétique
	public void modifieExempleValeur(int iLangue) {
		// Connexion à la base de données
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = etablirConnectionDB();

			// Récupération de la valeur
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);
            rs = stmt.executeQuery(
            		"SELECT str_langueiso, str_valeur, str_exemples"
            		+ " FROM exemple"
            		+ " WHERE str_langueiso=\'" + Langue.arrLangue[iLangue].strIso + "\'"
            		+ "   AND str_valeur=\'" + strValeur + "\'");

    		String strExemples="";
            boolean fExisting = false;
            if (rs.next()) {
            	fExisting = true;
           		strExemples = rs.getString("str_exemples");
            }
            
            // Boîte de dialogue de modification
            JOptionPane op = new JOptionPane(
            		"Veuillez entrer vos exemples",	// message
            		JOptionPane.PLAIN_MESSAGE,		// messageType
            		JOptionPane.OK_CANCEL_OPTION	// optionType
            		);
            op.setWantsInput(true);
            op.setInitialSelectionValue(strExemples);
            op.setFont(PanelTableauValeurs.fontPhonetique);
            JDialog dlg = op.createDialog(null, Langue.arrLangue[iLangue].strNom);
            dlg.setVisible(true);	
            
            // Test de la sortie de la boîte de dialogue et màj table
            Object selectedValue = op.getValue();
            if (selectedValue != null
            	&& selectedValue instanceof Integer
            		&& ((Integer) selectedValue).intValue() == JOptionPane.OK_OPTION) {
            	String strModified = (String) op.getInputValue();
            	if (fExisting) {
               		rs.updateString("str_exemples", strModified);
                	rs.updateRow();
            	} else {
            		rs.moveToInsertRow();
            		rs.updateString("str_langueiso", Langue.arrLangue[iLangue].strIso);
            		rs.updateString("str_valeur", strValeur);
               		rs.updateString("str_exemples", strModified);

            		rs.insertRow();
            		rs.moveToCurrentRow();
            	}

				panelExemples.rafraichirExemples(conn, strValeur, iLangue);
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
        	if (stmt!=null) {
        		try { stmt.close(); } catch(SQLException sqlEx) { /* ignore */ }
        		stmt=null;
        	}
        	if (conn!=null) {
        		try { conn.close(); } catch(SQLException sqlEx) { /* ignore */ }
        		conn=null;
        	}
        }
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();

		// Recherche si l'évènement provient d'un des boutons voyelles
		if (PanelTableauVoyelles.arrButtonVoyelles != null) {
			int i;
			for (i=0; i<PanelTableauVoyelles.arrButtonVoyelles.length; i++) {
				if (src == PanelTableauVoyelles.arrButtonVoyelles[i]) {
					// Une touche-valeur a été frappée, on copie dans le mot-buffer
					strValeur = PanelTableauVoyelles.arrButtonVoyelles[i].getText();
					String str = txtfldMot.getText() + strValeur;
					txtfldMot.setText(str);
					
					panelExemples.setToutBoutonActif(true);
					panelExemples.rafraichirExemples(strValeur, -1);
				}
			}
		}
		
		// Recherche si l'évènement provient d'un des boutons consonnes
		if (PanelTableauConsonnes.arrButtonConsonnes != null) {
			int i;
			for (i=0; i<PanelTableauConsonnes.arrButtonConsonnes.length; i++) {
				if (src == PanelTableauConsonnes.arrButtonConsonnes[i]) {
					// Une touche-valeur a été frappée, on copie dans le mot-buffer
					strValeur = PanelTableauConsonnes.arrButtonConsonnes[i].getText();
					String str = txtfldMot.getText() + strValeur;
					txtfldMot.setText(str);
					
					panelExemples.setToutBoutonActif(true);
					panelExemples.rafraichirExemples(strValeur, -1);
				}
			}
		}
		
		// Recherche si l'évènement provient d'un des boutons diacritiques
		if (PanelTableauDiacritiques.arrButtonDiacritiques != null) {
			int i;
			for (i=0; i<PanelTableauDiacritiques.arrButtonDiacritiques.length; i++) {
				if (src == PanelTableauDiacritiques.arrButtonDiacritiques[i]) {
					// Une touche-valeur a été frappée, on copie dans le mot-buffer
					strValeur = PanelTableauDiacritiques.arrButtonDiacritiques[i].getText();
					String str = txtfldMot.getText() + strValeur;
					txtfldMot.setText(str);
					
					panelExemples.setToutBoutonActif(true);
					panelExemples.rafraichirExemples(strValeur, -1);
				}
			}
		}
		
		// Recherche si l'évènement provient d'un des boutons hauteurs
		if (PanelTableauHauteurs.arrButtonHauteurs != null) {
			int i;
			for (i=0; i<PanelTableauHauteurs.arrButtonHauteurs.length; i++) {
				if (src == PanelTableauHauteurs.arrButtonHauteurs[i]) {
					// Une touche-valeur a été frappée, on copie dans le mot-buffer
					strValeur = PanelTableauHauteurs.arrButtonHauteurs[i].getText();
					String str = txtfldMot.getText() + strValeur;
					txtfldMot.setText(str);
					
					panelExemples.setToutBoutonActif(true);
					panelExemples.rafraichirExemples(strValeur, -1);
				}
			}
		}
		
		// Recherche si l'évènement provient d'un des boutons intensités
		if (PanelTableauIntensites.arrButtonIntensites != null) {
			int i;
			for (i=0; i<PanelTableauIntensites.arrButtonIntensites.length; i++) {
				if (src == PanelTableauIntensites.arrButtonIntensites[i]) {
					// Une touche-valeur a été frappée, on copie dans le mot-buffer
					strValeur = PanelTableauIntensites.arrButtonIntensites[i].getText();
					String str = txtfldMot.getText() + strValeur;
					txtfldMot.setText(str);
					
					panelExemples.setToutBoutonActif(true);
					panelExemples.rafraichirExemples(strValeur, -1);
				}
			}
		}
		
		// Autres boutons
		if (src == buttonEffacer) {
			txtfldMot.setText("");
		} else if (src == buttonCopier) {
			StringSelection strSel = new StringSelection(txtfldMot.getText());
			clipboard.setContents(strSel, this);
		} else {
			int i;
			for (i=0;  i < Langue.arrLangue.length; i++) {
				if (src == panelExemples.arrBouton[i]) {
					modifieExempleValeur(i);
				}
			}
		}
		
		boolean f = (txtfldMot.getText().length()>0);
		buttonEffacer.setEnabled(f);
		buttonCopier.setEnabled(f);
	}
	
	// Méthodes de ClipboardOwner
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
	}

	// Connection à la DB JPhonet
	public static Connection etablirConnectionDB() {
		JPhonetDBConn phocon = new JPhonetDBConn();
		String driver = new String(phocon.getDriver());	
		try {
			/*
			 **  Load the Derby driver. 
			 **     When the embedded Driver is used this action start the Derby engine.
			 **  Catch an error and suggest a CLASSPATH problem
			 */
			Class.forName(driver); 
		} catch(java.lang.ClassNotFoundException e)     {
			System.err.print("ClassNotFoundException: ");
		    System.err.println(e.getMessage());
		    System.out.println("\n    >>> Please check your CLASSPATH variable   <<<\n");
		}
		
		Connection conn=null;
		try {
            // Create (if needed) and connect to the database
            conn = DriverManager.getConnection(phocon.getConnectionURL());		 
		            
		} catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        
            // Message de dialogue d'erreur
            JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return conn;
	}
	
	// Sortie "propre" de Derby en mode "Embedded"
	public static void exitDB() {
        /*** In embedded mode, an application should shut down Derby.
           Shutdown throws the XJ015 exception to confirm success. ***/			
        if ((new JPhonetDBConn()).getDriver().equals("org.apache.derby.jdbc.EmbeddedDriver")) {
           boolean gotSQLExc = false;
           try {
              DriverManager.getConnection("jdbc:derby:;shutdown=true");
           } catch (SQLException se)  {	
              if ( se.getSQLState().equals("XJ015") ) {		
                 gotSQLExc = true;
              }
           }
           if (!gotSQLExc) {
           	  // System.out.println("Database did not shut down normally");
           }  else  {
              // System.out.println("Database shut down normally");	
           }  
        }
		
	}

	// Point d'entrée de l'application
	public static void main(String[] args) {
		// Lecture des propriétés de l'application
		defaultProps = new JPhonetProperties();
		String strEtiqEnvir = defaultProps.getEtiqEnvir();
		String strTitFrm = strTitre + ((strEtiqEnvir == null)? "": " - [" + strEtiqEnvir + "]");
		
		// Gestion de la boîte de dialogue principale
		JFrame f = new JPhonet(strTitFrm);
		ExitWindow exit = new ExitWindow();
		f.addWindowListener(exit);
		f.setVisible(true);
	}

}


