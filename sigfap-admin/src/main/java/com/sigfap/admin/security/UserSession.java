package com.sigfap.admin.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.sigfap.admin.model.entity.User;


@SessionScoped
public class UserSession implements Serializable 
{

	private static final long serialVersionUID = -7823721496962045205L;
	private User user;

    public boolean isLogged() 
    {
        return user != null;
    }

    public void logout() 
    {
        user = null;
    }
    
    public void setUser(User user)
    {
    	this.user = user;
    }
}
