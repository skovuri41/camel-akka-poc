package org.surya.camel_akka.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import akka.actor.ActorRef;

public class OrderProcessorService2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"./camel-context.xml");
		ActorRef actorRef = (ActorRef) context.getBean("myActor");
		ActorRef actorRef2 = (ActorRef) context.getBean("myActor");
		ActorRef actorRef3 = (ActorRef) context.getBean("myActor");
		ActorRef actorRef4 = (ActorRef) context.getBean("myActor");
		ActorRef actorRef5 = (ActorRef) context.getBean("myActor");
		ActorRef actorRef6 = (ActorRef) context.getBean("myActor");
		ActorRef actorRef7 = (ActorRef) context.getBean("myActor");
		actorRef.start();
		actorRef2.start();
		actorRef3.start();
		actorRef4.start();
		actorRef5.start();
		actorRef6.start();
		actorRef7.start();

	}
}
