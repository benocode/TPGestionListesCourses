package fr.benocode.listesCourses.bll;

import java.util.List;

import fr.benocode.listesCourses.BusinessException;
import fr.benocode.listesCourses.bo.Article;
import fr.benocode.listesCourses.dal.DAO;
import fr.benocode.listesCourses.dal.DAOFactory;

public class ArticleManager {

	private DAO<Article> daoArticle;

	public ArticleManager() throws BusinessException {
		this.daoArticle = DAOFactory.getArticleDAO();
	}
	
	public Article ajouter(String nomArticle) throws BusinessException {
		BusinessException exception = new BusinessException();
		
		Article article = new Article(nomArticle);
		
		this.validerNom(article,exception);

		if(!exception.hasErreurs())
		{
			this.daoArticle.insert(article);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return article;
	}
	
	public List<Article> visualiser() throws BusinessException {
		return this.daoArticle.selectAll();
	}
	
	private void validerNom(Article article, BusinessException businessException)
	{
		if(article.getNomArticle() == null || article.getNomArticle().isBlank() || article.getNomArticle().length()>200)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_NOM_ERREUR);
		}
	}
}