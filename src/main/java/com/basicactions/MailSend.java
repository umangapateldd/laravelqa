package com.basicactions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;
import com.utilities.ReadPropFile;

public class MailSend {
	ReadPropFile readPropFile = new ReadPropFile();
	String SMTP_SERVER;
	String EMAIL;
	String PASSWORD;
	String EMAIL_FROM;
	String EMAIL_TO;
	String EMAIL_TO_CC;
	String EMAIL_SUBJECT;
	String EMAIL_BODY_CONTENT;
	Message msg;
	Session session;
	Multipart multipart;
	BodyPart messageBodyPart;

	public void mailSend(String gmailEmail, String gmailPassword, String emailTo, String emailSubject,
			String emailBodyContent) throws IOException {
		mailConfig(gmailEmail, gmailPassword, emailTo, emailSubject, emailBodyContent);
		try {
			mailBody();
			mailEnclose();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void mailConfig(String gmailEmail, String gmailPassword, String emailTo, String emailSubject,
			String emailBodyContent) {
		// for example, smtp.mailgun.org
		SMTP_SERVER = "smtp.gmail.com";
//		EMAIL = readPropFile.readProp().getProperty("mailEmail");
//		PASSWORD = readPropFile.readProp().getProperty("mailPassword");
//
//		EMAIL_FROM = readPropFile.readProp().getProperty("mailEmailFrom");
//		EMAIL_TO = readPropFile.readProp().getProperty("mailEmailTo");

		EMAIL = gmailEmail;
		PASSWORD = gmailPassword;

		EMAIL_FROM = gmailEmail;
		EMAIL_TO = emailTo;
		EMAIL_TO_CC = "";

		EMAIL_SUBJECT = emailSubject;

		EMAIL_BODY_CONTENT = emailBodyContent;

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", SMTP_SERVER);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enable", "true");

		session = Session.getInstance(prop, null);
		msg = new MimeMessage(session);
	}

	public void mailBody() throws AddressException, MessagingException {
		// from
		msg.setFrom(new InternetAddress(EMAIL_FROM));

		// to
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));

		// cc
		msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(EMAIL_TO_CC, false));

		// subject
		msg.setSubject(EMAIL_SUBJECT);

		// Create the message part
		messageBodyPart = new MimeBodyPart();

		// Now set the actual message
		messageBodyPart.setText(EMAIL_BODY_CONTENT);

		// Create a multipart message
		multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);
	}

	public void mailEnclose() throws MessagingException {
		// Send the complete message parts
		msg.setContent(multipart);

		// Get SMTPTransport
		Transport t = session.getTransport("smtp");

		// connect
		t.connect(SMTP_SERVER, EMAIL, PASSWORD);

		// send
		t.sendMessage(msg, msg.getAllRecipients());

		t.close();
	}

	public void mailSend(String gmailEmail, String gmailPassword, String emailTo, String emailSubject,
			String emailBodyContent, String[] attachmentNameWithExtension) throws IOException {
		mailConfig(gmailEmail, gmailPassword, emailTo, emailSubject, emailBodyContent);
		try {
			mailBody();

			// Add Attachments
			String[] filename = attachmentNameWithExtension;
			for (int i = 0; i < filename.length; i++) {
				addAttachment(multipart, filename[i]);
			}

			mailEnclose();

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void addAttachment(Multipart multipart, String filename) throws MessagingException {
		File file = new File(filename);
		if (file.exists()) {
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
		}
	}

}
