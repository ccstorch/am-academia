package br.com.acad.dao.avisos.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.avisos.NoticiaCat;

@Stateless
public class NoticiaCatDAOImpl extends DAOImpl<NoticiaCat,Integer> implements NoticiaCatDAO{

	public NoticiaCatDAOImpl() {
		super();
	}

}