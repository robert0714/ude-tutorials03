/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */
package com.iisigroup.jtd.ude.tutorials03.security;

import com.iisigroup.ude.common.info.ISystem;
import com.iisigroup.ude.common.info.IUser;
import com.iisigroup.udeweb.security.UserProvider;


/**
 *
 */
public class UserProviderImpl implements UserProvider<UserDTO> {

    //================================================
    //== [Enumeration types] Block Start
    //== [Enumeration types] Block End 
    //================================================
    //== [static variables] Block Start
    //== [static variables] Block Stop 
    //================================================
    //== [instance variables] Block Start

    private String salt = "";
 

    //== [instance variables] Block Stop 
    //================================================
    //== [static Constructor] Block Start
    //== [static Constructor] Block Stop 
    //================================================
    //== [Constructors] Block Start (含init method)
    //== [Constructors] Block Stop 
    //================================================
    //== [Static Method] Block Start
    //== [Static Method] Block Stop 
    //================================================
    //== [Accessor] Block Start

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    //== [Accessor] Block Stop 
    //================================================
    //== [Overrided Method] Block Start (Ex. toString/equals+hashCode)
    //== [Overrided Method] Block Stop 
    //================================================
    //== [Method] Block Start

    //####################################################################
    //## [Method] sub-block : 
    //####################################################################

    @Override
    public UserDTO getUserByName(ISystem system, String userName) {

      
        return new UserDTO();
    }

    @Override
    public String getUserPassword(IUser detail) {
        return "12345";
    }

    //== [Method] Block Stop 
    //================================================
    //== [Inner Class] Block Start
    //== [Inner Class] Block Stop 
    //================================================
}