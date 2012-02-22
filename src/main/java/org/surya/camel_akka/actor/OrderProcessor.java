package org.surya.camel_akka.actor;

import org.surya.camel_akka.message.InputOrder;

import akka.actor.TypedActor;
import akka.event.EventHandler;

public class OrderProcessor extends TypedActor implements IOrderProcessor {

	public void processOrder(InputOrder order) {
		EventHandler.info(this,
				String.format("Received Order: %s", order.toString()));
	}
}
