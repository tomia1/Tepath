package com.gluonhq.charm.down.plugins;

import com.gluonhq.charm.down.DefaultServiceFactory;

public class EmailServiceFactory extends DefaultServiceFactory<EmailService> {
	
		public EmailServiceFactory() {
	        super(EmailService.class);
	    }
}
