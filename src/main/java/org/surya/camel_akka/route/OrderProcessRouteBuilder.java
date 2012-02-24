package org.surya.camel_akka.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.surya.camel_akka.exception.RunTimeAppException;

public class OrderProcessRouteBuilder extends RouteBuilder {
	protected transient Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void configure() throws Exception {
		log.info("## Binding OrderProcessRouteBuilder ##");

		errorHandler(defaultErrorHandler().useOriginalMessage()
				.log("!!DefaultErrorHandler!!").maximumRedeliveries(2)
				.redeliveryDelay(1000));

		onException(RunTimeAppException.class, Exception.class).handled(true)
				.maximumRedeliveries(1).useOriginalMessage()
				.redeliveryDelay(2000).logRetryAttempted(true)
				.retryAttemptedLogLevel(LoggingLevel.INFO).rollback();

		JaxbDataFormat jaxb = new JaxbDataFormat("org.surya.camel_akka.message");
		jaxb.setPrettyPrint(true);

		from("direct:marshalOrder").routeId("DirectJaxb").marshal(jaxb);

		from("activemq:orders.input").transacted().routeId("OrderProcessRoute")
				.log("Received On OrderProcessRoute->")
				// .unmarshal(jaxb)
				.to("typed-actor:orderTaker?method=processOrder");

	}
}
