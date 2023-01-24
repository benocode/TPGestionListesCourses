package fr.benocode.listesCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.benocode.appli.suiviDesRepas.BusinessException;
import fr.benocode.appli.suiviDesRepas.bo.Repas;

public class ArticleDAOJdbcImpl implements DAO {

	private static final String INSERT="INSERT INTO suivi_des_repas(date, menu) VALUES(?,?);";
	private static final String SELECT_ALL="SELECT * FROM suivi_des_repas;";
	
	@Override
	public void insert(Repas repas) throws BusinessException {
		if(repas==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			pstmt.setObject(1, repas.getDate());
			pstmt.setString(2, repas.getMenu());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}	
	}

	@Override
	public List<Repas> selectAll() throws BusinessException {
		List<Repas> ListeRepas = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			// Traitement du résultat
			while (rs.next()) {
				ListeRepas.add(new Repas(rs.getTimestamp("date").toLocalDateTime(), rs.getString("menu")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_OBJETS_ECHEC);
			throw businessException;
		}
		return ListeRepas;
	}
}
