package br.com.acad.dao.catGenerico.impl;

import javax.ejb.Stateless;

import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.catGenerico.SexoCat;

@Stateless
public class SexoCatDAOImpl extends DAOImpl<SexoCat,Integer> implements SexoCatDAO{

	public SexoCatDAOImpl() {
		super();
	}

}