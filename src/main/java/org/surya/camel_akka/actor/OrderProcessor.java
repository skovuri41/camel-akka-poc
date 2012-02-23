package org.surya.camel_akka.actor;

import org.surya.camel_akka.message.InputOrder;

import akka.actor.TypedActor;
import akka.event.EventHandler;

public class OrderProcessor extends TypedActor implements IOrderProcessor {

	public OrderProcessor() {
		EventHandler.info(this, String.format("Hey I am new Actor %s %s!!",
				getContext().getId(), getContext().getUuid()));
	}

	public void processOrder(InputOrder order) {
		System.err.println(getContext().getUuid());
		EventHandler.info(this,
				String.format("Received Order: %s", order.toString()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
