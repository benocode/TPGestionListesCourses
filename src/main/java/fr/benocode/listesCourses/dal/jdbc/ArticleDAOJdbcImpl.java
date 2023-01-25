package fr.benocode.listesCourses.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.benocode.listesCourses.BusinessException;
import fr.benocode.listesCourses.bo.Article;
import fr.benocode.listesCourses.dal.CodesResultatDAL;
import fr.benocode.listesCourses.dal.DAO;

public class ArticleDAOJdbcImpl implements DAO<Article> {

	private static final String SQL_SELECT_BY_ID = "select * from articles where idArticle=?";
	private static final String SQL_SELECT_ALL = "select * from articles";
	private static final String SQL_SELECT_ALL_BY_IDPANIER = "select * from articles where idPanier=?";
	private static final String SQL_INSERT = "insert into articles (nomArticle,idPanier) values (?,?)";
	private static final String SQL_UPDATE = "update articles set nomArticle=?,idPanier=? where idArticle=?";
	private static final String SQL_DELETE = "delete from articles where idArticle=?";
	
	private PanierDAOJdbcImpl panier;

	@Override
	public Article selectById (int idArticle) throws BusinessException {
		Article article = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, idArticle);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				article = new Article(rs.getInt("idArticle"), rs.getString("nomArticle"), panier.selectById(rs.getInt("idPanier")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJECT_ECHEC);
			throw businessException;
		}
		return article;
	}
	
	@Override
	public List<Article> selectAll() throws BusinessException {
		List<Article> ListeArticles = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
			
			// Traitement du résultat
			while (rs.next()) {
				ListeArticles.add(new Article(rs.getInt("idArticle"), rs.getString("nomArticle"), panier.selectById(rs.getInt("idPanier"))));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJECT_ECHEC);
			throw businessException;
		}
		return ListeArticles;
	}
	
	public List<Article> selectArticlesByPanier(int idPanier) throws BusinessException {
		List<Article> ArticlesDuPanier = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_ALL_BY_IDPANIER);
			pstmt.setInt(1, idPanier);
			ResultSet rs = pstmt.executeQuery();
			
			// Traitement du résultat
			while (rs.next()) {
				ArticlesDuPanier.add(new Article(rs.getInt("idArticle"), rs.getString("nomArticle"), panier.selectById(rs.getInt("idPanier"))));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJECT_ECHEC);
			throw businessException;
		}
		return ArticlesDuPanier;
	}
	
	@Override
	public void insert(Article article) throws BusinessException {
		if(article==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setInt(2, article.getPanier().getIdPanier());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.setIdArticle(rs.getInt("idArticle"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_ECHEC);
			throw businessException;
		}	
	}

	@Override
	public void update(Article article) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setInt(2, article.getPanier().getIdPanier());
			pstmt.setInt(3, article.getIdArticle());
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJECT_ECHEC);
			throw businessException;
		}
	}

	@Override
	public void delete(int idArticle) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, idArticle);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_OBJECT_ECHEC);
			throw businessException;
		}
	}
}
