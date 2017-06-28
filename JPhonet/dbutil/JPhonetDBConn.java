package dbutil;

import app.JPhonet;

public class JPhonetDBConn {
	// Le driver � utiliser
	String driver;
	
	// Le nom de la base de donn�es
	String dbName;
	
	// Localisation de la base de donn�es
	String connectionURL;
	
	public JPhonetDBConn() {
		this.driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		this.dbName = JPhonet.defaultProps.getDBname();		
		
		// La base de donn�es doit exister
		//   Elle pourra �tre initialis�e avec une base d'exemples
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
