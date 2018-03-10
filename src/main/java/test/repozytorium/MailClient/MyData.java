package test.repozytorium.MailClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class MyData implements Serializable {

	private static final long serialVersionUID = 1L;
	Properties props = new Properties();
	private String myMail;
	private String myPass;
	private String user;
	private String port;
	private String smtp;

	
	public MyData() {

	}
	public void loadProfile(String user) throws FileNotFoundException, IOException{
			this.user = user;
			props.load(new FileInputStream(user+"_config.txt"));
			myMail = props.getProperty("mail_adress");
			myPass = props.getProperty("password");
	}
	@SuppressWarnings("deprecation")
	public void createProfile(String user, String myMail, String myPass, String smtp, String port) {
		this.user = user;
		this.myMail = myMail;
		this.myPass = myPass;
		this.smtp = smtp;
		this.port = port;
		props.setProperty("mail_adress", myMail);
		props.setProperty("password", myPass);
		props.setProperty("smtp_host", smtp);
		props.setProperty("port", port);
		try {
			props.save(new FileOutputStream(user+"_config.txt"), "Konfiguracja uzytkownika: "+user);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void vievProps() {
		System.out.println(myMail);
		System.out.println(myPass);
	}
	
	public MyData getData() {
		return this;
	}
	public String getMyMail() {
		return myMail;
	}
	public String getMyPass() {
		return myPass;
	}
	
}
