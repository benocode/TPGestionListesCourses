package fr.benocode.listesCourses.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.benocode.listesCourses.BusinessException;
import fr.benocode.listesCourses.bo.Panier;
import fr.benocode.listesCourses.dal.CodesResultatDAL;
import fr.benocode.listesCourses.dal.DAO;

public class PanierDAOJdbcImpl implements DAO<Panier> {

	private static final String SQL_SELECT_BY_ID = "select * from paniers where idPanier=?";
	private static final String SQL_SELECT_ALL = "select * from paniers";
	private static final String SQL_INSERT = "insert into paniers (nomPanier) values (?)";
	private static final String SQL_UPDATE = "update paniers set nomPanier=? where idPanier=?";
	private static final String SQL_DELETE = "delete from paniers where idPanier=?";
	

	@Override
	public Panier selectById (int idPanier) throws BusinessException {
		Panier panier = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_BY_ID);
			pstmt.setInt(1, idPanier);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				panier = new Panier(rs.getInt("idPanier"), rs.getString("nomPanier"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJECT_ECHEC);
			throw businessException;
		}
		return panier;
	}
	
	@Override
	public List<Panier> selectAll() throws BusinessException {
		List<Panier> ListePaniers = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
			
			// Traitement du résultat
			while (rs.next()) {
				ListePaniers.add(new Panier(rs.getInt("idPanier"), rs.getString("nomPanier")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJECT_ECHEC);
			throw businessException;
		}
		return ListePaniers;
	}
	
	@Override
	public void insert(Panier panier) throws BusinessException {
		if(panier==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, panier.getNomPanier());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				panier.setIdPanier(rs.getInt("idPanier"));
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
	public void update(Panier panier) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, panier.getNomPanier());
			pstmt.setInt(2, panier.getIdPanier());
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
	public void delete(int idPanier) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, idPanier);
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
