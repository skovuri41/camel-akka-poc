package org.surya.camel_akka.service;

import org.apache.camel.spring.Main;

public class OrderProcessorService {

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.setApplicationContextUri("./camel-context.xml");
		main.enableHangupSupport();
		main.start();

	}

}
