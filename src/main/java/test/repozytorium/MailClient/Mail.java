package test.repozytorium.MailClient;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class Mail {
	MyData data;
	public Mail(MyData myData) {
		data = myData.getData();
	}
	
	public void sendMail(Msg message) {
		
    Properties props = new Properties();
    props.put("mail.smtp.host", data.getSmtp());
    props.put("mail.smtp.port", data.getPort());
    Session session = Session.getInstance(props, null);


    try {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(data.getMyMail());
        msg.setRecipients(Message.RecipientType.TO, message.reciver);
        msg.setSubject(message.getTitle());
//        msg.setSentDate(new Date(0));
        msg.setText(message.getMessage());
        Transport.send(msg, data.getMyMail(), data.getMyPass());
        System.out.println("mail sended");
    } catch (MessagingException mex) {
        System.out.println("send failed, exception: " + mex);
    }
	}
}