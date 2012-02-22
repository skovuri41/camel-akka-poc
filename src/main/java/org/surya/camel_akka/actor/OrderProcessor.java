package org.surya.camel_akka.actor;

import akka.actor.UntypedActor;
import akka.event.EventHandler;

public class OrderProcessor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof String)
			EventHandler.info(this,
					String.format("Received String message: %s", message));
		else
			throw new IllegalArgumentException("Unknown message: " + message);
	}
}
