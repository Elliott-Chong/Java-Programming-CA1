/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.util.Random;

/**
 *
 * @author elliott
 */
public class Rentee {

	private String member_id;
	private String name;
	private Comic[] comics_loaned = {};

	public static String generateRandomId(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		return sb.toString();
	}

	Rentee(String name) {
		this.member_id = generateRandomId(10);
		this.name = name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Comic[] getComics_loaned() {
		return this.comics_loaned;
	}

	public void setComics_loaned(Comic[] comics_loaned) {
		this.comics_loaned = comics_loaned;
	}
}
