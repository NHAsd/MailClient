package pl.codeme.email;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

	public class GetEmailRR {
		private static String to;
		private static String from;
		private static String text;
		private static String host;

		//private static Message message;
		static Scanner scanner = new Scanner(System.in);
		public static void getEmail(){

			to = "rrzeszotek@vp.pl";
			from = "rrzeszotek@vp.pl";
			text = "Hello";
			host = "smtp.poczta.onet.pl";

			Properties props = new Properties();
			Session session = Session.getInstance(props, null);
		    try {Store store = session.getStore("pop3");
		    	try {store.connect(host, to, "1buzon1");
		    	Folder folder = store.getFolder("INBOX");
		    	folder.open(Folder.READ_ONLY);
		    	int message = folder.getMessageCount();
		    	Message messageTab[] = folder.getMessages();
		    	System.out.println("Ile ostatnich wiadomości wyświetlić?");
		    	int ile = scanner.nextInt();
		    	for (int i=message; i>message-ile; i-- ){
			    	Message mes = folder.getMessage(i);
			    	System.out.println("Wiadomosc: " + i + " Tytuł: " + mes.getSubject());


					
//			    	try {
//						System.out.println(mes.getContent());
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
			    	//System.out.println(i);
		    	}
		    		
		    	System.out.println("Która widomosc do odczytu: ");
				int messNumber = scanner.nextInt();
				try {
					System.out.println(messageTab[messNumber-1].getContent());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
