package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class ResearchController {

	private final Result result1;

	private ResearchDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null, null);
	}

	@Inject
	public ResearchController(Result result1, ResearchDAO dao) {
		this.result1 = result1;
		this.dao = dao;
	}

	/** V1 - Versão 1 **/

	@Public
	@Get("/v1/researches")
	public void listarPesquisador() {
		List<Research> researches = dao.findAll();

		if (!researches.isEmpty()) {
			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
			result.setValue(researches);

			result1.use(Results.json()).from(result).exclude("value.telefones","value.pesquisadorUnidades", "value.etniaPes", "value.enderecoRes", "value.enderecoCom", "value.area").recursive().serialize();
			result1.include("pesquisadores", result);
		} else {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Pesquisador não encontrado.");
			
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}

	}

	@Public
	@Post("/v1/researcher")
	public void inserirPesquisador() {

	}

	@Public
	@Put("/v1/researcher")
	public void editarPesquisador() {

	}

	@Public
	@Delete("/v1/researcher/{id}")
	public void removerPesquisador(int id) {
		Research research = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
			result.getValue().add(research);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		} catch (Exception e) {
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error(
					"Pesquisador não encontrado.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

}
