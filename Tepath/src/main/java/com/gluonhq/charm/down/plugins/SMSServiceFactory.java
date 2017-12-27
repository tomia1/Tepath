package com.gluonhq.charm.down.plugins;

import com.gluonhq.charm.down.DefaultServiceFactory;

public class SMSServiceFactory extends DefaultServiceFactory<SMSService> {
	public SMSServiceFactory() {
        super(SMSService.class);
    }
}
