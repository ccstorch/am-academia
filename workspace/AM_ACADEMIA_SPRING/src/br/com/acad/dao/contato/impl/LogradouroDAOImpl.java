package br.com.acad.dao.contato.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.contato.interf.LogradouroDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.model.contato.Logradouro;

@Repository
public class LogradouroDAOImpl extends DAOImpl<Logradouro, Integer> implements LogradouroDAO
{

    public LogradouroDAOImpl()
    {
        super();
    }

    @Override
    public List<Logradouro> buscarTodos()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
