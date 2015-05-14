package com.sigfap.admin.controller;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;

import com.sigfap.admin.model.dao.UserDAO;
import com.sigfap.admin.model.entity.User;
import com.sigfap.admin.security.UserSession;
import com.sigfap.admin.security.intercept.annotation.Public;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
@Controller
public class RegisterController {
	private final Result result;

	private Validator validator;

	@Inject
    private UserDAO dao;
	/**
	 * @deprecated CDI eyes only
	 */
	protected RegisterController() {
		this(null);
	}

	@Inject
	public RegisterController(Result result) {
		this.result = result;
	}
	
	@Public
	@Path("/register")
	public void index(){
		
	}
	
	@Public
	@Post
	@Path("/register1")
	public void register(User user){
		try{
			user.setLogin(user.getLogin());
			user.setSenha(DigestUtils.shaHex(user.getSenha()));
			dao.persist(user);
		}catch(Exception ex){
			
		}
		user=null;
		result.redirectTo(AuthController.class).index();
	}
	
	
}
