package co.edu.unbosque.view;

import java.util.Scanner;

public class Vista {
	Scanner scan;
	public Vista() {
		scan = new Scanner(System.in);
	}
	
	public String scanS(String a) {
		System.out.println(a);
		String b = scan.next();
		return b;
	}
	
	public void imp(String a) {
		System.out.println(a);
	}
}
