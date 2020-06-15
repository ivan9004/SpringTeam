package com.jackrutoria.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;



public class Security {
	
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(Test.class);
		final String userName = "ivan9004";
		final String password = "pbojlnxgwhrjxyup";
		String fromMail = "ivan9004@yahoo.com";
		String toMail = "pephin90@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromMail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			msg.setSubject("Tes de correo en java");
			
			
			Multipart emailContent = new MimeMultipart();
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Mi prueba con multi part");
			
			//Adjuntos Body Part
			MimeBodyPart fileAttachment = new MimeBodyPart();
			fileAttachment.attachFile("C:\\Users\\ivanm\\Desktop\\CV\\Softtek\\CV_JIMontielOrdoñez_2020.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(fileAttachment);
			
			msg.setContent(emailContent);
			
			
			Transport.send(msg);
			logger.info("Mensaje enviado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
