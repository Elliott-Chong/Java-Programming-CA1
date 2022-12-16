/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author elliott
 */
import javax.swing.JOptionPane;

public class RentalSystem {

	public static String generateSpaces(int num) {
		String spaces = "";
		for (int i = 0; i < num; i++) {
			spaces += " ";
		}
		return spaces;
	}

	private Comic[] comics = {
		new Comic("978-0-4118-9361-3", "The Amazing Spider-man", 203, 20.5),
		new Comic("978-4-4602-6853-8", "Captain America", 89, 10.5),
		new Comic("978-8-5019-6465-6", "Batman", 103, 13.5),
		new Comic("978-3-4913-5834-5", "Cat woman", 293, 16.7),};
	private Rentee[] rentees = {
		new Rentee("Elliott"),
		new Rentee("Travis"),
		new Rentee("Kaushik"),};

	RentalSystem() {

	}

	public void displayAllComics() {
		String message_string = "ISBN-13" + generateSpaces(30) + "|Title" + generateSpaces(40) + "|Pages" + generateSpaces(10) + "|Price / Day" + generateSpaces(5) + "|Deposit\n-------------------------------------------------------------";

		for (int i = 0; i < this.comics.length; i++) {
			Comic comic = this.comics[i];
			message_string += "\n";
			message_string += comic.getIsbn();
			message_string += generateSpaces(30 - "ISBN-13".length() - comic.getIsbn().length()) + "|";
			message_string += comic.getTitle_name();
			message_string += generateSpaces(40 - comic.getTitle_name().length()) + "|";
			message_string += comic.getNum_pages();
		}

		JOptionPane.showMessageDialog(null, message_string, "All Comics", JOptionPane.INFORMATION_MESSAGE);
	}
}
