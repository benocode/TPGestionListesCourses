package fr.benocode.listesCourses.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_ARTICLE_NULL=10000;
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_ARTICLE_ECHEC=10001;
	
	/**
	 * Echec de l'extraction des données
	 */
	public static final int SELECT_ALL_ARTICLES_ECHEC=10002;
	
	/**
	 * Echec de l'extraction des données
	 */
	public static final int SELECT_BY_ID_ARTICLE_ECHEC=10003;
	
	/**
	 * Echec de l'extraction des données
	 */
	public static final int UPDATE_ARTICLE_ECHEC=10004;
	
	
}
