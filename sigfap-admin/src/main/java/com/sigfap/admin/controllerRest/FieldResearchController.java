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
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.SkillDAO;
import com.sigfap.admin.model.entity.Skill;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class FieldResearchController {

	private final Result result1;

	@Inject
	private SkillDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected FieldResearchController() {
		this(null, null);
	}

	@Inject
	public FieldResearchController(Result result1, SkillDAO dao) {
		this.result1 = result1;
		this.dao = dao;
	}

	/** V1 - Versão 1 **/

	@Public
	@Get("/v1/fieldsresearch")
	public void listarArea() {
		List<Skill> skills = dao.findAll();

		if (!skills.isEmpty()) {
			com.sigfap.admin.json.fieldresearch.Result result = new com.sigfap.admin.json.fieldresearch.Result();

			result.setValue(skills);

			result1.use(Results.json()).from(result)
					.exclude("value.pesquisadores").recursive().serialize();
			result1.include("areas", result);
		} else {
			com.sigfap.admin.json.fieldresearch.Error error = new com.sigfap.admin.json.fieldresearch.Error(
					"Nenhuma área de conhecimento cadastrada.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

	@Public
	@Post("/v1/fieldresearch")
	public void inserirArea(Skill skill) {
		skill.setVerificador(skill.getVerificador());
		skill.setArea_nome(skill.getArea_nome());
		skill.setArea_ativa(skill.isArea_ativa());

		try {
			dao.persist(skill);
			com.sigfap.admin.json.fieldresearch.Result result = new com.sigfap.admin.json.fieldresearch.Result();
			
			result.getValue().add(skill);

			result1.use(Results.json()).from(result).exclude("value.pesquisadores").recursive().serialize();
			result1.include(result);
		} catch (ConstraintViolationException e) {
			com.sigfap.admin.json.fieldresearch.Error error = new com.sigfap.admin.json.fieldresearch.Error(
					"Erro ao cadastrar área de conhecimento.");
			
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

	@Public
	@Put("/v1/fieldresearch")
	public void editarArea() {

	}

	@Public
	@Delete("/v1/fieldresearch/{id}")
	public void removerArea(int id) {
		Skill skill = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.fieldresearch.Result result = new com.sigfap.admin.json.fieldresearch.Result();

			result.getValue().add(skill);

			result1.use(Results.json()).from(result).exclude("value.pesquisadores").recursive().serialize();
			result1.include(result);
		} catch (Exception e) {
			com.sigfap.admin.json.fieldresearch.Error error = new com.sigfap.admin.json.fieldresearch.Error(
					"Área não encontrada.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

}
