package org.surya.camel_akka.message;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders")
public class Orders {
	@XmlElement(required = true)
	protected List<InputOrder> orders;

	public List<InputOrder> getOrders() {
		if (orders == null) {
			orders = new ArrayList<InputOrder>();
		}
		return orders;
	}
}
