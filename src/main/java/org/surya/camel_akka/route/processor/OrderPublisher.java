package org.surya.camel_akka.route.processor;

import java.util.EnumMap;
import java.util.Map.Entry;

import org.apache.camel.Body;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.surya.camel_akka.exception.RunTimeAppException;
import org.surya.camel_akka.message.MessageType;
import org.surya.camel_akka.message.OutgoingMessage;

public class OrderPublisher {

	protected transient Logger log = LoggerFactory.getLogger(getClass());

	private final ProducerTemplate template;

	public OrderPublisher(ProducerTemplate template) {
		super();
		this.template = template;
	}

	public void publish(
			@Body EnumMap<MessageType, OutgoingMessage> outgoingMsgMap) {

		try {
			for (Entry<MessageType, OutgoingMessage> entry : outgoingMsgMap
					.entrySet()) {
				MessageType msgType = entry.getKey();
				OutgoingMessage outgoingMessageObj = entry.getValue();
				for (String recipient : outgoingMessageObj.getRecipients()) {
					log.info(
							"Publishing message type {} to Recipeint {} with message \n {} ",
							new Object[] { msgType.name(), recipient,
									outgoingMessageObj.getMsg() });
					this.template.sendBodyAndHeaders(recipient,
							outgoingMessageObj.getMsg(),
							outgoingMessageObj.getHeaders());
				}
			}
			template.stop();
		} catch (Exception ex) {
			StringBuilder sbr = new StringBuilder(
					"!!! Exception:  TradePublisher. Cause: ").append(ex
					.getMessage());
			throw new RunTimeAppException(sbr.toString(), ex);
		}
	}

}
