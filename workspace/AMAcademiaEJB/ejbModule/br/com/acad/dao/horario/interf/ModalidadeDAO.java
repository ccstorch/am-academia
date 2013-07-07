package br.com.acad.dao.horario.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.horario.Modalidade;

@Remote
public interface ModalidadeDAO extends DAO<Modalidade,Integer>{
	
	public List<Modalidade> buscarTodos();
	
	
}
