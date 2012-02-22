package org.surya.camel_akka.actor;

import org.surya.camel_akka.message.InputOrder;

public interface IOrderProcessor {
	public void processOrder(InputOrder order);
}
