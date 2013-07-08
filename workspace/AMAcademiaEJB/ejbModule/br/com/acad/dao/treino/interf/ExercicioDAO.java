package br.com.acad.dao.treino.interf;

import java.util.List;

import javax.ejb.Remote;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.model.treino.Exercicio;

@Remote
public interface ExercicioDAO extends DAO<Exercicio,Integer>{
	
	public List<Exercicio> buscarTodos();
	
}