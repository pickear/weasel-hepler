package com.weasel.core.helper.test;

import com.weasel.lang.helper.DocumentConverter;

public class DocumentConverterTest {

	public static void main(String[] args) {
		User user = new User("aa", "abc123");
		String uJson = DocumentConverter.toJson(user);
		System.out.println(uJson);
	}
}
