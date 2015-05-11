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

import com.sigfap.admin.security.intercept.annotation.Rest;




public class RestInterceptor 
{
	@Inject
	private Logger logger;
	
	@Inject
    private HttpServletRequest request;
	
    @Accepts
    public boolean accepts(ControllerMethod method) {
        return 
            !(method.getMethod().isAnnotationPresent(Rest.class) ||
            method.getController().getType().isAnnotationPresent(Rest.class));
    }
    
    @AroundCall
    public void intercept(SimpleInterceptorStack stack) 
    {
    }
}
