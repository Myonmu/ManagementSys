package Other;
import javax.mail.*;
import javax.mail.internet.*;

import DAO.AbsenceDAO;

import java.util.*;
import javax.activation.*;
/**
 * Mail sender
 * However, the mail sent by the program is often considered spam.
 * !!!Do not use the mail address provided for spamming.!!!
 * @author Hippocrate
 *
 */
public class Mail {
    private final String user="gestion.absence.miskatonic";
    private final String password="QuickSand3014";
    private static String host = "smtp.gmail.com";
    private Properties properties;
    private Session session;
    public Mail() {
    	properties=new Properties();
    	properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        session=Session.getInstance(properties,new javax.mail.Authenticator() {
            	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }
    /**
     * Sends a warning mail to student
     * @param to
     */
    public void sendAbsWarning(String to) {
    	
    	try {
    		MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("[ATTENTION] Votre heures d'absence");
			message.setText("Bonjour, \n "
					+ "Vous avez depasse la limite de nombre d'heures d'absence.\n"
					+ "Penalites vous seront attribues.\n"
					+ "Serieusement,\n"
					+ "Systeme de gestion d'absence");
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
     * send warning email to every student who has been too lazy
     */
    public void sendMultiWarning() {
    	AbsenceDAO absDAO=new AbsenceDAO();
    	ArrayList<String> mailList=absDAO.getWarningMailList();
    	for(String i:mailList) {
    		sendAbsWarning(i);
    	}
    }
    public static void main(String[] args) {
    	Mail m=new Mail();
    	m.sendAbsWarning("miskatonic3014@yahoo.co.jp");
    }
}
