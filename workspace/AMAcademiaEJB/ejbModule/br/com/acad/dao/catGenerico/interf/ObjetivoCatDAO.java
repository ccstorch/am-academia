package br.com.acad.dao.catGenerico.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.catGenerico.ObjetivoCat;

@Remote
public interface ObjetivoCatDAO extends DAO<ObjetivoCat,Integer>{
	
	
	
}