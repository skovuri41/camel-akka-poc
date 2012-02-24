package org.surya.camel_akka.actor;

import static akka.actor.Actors.actorOf;
import akka.actor.ActorRef;
import akka.actor.TypedActor;
import akka.actor.UntypedActor;
import akka.actor.UntypedActorFactory;
import akka.event.EventHandler;

public class OrderTaker extends TypedActor implements IOrderProcessor {

	private ActorRef router;

	public OrderTaker() {
		EventHandler.info(this, String.format(
				"Hey I am OrderTaker Actor %s %s!!", getContext().getId(),
				getContext().getUuid()));

		// create the workers
		final ActorRef[] orderProcessors = new ActorRef[50];
		for (int i = 0; i < 50; i++) {
			orderProcessors[i] = actorOf(OrderProcessorUntyped.class).start();
		}

		// wrap them with a load-balancing router
		router = actorOf(new UntypedActorFactory() {
			public UntypedActor create() {
				return new OrderRouter(orderProcessors);
			}
		}).start();

	}

	public void processOrder(String order) {
		EventHandler.info(this,
				String.format("Received Order: %s", order.toString()));
		router.tell(order);
	}
}
