package com.sigfap.admin.controller;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.AddressDAO;
import com.sigfap.admin.model.dao.EthnicityDAO;
import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.dao.SkillDAO;
import com.sigfap.admin.model.dao.TelephoneDAO;
import com.sigfap.admin.model.entity.Address;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.model.entity.Telephone;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class ResearchController {
	private final Result result;

	private Validator validator;

	@Inject
	private ResearchDAO dao;
	
	@Inject
	private AddressDAO dao1;
	
	@Inject
	private EthnicityDAO dao2;
	
	@Inject
	private SkillDAO dao3;
	
	@Inject
	private TelephoneDAO dao4;
	
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null, null);
	}
	
	@Inject
	public ResearchController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Public
	@Path("/research")
	public void index() {
		
	}


	
	@Public
	@Post
	@Path("/registerResearch")
	public void save(Research research, Address address, Address address2, Integer etniaId, Integer areaId, Telephone telephone) {
		
		//System.out.println("Escolha do cidadao: "+ research.getEnderecoPref());
		
		//research.setArea(1);
		//research.setEtniaPes(research.getEtniaPes());
		
		
		try{
			dao1.persist(address);
			dao1.persist(address2);
		}
		catch (Exception e) {
				e.printStackTrace();
				result.include("error", e.getMessage());
				
			}
			
			research.setEnderecoRes(address);
			research.setEnderecoCom(address2);
			
			research.setEtniaPes(dao2.findById(etniaId));
			research.setArea(dao3.findById(areaId));
			
		try{
			    research.setSenha(DigestUtils.shaHex(research.getSenha()));
			    research.setAtivo(true);
				dao.persist(research);
				
				telephone.setPesquisador(research);
				dao4.persist(telephone);
				result.redirectTo(AuthController.class).index();
		}
		catch (Exception e) {
				e.printStackTrace();
				result.include("error", e.getMessage());
				result.redirectTo(this).index();					
		}
		
		
	}
	

	



}
