package com.functional_java.chapter5;

import java.time.LocalDateTime;
import java.util.Objects;

public class PojoUser {
	private final String userName;
	private final LocalDateTime lastLogin;

	public PojoUser(String userName, LocalDateTime lastLogin) {
		this.userName = userName;
		this.lastLogin = lastLogin;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PojoUser pojoUser = (PojoUser)o;
		return Objects.equals(userName, pojoUser.userName) && Objects.equals(lastLogin,
			pojoUser.lastLogin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, lastLogin);
	}

	@Override
	public String toString() {
		return "PojoUser{" +
			"userName='" + userName + '\'' +
			", lastLogin=" + lastLogin +
			'}';
	}
}
