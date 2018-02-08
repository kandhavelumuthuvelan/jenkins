package jenkins;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

    public static void main(String[]args) throws IOException {

       final String username = "kandhavelu.muthuvelan@aspiresys.com";
        String password = "velu@123";
        final String receipt = "kandhavelu.muthuvelan@aspiresys.com";
        //final String username = "kandhavelu";
       // String password = "aspire123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.aspiresys.com");
        props.put("mail.smtp.port", "25");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        
        try {
        	
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receipt));
            message.setSubject("BIS");
            message.setText("demo mail");

            Transport.send(message);

            System.out.println("Done"+receipt);

        	 } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}