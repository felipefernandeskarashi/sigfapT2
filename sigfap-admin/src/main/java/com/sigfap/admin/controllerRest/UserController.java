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
	protected UserController() {
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

		if (!users.isEmpty()) {
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

			result.setValue(users);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include("usuarios", result);
		} else {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Nenhum usuário cadastrado.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

	@Public
	@Post
	@Path("/v1/user")
	public void inserirUsuario(User user) {
		if (user.getLogin() == null && user.getSenha() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Informe o e-mail e senha.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if (user.getLogin() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"O e-mail (login) precisa ser preenchido.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if (user.getSenha() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"A senha precisa ser preenchida.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else {
			user.setLogin(user.getLogin());
			user.setSenha(DigestUtils.shaHex(user.getSenha()));
			try {
				dao.persist(user);
				com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

				result.getValue().add(user);

				result1.use(Results.json()).from(result).recursive()
						.serialize();
				result1.include(result);
			} catch (Exception e) {
				com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
						"Impossivel criar usuário.");
				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
			}
		}
	}

	@Public
	@Put("/v1/user")
	public void editarUsuario(User user) {
		if (user.getLogin() == null && user.getSenha() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Informe o e-mail e senha.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if (user.getLogin() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"O e-mail (login) precisa ser preenchido.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else if (user.getSenha() == null) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"A senha precisa ser preenchida.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		} else {

			user.setSenha(DigestUtils.shaHex(user.getSenha()));

			try {
				dao.update(user);
				com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

				result.getValue().add(user);

				result1.use(Results.json()).from(result).recursive()
						.serialize();
				result1.include(result);
			} catch (Exception e) {
				com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
						"Impossivel editar usuário.");
				result1.use(Results.json()).from(error).serialize();
			}
		}
	}

	@Public
	@Delete("/v1/user/{id}")
	public void removerUsuario(int id) {
		User user = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

			result.getValue().add(user);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		} catch (Exception e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Usuário não encontrado.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

}
