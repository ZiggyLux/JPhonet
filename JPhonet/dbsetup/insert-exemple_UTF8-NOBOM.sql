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
/*		run 'insert-exemple_UTF8-NOBOM.sql';								  */
/*		select * from exemple;												  */
/*----------------------------------------------------------------------------*/

SET SCHEMA APP;

INSERT INTO exemple VALUES 
	('de','Y','f_ü_nf, Gl_ü_ck',NULL),
	('de','h','_H_aus',NULL),
	('de','o','w_oh_l',NULL),
	('de','u','g_u_t',NULL),
	('de','x','Bu_ch_',NULL),
	('de','y','_ü_ber',NULL),
	('de','ç','i_ch_',NULL),
	('de','ø','sch_ö_n',NULL),
	('de','ŋ','Di_ng_',NULL),
	('de','œ','zw_ö_lf',NULL),
	('de','ɔ','S_o_nne',NULL),
	('de','ə','bitt_e_',NULL),
	('de','ɪ','b_i_tte',NULL),
	('de','ɸ','Sch_w_ester',NULL),
	('de','ʃ','_sch_ön',NULL),
	('de','ε','B_e_tt',NULL),
	('en','g','_g_et',NULL),
	('en','h','_h_ome',NULL),
	('en','j','_y_oung {sans friction}',NULL),
	('en','u','f_oo_l {mais allongé}',NULL),
	('en','æ','p_a_t, b_a_g, m_a_d; {anglais du Sud} s_a_t, _a_pple',NULL),
	('en','ð','_th_en',NULL),
	('en','ŋ','ki_ng_',NULL),
	('en','œ','b_i_rd, l_ea_rn, b_u_rn',NULL),
	('en','ɐ','sof_a_',NULL),
	('en','ɑ','f_a_ther, guit_a_r',NULL),
	('en','ɒ','p_o_t, l_o_g; {anglais du Sud} h_o_t, f_o_nd, w_a_sh',NULL),
	('en','ə','_a_bove',NULL),
	('en','ɦ','be_h_ave, man_h_ood',NULL),
	('en','ɪ','s_i_t, p_i_ty',NULL),
	('en','ɹ','dee_r_, nea_r_, he_r_e, pea_r_, the_r_e, poo_r_, mo_r_e, fi_r_e, flowe_r_ (us)',NULL),
	('en','ʊ','f_u_ll, s_oo_t',NULL),
	('en','ʌ','c_u_p, c_o_me',NULL),
	('en','ʒ','mea_s_ure',NULL),
	('en','θ','_th_ick',NULL),
	('es','r','_r_ojo',NULL),
	('es','x','hi_j_o',NULL),
	('es','ð','ca_d_a',NULL),
	('es','ŋ','te_ng_o',NULL),
	('es','ɤ','lue_g_o',NULL),
	('es','ɱ','a_n_fora',NULL),
	('es','ɲ','a_ñ_o',NULL),
	('es','ɾ','pe_r_o',NULL),
	('es','ʎ','ca_ll_e {Europe}',NULL),
	('es','ʒ','{Amérique du Sud} _ll_amar',NULL),
	('es','β','sa_b_er {intervocalique}',NULL),
	('es','θ','{Espagne} pla_c_er, pla_z_a',NULL),
	('fr','R','{grasseyé, typique des faubourgs de Paris}',NULL),
	('fr','a','p_a_tte {parisien?}',NULL),
	('fr','b','_b_aba',NULL),
	('fr','d','_d_ada',NULL),
	('fr','e','th_é_',NULL),
	('fr','f','_f_anfan',NULL),
	('fr','g','_g_are, _gu_é',NULL),
	('fr','h','_h_aricot',NULL),
	('fr','i','s_i_',NULL),
	('fr','j','p_i_ed {yod?}',NULL),
	('fr','k','_c_ancan, _k_épi, _qu_e',NULL),
	('fr','l','_l_it',NULL),
	('fr','m','_m_amam',NULL),
	('fr','n','_n_ana',NULL),
	('fr','o','g_au_che, _eau_',NULL),
	('fr','p','_p_apa, ca_p_',NULL),
	('fr','s','go_ss_e, _ç_a',NULL),
	('fr','t','_t_ata, _t_u, é_t_aler',NULL),
	('fr','u','p_oux_',NULL),
	('fr','v','_v_ie',NULL),
	('fr','y','pl_u_me',NULL),
	('fr','z','_z_igzag',NULL),
	('fr','ø','p_eu_, f_eu_, j_eu_',NULL),
	('fr','œ','p_eu_r, _oeu_f',NULL),
	('fr','ɔ','m_o_rt, d_o_nner',NULL),
	('fr','ə','{e muet} pr_e_mier, l_e_',NULL),
	('fr','ɥ','l_u_i, h_u_ile',NULL),
	('fr','ɲ','a_gn_eau',NULL),
	('fr','ʁ','{r Parisien standard} ',NULL),
	('fr','ʃ','_ch_ichi',NULL),
	('fr','ʒ','_j_eu, _ge_ai',NULL),
	('fr','ʝ','{yod} p_i_ed',NULL),
	('fr','̃','p_ain_, _in_térêts',NULL),
	('fr','ε','m_e_ttre, p_aî_tre',NULL),
	('it','o','c_o_sa',NULL),
	('it','r','_r_osso',NULL),
	('it','u','s_u_bito',NULL),
	('it','ɔ','c_o_sa',NULL),
	('it','ɱ','i_n_vida',NULL),
	('it','ʎ','vo_gl_io, _gl_i',NULL),
	('ru','a','м_я_со {?}',NULL),
	('ru','e','уж_е_',NULL),
	('ru','o','',NULL),
	('ru','r','_р_абота',NULL),
	('ru','u','с_у_п',NULL),
	('ru','v','_в_от',NULL),
	('ru','x','_х_орошо',NULL),
	('ru','ç','мя_г_кий',NULL),
	('ru','ɔ','д_о_м',NULL),
	('ru','ɨ','с_ы_н',NULL),
	('ru','ɸ','_ф_ура',NULL),
	('ru','ʃ','хоро_ш_о',NULL),
	('ru','ʌ','д_о_ма',NULL),
	('ru','ʎ','водите_ль_',NULL),
	('ru','ʒ','у_ж_е',NULL),
	('ru','ε','_э_тот',NULL);

