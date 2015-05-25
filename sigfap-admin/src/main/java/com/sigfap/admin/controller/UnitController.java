package com.sigfap.admin.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
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
	@Get
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
	
	@Path("/unit/buscar")
	public void buscar(){
		
	}
	
	@Post
	@Path("/unit/exibir")
	public void exibir(Unit unit, String instNome, String tipoOrdenacao, int situacao){
		if(situacao == 1) unit.setAtiva(true);
		if(situacao == 2) unit.setAtiva(false);
		Institution inst = new Institution();
		List<Institution> insts = new ArrayList<Institution>();
		List<Unit> resultado = new ArrayList<Unit>();
		inst.setNome(instNome);
		insts = dao.findByExample(inst);
		if(!insts.isEmpty() && instNome != null){
			resultado = dao2.findByCriteria(Restrictions.sqlRestriction("{alias}.instituicao_id =" + insts.get(0).getId()), Example.create(unit));
		}
		else{
			resultado =  dao2.findByCriteria(Example.create(unit));
		}
		if(tipoOrdenacao.equals("1")){
			Collections.sort(resultado, new Comparator<Unit>() { //ordena pelo nome, todas as instituicoes cadastradas

				@Override
				public int compare(Unit o1, Unit o2) {
					return o1.getNome().toUpperCase().compareTo(o2.getNome().toUpperCase());
				}
			});
		}
		if(tipoOrdenacao.equals("2")){
			Collections.sort(resultado, new Comparator<Unit>() { //ordena pela inst, todas as instituicoes cadastradas

				@Override
				public int compare(Unit o1, Unit o2) {
					return o1.getInstituicao().getId().compareTo(o2.getInstituicao().getId());
				}
			});
		}
		result.include("resultado", resultado);
		
	}
	
	@Get
	@Path("/unit/edit/{id}")
	public void edit (int id)
	{
		result.include("edit", dao2.findById(id));
	}
	
	@Get
	@Path("/institution/delete/{id}")
	public void delete (int id)
	{
		
	}
}