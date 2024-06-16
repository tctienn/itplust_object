package service;


import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class GmailService {


	
	public static void sendEmail( String toAddress,
            String subject, String message) throws MessagingException {
		String userName = "demoweb2220@gmail.com";
		String host = "smtp.gmail.com";
		String port = "587";
		String password = "knxmcyngzxyyuehq";
		
        // Cấu hình properties cho session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tạo một session mới với thông tin xác thực
        Session session = Session.getInstance(properties,
                new jakarta.mail.Authenticator() {
                    protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new jakarta.mail.PasswordAuthentication(userName, password);
                    }
                });

        // Tạo một message mới
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
        msg.setText(message);

        // Gửi email
        Transport.send(msg);
    }
	
}
