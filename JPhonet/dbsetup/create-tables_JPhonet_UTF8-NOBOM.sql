/*----------------------------------------------------------------------------*/
/* Application......... JPhonet                                               */
/* Version............. 1.0                                                   */
/* Plateforme.......... Portable                                              */
/* Source.............. create-tables_JPhonet_UTF8-NOBOM.sql                  */
/* Dernière MAJ........                                                       */
/* Auteur.............. Marc CESARINI                                         */
/* Remarque............ Derby 10											  */
/* Brève description... Création table EXEMPLE comportant les exemples par	  */
/*						lettre de la phonétique            					  */
/*                                                                            */
/* Emplacement......... \                                                     */
/* Création & chargement													  */
/*	1) Lancement de la console en mode UNICODE								  */
/*		Windows-R															  */
/*		puis "cmd /U"														  */
/*	2) Choix d'une police UNICODE											  */
/*		Consolas															  */
/*	3) Choix du codepage à UTF-8											  */
/*		chcp 65001															  */
/*	4) Lancement de ij$JPhonet plaçant le codeset à "UTF8" (via fichier 	  */
/*		properties)															  */
/*	5) Préparation d'un fichier texte DOS UTF8/NOBOM avec insert et caractères*/ 
/*		français, russes, etc..												  */
/*	6) Dans ij																  */
/*		connect 'jdbc:derby:JPhonet';										  */
/*		set schema APP;														  */
/*		run 'create-tables_JPhonet_UTF8-NOBOM.sql';							  */
/*----------------------------------------------------------------------------*/

SET SCHEMA APP;
CREATE TABLE exemple (
	str_langueiso char(2) NOT NULL DEFAULT '',
	str_valeur char(3) NOT NULL DEFAULT '',
	str_exemples varchar(256) DEFAULT NULL,
	str_notes CLOB,
	PRIMARY KEY (str_langueiso, str_valeur)
);