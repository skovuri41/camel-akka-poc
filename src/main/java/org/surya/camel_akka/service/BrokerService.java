package org.surya.camel_akka.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BrokerService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"./broker-context.xml");
	}
}
