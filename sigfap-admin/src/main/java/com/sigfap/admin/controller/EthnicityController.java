package com.sigfap.admin.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.EthnicityDAO;
import com.sigfap.admin.model.entity.Ethnicity;
import com.sigfap.admin.model.entity.Research;

@Controller
public class EthnicityController {
	private final Result result;
	private Validator validator;
	
	@Inject
	private EthnicityDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected EthnicityController(){
		this(null);
	}
	
	@Inject
	public EthnicityController(Result result){
		this.result = result;
	}
	
	@Get
	@Path("/list")
	public void index(){
		List<Ethnicity> listaEtnia = dao.findAll();
		result.include("busca", listaEtnia);
	}
	
	@Post
	@Path("/register")
	public void add(Ethnicity ethnicity){
		try{
			
			ethnicity.setAtiva(true);
			dao.persist(ethnicity);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		result.redirectTo(this).index();
		
	}
	
//	public void remove(){
//		
//	}
//	
//	public void search(){
//		
//	}
//	
//	public void list(){
//		
//	}
	

}
