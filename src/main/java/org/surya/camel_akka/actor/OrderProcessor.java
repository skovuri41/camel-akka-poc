package org.surya.camel_akka.actor;

import akka.actor.TypedActor;
import akka.event.EventHandler;

public class OrderProcessor extends TypedActor implements IOrderProcessor {

	public OrderProcessor() {
		EventHandler.info(this, String.format("Hey I am new OrderProcessor Actor %s %s!!",
				getContext().getId(), getContext().getUuid()));
	}

	public void processOrder(String order) {
		EventHandler
				.info(this, String.format("Processing by Actor %s",
						getContext().getUuid()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
