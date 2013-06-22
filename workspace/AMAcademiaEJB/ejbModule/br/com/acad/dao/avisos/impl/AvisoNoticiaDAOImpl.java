package br.com.acad.dao.avisos.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.avisos.interf.NoticiaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.avisos.Noticia;

@Stateless
public class AvisoNoticiaDAOImpl extends DAOImpl<Noticia,Integer> implements NoticiaDAO{

	public AvisoNoticiaDAOImpl() {
		super();
	}

}