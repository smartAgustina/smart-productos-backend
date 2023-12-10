package com.smart.smartproductospet.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginRequestDto implements Serializable {

		private static final long serialVersionUID = 1737924734384144460L;

		private String mail;
		private String password;

		public LoginRequestDto() {
		}

}
