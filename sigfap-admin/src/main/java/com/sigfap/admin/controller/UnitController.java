package com.sigfap.admin.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.AddressDAO;
import com.sigfap.admin.model.dao.InstitutionDAO;
import com.sigfap.admin.model.dao.TelephoneDAO;
import com.sigfap.admin.model.dao.UnitDAO;
import com.sigfap.admin.model.entity.Address;
import com.sigfap.admin.model.entity.Institution;
import com.sigfap.admin.model.entity.Telephone;
import com.sigfap.admin.model.entity.Unit;

@Controller
public class UnitController{
	private final Result result;
	
	private Validator validator;
	@Inject
	private InstitutionDAO dao;
	
	@Inject
	private UnitDAO dao2;
	
	@Inject
	private AddressDAO dao3;
	
	@Inject
	private TelephoneDAO dao4;
	/**
	 * @deprecated CDI eyes only
	 */
	protected UnitController(){
		this(null);
	}
	
	@Inject
	public UnitController(Result result){
		this.result = result;
	}
	
	@Path("/inserir-unidade")
	public void index(){
		List<Institution> instituicoes = dao.findAll();
		Collections.sort(instituicoes, new Comparator<Institution>() { //ordena pelo nome, todas as instituicoes cadastradas

			@Override
			public int compare(Institution o1, Institution o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		result.include("instituicoes", instituicoes); //inclui no jsp, a lista ordenada.
	}
	
	@Post
	@Path("/inserir-unidade1")
	public void inserir(int result_in, Unit unit, Telephone telephone, Address address){
		unit.setInstituicao(dao.findById(result_in));
		try{
			dao3.persist(address);
		}catch(Exception e){}
		unit.setEndereco(address);
		try{
			dao2.persist(unit);
			telephone.setUnidadeT(unit);
			dao4.persist(telephone);
		}catch(Exception e){}
		result.redirectTo(IndexController.class).index();
	}
}