package by.epam.training.kazieva.logic;

import by.epam.training.kazieva.exception.LogicException;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class MailLogic {

    private static final Logger logger = Logger.getLogger(MailLogic.class);
    private static final String HOST ="smtp.gmail.com";
    private static final String USER="mmf.abiturient@gmail.com";
    private static final String PASS="mmf.abiturient2018";
    private static final String FROM="mmf.abiturient@gmail.com";
    private static final String SUBJECT="REGISTRATIN IN MMF ABTURUEN SERVICE";
    private static final String TRUE="true";
    private static final String PORT = "587";
    private static final String TRUST = "smtp.gmail.com";

    public static void sendRegistratedEmail(String email, String password, String key, String fname) throws LogicException {
        String to = email;
        String text ="Hello, "+fname+"!"+"\n" +
                "Your login is "+email+". \n"+
                "Your password = "+password+" and key ="+key+". \n"+
                "Kind regards"+". \n"+
                "MMF BSU";
        boolean sessionDebug=false;

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable",TRUE);
        properties.put("mail.smtp.ssl.trust", TRUST);
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth",TRUE);
        properties.put("mail.smtp.starttls.required",TRUE);

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession= Session.getDefaultInstance(properties);
        mailSession.setDebug(sessionDebug);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(SUBJECT);
            message.setSentDate(new Date());
            message.setText(text);

            Transport tr=mailSession.getTransport("smtp");
            tr.connect(HOST,USER,PASS);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
            logger.info("send good");
        } catch (NoSuchProviderException e) {
            logger.error(e);
            throw new LogicException("Error NoSuchProviderException email");
        } catch (MessagingException e) {
            logger.error(e);
            throw new LogicException("Error MessagingException email");
        }
    }
}
