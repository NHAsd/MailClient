package test.repozytorium.MailClient;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * MailClient
 *
 */
import java.util.Properties;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
    	MyData profile = new MyData();
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	String menu;
    	boolean men = false;
    	System.out.println("Program mail client");
    	do {
        	System.out.println("Dostepne opcje: ");
        	System.out.println("Utworz profil. Komenda - create");
        	System.out.println("wczytaj profil. Komenda - load");
        	menu = scanner.nextLine();
	    	if(menu.equals("create")) {
	    		System.out.println("podaj nazwe konta");
	    		String user = scanner.nextLine();
	    		System.out.println("podaj adres email");
	    		String myMail = scanner.nextLine();
	    		System.out.println("podaj haslo");
	    		String myPass = scanner.nextLine();
	    		System.out.println("podaj adres serwera smtp");
	    		String smtp = scanner.nextLine();
	    		System.out.println("podaj port");
	    		String port = scanner.nextLine();
	        	profile.createProfile(user, myMail, myPass, smtp, port);
				try {
					profile.loadProfile(user);
				} catch (FileNotFoundException e) {
					System.out.println("profil o nazwie " + user + " nie istnieje.");
					men = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	men = false;
	    	}
	    	else if(menu.equals("load")) {
	    		System.out.println("podaj nazwe konta");
	    		String user = scanner.nextLine();
	        	try {
					profile.loadProfile(user);
					men = false;
				} catch (FileNotFoundException e) {
					System.out.println("profil o nazwie " + user + " nie istnieje.");
					men = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	
	    	}
	    	else {
	    		System.out.println("zla komenda");
	    		men = true;
	    	}
    	}while(men);
    	profile.vievUser();
       	Mail mail = new Mail(profile);
       	mail.sendMail(new Msg().writeMail());
    }
}


 