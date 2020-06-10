package com.jackrutoria.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

public class App {

	final static Logger logger = Logger.getLogger(Test.class);

	@Scheduled(cron = "*/5 * * * * ?")
	public static void main(String[] args) throws InterruptedException {
		logger.info("Tarea Pprogramada" + new Date());

		Thread.sleep(3000);
	}

}
