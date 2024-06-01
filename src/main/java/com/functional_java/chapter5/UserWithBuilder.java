package com.functional_java.chapter5;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.cglib.core.Local;

import lombok.NonNull;

public record UserWithBuilder(String userName, boolean isActive, LocalDateTime lastLogin) {

	public static final class Builder {
		private final String userName;
		//생성 중 변경될 수 있는 필드
		private boolean active;
		private LocalDateTime lastLogin;

		public Builder(String userName) {
			this.userName = userName;
			this.active = true;
		}

		public Builder active(boolean isActive) {
			if (this.active == false) {
				throw new IllegalArgumentException();
			}

			this.active = isActive;
			return this;
		}

		public Builder lastLogin(LocalDateTime lastLogin) {
			this.lastLogin = lastLogin;
			return this;
		}

		//최종 불변 객체 return
		public UserWithBuilder build() {
			return new UserWithBuilder(this.userName, this.active, this.lastLogin);
		}

	}

}