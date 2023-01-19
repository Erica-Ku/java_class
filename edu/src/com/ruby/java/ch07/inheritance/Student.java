package com.ruby.java.ch07.inheritance;

public class Student extends Person {
	private String major;

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString() {
		return this.getName() + ":" + this.getAge() + ":" + major;
	}
	
	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
		System.out.println("Student(name, age, major) 생성자 실행!");
	}
}