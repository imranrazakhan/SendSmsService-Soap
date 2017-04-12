package com.poc.sms.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.sms.send_sms.service.SendSmsResponse;

public class SmsPostProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		SendSmsResponse	smsResponse	=	new SendSmsResponse();
		smsResponse.setResult("Sms Sent");
		
		exchange.getOut().setBody( smsResponse );
		
	}

}
