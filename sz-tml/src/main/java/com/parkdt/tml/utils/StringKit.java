package com.parkdt.tml.utils;
public class StringKit {
	
	public static boolean isEmpty(String s) {
		return s == null || s.trim().isEmpty();
	}
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	public static void main(String[] args) {
		System.out.println('\u53F0');
	}
}
