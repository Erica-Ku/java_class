package edu.mission;

public class Mission2 {

	public static void main(String[] args) {
		int tot = 177000;
		int oman = 50000;
		int man = 10000;
		int och = 5000;
		int ch = 1000;
		
		int n1 = tot/oman;
		int n2 = (tot-(n1*oman))/man;
		int n3 = (tot-((n1*oman)+(n2*man)))/och;
		int n4 = (tot-((n1*oman)+(n2*man)+(n3*och)))/ch;
		
		System.out.println("5만원권 : " + n1 + "장");
		System.out.println("1만원권 : " + n2 + "장");
		System.out.println("5천원권 : " + n3 + "장");
		System.out.println("1천원권 : " + n4 + "장");
	}
}