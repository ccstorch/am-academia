package br.com.acad.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import br.com.acad.dao.generico.interf.DAO;
import br.com.acad.logic.AnnotationsLogic;
import br.com.acad.logic.MessagesLogic;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.GenericEntity;


/**
 * Bean generico com metodos, atributos e assinaturas que todos beans devem possuir.
 * 
 * @author Christian Storch
 * 
 * @param <T>
 */
public abstract class Bean<T extends GenericEntity> {

	
	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/

	// DAO
	protected DAO<T, Integer> dao;

	// Entity
	protected T entity;
	protected List<T> entities;
	
	// Search
	protected String[] staticFields;
	protected String search;
	
	// Paginação
	protected int page = 1;
	protected long totalPages;
	protected long totalEntities;
	
	// View
	protected String permanentView;
	protected String view;
	protected String[] staticViewsValue;
	protected String[] staticViewsLabel;
	
	// Ordenacao
	protected String order;
	protected int initialOrder = 0;
	protected String[] staticFieldsOrderValue;
	protected String[] staticFieldsOrderLabel;
	
	// Navigation
	protected boolean showEntity;
	protected boolean showEntity2;
	protected boolean showEntity3;
	protected boolean showEntity4;

	// Detail
	protected boolean showEntityDetail;
	
	
	/************************************************************************************************************/
	//ASSINATURAS
	/************************************************************************************************************/
	
	public abstract void showNewEntity();
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	public void init(){
		if(staticFields==null){
			staticFields = AnnotationsLogic.getSearchValueFields(dao.getEntityClass());
		}
		if(staticFieldsOrderLabel==null){
			staticFieldsOrderLabel = AnnotationsLogic.getOrderLabelFields(dao.getEntityClass());
			staticFieldsOrderValue = AnnotationsLogic.getOrderValueFields(dao.getEntityClass());
		}
		if(order == null && staticFieldsOrderLabel != null){
			order = staticFieldsOrderLabel[initialOrder];
		}
		if(order == null && staticFields !=null){
			order = staticFields[initialOrder];
		}
		if(staticViewsLabel==null){
			staticViewsLabel = AnnotationsLogic.getViewLabelFields(dao.getEntityClass());
			staticViewsValue = AnnotationsLogic.getViewValueFields(dao.getEntityClass());
		}
		if(staticViewsLabel != null){
			view = staticViewsLabel[0];
		}
		
		atualizar();
	}
	
	/**
	 * fecha painel de edicao de uma entity
	 */
	public void dontShowEntity() {
		closeForms();
	}
	
	/**
	 * mostra painel de edicao de uma Entity
	 */
	public void showEditEntity(){
		if(entity!=null){
			showEntity = true;
			showEntity2 = false;
			showEntity3 = false;
			showEntity4 = false;
			showEntityDetail = false;
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para editar");
		}
	}
	
	/**
	 * atualiza pagina
	 */
	public void atualizar() {
		try{
			closeForms();
			atualizaPages();
			entities = buscarTodos();
		}catch(Exception e){
			MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o administrador");
			e.printStackTrace();
		}
	}

	/**
	 * Apaga o filtro de search
	 */
	public final void resetSearch() {
		search = "";
		atualizar();
	}

	/**
	 * atualiza pagina com msg de sucesso
	 */
	public void atualizarComMsg() {
		atualizar();
		MessagesLogic.addInfoMessage("Sucesso", "Atualizado");
	}
	
	/**
	 * proxima tela da tabela.
	 */
	public void nextPageTable(){
		if(page<totalPages){
			page++;
			atualizar();
		}else{
			MessagesLogic.addWarnMessage("Aviso", "ultima pagina");
		}
	}

	/**
	 * tela anterior da tabela.
	 */
	public void previousPageTable(){
		if(page>1){
			page--;
			atualizar();
		}else{
			MessagesLogic.addWarnMessage("Aviso", "primeira pagina");
		}
	}
	
	/**
	 * abre formulario 1.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm1(){
		showEntity = true;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 1 e abre o 2.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm2(){
		showEntity = false;
		showEntity2 = true;
		showEntity3 = false;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 2 e abre o 3.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm3(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = true;
		showEntity4 = false;
	}
	
	/**
	 * fecha formulario 3 e abre o 4.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showForm4(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = true;
	}
	
	/**
	 * Mostra detalhes da entidade selecionada
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void showFormDetail(){
		closeForms();
		showEntityDetail = true;
	}
	
	/**
	 * Mostra detalhes da entidade selecionada
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void hideFormDetail(){
		showEntityDetail = false;
	}
	
	
	
	

	/************************************************************************************************************/
	//METODOS INTERNOS
	/************************************************************************************************************/
	
