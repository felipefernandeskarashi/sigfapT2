package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.exception.JDBCConnectionException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.SkillDAO;
import com.sigfap.admin.model.entity.Skill;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class SkillController {

	private final Result result1;

	@Inject
	private SkillDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected SkillController() {
		this(null);
	}

	@Inject
	public SkillController(Result result1) {
		this.result1 = result1;
	}

	/** V1 - Versão 1 **/

	@Public
	@Get
	@Path("/v1/skills")
	public void listarArea() {
		List<Skill> skills = dao.findAll();

		if (!skills.isEmpty()) {
			com.sigfap.admin.json.skill.Result result = new com.sigfap.admin.json.skill.Result();

			result.setValue(skills);

			result1.use(Results.json()).from(result)
					.exclude("value.pesquisadores").recursive().serialize();
			result1.include("areas", result);
			return;
		} else {
			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Nenhuma área de conhecimento cadastrada.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

	@Public
	@Post("/v1/skill")
	public void inserirArea(Skill skill) {

		try {

			if (skill.getNome() == null) {
				com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
						"Precisa preencher o nome da área de conhecimento.");

				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
				return;
			} else {

				dao.persist(skill);
				com.sigfap.admin.json.skill.Result result = new com.sigfap.admin.json.skill.Result();

				result.getValue().add(skill);

				result1.use(Results.json()).from(result)
						.exclude("value.pesquisadores").recursive().serialize();
				result1.include(result);
			}
		} catch (JDBCConnectionException e) {

			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Problema de conexão com o banco.");
			result1.use(Results.json()).from(error).recursive().serialize();
			result1.include(error);

		} catch (Exception e) {
			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Erro ao cadastrar área de conhecimento.");

			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

	@Public
	@Put("/v1/skill")
	public void editarArea(Skill skill) {

		if (skill.getNome() == null) {
			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Preencher o nome da área de conhecimento.");
			result1.use(Results.json()).from(error).recursive().serialize();
			result1.include(error);
			return;
		}

		else {
	
			try {

				dao.update(skill);

				com.sigfap.admin.json.skill.Result result = new com.sigfap.admin.json.skill.Result();
				result.getValue().add(skill);

				result1.use(Results.json()).from(result)
						.exclude("value.pesquisadores").recursive().serialize();
				result1.include(result);
			}

			catch (Exception e) {

				com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
						"Impossível editar área de conhecimento.");
				result1.use(Results.json()).from(error).recursive().serialize();
				result1.include(error);
			}

		}
	}

	@Public
	@Delete
	@Path("/v1/skill/{id}")
	public void removerArea(int id) {
		Skill skill = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.skill.Result result = new com.sigfap.admin.json.skill.Result();

			result.getValue().add(skill);

			result1.use(Results.json()).from(result)
					.exclude("value.pesquisadores").recursive().serialize();
			result1.include(result);
		} catch (JDBCConnectionException e) {

			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Problema de conexão com o banco.");
			result1.use(Results.json()).from(error).recursive().serialize();

		} catch (Exception e) {
			com.sigfap.admin.json.skill.Error error = new com.sigfap.admin.json.skill.Error(
					"Área não encontrada.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

}
