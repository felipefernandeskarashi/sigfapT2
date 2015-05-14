package com.sigfap.admin.controller;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.UserDAO;
import com.sigfap.admin.model.entity.User;
import com.sigfap.admin.security.UserSession;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class AuthController {
	private final Result result;

	private Validator validator;

	@Inject
	private UserDAO dao;

	@Inject
	private UserSession userSession;

	/**
	 * @deprecated CDI eyes only
	 */
	protected AuthController() {
		this(null, null);
	}

	@Inject
	public AuthController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Public
	@Path("/auth")
	public void index() {
		
	}

	@Public
	@Post
	@Path("/signup")
	public void signup(User user) {
		validator.addIf(dao.loginExists(user.getEmail()), new SimpleMessage(
				"nome", "login.already.exists"));
		validator.onErrorRedirectTo(this).index();

		/**
		 * Login == e-mail
		 * */

		user.setLogin(user.getEmail());
		user.setPassword(DigestUtils.shaHex(user.getPassword()));
		try {
			dao.persist(user);

			validator.add(new SimpleMessage("sucess", "user.created.success",
					Severity.SUCCESS));
		} catch (Exception e) {
			result.include("error", "user.created.error" + e.getMessage());
		}

		result.redirectTo(this).index();
	}

	@Public
	@Post
	@Path("/signin")
	public void signin(User user) {
		User userLogged = null;

		try {
			userLogged = dao.authentication(user.getLogin(), user.getPassword());
			
			if(userLogged == null)
			{
				result.include("error", "wrong.login.or.password");
				result.redirectTo(this).index();
			}
			else
			{
				result.include("message", "successful.login");
				
				userSession.setUser(userLogged);
				
				result.redirectTo(IndexController.class).index();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.include("error", e.getMessage());
			result.redirectTo(this).index();
		}

	}

	@Public
	@Get
	@Path("/logout")
	public void logout() {
		userSession.logout();
		result.redirectTo(this).index();
		
	}
}
