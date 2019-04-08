package hu.headortail.model.service;

import java.util.Scanner;

public class Console {

	private final Scanner scanner;

	public Console(Scanner scanner) {
		this.scanner = scanner;
	}
	

	public String readBet(String text) {
		System.out.print(text);
		return scanner.next().toUpperCase();
	}
}
