package org.surya.camel_akka.route.processor;

import java.util.EnumMap;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.surya.camel_akka.message.InputOrder;
import org.surya.camel_akka.message.MessageType;
import org.surya.camel_akka.message.OutgoingMessage;
import org.surya.camel_akka.persister.OrderPersister;

public class OrderController {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	private OrderPersister persister;

	public OrderController(OrderPersister persister) {
		super();
		this.persister = persister;
	}

	public void processOrder(Exchange exchange) {

		InputOrder order = exchange.getIn().getBody(InputOrder.class);

		log.info("Processing Order {}", order.getRefNo());

		// validate order

		// generate outgoingmessages enumMap
		OutgoingMessage xmlMsg = new OutgoingMessage(MessageType.XML, "",
				"activemq:orders.billing");

		OutgoingMessage strMsg = new OutgoingMessage(MessageType.STRING,
				order.toString(), "activemq:orders.shipping");

		EnumMap<MessageType, OutgoingMessage> messageMap = new EnumMap<MessageType, OutgoingMessage>(
				MessageType.class);
		messageMap.put(xmlMsg.getMsgType(), xmlMsg);
		messageMap.put(strMsg.getMsgType(), strMsg);

		// persist order
		this.persister.save(order, exchange.getContext().getRegistry());

		exchange.getIn().setBody(messageMap);

	}

}
