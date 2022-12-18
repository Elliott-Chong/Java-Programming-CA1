/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import javax.swing.JOptionPane;

/**
 *
 * @author elliott
 */
public class RentalMenu {

	public static void main(String[] args) {
		final String option_message = "Enter your option:\n\n1. Display all Comics\n2. Search Comic by ISBN-13\n3. Search Rentee by Member ID\n4. Print Earning Statistic\n5. Exit";
		RentalSystem rental_system = new RentalSystem();
		int choice = 0;
		OUTER:
		while (true) {
			try {
				choice = Integer.parseInt(JOptionPane.showInputDialog(null, option_message, "Comic Rental System", JOptionPane.QUESTION_MESSAGE));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid option! Please enter a number from 1 - 5", "Error", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			if (choice < 1 || choice > 5) {
				JOptionPane.showMessageDialog(null, "Invalid option! Please enter a number from 1 - 5", "Error", JOptionPane.ERROR_MESSAGE);
				continue;

			}
			switch (choice) {
				case 1:
					rental_system.displayAllComics();
					continue;
				case 2:
					rental_system.displayComic();
					continue;
				case 3:
					rental_system.displayMember();
					continue;
				case 4:
					rental_system.displayEarningStatistics();
					continue;
				case 5:
					break OUTER;
				default:
					break;
			}
		}
	}
}
