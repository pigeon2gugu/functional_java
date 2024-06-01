package com.functional_java.chapter5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;
import java.time.LocalDateTime;

//정리글 : https://celdan.tistory.com/49
public class Main {
	public static void main(String[] args) {
		RecordUser recordUser = new RecordUser("haneul", LocalDateTime.now());
		String userName = recordUser.userName();

		//reflection
		for (RecordComponent component : RecordUser.class.getRecordComponents()) {
			System.out.println("Component: " + component.getName());
			for (Annotation annotation : component.getAnnotations()) {
				System.out.println("Annotation: " + annotation);
			}
		}

		for (Constructor constructor : RecordUser.class.getDeclaredConstructors()) {
			System.out.println("constructor: " + constructor.getName());
		}

		//Builder
		UserWithBuilder user = new UserWithBuilder.Builder("haneul")
			.active(false)
			.lastLogin(LocalDateTime.now())
			.build();
	}
}
