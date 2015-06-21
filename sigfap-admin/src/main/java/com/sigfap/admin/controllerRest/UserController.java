package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.sigfap.admin.model.dao.UserDAO;
import com.sigfap.admin.model.entity.User;
import com.sigfap.admin.security.intercept.annotation.Public;



@Controller
public class UserController {

	private final Result result1;
	
	@Inject
	private UserDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected UserController(){
		this(null, null);
	}

	@Inject	
	public UserController(Result result1, UserDAO dao) {
		this.result1 = result1;
		this.dao = dao;
	}
	
	
	/** V1 - Versão 1 **/
	
	@Public
	@Get("/v1/users")
	public void listarUsuario() {
			List<User> users = dao.findAll();
			
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();
			result.setUsuarios(users);
			
			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include("usuarios", result);
	}
	
	@Public
	@Post
	@Path("/v1/user")
	public void inserirUsuario(User user) {
		user.setLogin(user.getLogin());
		user.setSenha(DigestUtils.shaHex(user.getSenha()));
		try {
			dao.persist(user);
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result(user);
			
			result.getUsuarios().add(user);
			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		} catch (Exception e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error("Impossivel criar usuário.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}
	
	@Public
	@Put("/v1/user")
	public void editarUsuario(){
		
	}
	
	@Public
	@Delete("/v1/user/{id}")
	public void removerUsuario(int id){
		User user = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();
			result.getUsuarios().add(user);
			
			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		}
		catch (Exception e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error("Usuário não encontrado.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}
	
}
