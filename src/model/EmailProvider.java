package model;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * Allows for the ability to send email messages over STMP 
 * @author Paul Soiya II
 * @version April 7, 2015
 */
public class EmailProvider {
	
	private static EmailProvider instance = null;

	public final static String STMP_USER = "sports.comparison@gmail.com";
	private final String STMP_HOST = "smtp.gmail.com";
	private final String STMP_PORT = "587";
	private final String STMP_PASSWORD = "sportsComp";
	
	private EmailProvider() { }
	
	public static EmailProvider getInstance() {
		if (instance == null) {
			instance = new EmailProvider();
		}
		return instance;
	}
	
	/**
	 * Sends an email via STMP
	 * @param email
	 * @return
	 */
	public boolean sendEmail(Email email) {

		boolean sent = false;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", STMP_HOST);
		props.put("mail.smtp.port", STMP_PORT);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(STMP_USER,
								STMP_PASSWORD);
					}
				});

		//check if there is an attachment and branch accordingly 
		if (email.getAttachmentPath() == null || email.getAttachmentPath().equals("") ) {
			sent = sendBasicEmail(session, email);
			System.out.println("ATTACHMENT IS NULL");
		} else { 
			sent = sendMultiPartEmail(session, email);
		}

		return sent;
	}
	
	/**
	 * Sends a basic text only email
	 * @param session
	 * @param email
	 * @return
	 */
	private boolean sendBasicEmail(Session session, Email email){
		
		boolean sent = false;
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getFrom()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getBody());

			Transport.send(message);

			sent = true;

		} catch (MessagingException mesExp) {
			System.out.println(getClass().getSimpleName()
					+ " has error message = " + mesExp.getMessage());
		}

		return sent;
	}
	
	/**
	 * Sends an email with an attachment
	 * @param session
	 * @param email
	 * @return
	 */
	private boolean sendMultiPartEmail(Session session, Email email) {

		boolean sent = false;

		try {
		
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFrom())); 
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email.getTo()));
			msg.setSubject(email.getSubject());
			
			Multipart mp = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(email.getBody(), "text/html");
			mp.addBodyPart(htmlPart);
			
			// Create a new part for the attached file
			MimeBodyPart attachment = new MimeBodyPart();
			attachment.attachFile(new File(email.getAttachmentPath()));
			attachment.setHeader("Content-Type", "image/png");

			mp.addBodyPart(attachment);
			
			msg.setContent(mp);
			
			//must set this so class loader knows of the different MIME types
			MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap(); 
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html"); 
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml"); 
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain"); 
			mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed"); 
			mc.addMailcap("message/rfc822;; x-java-content- handler=com.sun.mail.handlers.message_rfc822");
			
			Transport.send(msg);

			sent = true;

		} catch (MessagingException mesExp) {
			System.out.println(getClass().getSimpleName()
					+ " has error message = " + mesExp.getMessage());
			mesExp.printStackTrace();
		} catch (IOException e) {
			System.out.println(getClass().getSimpleName()
					+ " has error message = " + e.getMessage());
		}

		return sent;
	}
	

}
