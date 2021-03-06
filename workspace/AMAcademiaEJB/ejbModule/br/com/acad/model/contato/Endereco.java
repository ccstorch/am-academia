package br.com.acad.model.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqEndereco", sequenceName="SEQ_ENDERECO", allocationSize=1)
@Table(name="ACAD_ENDERECO")
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEndereco")
	@Column(name="ID_ENDERECO")
	private int id;
	
	@Column(nullable=false)
	private int numero;
	
	@Column(length=255, nullable=true)
	private String complemento;
	
	@ManyToOne
	@JoinColumn(name="LOGRADOURO_ID")
	private Logradouro logradouro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
}
