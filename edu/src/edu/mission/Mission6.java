package edu.mission;

public class Mission6 {

	public static void main(String[] args) {
		int a = 12;
		int b = 18;
		
		System.out.println("최대공약수: " + gcd(a,b));
		System.out.println("최소공배수: " + lcm(a,b));
	}
		
	static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b!= 0) {
			int c = a%b;
			a = b;
			b = c;
		}
		return a;
	}
	
	static int lcm(int a, int b) {
		return a*b / gcd(a,b);
	}
}