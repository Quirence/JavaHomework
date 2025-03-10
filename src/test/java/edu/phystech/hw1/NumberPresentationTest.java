package edu.phystech.hw1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class NumberPresentationTest {

	private static String toBinary(int x) {
		StringBuilder binary = new StringBuilder();
		if (x == 0)
			return "0";
		while (x > 0) {
			binary.append(x % 2);
			x /= 2;
		}
		return binary.reverse().toString();
	}

	private static String toOct(int x) {
		StringBuilder octal = new StringBuilder();
		if (x == 0)
			return "0";
		while (x > 0) {
			octal.append(x % 8);
			x /= 8;
		}
		return octal.reverse().toString();
	}

	private static String toHex(int x) {
		StringBuilder hex = new StringBuilder();
		if (x == 0)
			return "0";
		char[] hexDigits = "0123456789abcdef".toCharArray();
		while (x > 0) {
			hex.append(hexDigits[x % 16]);
			x /= 16;
		}
		return hex.reverse().toString();
	}


	@Test public void binaryPresentation() {
		Assertions.assertEquals("0", toBinary(0));
		Assertions.assertEquals("1", toBinary(1));

		Assertions.assertEquals("10", toBinary(2));
		Assertions.assertEquals("100", toBinary(4));
		Assertions.assertEquals("10000000", toBinary(128));

		Assertions.assertEquals("11111111", toBinary(255));
		Assertions.assertEquals("11111111", toBinary(255));

		Assertions.assertEquals("100101100100110000010", toBinary(1231234));
	}


	@Test public void octPresentation() {
		for (int i = 0; i < 8; ++i) {
			Assertions.assertEquals(String.valueOf(i), toHex(i));
		}

		Assertions.assertEquals("10", toOct(8));
		Assertions.assertEquals("100", toOct(64));
		Assertions.assertEquals("200", toOct(128));

		Assertions.assertEquals("377", toOct(255));

		Assertions.assertEquals("4544602", toOct(1231234));
	}

	@Test public void hexPresentation() {
		for (int i = 0; i < 10; ++i) {
			Assertions.assertEquals(String.valueOf(i), Integer.toHexString(i));
		}

		Assertions.assertEquals("10", toHex(16));
		Assertions.assertEquals("100", toHex(256));
		Assertions.assertEquals("200", toHex(512));

		Assertions.assertEquals("21e", toHex(542));

		Assertions.assertEquals("45b0c2", toHex(4567234));
	}


}

