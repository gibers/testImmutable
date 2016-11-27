package com.jbc.mesObj;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Velo {
	
    final static Logger log = LoggerFactory.getLogger(Velo.class);
		
	String name; 
	int poid;
	int prix;
	
	/**
	 * affiche {@link Velo#name name} et les autres caractéristiques.
	 * 
	 */
	public void affiche() {
		String carac = ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
		log.debug("je suis un velo; " + carac);
	}
	
}
