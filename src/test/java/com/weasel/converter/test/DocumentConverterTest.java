package com.weasel.converter.test;

import com.weasel.helper.DocumentConverter;

public class DocumentConverterTest {

	public static void main(String[] args) {
		User user = new User("aa", "abc123");
		String uJson = DocumentConverter.toJson(user);
		System.out.println(uJson);
	}
}
