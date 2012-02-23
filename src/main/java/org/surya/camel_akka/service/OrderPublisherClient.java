package org.surya.camel_akka.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderPublisherClient {

	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext appctx = new ClassPathXmlApplicationContext(
				"/publisher-context.xml");
		Thread.sleep(10000);
		appctx.close();
	}

}
