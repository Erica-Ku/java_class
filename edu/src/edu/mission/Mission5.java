package edu.mission;

import java.util.Arrays;

public class Mission5 {
	public static void merge(int [] a, int [] b, int [] sum) {
		int index = 0;
		for(int c: a) {
			sum[index++] = c;
		}
		for(int c: b) {
			sum[index++] = c;
		}
		System.out.println(Arrays.toString(sum));
	}

	public static void main(String[] args) {
		int [] a = {1,2,3,4,5};
		int [] b = {6,7,8,9,10};
		int [] c = new int [a.length+b.length];
		
		merge(a,b,c);
	}
}