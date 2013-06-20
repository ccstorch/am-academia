package br.com.acad.model.treino;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("serial")
public abstract class Treino implements Serializable{

	private int id;
	
	private String nome;
	
	private String descricao;
	
	private Calendar data;
	
	private TreinoTipo tipoTreino;
	
	private List<DiaTreino> diasTreino;
	
	private long tempoDescanso;

	//private ProfessorFunc professor;	
	
	
	public Treino(){}

	public Treino(int id, String nome, String descricao, Calendar data,
			TreinoTipo tipoTreino, List<DiaTreino> diasTreino,
			long tempoDescanso) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.tipoTreino = tipoTreino;
		this.diasTreino = diasTreino;
		this.tempoDescanso = tempoDescanso;
	}

	public long getTempoDescanso() {
		return tempoDescanso;
	}

	public void setTempoDescanso(long tempoDescanso) {
		this.tempoDescanso = tempoDescanso;
	}




	public List<DiaTreino> getDiasTreino() {
		return diasTreino;
	}

	public void setDiasTreino(List<DiaTreino> diasTreino) {
		this.diasTreino = diasTreino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public TreinoTipo getTipoTreino() {
		return tipoTreino;
	}

	public void setTipoTreino(TreinoTipo tipoTreino) {
		this.tipoTreino = tipoTreino;
	}
	
	
	
	
	
}
