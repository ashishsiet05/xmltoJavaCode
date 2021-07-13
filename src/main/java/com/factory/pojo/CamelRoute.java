package com.factory.pojo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;


public class CamelRoute extends RouteBuilder {

	
	         
	@Override
	public void configure() throws Exception {
		JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
		jaxbDataFormat.setObjectFactory(false);
		jaxbDataFormat.setContextPath("com.factory.jaxb");

		from("file://data?noop=true").logMask()
				.process((exchange)-> {
						System.out.println("you are in processer block you build your logic here "+exchange.getExchangeId());
						
						
						
				})/* .to("cxf:bean:customerServiceEndpoint") */
				.unmarshal(jaxbDataFormat)
			    .log("Processing ${body.getQuestionname()}");
}
}
