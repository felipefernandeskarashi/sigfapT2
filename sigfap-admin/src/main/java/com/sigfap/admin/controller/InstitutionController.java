package com.sigfap.admin.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.entity.Institution;

@Controller
public class InstitutionController{
	private final Result result;
	
	private Validator validator;
	@Inject
	private InstitutionDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected InstitutionController(){
		this(null);
	}
	
	@Inject
	public InstitutionController(Result result){
		this.result = result;
	}
	
	
	@Path("/registrar-instituicao")
	public void index(){
		
	}
	
	@Post
	@Path("/registrar-instituicao1")
	public void registrar(Institution institution, boolean ies, boolean finsLucrativos){
		institution.setFinsLucrativos(false);
		institution.setIes(false);
		if(ies){
			institution.setIes(true);
		}
		if(finsLucrativos){
			institution.setFinsLucrativos(true);
		}
		try{
			institution.setAtiva(true);
			dao.persist(institution);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		result.redirectTo(IndexController.class).index();
	}
	
	
	@Path("/buscar-instituicao")
	public void buscar(){
		
	}
	
	@Post
	@Path("/exibir-instituicoes")
	public void exibir(Institution institution, String tipoOrdenacao, String situacao, String limitePorPagina){
		if(situacao.equals("1")) institution.setAtiva(true);
		if(situacao.equals("2")) institution.setAtiva(false);
		List<Institution> instituicoes = dao.findByExample(institution);
		if(tipoOrdenacao.equals("1")){
			Collections.sort(instituicoes, new Comparator<Institution>() { //ordena pelo nome, todas as instituicoes cadastradas

				@Override
				public int compare(Institution o1, Institution o2) {
					return o1.getNome().toUpperCase().compareTo(o2.getNome().toUpperCase());
				}
			});
		}
		if(tipoOrdenacao.equals("2")){
			Collections.sort(instituicoes, new Comparator<Institution>() { //ordena pela sigla, todas as instituicoes cadastradas

				@Override
				public int compare(Institution o1, Institution o2) {
					return o1.getDependenciaAdmText().toUpperCase().compareTo(o2.getDependenciaAdmText().toUpperCase());
				}
			});
		}
		result.include("busca", instituicoes);
	}
	
	@Get
	@Path("/institution/edit/{id}")
	public void edit (int id)
	{
		result.include("edit", dao.findById(id));
	}
	
	@Get
	@Path("/institution/delete/{id}")
	public void delete (int id)
	{
		Institution delete = dao.findById(id);
		delete.setAtiva(false);
		dao.update(delete);
		result.redirectTo(this).buscar();
	}
	
	@Post
	@Get
	@Path("/institution/edit")
	public void editInst(Institution edit, int idInst, boolean ies, boolean finsLucrativos){
		edit.setId(idInst);
		edit.setFinsLucrativos(false);
		edit.setIes(false);
		if(ies){
			edit.setIes(true);
		}
		if(finsLucrativos){
			edit.setFinsLucrativos(true);
		}
		try{
			if(edit.getAtiva() != true){
				edit.setAtiva(false);
			}
			dao.update(edit);
			
		}catch(Exception e){
			System.out.println("Erro Edição"+e.getMessage());
		}
		result.redirectTo(this).buscar();
	}
}