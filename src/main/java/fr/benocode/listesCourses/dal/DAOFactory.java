package fr.benocode.listesCourses.dal;

import fr.benocode.listesCourses.bo.Article;
import fr.benocode.listesCourses.bo.Panier;
import fr.benocode.listesCourses.dal.jdbc.ArticleDAOJdbcImpl;
import fr.benocode.listesCourses.dal.jdbc.PanierDAOJdbcImpl;

public abstract class DAOFactory {
	
	private static DAO<Article> articleDAO;
	private static DAO<Panier> panierDAO;
	
	public static DAO<Article> getArticleDAO() {
		if (articleDAO == null) {
			articleDAO = new ArticleDAOJdbcImpl();
		}
		return articleDAO;
	}
	
	public static DAO<Panier> getPanierDAO() {
		if (panierDAO == null) {
			panierDAO = new PanierDAOJdbcImpl();
		}
		return panierDAO;
	}
}