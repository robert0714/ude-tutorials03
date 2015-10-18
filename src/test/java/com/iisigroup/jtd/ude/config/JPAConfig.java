/*
 * Copyright (c) 2010-2020 IISI.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of IISI.
 */
package com.iisigroup.jtd.ude.config;

import com.iisigroup.jtd.ude.tutorials03.services.ContactService;
import com.iisigroup.jtd.ude.tutorials03.services.ContactServiceForJPAImpl;

import javax.sql.DataSource;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource; 

@Configuration 
@ImportResource("classpath:datasource-tx-jpa.xml")
public class JPAConfig {
	
	@Autowired
	private DataSource ds ;

    @Bean(name="databaseTester")
    public DataSourceDatabaseTester dataSourceDatabaseTester() {  
        DataSourceDatabaseTester databaseTester =
                new DataSourceDatabaseTester(ds);
        return databaseTester;
    }
    
	

    @Bean(name="xlsDataFileLoader")
    public XlsDataFileLoader xlsDataFileLoader() {
        return new XlsDataFileLoader();
    }
    @Bean(name="contactServiceJPAImpl")
    public ContactService getContactService() {
        return new ContactServiceForJPAImpl();
    }
	
}