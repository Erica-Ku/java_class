package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test04 {

	/*public static void main(String[] args) {
		try {
			FileInputStream fi = new FileInputStream("a.txt");
			int c = fi.read();
			System.out.println((char) c);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void test() throws IOException {
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
	}
	
	public static void main(String[] args) {
		try {
		test();
		} catch (IOException e) {
		System.out.println("파일이 없습니다.");
		}
	}
}