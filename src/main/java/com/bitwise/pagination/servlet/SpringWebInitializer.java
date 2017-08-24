package com.bitwise.pagination.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bitwise.pagination.config.SpringWebConfig;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] {};
	}

}