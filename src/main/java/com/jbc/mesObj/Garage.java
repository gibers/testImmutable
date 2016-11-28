package com.jbc.mesObj;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbc.beans.Contact;
import com.jbc.beans.ImmutableContact;

@Component
public class Garage {

    final static Logger log = LoggerFactory.getLogger(Garage.class);
    
	@Autowired
	Velo velo;
	
	@Autowired
	ContactRepository contactRep ;

	public void affiche () {
		log.debug("je suis un garage");
		velo.affiche();
	}
	
	public void listAll() {
		List<Contact> ll = contactRep.findAll();
		
		for(Contact l1 : ll) {
			if(l1 instanceof ImmutableContact) {
				ImmutableContact imm = (ImmutableContact) l1;
				log.debug(imm.toString());
			}
		}
		
//		log.debug(ReflectionToStringBuilder.toString(ll, ToStringStyle.MULTI_LINE_STYLE));
//		return contactRep.findAll();
	}

}

