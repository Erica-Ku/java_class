package edu.mission;

import java.util.Scanner;

public class Mission7 {

	public static void printGugudan(int n) {
			for(int i = 1; i <= 9 ; i++) {
				for(int j = 2; j <=3 ; j++) {
					System.out.print(n + "*" + i + "=" + (n*i));
					System.out.println("\t" + (n+1) + "*" + i + "=" + ((n+1)*i));
				}
			}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		printGugudan(n);
		
		scanner.close();
	}
}