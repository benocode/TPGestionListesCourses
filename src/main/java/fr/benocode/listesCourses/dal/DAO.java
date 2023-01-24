package fr.benocode.listesCourses.dal;

import fr.benocode.appli.suiviDesRepas.bo.Repas;

import java.util.List;

import fr.benocode.appli.suiviDesRepas.BusinessException;

public interface DAO {
	
	public void insert(Repas repas) throws BusinessException;
	public List<Repas> selectAll() throws BusinessException;
}
