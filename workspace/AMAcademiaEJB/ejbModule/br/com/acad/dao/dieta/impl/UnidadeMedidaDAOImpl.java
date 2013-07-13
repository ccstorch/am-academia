package br.com.acad.dao.dieta.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.UnidadeMedidaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.UnidadeMedida;

@Stateless
public class UnidadeMedidaDAOImpl extends DAOImpl<UnidadeMedida,Integer> implements UnidadeMedidaDAO{

	public UnidadeMedidaDAOImpl() {
		super();
	}

	@Override
	public List<UnidadeMedida> buscarTodos() {
		TypedQuery<UnidadeMedida> q = em.createQuery("from UnidadeMedida", UnidadeMedida.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(UnidadeMedida.STATIC_FIELDS, "UnidadeMedida", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<UnidadeMedida> buscarTodos(int page, String txtSearch,
			String order) {
		TypedQuery<UnidadeMedida> q = em.createQuery(SqlLogic.getSql(UnidadeMedida.STATIC_FIELDS, "UnidadeMedida", txtSearch, order), UnidadeMedida.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

}
