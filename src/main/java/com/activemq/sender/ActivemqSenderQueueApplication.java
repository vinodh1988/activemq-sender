package com.activemq.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class ActivemqSenderQueueApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(ActivemqSenderQueueApplication.class, args);
		
		
	     JmsTemplate jms = ctx.getBean(JmsTemplate.class);
	     while(true) {
	    	 long id = Math.round(Math.random()*10000);
	    	  if(id==9495)
	    		  break;
	    	 	jms.convertAndSend("MyQueue", "Message "+id);
	}

}}
