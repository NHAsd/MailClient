package test.repozytorium.MailClient;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.security.auth.Subject;

public class Messages {

    private static String subject;
    private static String content;
   
    public Messages() {
        try {
        	
    
            Properties props = new Properties();

    			Session session = Session.getInstance(props, null);
            	Store store = session.getStore("pop3");
                store.connect("poczta.o2.pl", "niewnikaj99@o2.pl", "chujkurwanoobie");
                Folder folder = store.getFolder("INBOX");

                folder.open(Folder.READ_ONLY);
                int message = folder.getMessageCount();
                Message messageTab[] = folder.getMessages();
                Message mes = folder.getMessage(1);

        
            subject = mes.getSubject();
            content = (String) mes.getContent();
        }
        catch(Exception e) {
        	
        }

    }
    
    public static void main(String [] args) {
        
        try {
        	
            
            Properties props = new Properties();

    			Session session = Session.getInstance(props, null);
            	Store store = session.getStore("pop3");
                store.connect("poczta.o2.pl", "niewnikaj99@o2.pl", "chujkurwanoobie");
                Folder folder = store.getFolder("INBOX");

                folder.open(Folder.READ_ONLY);
                int message = folder.getMessageCount();
                Message messageTab[] = folder.getMessages();
                Message mes = folder.getMessage(1);
                mes.getReceivedDate(); // data otrzymania wiadomosci 
                mes.getAllRecipients(); // zwraca tablice 
                
            subject = mes.getSubject();
            content = (String) mes.getContent();
        }
        catch(Exception e) {
        	
        }


    	System.out.println("asd");
    	System.out.println(subject);
    	
    }
    
    
//
//    public void jebac() {
//        Session session = Session.getInstance(props, null);
//        try {Store store = session.getStore("pop3");
//            try {store.connect("poczta.o2.pl", "niewnikaj99@o2.pl", "chujkurwanoobie");
//            Folder folder = store.getFolder("INBOX");
//            folder.open(Folder.READ_ONLY);
//            int message = folder.getMessageCount();
//            Message messageTab[] = folder.getMessages();
//            System.out.println("Ile ostatnich wiadomości wyświetlić?");
//            int ile = 4;
//            for (int i=message; i>message-ile; i-- ){
//                Message mes = folder.getMessage(i);
//                System.out.println("Wiadomosc: " + i + " Tytuł: " + mes.getSubject());
//
//
//               
////                try {
////                    System.out.println(mes.getContent());
////                } catch (IOException e) {
////                    // TODO Auto-generated catch block
////                    e.printStackTrace();
////                }
//                //System.out.println(i);
//            }
//               
//            System.out.println("Która widomosc do odczytu: ");
//           
//            try {
//                System.out.println(messageTab[3].getContent());
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//           
//            } catch (MessagingException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (NoSuchProviderException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//       
//    }



    public String getSubject() {
        return subject;
    }



    public String getContent() {
        return content;
    }

}