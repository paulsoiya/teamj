package model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

}
