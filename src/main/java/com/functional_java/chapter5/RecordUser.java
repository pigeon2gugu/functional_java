package com.functional_java.chapter5;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.NonNull;

public record RecordUser(@NonNull String userName, LocalDateTime lastLogin) {

	//표준 생성자 재정의
	// public RecordUser(String userName, LocalDateTime lastLogin) {
	// 	Objects.requireNonNull(userName);
	// 	Objects.requireNonNull(lastLogin);
	//
	// 	this.userName = userName;
	// 	this.lastLogin = lastLogin;
	// }

	//위와 동일한 컴팩트 생성자
	public RecordUser {
		Objects.requireNonNull(userName);
		Objects.requireNonNull(lastLogin);

		userName = userName;
		lastLogin = lastLogin;
	}

	//상태
	public boolean hasLoggedInAtLeastOnce() {
		return this.lastLogin != null;
	}
}