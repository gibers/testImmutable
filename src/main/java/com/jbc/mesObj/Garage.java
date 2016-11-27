package com.jbc.mesObj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbc.testImmutable.App;

@Component
public class Garage {

    final static Logger log = LoggerFactory.getLogger(Garage.class);
    
	@Autowired
	Velo velo;

	public void affiche () {
		log.debug("je suis un garage");
		velo.affiche();
	}

}
