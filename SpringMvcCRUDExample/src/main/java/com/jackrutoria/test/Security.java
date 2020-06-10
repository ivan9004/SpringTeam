package com.jackrutoria.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;



public class Security {
	final Logger logger = Logger.getLogger(Test.class);

	@Scheduled(fixedRate = 5000)
	public void run() throws InterruptedException {

		logger.info("Tarea Pprogramada"+new Date());
		
		Thread.sleep(3000);
	}

}
