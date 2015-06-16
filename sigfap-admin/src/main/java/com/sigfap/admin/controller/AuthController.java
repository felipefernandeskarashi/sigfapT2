package com.sigfap.admin.controller;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.ResearchDAO;
import com.sigfap.admin.model.dao.UserDAO;
import com.sigfap.admin.model.entity.Research;
import com.sigfap.admin.model.entity.User;
import com.sigfap.admin.security.ResearchSession;
import com.sigfap.admin.security.UserSession;
import com.sigfap.admin.security.intercept.annotation.Public;

@Controller
public class AuthController {
	private final Result result;

	private Validator validator;

	@Inject
	private UserDAO dao;
	
	@Inject
	private ResearchDAO dao1;

	@Inject
	private UserSession userSession;

	@Inject
	private ResearchSession researchSession;

	/**
	 * @deprecated CDI eyes only
	 */
	protected AuthController() {
		this(null);
	}

	@Inject
	public AuthController(Result result) {
		this.result = result;
	}

	@Public
	@Path("/auth")
	public void index() {
		
	}

	@Public
	@Path("/signup")
	public void signup() {

	}
	
	@Public
	@Post
	@Path("/save")
	public void save(User user) {
//		validator.addIf(dao.loginExists(user.getLogin()), new SimpleMessage(
//				"e-mail", "login.already.exists"));
//		validator.onErrorRedirectTo(this).index();

		/**
		 * Login == e-mail
		 * */

		user.setLogin(user.getLogin());
		user.setSenha(DigestUtils.shaHex(user.getSenha()));
		try {
			dao.persist(user);

//			validator.add(new SimpleMessage("sucess", "user.created.success",
//					Severity.SUCCESS));
			result.include("mensagem", "Usuário cadastrado com sucesso.");
						
		} catch (Exception e) {
//			validator.add(new SimpleMessage("error", "user.notcreated.error",Severity.ERROR));
			result.include("error", "user.created.error" + e.getMessage());
			result.include("mensagem", "Usuário não cadastrado.");
		}
		user=null;
		result.redirectTo(this).index();
	}

	@Public
	@Post
	@Path("/signin")
	public void signin(User user) {
		User userLogged = null;

		try {
			userLogged = dao.authentication(user.getLogin(), user.getSenha());
			
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
	@Post
	@Path("/signinResearch")
	public void signinResearch(Research research) {
		Research researchLogged = null;

		try {
			researchLogged = dao1.authentication(research.getEmail(), research.getSenha());
			
			if(researchLogged == null)
			{
				result.include("error", "wrong.login.or.password");
				result.redirectTo(this).index();
			}
			else
			{
				result.include("message", "successful.login");
				
				researchSession.setResearch(researchLogged);
				
				result.redirectTo(PanelController.class).index();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.include("error", e.getMessage());
			result.redirectTo(this).index();
		}
		
//		result.redirectTo(PanelController.class).index();

	}

	@Public
	@Get
	@Path("/logout")
	public void logout() {
		userSession.logout();
		result.redirectTo(this).index();
		
	}
}
