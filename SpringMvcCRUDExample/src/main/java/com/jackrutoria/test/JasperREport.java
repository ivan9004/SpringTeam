package com.jackrutoria.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperREport {
	
	@Autowired
	private JavaMailSender mailSender;

	public static void main(String[] args) {
		JasperREport report = new JasperREport();
		report.reportView();

	}
	
	public void reportView() {
		
		final Logger logger = Logger.getLogger(JasperREport.class);
		JasperREport conn = new JasperREport();
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

			// se muestra en una ventana aparte para su descarga
			JasperPrint jasperPrintWindow = JasperFillManager.fillReport(
					"C:\\Users\\ivanm\\git\\SpringTeam\\SpringMvcCRUDExample\\src\\main\\resources\\jasperreports\\Blank_A4_report.jasper",
					null, conn.conectar());
			JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
			

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrintWindow, baos);
			DataSource aAttachment = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
			
			msg.setFrom(new InternetAddress(fromMail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			msg.setSubject("Tes de correo en java");
			
			
			Multipart emailContent = new MimeMultipart();
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Mi prueba con multi part");
			
			//Adjuntos Body Part
			MimeBodyPart fileAttachment = new MimeBodyPart();
			fileAttachment.setDataHandler(new DataHandler(aAttachment));
			fileAttachment.setFileName("report.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(fileAttachment);
			
			msg.setContent(emailContent);
			
			
			Transport.send(msg);
			logger.info("Mensaje enviado");
			jasperViewer.setVisible(true);
 
			logger.info("Mensaje enviado");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	public static Connection conectar() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://localhost:3306/usuarios?user=root&password=";
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conexion Satisfactoria");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
