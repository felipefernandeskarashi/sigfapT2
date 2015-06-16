package com.sigfap.admin.security.intercept;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

import com.sigfap.admin.controller.AuthController;
import com.sigfap.admin.security.ResearchSession;
import com.sigfap.admin.security.UserSession;
import com.sigfap.admin.security.intercept.annotation.Public;



@Intercepts
public class SessionInterceptor 
{
	@Inject
	private Logger logger;
	
	@Inject
    private HttpServletRequest request;
	
	@Inject
    private Result result;
	
	@Inject
    private UserSession userSession;

	@Inject
    private ResearchSession researchSession;

	/**
	 * Verica se action do Controller possui a annotation @Public
	 * @param method
	 * @return
	 */
    @Accepts
    public boolean accepts(ControllerMethod method) 
    {
        return 
            !(method.getMethod().isAnnotationPresent(Public.class) ||
            method.getController().getType().isAnnotationPresent(Public.class));
    }
    
    /**
	 * Caso a action não seja pública, o acesso será 
	 * redirecionado para a página de login
	 * */
    @AroundCall
    public void intercept(SimpleInterceptorStack stack) 
    {
    	logger.debug("Intercept!");
    	
    	if (userSession.isLogged() || researchSession.isLogged()) 
    		stack.next();
        else 
        	result.redirectTo(AuthController.class).index();
    }
}
