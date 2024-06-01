package com.functional_java.chapter5;

public record Rectangle(Origin origin, int width, int height) {

	//다른 레코드와 조합하고 추가 생성자 활용
	public Rectangle(int x, int y, int width, int height) {
		this(new Origin(x, y), width, height);
	}

	public Rectangle(int width, int height) {
		this(new Origin(), width, height);
	}

	// //네이밍 규칙에 따라 두 조합을 한번에 사용은 불가능 하다. 정적 메서드 사용

	// public Rectangle(int x, int width, int height) {
	// 	this(new Origin(x, 0), width, height);
	// }
	// public Rectangle(int y, int width, int height) {
	// 	this(new Origin(0, y), width, height);
	// }

	public static Rectangle atX(int x, int width, int height) {
		return new Rectangle(x, 0, width, height);
	}

	public static Rectangle atY(int y, int width, int height) {
		return new Rectangle(0, y, width, height);
	}

}