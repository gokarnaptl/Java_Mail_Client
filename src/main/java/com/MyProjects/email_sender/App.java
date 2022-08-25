package com.MyProjects.email_sender;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {
	public static void main(String[] args) {
		
		System.out.println("preparing....plz wait....");
		String message = "HELLLLLLOOO";
		String subject = "My 1st Maven project";
		String to = "gokarnapatil3@gmail.com";
		String from = "javamail884@gmail.com";
		
		
		sendAttach(message,subject,to,from);
	}

	
	private static void sendAttach(String message, String subject, String to, String from) {

		
		String host="smtp.gmail.com";
		
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
	
		
	
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("javamail884@gmail.com", "Javamail884488");
			}
			
			
			
		});
		
		session.setDebug(true);
		
MimeMessage m = new MimeMessage(session);
		
		try {
		
	
		m.setFrom(from);
		
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		m.setSubject(subject);
		
		m.setText("Heyyyyyy ! This is  my Java Mail");
		
		Transport.send(m);
		
		System.out.println("Mail Sent! Thank you");
		
		
		}catch (Exception e) {
		
		}
			
	}

	
}



