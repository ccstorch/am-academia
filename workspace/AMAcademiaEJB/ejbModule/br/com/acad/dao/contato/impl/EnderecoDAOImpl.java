package br.com.acad.dao.contato.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.acad.dao.contato.interf.EnderecoDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Endereco;

@Stateless
public class EnderecoDAOImpl extends DAOImpl<Endereco,Integer> implements EnderecoDAO{

	public EnderecoDAOImpl() {
		super();
	}

	@Override
	public List<Endereco> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
