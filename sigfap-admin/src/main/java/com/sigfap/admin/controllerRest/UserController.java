package com.sigfap.admin.controllerRest;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.exception.JDBCConnectionException;

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
import com.sigfap.admin.validation.CheckEmail;

@Controller
public class UserController {

	private final Result result1;

	@Inject
	private UserDAO dao;

	@Inject
	private CheckEmail verificadorEmail;

	/**
	 * @deprecated CDI eyes only
	 */
	protected UserController() {
		this(null);
	}

	@Inject
	public UserController(Result result1) {
		this.result1 = result1;
	}

	/** V1 - Versão 1 **/

	@Public
	@Get
	@Path("/v1/users")
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
	@Post("/v1/user")
	public void inserirUsuario(User user) {

		String validaEmail = user.getLogin();

		if ((verificadorEmail.isEmail(validaEmail) == false)
				|| (user.getSenha() == null)) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Informe o e-mail ou senha corretamente.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
			return;
		}

		else {

			user.setLogin(user.getLogin());
			user.setSenha(DigestUtils.shaHex(user.getSenha()));

			try {
				dao.persist(user);
				com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

				result.getValue().add(user);

				result1.use(Results.json()).from(result).recursive()
						.serialize();
				result1.include(result);
			}

			catch (JDBCConnectionException e) {
				com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
						"Problema de conexão com o banco.");
				result1.use(Results.json()).from(error).recursive().serialize();
				result1.include(error);
			}

			catch (Exception e) {
				com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
						"Impossivel criar usuário.");
				result1.use(Results.json()).from(error).recursive().serialize();
				result1.include(error);
			}
		}
	}

	@Public
	@Put("/v1/user/{id}")
	public void editarUsuario(int id, User user) {

		User user1 = dao.findById(id);

		String validaEmail2 = user.getLogin();

		if (user.getLogin() != null) {
			if (verificadorEmail.isEmail(validaEmail2) == false) {
				com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
						"Informe o e-mail corretamente.");
				result1.use(Results.json()).from(error).serialize();
				result1.include(error);
				return;
			}

			else {
				user1.setLogin(user.getLogin());
			}
		}

		if (user.getSenha() != null) {
			user1.setSenha(DigestUtils.shaHex(user.getSenha()));
		}

		try {

			dao.update(user1);

			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

			result.getValue().add(user1);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		}

		catch (JDBCConnectionException e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Problema de conexão com o banco.");
			result1.use(Results.json()).from(error).recursive().serialize();
			result1.include(error);
		}

		catch (Exception e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Impossivel editar usuário.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}

	}

	@Public
	@Delete
	@Path("/v1/user/{id}")
	public void removerUsuario(int id) {
		User user = dao.findById(id);
		try {
			dao.deleteById(id);
			com.sigfap.admin.json.user.Result result = new com.sigfap.admin.json.user.Result();

			result.getValue().add(user);

			result1.use(Results.json()).from(result).recursive().serialize();
			result1.include(result);
		} catch (JDBCConnectionException e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Problema de conexão com o banco.");
			result1.use(Results.json()).from(error).recursive().serialize();
		} catch (Exception e) {
			com.sigfap.admin.json.user.Error error = new com.sigfap.admin.json.user.Error(
					"Usuário não encontrado.");
			result1.use(Results.json()).from(error).serialize();
			result1.include(error);
		}
	}

}