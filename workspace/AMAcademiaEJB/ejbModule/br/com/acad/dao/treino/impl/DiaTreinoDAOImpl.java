package br.com.acad.dao.treino.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.dao.treino.interf.DiaTreinoDAO;
import br.com.acad.model.treino.DiaTreino;

@Stateless
public class DiaTreinoDAOImpl extends DAOImpl<DiaTreino,Integer> implements DiaTreinoDAO{

	public DiaTreinoDAOImpl() {
		super();
	}


}
