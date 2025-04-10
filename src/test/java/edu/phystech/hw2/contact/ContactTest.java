package edu.phystech.hw2.contact;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;


record Contact(String username, String email) implements Comparable<Contact> {

	public static final String UNKNOWN_EMAIL = "unknown@gmail.com";

	Contact {
		if (username == null || username.isBlank()) {
			throw new InvalidContactFieldException("username");
		}
		if (email == null || (!email.equals(UNKNOWN_EMAIL) && !email.matches(
			"[\\w.%-]+@gmail\\.com"))) {
			throw new InvalidContactFieldException("email");
		}
	}

	Contact(String username) {
		this(username, UNKNOWN_EMAIL);
	}

	@Override public int compareTo(Contact other) {
		return Integer.compare(this.username.length(), other.username.length());
	}
}


public class ContactTest {

	@Test public void justWorks() {

		Assertions.assertDoesNotThrow(() -> {
			Contact first = new Contact("username", "username@gmail.com");
			Contact second = new Contact("123", "123@gmail.com");

			Contact withoutEmail = new Contact("withoutEmail");
			Assertions.assertEquals(Contact.UNKNOWN_EMAIL, withoutEmail.email());
		});

	}

	@Test public void validationTest() {
		var exception = Assertions.assertThrows(InvalidContactFieldException.class,
			() -> new Contact("   ", "123@gmai.com"));
		Assertions.assertEquals("username", exception.getFieldName());
		exception = Assertions.assertThrows(InvalidContactFieldException.class,
			() -> new Contact("   1", "123@mai.ru"));
		Assertions.assertEquals("email", exception.getFieldName());
		exception = Assertions.assertThrows(InvalidContactFieldException.class,
			() -> new Contact("   ", ""));
		Assertions.assertEquals("username", exception.getFieldName());
	}

	@Test public void compareTest() {
		var result = Stream.of(new Contact("AFD"), new Contact("a"), new Contact("zZ"))
			.sorted(Contact::compareTo).map(Contact::username).toList();
		Assertions.assertEquals(List.of("a", "zZ", "AFD"), result);
		Assertions.assertInstanceOf(Comparable.class, new Contact("AFD"));
	}
}
