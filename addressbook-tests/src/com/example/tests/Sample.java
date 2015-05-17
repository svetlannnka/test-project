package com.example.tests;

public class Sample {

	public static void main(String[] args) {
		
		String b = "   +1 (516) 603-1694";
		//System.out.println(b.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d-]+"));
		b=b.trim();
		System.out.println(b);
		b = b.replaceAll("[ ()\\-]", "");
		System.out.println(b);
		System.out.println(b.matches("\\+\\d+"));
	}
}

