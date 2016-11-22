package com.jbc.mesObj;

import org.springframework.stereotype.Component;

@Component
public class Velo {
		
	String name; 
	int poid;
	int prix;
	
	public void affiche() {
		System.out.println("je suis un velo");
	}
	
}
