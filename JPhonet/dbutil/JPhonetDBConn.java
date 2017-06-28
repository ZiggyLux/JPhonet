package dbutil;

import app.JPhonet;

public class JPhonetDBConn {
	// Le driver à utiliser
	String driver;
	
	// Le nom de la base de données
	String dbName;
	
	// Localisation de la base de données
	String connectionURL;
	
	public JPhonetDBConn() {
		this.driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		this.dbName = JPhonet.defaultProps.getDBname();		
		
		// La base de données doit exister
		//   Elle pourra être initialisée avec une base d'exemples
		this.connectionURL = "jdbc:derby:" + dbName + ";create=false";
	}
	
	public String getDriver() {
		return driver;
	}
	
	public String getDBName() {
		return dbName;
	}
	
	public String getConnectionURL() {
		return connectionURL;
	}
	
}
