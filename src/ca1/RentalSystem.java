/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 *
 * @author elliott
 */
import java.awt.Font;
import javax.swing.*;

public class RentalSystem {

	private Comic[] comics = {
		new Comic("978-0-4118-9361-3", "The Amazing Spider-man", 203, 20.5),
		new Comic("978-4-4602-6853-8", "Captain America", 89, 10.5),
		new Comic("978-8-5019-6465-6", "Batman", 103, 13.5),
		new Comic("978-3-4913-5834-5", "Cat woman", 293, 16.7),};
	private Rentee[] rentees = {
		new Rentee("Elliott"),
		new Rentee("Travis"),
		new Rentee("Kaushik"),};

	public double getRentalFee(double price) {
		return price / 20.0;
	}

	public double getDepositFee(double price) {
		return price + (price / 100.0 * 10.0);
	}

	public void displayMember() {
		for (Rentee r : rentees) {
			System.out.println(r.getMember_id());
		}
		int index = -1;
		double totalRental = 0;
		String inputId = JOptionPane.showInputDialog(null, "Enter MemberID to search:");

		for (int i = 0; i < rentees.length; i++) {
			Rentee rentee = rentees[i];
			if (inputId.equals(rentee.getMember_id())) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			JOptionPane.showMessageDialog(null, String.format("Cannot find the MemberId \"%s\"!!", inputId), "Info",
				JOptionPane.ERROR_MESSAGE);
		} else {
			Rentee rentee = rentees[index]; // Storing found rentee in rental object
			String format = "%-10s | %-35s \n";
			StringBuilder sb = new StringBuilder();
			sb.append(String.format(format, "MemberID", "Name"));
			sb.append("------------------------------\n");
			sb.append(String.format(format, rentee.getMember_id(), rentee.getName()));
			sb.append("\nComics Loaned:\n");
			for (int i = 0; i < rentee.getComics_loaned().length; i++) {
				Comic comic = rentee.getComics_loaned()[i];
				sb.append(i + 1 + ". " + comic.getTitle_name() + "\n");

				// Calculating the total rental per day
				totalRental += getRentalFee(comic.getCost_price());
			}
			sb.append("\n\n" + "Total Rental Per Day: $" + String.format("%.2f", totalRental));
			JTextArea message = getFormattedMsg(sb);
			JOptionPane.showMessageDialog(null, message, "All Comics", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sb.toString());
		}
	}

	public void displayComic() {
		int index = -1;
		String inputIsbn = JOptionPane.showInputDialog(null, "Enter ISBN-13 to search:");

		for (int i = 0; i < comics.length; i++) {
			Comic comic = comics[i];
			if (inputIsbn.equals(comic.getIsbn())) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			JOptionPane.showMessageDialog(null, String.format("Cannot find the Comic \"%s\"!!", inputIsbn), "Info",
				JOptionPane.ERROR_MESSAGE);
		} else {
			Comic comic = comics[index]; // Storing found comic in comic object
			String rentalFee = String.format("%.2f", getRentalFee(comic.getCost_price()));
			String depositFee = String.format("%.2f", getDepositFee(comic.getCost_price()));
			String message = String.format(
				"%s\n\nStock purchased at $%s.\nCost $%s per day to rent.\nRequire deposit of $%s.",
				comic.getTitle_name(), Double.toString(comic.getCost_price()), rentalFee, depositFee);

			JOptionPane.showMessageDialog(null, message);
		}
	}

	public void displayEarningStatistics() {
		double average_earning = 0;
		double total_earning = 0;
		int total_rentees = rentees.length;

		for (Rentee rentee : rentees) {
			for (Comic comic : rentee.getComics_loaned()) {
				total_earning += getRentalFee(comic.getCost_price());
			}
		}
		average_earning = total_earning / total_rentees;
		String message = String.format("""
                Earning Per Day:

                -------------

                There are %s Rentees in total.

                Average earning per day based on numbers of rentees is $%.2f.

                Total earning per day is $%.2f.
                """, total_rentees, average_earning, total_earning);

		JOptionPane.showMessageDialog(null, message);

	}

	public void displayAllComics() {
		double rentalFee;
		double depositFee;
		String format = "%-25s | %-35s | %-6s | %-10s | %s%n";
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(format, "ISBN-13", "Title", "Pages", "Price/Day", "Deposit"));
		sb.append("------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < this.comics.length; i++) {
			Comic comic = this.comics[i];
			rentalFee = getRentalFee(comic.getCost_price());
			depositFee = getDepositFee(comic.getCost_price());
			sb.append(String.format(format, comic.getIsbn(), comics[i].getTitle_name(), comic.getCost_price(),
				String.format("$%.2f", rentalFee), String.format("$%.2f", depositFee)));
		}
		JTextArea message = getFormattedMsg(sb);
		JOptionPane.showMessageDialog(null, message, "All Comics", JOptionPane.INFORMATION_MESSAGE);
		System.out.println(sb.toString());
	}

	public JTextArea getFormattedMsg(StringBuilder msg) {
		JTextArea label = new JTextArea(msg.toString());
		label.setOpaque(false);
		label.setEditable(false);
		label.setFont(new Font("Monospaced", Font.BOLD, 12));

		return label;
	}
}
