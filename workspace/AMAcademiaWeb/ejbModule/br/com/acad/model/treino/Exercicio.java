package br.com.acad.model.treino;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Exercicio implements Serializable {
	
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private String fotoLocal;
	
	private ParteCorpo parteCorpoPrimaria;
	
	private ParteCorpo parteCorpoSecundaria;
	
	
	public Exercicio(){}
	
	public Exercicio(int id, String nome, String descricao, String fotoLocal,
			ParteCorpo parteCorpoPrimaria, ParteCorpo parteCorpoSecundaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.fotoLocal = fotoLocal;
		this.parteCorpoPrimaria = parteCorpoPrimaria;
		this.parteCorpoSecundaria = parteCorpoSecundaria;
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

	public String getFotoLocal() {
		return fotoLocal;
	}

	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}

	public ParteCorpo getParteCorpoPrimaria() {
		return parteCorpoPrimaria;
	}

	public void setParteCorpoPrimaria(ParteCorpo parteCorpoPrimaria) {
		this.parteCorpoPrimaria = parteCorpoPrimaria;
	}

	public ParteCorpo getParteCorpoSecundaria() {
		return parteCorpoSecundaria;
	}

	public void setParteCorpoSecundaria(ParteCorpo parteCorpoSecundaria) {
		this.parteCorpoSecundaria = parteCorpoSecundaria;
	}
	
	
	

	
	
	
	
}
