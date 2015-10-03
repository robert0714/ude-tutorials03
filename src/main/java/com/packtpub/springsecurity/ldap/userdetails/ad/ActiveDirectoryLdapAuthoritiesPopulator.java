package com.packtpub.springsecurity.ldap.userdetails.ad;
 

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapRdn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

/**
 * An {@link LdapAuthoritiesPopulator} that is based on the {@link ActiveDirectoryLdapAuthenticationProvider}. The
 * implementation obtains the {@link GrantedAuthority}'s from the userData's memberOf attribute. It then uses the last
 * {@link LdapRdn}'s value as the {@link GrantedAuthority}.
 *
 * @author Rob Winch
 * @see ActiveDirectoryLdapAuthenticationProvider
 */
public final class ActiveDirectoryLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
	private final Logger logger = LoggerFactory.getLogger(ActiveDirectoryLdapAuthoritiesPopulator.class);

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(final DirContextOperations userData, String username) {
    	final String[] groups = userData.getStringAttributes("memberOf");
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        logger.info("username: {}" ,username);
        logger.info("userData: {}" ,ToStringBuilder.reflectionToString(userData));
        
        for (String group : groups) {
        	authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            LdapRdn authority = new DistinguishedName(group).removeLast();
            authorities.add(new SimpleGrantedAuthority(authority.getValue()));
        }
        return authorities;
    }
}