package org.surya.camel_akka.route;

import org.apache.camel.builder.RouteBuilder;
import org.surya.camel_akka.message.InputOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.apache.camel.component.stax.StAXBuilder.stax;

public class OrderPublishRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// Thread Pool
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		// Route
		from("file:src/data?noop=true").split(stax(InputOrder.class))
				.streaming().executorService(threadPool)
				.log("Publishing to Queue ${body}").convertBodyTo(String.class)
				.to("activemq:orders.input?jmsMessageType=Text");

	}
}
