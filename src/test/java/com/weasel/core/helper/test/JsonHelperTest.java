package com.weasel.core.helper.test;

import com.weasel.lang.helper.JsonHelper;

public class JsonHelperTest {

	public void testToJsonString(){
		User user = new User("aa", "abc123");
		String uJson = JsonHelper.toJsonString(user);
		System.out.println(uJson);
	}
	
	public static void main(String[] args) {
		User user = new User("aa", "abc123");
		String uJson = JsonHelper.toJsonString(user);
		System.out.println(uJson);
	}
}
