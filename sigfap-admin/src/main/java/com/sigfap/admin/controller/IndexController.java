package com.sigfap.admin.controller;

import javax.inject.Inject;

import com.sigfap.admin.security.intercept.annotation.Public;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Public
	@Path("/")
	public void index() {
		
	}
}