package br.com.acad.dao.generico.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.SqlLogic;

@Repository
public abstract class DAOImpl<T, K> implements DAO<T, K>
{

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> entityClass;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DAOImpl()
    {
        this.entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> buscarTodos(String[] columns, int page, String search, String order, String view)
    {
        Query q = em.createQuery(SqlLogic.getSql(columns, entityClass.getSimpleName(), search, order, view));

        q.setMaxResults(SqlLogic.TABLE_SIZE);

        if (page > 0)
        {
            q.setFirstResult((page - 1) * SqlLogic.TABLE_SIZE);
        }
        else
        {
            q.setFirstResult(1);
        }

        return (List<T>) q.getResultList();
    }

    @Override
    public long contarTodos(String[] columns, String search, String view)
    {
        Query q = em.createQuery(SqlLogic.getCountSql(columns, entityClass.getSimpleName(), search, view));
        return (Long) q.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> filtrarTodos(int page, Map<String, String> filtros, String order)
    {
        Query q = em.createQuery(SqlLogic.getFilterSql(filtros, getClassName(), order));

        q.setMaxResults(SqlLogic.TABLE_SIZE);

        if (page > 0)
        {
            q.setFirstResult((page - 1) * SqlLogic.TABLE_SIZE);
        }
        else
        {
            q.setFirstResult(1);
        }

        return q.getResultList();
    }

    @Override
    public long contarTodosFiltro(Map<String, String> filtros)
    {
        Query q = em.createQuery(SqlLogic.getCountFilterSql(getClassName(), filtros));
        return (Long) q.getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 120)
    public T insert(T entity)
    {
        // EntityManager em = getEntityManager();
        // em.getTransaction().begin();

        em.persist(entity);

        // em.getTransaction().commit();
        return entity;
    }

    @Override
    public void remove(T entity)
    {
        // EntityManager em = getEntityManager();
        // em.getTransaction().begin();

        em.remove(entity);

        // em.getTransaction().commit();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 120)
    public T update(T entity)
    {
        // EntityManager em = getEntityManager();
        // em.getTransaction().begin();

        em.merge(entity);

        // em.getTransaction().commit();
        return entity;

    }

    @Override
    public T searchById(K id)
    {
        // EntityManager em = getEntityManager();
        return em.find(entityClass, id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 120)
    public void removeById(K id)
    {
        // EntityManager em = getEntityManager();
        // em.getTransaction().begin();

        T entity = em.find(entityClass, id);

        em.remove(entity);

        // em.getTransaction().commit();
    }

    @Override
    public String getClassName()
    {
        return entityClass.getSimpleName();
    }

    @Override
    public Class<T> getEntityClass()
    {
        return entityClass;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

}