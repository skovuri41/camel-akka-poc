package org.surya.camel_akka.actor;

import akka.actor.UntypedActor;
import akka.event.EventHandler;

public class OrderProcessorUntyped extends UntypedActor {

	public OrderProcessorUntyped() {
		EventHandler.info(this, String.format("Hey I am new OrderProcessorUntyped %s %s!!",
				getContext().getId(), getContext().getUuid()));
	}

	public void onReceive(Object message) {
		if (message instanceof String) {
			String body = (String) message;
			// EventHandler.info(this,
			// String.format("Received Order: %s by %s \n",
			// body));
			EventHandler.info(this, String.format("Processing by Actor %s",
					getContext().getUuid()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
