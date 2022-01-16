/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SendEmail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javafx.scene.control.Button;

public class SendEmail {

	private static String seatPlace = new String();
	private static String fnbPlace = new String();

	public static void setFnbPlace(String fnbPlace) {
		SendEmail.fnbPlace = "";

		SendEmail.fnbPlace = fnbPlace;
	}

	public static void setSeat(String seat) {
		SendEmail.seatPlace = "";

		SendEmail.seatPlace = seat;
	}

	public void sendEmail() {

		// authentication info
		final String username = "cubacinema118@gmail.com";
		final String password = "cubacinema123";
		String fromEmail = "cubacinema118@gmail.com";
		String toEmail = "afiq.danish306@gmail.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// Qr element

		Random random = new Random();

		// qrID Generator

		String qrID = "";

		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%&";

		for (int i = 0; i < 20; i++) {
			// Add a random char from the chars string to the rand string
			qrID += chars.toCharArray()[new Random().nextInt(chars.length())];
		}

		String movie = "Spodemum";
		String date = "69/69";
		String time = "14.30";
		String location = "midvalley";
		String hall = "10";
		String seat = seatPlace;
		String fnb = fnbPlace;

		// QR generator

		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(qrID, BarcodeFormat.QR_CODE, 500, 500);

			MatrixToImageWriter.writeToPath(bitMatrix, "png", Paths.get("D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\SendEmail\\qr.png"));
		} catch (IOException | WriterException e1) {

			e1.printStackTrace();
		}

		// Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Subject Line");

			Multipart emailContent = new MimeMultipart();

			// Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Movie: " + movie + "\nDate: " + date + "\nTime" + time + "\nLocation: " + location
					+ "\nHall: " + hall + "\nSeat: " + seat + "\nFood and bervages: " + fnb
					+ "\n\nThank you for watching with GSC.");

			// Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile("D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\SendEmail\\qr.png");

			// Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);

			// Attach multipart to message
			msg.setContent(emailContent);

			Transport.send(msg);

			File file = new File("D:\\newCode\\university\\FundamentalOfProgramming\\assigment\\CineBook\\cinebook\\src\\SendEmail\\qr.png");

			if (file.delete()) // delete() will delete the selected file from system and return true if deletes
								// successfully else it'll return false
			{
				System.out.println("Selected File deleted successfully");
			} else {
				System.out.println("Failed to delete the selected file");
			}

			System.out.println("Sent message");
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}

	}

}