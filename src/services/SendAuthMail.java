package services;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.User;

public class SendAuthMail {

	//metoda ktora zwraca wygenerowana liczbe, oraz na podstawie usera wysyla do niego maila z kodem wyryfikacyjnym
	public int sendAuthenticatorMail(User userToConfirm) {
		
		GenerateAuthenticatorNumber genAuth = new GenerateAuthenticatorNumber();
		
		int verificationNumber = genAuth.randomNumber();
		try {
			 String host ="smtp.gmail.com" ;
<<<<<<< HEAD
	         String user = "<CLEARED>";
	         String pass = "<CLEARED>";
	         String to = userToConfirm.getUserEmail();
	         String from = "<CLEARED>";
	         String subject = "<CLEARED>";
	         String messageText = "Aby aktywowa� konto, prosz� skopiowa� numer i wklei� go na stronie weryfikacyjnej: " + verificationNumber;
=======
	         String user = "CLEARED";
	         String pass = "CLEARED";
	         String to = userToConfirm.getUserEmail();
	         String from = "CLEARED";
	         String subject = "FoodTruckFinder mail weryfikacyjny";
	         String messageText = "Aby aktywowaæ konto, proszê skopiowaæ numer i wkleiæ go na stronie weryfikacyjnej: " + verificationNumber;
>>>>>>> f848c6c617d019b749a7f48ad4480c9aa8725131
	         boolean sessionDebug = false;
	         
	         Properties props = System.getProperties();
	         props.put("mail.smtp.starttls.enable", "true");
	         props.put("mail.smtp.host", host);
	         props.put("mail.smtp.port", "587");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.smtp.starttls.required", "true");
	         props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	         
	         java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	         Session mailSession = Session.getDefaultInstance(props, null);
	         mailSession.setDebug(sessionDebug);
	         Message msg = new MimeMessage(mailSession);
	         msg.setFrom(new InternetAddress(from));
	         InternetAddress[] address = {new InternetAddress(to)};
	         msg.setRecipients(Message.RecipientType.TO, address);
	         msg.setSubject(subject); msg.setSentDate(new Date());
	         msg.setText(messageText);

	        Transport transport=mailSession.getTransport("smtp");
	        transport.connect(host, user, pass);
	        transport.sendMessage(msg, msg.getAllRecipients());
	        transport.close();
	        System.out.println("message send successfully");
			
		}
		
		catch(Exception ex)
	    {
	        System.out.println(ex);
	    }
		
		
		return verificationNumber;
	}
}
