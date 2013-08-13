package br.com.acad.bean.mobile;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.catGenerico.interf.DiasTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.DuracaoTreinoCatDAO;
import br.com.acad.dao.catGenerico.interf.FaixaEtariaCatDAO;
import br.com.acad.dao.catGenerico.interf.ObjetivoCatDAO;
import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.model.cat.DiasTreinoCat;
import br.com.acad.model.cat.DuracaoTreinoCat;
import br.com.acad.model.cat.FaixaEtariaCat;
import br.com.acad.model.cat.ObjetivoCat;
import br.com.acad.model.cat.SexoCat;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MBuscaTreinoBean implements Serializable{
	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	@EJB
	private FaixaEtariaCatDAO faixaEtariaCatDAO;
	@EJB
	private SexoCatDAO sexoCatDAO;
	@EJB
	private ObjetivoCatDAO objetivoCatDAO;
	@EJB
	private DuracaoTreinoCatDAO duracaoTreinoCatDAO;
	@EJB
	private DiasTreinoCatDAO diasTreinoCatDAO;
	
	
	private FaixaEtariaCat faixaEtariaCat = new FaixaEtariaCat();
	private SexoCat sexoCat = new SexoCat();
	private ObjetivoCat objetivoCat = new ObjetivoCat();
	private DuracaoTreinoCat duracaoTreinoCat = new DuracaoTreinoCat();
	private DiasTreinoCat diasTreinoCat = new DiasTreinoCat();
	
	private List<DiasTreinoCat> diasTreinoCatField;
	private List<ObjetivoCat> objetivoCatField;
	private List<DuracaoTreinoCat> duracaoTreinoCatField;
	private List<FaixaEtariaCat> faixaEtariaCatField;
	private List<SexoCat> sexoCatField;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	public String init(){
		faixaEtariaCat = new FaixaEtariaCat();
		sexoCat = new SexoCat();
		objetivoCat = new ObjetivoCat();
		duracaoTreinoCat = new DuracaoTreinoCat();
		diasTreinoCat = new DiasTreinoCat();
		
		objetivoCatField = objetivoCatDAO.buscarTodos();
		
		return "pm:buscaTreino";
	}
	
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	/**
	 * busca todos DiasSemanasCat para preencher o field
	 */
	public List<DiasTreinoCat> getDiasTreinoCatField() {
		return diasTreinoCatField;
	}
	
	/**
	 * busca todos DuracaoTreinoCat para preencher o field
	 */
	public List<DuracaoTreinoCat> getDuracaoTreinoCatField() {
		return duracaoTreinoCatField;
	}
	
	/**
	 * busca todos FaixaEtariaCat para preencher o field
	 */
	public List<FaixaEtariaCat> getFaixaEtariaCatField() {
		return faixaEtariaCatField;
	}
	
	/**
	 * busca todos ObjetivoCat para preencher o field
	 */
	public List<ObjetivoCat> getObjetivoCatField() {
		return objetivoCatField;
	}
	
	/**
	 * busca todos SexoCat para preencher o field
	 */
	public List<SexoCat> getSexoCatField() {
		return sexoCatField;
	}

	/************************************************************************************************************/
	//GETs e SETs
	/************************************************************************************************************/
	
	public FaixaEtariaCat getFaixaEtariaCat() {
		return faixaEtariaCat;
	}


	public void setFaixaEtariaCat(FaixaEtariaCat faixaEtariaCat) {
		this.faixaEtariaCat = faixaEtariaCat;
	}


	public SexoCat getSexoCat() {
		return sexoCat;
	}


	public void setSexoCat(SexoCat sexoCat) {
		this.sexoCat = sexoCat;
	}


	public ObjetivoCat getObjetivoCat() {
		return objetivoCat;
	}


	public void setObjetivoCat(ObjetivoCat objetivoCat) {
		this.objetivoCat = objetivoCat;
	}


	public DuracaoTreinoCat getDuracaoTreinoCat() {
		return duracaoTreinoCat;
	}


	public void setDuracaoTreinoCat(DuracaoTreinoCat duracaoTreinoCat) {
		this.duracaoTreinoCat = duracaoTreinoCat;
	}


	public DiasTreinoCat getDiasTreinoCat() {
		return diasTreinoCat;
	}


	public void setDiasTreinoCat(DiasTreinoCat diasTreinoCat) {
		this.diasTreinoCat = diasTreinoCat;
	}
	
	
}