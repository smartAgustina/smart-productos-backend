package com.smart.smartproductospet.dto;

import java.io.Serializable;

public class LoginRequestDto implements Serializable {

		private static final long serialVersionUID = 1737924734384144460L;

		private String username;
		private String mail;
		private String password;

		public LoginRequestDto() {
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
