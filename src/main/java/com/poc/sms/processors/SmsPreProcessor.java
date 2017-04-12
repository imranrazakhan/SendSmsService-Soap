package com.poc.sms.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.smpp.SmppConstants;
import org.sms.send_sms.service.SendSmsRequest;

public class SmsPreProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		 SendSmsRequest	req = exchange.getIn().getBody(SendSmsRequest.class);
         
	     exchange.getOut().setHeader(SmppConstants.COMMAND, "SubmitSm");
	     exchange.getOut().setHeader(SmppConstants.SOURCE_ADDR, req.getAddresses() );
	     exchange.getOut().setHeader(SmppConstants.DEST_ADDR, req.getSenderName() );
	     exchange.getOut().setBody(  req.getMessage()  );
		
	}

}
