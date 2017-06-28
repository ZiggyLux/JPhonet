package app;
import java.awt.event.*;

public class ExitWindow extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
    	// Fermeture "propre" de la DB
    	JPhonet.exitDB();
    	
        System.exit(0);
    }
}
