package org.surya.camel_akka.actor;

import akka.camel.Message;
import akka.camel.UntypedConsumerActor;
import akka.event.EventHandler;

public class OrderProcessor2 extends UntypedConsumerActor {

	public OrderProcessor2() {
		EventHandler.info(this, String.format("Hey I am new Actor2 %s %s!!",
				getContext().getId(), getContext().getUuid()));
	}

	public String getEndpointUri() {
		return "activemq:orders.input";
	}

	public void onReceive(Object message) {
		Message msg = (Message) message;
		String body = msg.getBodyAs(String.class);
		//EventHandler.info(this, String.format("Received Order: %s by %s \n", body));
		EventHandler
				.info(this, String.format("Processing by Actor %s",
						getContext().getUuid()));
	}
}
