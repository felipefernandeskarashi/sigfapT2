package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.exception.ConstraintViolationException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.SectorDAO;
import com.sigfap.admin.model.entity.Sector;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class SectorController {

	private final Result result1;
		
	private Validator validator;
	@Inject
	private SectorDAO dao;
		
	/**
     * @deprecated CDI eyes only
	*/
	protected SectorController(){
		this(null);
	}
		
	@Inject
	public SectorController(Result result){
		this.result1 = result;
	}
	
	@Public
	@Get("/v1/sectors")
	public void listar(){
		List<Sector> temp = dao.findAll();
		com.sigfap.admin.json.sector.Result result = 
				new com.sigfap.admin.json.sector.Result();
		result.setSetores(temp);
		result1.use(Results.json()).from(result).recursive()
			.exclude("setores.unidade").serialize();
		result1.include("setores", result);
	}
	
	@Public 
	@Post("/v1/sector")
	public void inserir(Sector sector){
		
		try{
			dao.persist(sector);
		}catch(ConstraintViolationException e){
			com.sigfap.admin.json.sector.Error error = 
					new com.sigfap.admin.json.sector.Error("Unidade não existe");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
			return;
			
		}
		com.sigfap.admin.json.sector.Result result = 
				new com.sigfap.admin.json.sector.Result();
		result.getSetores().add(sector);
		result1.use(Results.json()).from(result).recursive()
			.exclude("setores.unidade").serialize();
		result1.include(result);
		
	}
	
	@Public
	@Delete("/v1/sector/{id}")
	public void deletar(int id){
		Sector temp = dao.findById(id);
		try{
			dao.deleteById(id);
			com.sigfap.admin.json.sector.Result result = 
					new com.sigfap.admin.json.sector.Result();
			result.getSetores().add(temp);
			result1.use(Results.json()).from(result).recursive()
				.exclude("setores.unidade").serialize();
			result1.include(result);
		}catch(Exception e){
			com.sigfap.admin.json.sector.Error error = 
					new com.sigfap.admin.json.sector.Error("Objeto não encontrado");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
			System.out.println(id);
		}
	}
	
	@Public
	@Put("/v1/sector/{id}")
	public void atualizar(int id, Sector sector){
		//não funciona
		sector.setId(id);
		try{
			System.out.println(sector.getNome());
			dao.update(sector);
			System.out.println(sector.getNome());
		}catch(Exception e){
			System.out.println(sector.getNome());
		}
	}

}
