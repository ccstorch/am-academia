package br.com.acad.dao.generico.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.interf.DAO;

public class DAOImpl<T,K> implements DAO<T,K>{

	@PersistenceContext(name="CLIENTE_ORACLE")
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("all")
	public DAOImpl(){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass() 
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	@Override
	public void insert(T entity) {
		em.persist(entity);
	}
	
	@Override
	public void removeById(K id){
		T entity = em.find(entityClass,id);
		em.remove(entity);
	}
	
	@Override
	public T searchByID(K id) {
		return (T) em.find(entityClass, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public List<T> searchAll() {
		TypedQuery<T> q = em.createQuery("from " + this.entityClass.getName(), this.entityClass);
		return q.getResultList();
	}



	
	
	
}