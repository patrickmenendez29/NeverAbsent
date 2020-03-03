import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class HtmlEmailSender {
public void sendHtmlEmail(
final String userName, final String password, String toAddress,
String subject, String message, String attachment) throws AddressException,
MessagingException {
// sets SMTP server properties
Properties properties = new Properties();
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", "587");
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");


// creates a new session with an authenticator
Authenticator auth = new Authenticator() {
public PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(userName, password);
}
};
Session session = Session.getInstance(properties, auth);
// creates a new e-mail message
Message msg = new MimeMessage(session);
msg.setFrom(new InternetAddress(userName));

BodyPart messageBodyPart = new MimeBodyPart();

Multipart multipart = new MimeMultipart();


messageBodyPart = new MimeBodyPart();
String filename = "example.pdf";
DataSource source = (DataSource) new FileDataSource(filename);
messageBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) source));
messageBodyPart.setFileName(filename);
multipart.addBodyPart(messageBodyPart);

msg.setContent(multipart);



        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
msg.setRecipients(Message.RecipientType.TO, toAddresses);
msg.setSubject(subject);
msg.setSentDate(new Date());
// set plain text message
msg.setContent(multipart, "text/html");
// sends the e-mail
Transport.send(msg);
}
/**
 * Test the send html e-mail method
 *
 */
        public static void main(String[] args) {
// SMTP server information

String mailFrom = "patrick.menendezrosado@saintandrews.net";
String password = "dmiskzqbsfytvedb";
// outgoing message information
String mailTo = "patrick.menendezrosado@saintandrews.net";
String subject = "Hello my friend";
// message contains HTML markups
String message = "<i>Greetings!</i><br>";
message += "<b>Wish you a nice day!</b><br>";
message += "<font color=red>Duke</font>";
HtmlEmailSender mailer = new HtmlEmailSender();
try {
mailer.sendHtmlEmail( mailFrom, password, mailTo,
                    subject, message,null);
System.out.println("Email sent.");
} catch (Exception ex) {
System.out.println("Failed to sent email.");
ex.printStackTrace();
}
}
}