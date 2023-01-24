package fr.benocode.listesCourses.dal;

public abstract class DAOFactory {
	
	public static DAO getRepasDAO()
	{
		return new ArticleDAOJdbcImpl();
	}
}