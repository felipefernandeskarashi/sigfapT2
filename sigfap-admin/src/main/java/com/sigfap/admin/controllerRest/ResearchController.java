package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class ResearchController {

<<<<<<< HEAD
	private final Result result1;

=======
	private final Result result;
	
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
	private ResearchDAO dao;

	/**
	 * @deprecated CDI eyes only
	 */
	protected ResearchController() {
		this(null, null);
	}

	@Inject
<<<<<<< HEAD
	public ResearchController(Result result1, ResearchDAO dao) {
		this.result1 = result1;
=======
	public ResearchController(Result result, ResearchDAO dao){
		this.result = result;
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
		this.dao = dao;
	}

	/** V1 - Versão 1 **/

	@Public
<<<<<<< HEAD
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

=======
	@Get
	@Path("/v1/researches")
	public void listarPesquisador(){
		
		List<Research> researches = dao.findAll();
		
		com.sigfap.admin.json.research.Result result1 = new com.sigfap.admin.json.research.Result();
		result1.setValue(researches);
		
		result.use(Results.json()).from(result).include("value").exclude("value.pesquisadorUnidades").serialize();
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
	}

	@Public
<<<<<<< HEAD
	@Post("/v1/researcher")
	public void inserirPesquisador() {

=======
	@Post
	@Path("/v1/researcher")
	public void inserirPesquisador(Research research){
		//faze de teste
		try {
			
			dao.persist(research);			
			com.sigfap.admin.json.research.Result result1 = new com.sigfap.admin.json.research.Result();
			result1.getValue().add(research);
			result.use(Results.json()).from(result1).exclude("value.pesquisadorUnidades").serialize();
			
		} catch (Exception e) {
			
			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error("Impossivel criar Pesquisador");
			result.use(Results.json()).from(error).serialize(); 			
		}
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
	}

	@Public
	@Put("/v1/researcher")
	public void editarPesquisador() {

	}

	@Public
	@Delete("/v1/researcher/{id}")
<<<<<<< HEAD
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
=======
	public void removerPesquisador(int id){
//		Research research = dao.findById(id);
//		try {
//			dao.deleteById(id);
//			com.sigfap.admin.json.research.Result result = new com.sigfap.admin.json.research.Result();
//			result.getPesquisadores().add(research);
//			
//			result1.use(Results.json()).from(result).recursive().serialize();
//			result1.include(result);
//		} catch (Exception e) {
//			com.sigfap.admin.json.research.Error error = new com.sigfap.admin.json.research.Error("Pesquisador não encontrado.");
//			result1.use(Results.json()).from(error).serialize();
//			result1.include(error);
//		}
>>>>>>> c989b65612bfd7473a1452751b334ed4bdf3f12d
	}

}
