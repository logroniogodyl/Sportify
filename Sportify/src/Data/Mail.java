package Data;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	static String  destinatario = "";
	final static String  MITTENTE = "sportify_jami70@libero.it";
	final static String HOST = "smtp.libero.it";
	static String  oggetto = "";
	static String testo = "";
	
	public static void invioMail(String destinatario, String oggetto, String testo)
	{
		
		
		
		Properties p =  new Properties();
		p.put("mail.smtp.host", HOST);
		p.put("port", 465);
		p.put("mail.smtp.ssl.enable", "true");
	    p.put("mail.smtp.auth", "true");
		
		//Session sessione = Session.getDefaultInstance(p);
	    
	    Session session = Session.getInstance(p, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(MITTENTE, "Jami70_Sport");

            }

        });
		
	    session.setDebug(true);
	    
		MimeMessage mail = new MimeMessage(session);
		
		try {
			mail.setFrom(new InternetAddress(MITTENTE));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mail.setSubject(oggetto);
			mail.setText(testo);
			
			System.out.println("sending...");
			Transport.send(mail);
			System.out.println("Mail inviata con successo");
			
		}
		catch(Exception e) {
			System.out.println("Si è verificato un errore");
			e.printStackTrace();
		}
	}
	
}
