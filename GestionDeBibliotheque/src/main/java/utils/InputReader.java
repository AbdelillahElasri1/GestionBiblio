package utils;

import java.util.Scanner;

public class InputReader {
	private final Scanner scanner;
	
	public InputReader(java.io.InputStream inputStream) {
		this.scanner = new Scanner(inputStream);
	}
	public String readLine() {
		return scanner.nextLine();
	}
	public int readInt(){
		int value = -1;
		while (true){
			try {
				value = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter an integer: ");
			}
		}
		return value;
	}
	
}
