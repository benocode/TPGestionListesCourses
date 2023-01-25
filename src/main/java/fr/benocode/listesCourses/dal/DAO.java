package fr.benocode.listesCourses.dal;

import java.util.List;

import fr.benocode.listesCourses.BusinessException;

public interface DAO<T> {
	
	public T selectById(int id) throws BusinessException;

	public List<T> selectAll() throws BusinessException;

	public void update(T object) throws BusinessException;

	public void insert(T object) throws BusinessException;

	public void delete(int id) throws BusinessException;
}
