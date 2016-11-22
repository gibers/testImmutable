package com.jbc.mesObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Garage {

	@Autowired
	Velo velo;

	public void affiche () {
		System.out.println("je suis un garage");
	}
	
}
