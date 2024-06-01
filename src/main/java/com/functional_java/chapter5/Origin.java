package com.functional_java.chapter5;

public record Origin(int x, int y) {

	//기본 값에 대한 사용자 정의 생성자
	public Origin() {
		this(0, 0);
	}

	//다만 인수가 없는 생성자의 경우 상수를 활용하는 것 이 적절하다.
	public static Origin ZERO = new Origin(0, 0);
}