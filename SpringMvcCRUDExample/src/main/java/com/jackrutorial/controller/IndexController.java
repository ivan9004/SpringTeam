package com.jackrutorial.controller;

import java.io.InputStream;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackrutoria.test.Test;
import com.jackrutorial.service.ReporteCompraService;
import com.jackrutorial.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	UserService userService;

	@Autowired
	ReporteCompraService reporteService;

	final Logger logger = Logger.getLogger(IndexController.class);

	public Properties loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("email.properties");
		Properties prop = new Properties();
		try {
			prop.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

	@RequestMapping(value = "/admin")
	public String inicio(ModelMap model, Authentication authentication) {
		authentication.getPrincipal();
		model.addAttribute("user", userService.getActiveUser(authentication.getName()));
		return "index";
	}

	// Se añade un cometario a la clase IndexController
	@RequestMapping("/report")
	public String verReporte(Model model,
			@RequestParam(name = "format", defaultValue = "pdf", required = false) String format) {

		final IndexController prop = new IndexController();
		String toMail = "pephin90@gmail.com";

		Properties properties = new Properties();
		properties.put(prop.loadProperties().getProperty("Auth"), prop.loadProperties().getProperty("enable"));
		properties.put(prop.loadProperties().getProperty("Starttls"), prop.loadProperties().getProperty("starttlsEnable"));
		properties.put(prop.loadProperties().getProperty("host"), prop.loadProperties().getProperty("hostValue"));
		properties.put(prop.loadProperties().getProperty("port"), prop.loadProperties().getProperty("portValue"));

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.loadProperties().getProperty("userName"), prop.loadProperties().getProperty("password"));
			}
		});

		MimeMessage msg = new MimeMessage(session);

		try {

			model.addAttribute("format", format);
			model.addAttribute("datasource_report", reporteService.listCombinado());
			model.addAttribute("AUTOR", "Ivan");

			msg.setFrom(new InternetAddress(prop.loadProperties().getProperty("fromMail")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			msg.setSubject(prop.loadProperties().getProperty("titulo"));

			Multipart emailContent = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(prop.loadProperties().getProperty("mensaje"));

			MimeBodyPart fileAttachment = new MimeBodyPart();
			fileAttachment.attachFile("C:\\Users\\ivanm\\Desktop\\Desarrollo\\Bucket\\test.pdf");

			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(fileAttachment);

			msg.setContent(emailContent);

			Transport.send(msg);
		} catch (Exception e) {
			logger.error(e);
		}

		return "Blank_A4_report";
	}

}