	/**
	 * Atualiza o total de entities e o total de paginas
	 */
	public void atualizaPages() throws Exception{
		totalEntities = contarTodos();
		totalPages = (totalEntities/SqlLogic.TABLE_SIZE); 
		totalPages += totalEntities%SqlLogic.TABLE_SIZE!=0?1:0;
		if(totalPages==0){
			totalPages = 1;
		}
	}
	
	/**
	 * inclui ou edita Entity no banco
	 * @param dao DAO da entity a ser inserida
	 * @param id id do objeto que sera inserido no banco
	 */
	public void incluirEntity() {
		try{
			if(entity.getId()==0){
				entity = dao.insert(entity);
			}else{
				entity = dao.update(entity);
			}
			atualizar();
			MessagesLogic.addInfoMessage("Sucesso", "Salvo com sucesso");
		}catch(Exception e){
			MessagesLogic.addErrorMessage("Erro", "Ocorreu um erro! Contate o administrador");
		}
	}
	
	
	
	/**
	 * Deleta Entity do banco
	 * @param dao DAO referente a entity a ser excluida
	 * @param entity objeto que sera excluido
	 * @param id id da entity que sera excluida
	 */
	public void deletarEntity(){
		if(entity != null){
			try{
				dao.removeById(entity.getId());
				atualizar();
				showEntityDetail = false;
				MessagesLogic.addInfoMessage("Sucesso", "Deletado com sucesso");
			}catch(Exception e){
				MessagesLogic.addErrorMessage("Erro", "O objeto não pode ser deletado pois está relacionado a outro objeto");
				return;
			}
		}else{
			MessagesLogic.addWarnMessage("Erro", "Selecione um para deletar");
		}
	}
	
	/**
	 * fecha todos formularios.
	 * Utilizado somente para casos de formularios mais complexos
	 */
	public void closeForms(){
		showEntity = false;
		showEntity2 = false;
		showEntity3 = false;
		showEntity4 = false;
	}

	/**
	 * retorna busca de todas as entities para tabela
	 * @return
	 */
	protected List<T> buscarTodos() throws Exception{
		
		if(search!=null && search.length()>0){
			page = 1;
		}
		
		if(page > totalPages){
			page = (int) totalPages;
			MessagesLogic.addWarnMessage("Erro", "Número de paginação da tabela invalido");
		}
		if(page < 1){
			page = 1;
			MessagesLogic.addWarnMessage("Erro", "Número de paginação da tabela invalido");
		}
		
		if(staticFieldsOrderLabel!=null){
			int posicao =  Arrays.asList(staticFieldsOrderLabel).indexOf(order);
			return dao.buscarTodos(staticFields, page, search, staticFieldsOrderValue[posicao], getTempView());
		}else{
			return dao.buscarTodos(staticFields, page, search, order, getTempView());
		}
	}
	
	/**
	 * retorna contagem de todos as entities
	 * @return
	 */
	protected long contarTodos(){
		return dao.contarTodos(staticFields, search, getTempView());
	}
	
	/**
	 * retorna uma string temporaria de view, juntando a permanetView e a view
	 * @return
	 */
	public String getTempView(){
		String tempView = new String();
		if(staticViewsLabel != null && view != null){
			int posicao =  Arrays.asList(staticViewsLabel).indexOf(view);
			tempView = staticViewsValue[posicao];
		}
		if(view != null && view.length() > 0 && permanentView != null && permanentView.length() > 0){
			tempView += " and ";
		}
		tempView += permanentView == null? "" : permanentView;
		return tempView;
	}
	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public List<T> getEntities() {
		return entities;
	}
	public boolean getShowEntity() {
		return showEntity;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public boolean getShowEntity2() {
		return showEntity2;
	}
	public boolean getShowEntity3() {
		return showEntity3;
	}
	public boolean getShowEntity4() {
		return showEntity4;
	}
	public boolean getShowEntityDetail() {
		return showEntityDetail;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public long getTotalEntities() {
		return totalEntities;
	}
	public String[] getStaticFieldsOrderValue() {
		return staticFieldsOrderValue;
	}
	public String[] getStaticFieldsOrderLabel() {
		return staticFieldsOrderLabel;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getPermanentView() {
		return permanentView;
	}
	public String[] getStaticViewsValue() {
		return staticViewsValue;
	}
	public String[] getStaticViewsLabel() {
		return staticViewsLabel;
	}
	
	
	
}
