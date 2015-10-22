package by.ansgar.helper.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
	
	public static boolean senMail(String user, String password, String message,
			String [] to) {

		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", true);
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMes = new MimeMessage(session);
		
		try {
			mimeMes.setFrom(new InternetAddress(user));
			InternetAddress [] toAddress = new InternetAddress[to.length];
			for(int i = 0; i < to.length; i++){
				toAddress[i] = new InternetAddress(to[i]);
			}
			for(int i = 0; i < toAddress.length; i++){
				mimeMes.addRecipients(RecipientType.TO, toAddress);
			}
			
			mimeMes.setSubject("mail using javamail api");
			mimeMes.setText(message);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(mimeMes, mimeMes.getAllRecipients());
			transport.close();
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
