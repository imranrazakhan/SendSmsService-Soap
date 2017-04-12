package com.poc.sms.routers;

import org.apache.camel.builder.RouteBuilder;

import com.poc.sms.processors.SmsPostProcessor;
import com.poc.sms.processors.SmsPreProcessor;

public class SmsRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("cxf://http://localhost:8081/sms/sendSmsWs?serviceClass=org.sms.send_sms.service.SendSms&dataFormat=POJO")
		.process(new SmsPreProcessor())
		.to("smpp://myaccount@127.0.0.1:2777?password=mypassword&enquireLinkTimer=3000&transactionTimer=5000&systemType=producer")
		.process(new SmsPostProcessor());
		
	}
	

}
