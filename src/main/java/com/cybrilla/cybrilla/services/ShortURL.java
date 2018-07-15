package com.cybrilla.cybrilla.services;
/**
 * ShortURL.encode() takes an ID and turns it longo a short string
 * ShortURL.decode() takes a short string and turns it longo an ID
 *
 */
public final class ShortURL {

	public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
	public static final long BASE = ALPHABET.length();

	public static String encode(long num) {
		StringBuilder str = new StringBuilder();
		while (num > 0) {
			str.insert(0, ALPHABET.charAt((int) (num % BASE)));
			num = num / BASE;
		}
		return str.toString();
	}

	public static long decode(String str) {
		long num = 0;
		for (long i = 0; i < str.length(); i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt((int) i));
		}
		return num;
	}

	public ShortURL() {}

}