/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */
package com.iisigroup.udeweb.security.common;

import com.iisigroup.ude.common.info.IRole;
import com.iisigroup.ude.common.info.IUser;
import com.iisigroup.ude.common.info.IUserHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The Class CommonUserDetail.
 *
 * @param <U> the generic type
 */
public class CommonUserDetail<U extends IUser> implements UserDetails, IUserHolder<U> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1439325273462952423L;

    /** The detail. */
    private final U detail;

    /** The authorities. */
    private Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

    /** The password. */
    private final String password;

    /** The root menu. */
    private MenuItem rootMenu = MenuItem.EMPTY_ROOT;

    /**
     * constructor. 
     *
     * @param detail the detail
     * @param password the password
     */
    public CommonUserDetail(U detail, String password) {
        this.detail = detail;
        this.password = password;
        if (detail != null) {
            final Collection<? extends IRole> roles = detail.getRoles();
            if (roles != null) {
                final List<GrantedAuthority> authorities = new ArrayList<>();
                for (final IRole iRole : roles) {
                    authorities.add(new SimpleGrantedAuthority(iRole.getRolename()));
                }
                this.authorities = authorities;
            }
        }
    }

    /**
     * Gets the detail.
     *
     * @return the detail
     */
    @Override
    public U getDetail() {
        return this.detail;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        return this.detail.getUsername();
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Gets the authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * Checks if is account non expired.
     *
     * @return true, if is account non expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if is account non locked.
     *
     * @return true, if is account non locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if is credentials non expired.
     *
     * @return true, if is credentials non expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    @Override
    public boolean isEnabled() {
        return this.detail.isActive();
    };

    /**
     * Gets the root menu.
     *
     * @return the rootMenu
     */
    public MenuItem getRootMenu() {
        return this.rootMenu;
    }

    /**
     * Sets the root menu.
     *
     * @param rootMenu the rootMenu to set
     */
    public void setRootMenu(MenuItem rootMenu) {
        this.rootMenu = rootMenu;
    }

}
