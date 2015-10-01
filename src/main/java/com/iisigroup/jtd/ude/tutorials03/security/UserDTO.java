/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */
package com.iisigroup.jtd.ude.tutorials03.security;

import com.iisigroup.ude.common.info.IRole;
import com.iisigroup.ude.common.info.IUser;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 */
public class UserDTO implements Serializable ,IUser{
    /**
     * 使用者帳號
     */
    private String userAccount;
    /**
     * 使用者密碼
     */
    private String userPassword;
    private Collection<? extends IRole> roles;
    
	public String getUsername() {
		// TODO Auto-generated method stub
		return "Robert";
	}

	public Collection<? extends IRole> getRoles() { 
		return this.roles;
	}

	public boolean isActive() { 
		return true;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setRoles(Collection<? extends IRole> roles) {
		this.roles = roles;
	}
	
}
