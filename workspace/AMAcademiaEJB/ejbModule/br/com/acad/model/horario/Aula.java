package br.com.acad.model.horario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqAula", sequenceName="SEQ_AULA", allocationSize=1)
@Table(name="ACAD_AULA")
public class Aula implements Serializable{

	public static final String[] STATIC_FIELDS = {"descricao", "nome"};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAula")
	@Column(name="ID_AULA")
	private int id;

	@Column(length=255, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=true)
	private String descricao;
	
	@Column(length=500, nullable=true)
	private String fotoLocal;
	
	
	
	public Aula() {
		super();
	}
	
	public Aula(String nome, String descricao, String fotoLocal) {
		this.nome = nome;
		this.descricao = descricao;
		this.fotoLocal = fotoLocal;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFotoLocal() {
		return fotoLocal;
	}

	public void setFotoLocal(String fotoLocal) {
		this.fotoLocal = fotoLocal;
	}
	
	
	
}
