package br.com.acad.dao.treino.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.model.treino.Treino;

@Stateless
public class TreinoDAOImpl extends DAOImpl<Treino,Integer> implements TreinoDAO{

	public TreinoDAOImpl() {
		super();
	}

	@Override
	public List<Treino> buscarTodos() {
		TypedQuery<Treino> q = em.createQuery("from Treino", Treino.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Treino> buscarTodos(int page, String txtSearch, String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
