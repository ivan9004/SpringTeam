package com.jackrutoria.test;

import org.apache.log4j.Logger;

public class Test {

	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(Test.class);
		
		logger.debug("Esta es una prueba debug: "+ "parameter/exception oject");
		logger.info("Este es con info:"+ "parameter/exception oject");
		logger.warn("Este es con warn:  "+ "parameter/exception oject");
		logger.error("Este es con error:  "+ "parameter/exception oject");
		logger.fatal("Este es con fatal: "+ "parameter/exception oject");
	}

}
