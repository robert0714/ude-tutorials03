package com.iisigroup.jtd.ude.tutorials03.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.util.StringUtils;

//https://dzone.com/articles/how-create-your-own-dynamic
public class DataSourcesBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	private final List<String> customerKeys;

	public DataSourcesBeanFactoryPostProcessor(Environment springEnvironment) {
		this.customerKeys = parseCustomerKeys(springEnvironment.getProperty("customerKeys"));
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		for (String customerKey : customerKeys) {
			String dataSourceName = "dataSource_" + customerKey;
			BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder
					.genericBeanDefinition(JndiObjectFactoryBean.class);
			definitionBuilder.addPropertyValue("jndiName", "jdbc/" + dataSourceName);
			registry.registerBeanDefinition(dataSourceName, definitionBuilder.getBeanDefinition());
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// we actually only add new beans, but do not post process the existing
		// definitions
	}

	private static List<String> parseCustomerKeys(String rawCustomerKeys) {
		if (StringUtils.isEmpty(rawCustomerKeys)) {
			throw new IllegalArgumentException("Property 'customerKeys' is undefined.");
		}
		return Collections.unmodifiableList(Arrays.asList(StringUtils.split(rawCustomerKeys, ",")));
	}
}