package br.com.acad.model.treino;

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
@SequenceGenerator(name="seqParteCopro", sequenceName="SEQ_PARTE_CORPO", allocationSize=1)
@Table(name="ACAD_PARTE_CORPO")
public class ParteCorpo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqParteCopro")
	@Column(name="ID_PARTE_CORPO")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;

	
	public ParteCorpo(){}
	
	public ParteCorpo(String nome) {
		super();
		this.nome = nome;
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
	
	
	
}
