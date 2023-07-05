//package objects;
//
//
////libraries needed for email sending
//import java.util.Properties;
//
//
//import javax.mail.Message;
//
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//
//public class EmailSender{
//	
//
//public void sendEmail(String email,String firstName, String lastName, String date, String time, String competition, String stadium, String homeTeam, String awayTeam) { //this part is related to javax.mail and our email provider "send in blue"
//
//	  String username="mohamedzaky970@gmail.com"; // this is our server username which is the same as our email
//	  String password="XjGqJtWKhnraAsUT"; //this is the email server password , DON'T MESS WITH THAT !!!
//	
//	  
//	  Properties prop = new Properties(); // it controls the properties of the connection (email side) (not related with our database)
//		prop.put("mail.smtp.auth" ,"true"); // this code just to configure that there will be authentication in the mail
//		prop.put("mail.smtp.ssl.protokls" ,"TLSv1.2"); // the protocol that email use, and yes it is written protokls , this is not a mistake
//		prop.put("mail.smtp.host","smtp-relay.sendinblue.com"); // this config our host "send in blue" , don't mess with it 
//		prop.put("mail.smtp.port","587");						//port number we use , don't change it
//		
//	Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
//		    protected PasswordAuthentication getPasswordAuthentication() {
//		        return new javax.mail.PasswordAuthentication(username, password);
//		    }
//		});
//
//		
//		
//		session.setDebug(true); // it gives us a step by step knowledge for the email sending process
//		try {
//			
//			Message message = new MimeMessage(session); // this creates the instance of our email
//			
//			message.setFrom(new InternetAddress("mohamedzaky970@gmail.com")); // sender email
//			message.setRecipient(Message.RecipientType.TO,new InternetAddress(email)); // reciever email , the reciver email is the one sent in method
//			message.setSubject("Match Booked Sir"); // write the subject in email , the part you read without opening the email
//			message.setText("Hello "+firstName+" "+lastName+" your match has been booked\nMatch Details:\n"); // the actual text in mail , the part you see when you open the email
//			Transport.send(message); 				// the step that actually sends the email 
//			
//		} catch (Exception e) {
//			
//			System.out.println("error : "+ e.getMessage());
//			
//		}
//		
//	
//}}
package objects;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public void sendEmail(String email, String firstName, String lastName, String date, String time, String competition, String stadium, String homeTeam, String awayTeam) {
        String username = "mohamedzaky970@gmail.com";
        String password = "XjGqJtWKhnraAsUT";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protokls", "TLSv1.2");
        prop.put("mail.smtp.host", "smtp-relay.sendinblue.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mohamedzaky970@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Match Booked");
            String emailContent = "Hello " + firstName + " " + lastName + ", your match has been booked.\n\nMatch Details:\n";
            emailContent += "Date: " + date + "\n";
            emailContent += "Time: " + time + "\n";
            emailContent += "Competition: " + competition + "\n";
            emailContent += "Stadium: " + stadium + "\n";
            emailContent += "Home Team: " + homeTeam + "\n";
            emailContent += "Away Team: " + awayTeam + "\n";
            
            message.setText(emailContent);
            
            Transport.send(message);
            
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void sendEmail(String email, String number) {
        String username = "mohamedzaky970@gmail.com";
        String password = "XjGqJtWKhnraAsUT";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protokls", "TLSv1.2");
        prop.put("mail.smtp.host", "smtp-relay.sendinblue.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mohamedzaky970@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("OTP code has been sent");
            String emailContent = "Please confirm your registeration by entering this form. This is the number "+ number;
            message.setText(emailContent);
            
            Transport.send(message);
            
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
