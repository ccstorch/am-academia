package br.com.acad.dao.avisos.interf;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.avisos.NoticiaCat;

@Remote
public interface NoticiaCatDAO extends DAO<NoticiaCat,Integer>{
	
	
}
