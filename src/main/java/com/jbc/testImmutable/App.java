package com.jbc.testImmutable;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import testImmutable.Config;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.jbc.mesObj.FoobarValue;
import com.jbc.mesObj.Garage;
import com.jbc.mesObj.ImmutableFoobarValue;

/**
 * Hello world!
 *
 */
public class App {
	
    final static Logger log = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
//    	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//    	StatusPrinter.print(lc);

    	log.debug("Hello World!");
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Garage garage = context.getBean(Garage.class);        
        garage.affiche();
        garage.listAll();
        
        FoobarValue value = ImmutableFoobarValue.builder().foo(2).bar("Bar").addBuz(1,2,3).build();
        
        int foo = value.foo();
        List<Integer> buz = value.buz();
    }
}
