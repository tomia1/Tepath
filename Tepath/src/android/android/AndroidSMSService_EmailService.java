package com.gluonhq.charm.down.plugins.android;

import android.content.Intent;
import android.net.Uri;
import com.gluonhq.charm.down.plugins.SMSService;
import javafxports.android.FXActivity;

public class AndroidSMSService implements SMSService {
	@Override
	public void sendSMS(String number) {
		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
		
		smsIntent.setData(Uri.parse("sms:"));
		smsIntent.putExtra("address", number);
		FXActivity.getInstance().startActivity(smsIntent);

		Services.get(SMSService.class).ifPresent(s -> button.setOnAction(e -> s.sendSMS(textField.getText())));
	}
	
	
	@Override
	public void sendEmail(String email) {
		Intent emailIntent = new Intent(Intent.ACTION_VIEW);
		
		emailIntent.setData(Uri.parse("@email:"));
		eimailIntent.putExtra("address", email);
		FXActivity.getInstance().startActivity(emailIntent);

		Services.get(EmailService.class).ifPresent(s -> button.setOnAction(e -> s.sendEmail(textField.getText())));
		
	}
}
