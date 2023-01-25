package fr.benocode.listesCourses.bll;

import java.util.List;

import fr.benocode.listesCourses.BusinessException;
import fr.benocode.listesCourses.bo.Panier;
import fr.benocode.listesCourses.dal.DAO;
import fr.benocode.listesCourses.dal.DAOFactory;

public class PanierManager {
	
	private DAO<Panier> daoPanier;

	public PanierManager() throws BusinessException {
		this.daoPanier = DAOFactory.getPanierDAO();
	}
	
	public Panier ajouter(String nomPanier) throws BusinessException {
		BusinessException exception = new BusinessException();
		
		Panier panier = new Panier(nomPanier);
		
		this.validerNom(panier,exception);

		if(!exception.hasErreurs())
		{
			this.daoPanier.insert(panier);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return panier;
	}
	
	public List<Panier> visualiser() throws BusinessException {
		return this.daoPanier.selectAll();
	}
	
	private void validerNom(Panier panier, BusinessException businessException)
	{
		if(panier.getNomPanier() == null || panier.getNomPanier().isBlank() || panier.getNomPanier().length()>120)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PANIER_NOM_ERREUR);
		}
	}
}
