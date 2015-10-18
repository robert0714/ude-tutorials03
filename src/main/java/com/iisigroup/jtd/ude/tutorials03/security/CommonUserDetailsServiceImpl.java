/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */
package com.iisigroup.jtd.ude.tutorials03.security;
/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */ 

import com.iisigroup.udeweb.security.common.CommonUserDetail;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 取得使用者資訊元件.
 */
public class CommonUserDetailsServiceImpl implements UserDetailsService {

     

    /**
     * constructor. 
     * @param userProvider
     */
    public CommonUserDetailsServiceImpl( ) {
         
    }

    /**
     * LoadUserByUsername.
     *
     * @param username the username
     * @return the userDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        
        UserDTO detail = new UserDTO();
        detail.setUserAccount("robert");
        detail.setUserPassword("12345");
        
        String password ="12345";
        UserDetails result = new CommonUserDetail<>(detail, password);
        System.out.println("This is robert test .............");
		return result ;
    }
}

