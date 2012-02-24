package org.surya.camel_akka.actor;

import akka.actor.ActorRef;
import akka.routing.InfiniteIterator;
import akka.routing.UntypedLoadBalancer;
import akka.routing.CyclicIterator;
import static java.util.Arrays.asList;

public class OrderRouter extends UntypedLoadBalancer {

	private final InfiniteIterator<ActorRef> orderProcessors;

	public OrderRouter(ActorRef[] orderProcessors) {
		this.orderProcessors = new CyclicIterator<ActorRef>(
				asList(orderProcessors));
	}

	@Override
	public InfiniteIterator<ActorRef> seq() {
		return orderProcessors;
	}

}
