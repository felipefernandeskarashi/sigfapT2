package com.sigfap.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

import com.sigfap.admin.model.dao.UserDAO;
import com.sigfap.admin.model.entity.User;

@Controller
public class UserController {
	private final Result result;
	
	private Validator validator;
	
	@Inject
	private Logger logger;
	
	private UserDAO dao;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected UserController()
	{
		this(null, null, null);
	}
	
	@Inject
	public UserController(Result result, Validator validator, UserDAO dao) {
		this.result = result;
		this.validator = validator;
		this.dao = dao;
	}
	
	@Get
	@Path("/user")
	public void index ()
	{
		List<User> users = dao.findAll();
		
		result.include("users", users);
	}
	
	@Get
	@Path("/user/edit/{id}")
	public void edit (int id)
	{
		
	}
	
	@Get
	@Path("/user/delete/{id}")
	public void delete (int id)
	{
		dao.delete(dao.findById(id));
		result.redirectTo(this).index();
	}
}
