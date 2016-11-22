package com.jbc.testImmutable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import testImmutable.Config;

import com.jbc.mesObj.Garage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Garage garage = context.getBean(Garage.class);        
        garage.affiche();
        
    }
}
