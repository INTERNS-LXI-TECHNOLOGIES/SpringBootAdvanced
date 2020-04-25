package com.adarsh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.adarsh.config.PersistanceJpaConfig;
import com.adarsh.config.WebMvcConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {
	
	 @Override
	    protected Class <?> [] getRootConfigClasses() {
	        return new Class[] {
	            PersistanceJpaConfig.class
	        };
	        //return null;
	    }

	    @Override
	    protected Class <?> [] getServletConfigClasses() {
	        return new Class[] {
	            WebMvcConfig.class
	        };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] {
	            "/"
	        };
	    }

}
