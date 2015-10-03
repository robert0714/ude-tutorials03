///*
// * Copyright 2005-2013 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package org.springframework.ldap.core.support;
//
//import javax.naming.NamingException;
//import javax.naming.directory.DirContext;
//import javax.naming.ldap.InitialLdapContext;
//
//import java.util.Hashtable;
//import java.util.Map.Entry;
//import java.util.Set;
//
///**
// * ContextSource implementation which creates an <code>InitialLdapContext</code>
// * instance. For configuration information, see
// * {@link org.springframework.ldap.core.support.AbstractContextSource AbstractContextSource}.
// * 
// * @see org.springframework.ldap.core.support.AbstractContextSource
// * 
// * @author Mattias Hellborg Arthursson
// * @author Adam Skogman
// * @author Ulrik Sandberg
// */
//public class LdapContextSource extends AbstractContextSource {
//
//    /*
//     * @see org.springframework.ldap.support.AbstractContextSource#getDirContextInstance(java.util.Hashtable)
//     */
//    protected DirContext getDirContextInstance(Hashtable<String, Object> environment)
//            throws NamingException {
//    	final  	Set<Entry<String, Object>> entrySet = environment.entrySet();
//    	
//    	for(Entry<String, Object> unit : entrySet){
//    		System.out.println(String.format("%s :%s", unit.getKey() , unit.getValue()  )  );    		
//    	}
//    	
////    	environment.put(Context.INITIAL_CONTEXT_FACTORY,
////                 "com.sun.jndi.ldap.LdapCtxFactory");
////    	environment.put(Context.PROVIDER_URL, "ldap://192.168.2.12:389");
////    	environment.put(Context.SECURITY_PRINCIPAL, "iisildap@iead.local");
////    	environment.put(Context.SECURITY_CREDENTIALS, "typeYourPassword");
////    	environment.put(Context.SECURITY_AUTHENTICATION, "simple");
//        return new InitialLdapContext(environment, null);
//    }
//}
