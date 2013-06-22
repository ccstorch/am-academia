package br.com.acad.model.dieta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqDiaDieta", sequenceName="SEQ_DIA_DIETA", allocationSize=1)
@Table(name="ACAD_DIA_DIETA")
public class DiaDieta implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDiaDieta")
	@Column(name="ID_DIA_DIETA")
	private int id;
	
	@Column(length=255, nullable=false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name="DIA_DIETA_ID")
	private List<Refeicao> refeicoes;
	
	public DiaDieta(){}

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

	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}
	
	
	
}