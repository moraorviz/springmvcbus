package impl.bus.presentation.ticketresume;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

	final String username = "autobusmvcprueba@gmail.com";
	final String password = "Mypassword123";
	private String destinatario;
	private String code;

	public Email(String destinatario, String code) {
		this.destinatario = destinatario;
		this.code = code;
	}

	public void sendEmail() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("autobusmvcprueba@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(this.destinatario));
			message.setSubject("Atubous Gmail TLS");
			message.setText("Dear User ," + "\n\n You have booked travel number " + this.code);

			Transport.send(message);

			System.out.println("Message sent.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
