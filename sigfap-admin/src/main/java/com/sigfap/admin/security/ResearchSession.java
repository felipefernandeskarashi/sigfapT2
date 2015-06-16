package com.sigfap.admin.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.sigfap.admin.model.entity.Research;


@SessionScoped
public class ResearchSession implements Serializable 
{

	private static final long serialVersionUID = -7823721496962045205L;
	private Research research;

    public boolean isLogged() 
    {
        return research != null;
    }

    public void logout() 
    {
        research = null;
    }
    
    public void setResearch(Research research)
    {
    	this.research = research;
    }
}
