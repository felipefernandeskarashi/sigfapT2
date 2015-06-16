package com.sigfap.admin.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

import com.sigfap.admin.model.dao.CityDAO;
import com.sigfap.admin.model.entity.City;

public class CityController {

	private final Result result;
	
	@Inject
	private CityDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected CityController() {
		this(null);
	}

	@Inject
	public CityController(Result result) {
		this.result = result;
	}
	
	@Path("/registerCity")
	public void save(){
		
	}
	
	@Path("/listCity")
	public void list(){
		List<City> listaCidades = dao.findAll();
		result.include("busca", listaCidades);
	}
	
	@Path("/removeCity/{id}")
	public void remove(int id){
		dao.delete(dao.findById(id));
		result.redirectTo(this).list();
	}
	
	@Path("/editCity/{id}")
	public void edit(int id){
	
	}
	
	
}
