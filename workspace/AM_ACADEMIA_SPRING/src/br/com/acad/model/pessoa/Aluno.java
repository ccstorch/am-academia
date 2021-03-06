package br.com.acad.model.pessoa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.annotation.Show;
import br.com.acad.dao.dieta.interf.DietaDAO;
import br.com.acad.dao.treino.interf.TreinoDAO;
import br.com.acad.logic.PessoaLogic;
import br.com.acad.logic.model.FieldType;
import br.com.acad.model.dieta.Dieta;
import br.com.acad.model.treino.Treino;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACAD_PESSOA_ALUNO")
@PrimaryKeyJoinColumn(name = "ID_PESSOA_ID")
public class Aluno extends Pessoa
{

    @Column(nullable = true, precision = 2)
    @Show(label = "Peso", order = true, Type = FieldType.DOUBLE, filter = true)
    private double peso;

    @Column(nullable = true, precision = 2)
    @Show(label = "Altura", order = true, Type = FieldType.DOUBLE, filter = true)
    private double altura;

    private int numSolicitacao = 0;
    private int numSolicitacaoDieta = 0;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ACAD_ALUNO_TREINO", joinColumns = { @JoinColumn(name = "ALUNO_ID") }, inverseJoinColumns = { @JoinColumn(name = "TREINO_ID") })
    private Set<Treino> treinos = new HashSet<Treino>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ACAD_ALUNO_DIETA", joinColumns = { @JoinColumn(name = "ALUNO_DIETA") }, inverseJoinColumns = { @JoinColumn(name = "DIETA_ID") })
    private Set<Dieta> dietas = new HashSet<Dieta>();

    // Metodos
    public void addTreino(Treino treino, TreinoDAO dao)
    {
        treinos = new HashSet<Treino>(dao.buscarPorAluno(this));
        treinos.add(treino);
    }

    public void removeTreino(Treino treino)
    {
        treinos.remove(treino);
    }

    public void addDieta(Dieta dieta, DietaDAO dao)
    {
        dietas = new HashSet<Dieta>(dao.buscarPorAluno(this));
        dietas.add(dieta);
    }

    /**
     * Mostra a idade do aluno a partir da data de nasciemento
     * 
     * @return
     */
    public int getIdadeAluno()
    {
        if (this.getDataNascimento() != null)
        {
            return PessoaLogic.getIdade(this.getDataNascimento());
        }
        else
        {
            return 0;
        }
    }

    /**
     * Mostra a idade como string do aluno a partir da data de nasciemento
     * 
     * @return
     */
    public String getIdadeAlunoDetail()
    {
        if (this.getDataNascimento() != null)
        {
            return String.valueOf(PessoaLogic.getIdade(this.getDataNascimento()));
        }
        else
        {
            return "0";
        }
    }

    public Aluno()
    {
    }

    public Aluno(Integer id, String nome)
    {
        this.setId(id);
        this.setNome(nome);
    }

    public void incrementNumSolicitacao()
    {
        numSolicitacao += 1;
    }

    public void incrementNumSolicitacaoDieta()
    {
        numSolicitacaoDieta += 1;
    }

    public Set<Dieta> getDietas()
    {
        return dietas;
    }

    public void setDietas(Set<Dieta> dietas)
    {
        this.dietas = dietas;
    }

    public Set<Treino> getTreinos()
    {
        return treinos;
    }

    public void setTreinos(Set<Treino> treinos)
    {
        this.treinos = treinos;
    }

    public double getPeso()
    {
        return peso;
    }

    public void setPeso(double peso)
    {
        this.peso = peso;
    }

    public double getAltura()
    {
        return altura;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }

    public int getNumSolicitacao()
    {
        return numSolicitacao;
    }

    public void setNumSolicitacao(int numSolicitacao)
    {
        this.numSolicitacao = numSolicitacao;
    }

    public int getNumSolicitacaoDieta()
    {
        return numSolicitacaoDieta;
    }

    public void setNumSolicitacaoDieta(int numSolicitacaoDieta)
    {
        this.numSolicitacaoDieta = numSolicitacaoDieta;
    }

}
