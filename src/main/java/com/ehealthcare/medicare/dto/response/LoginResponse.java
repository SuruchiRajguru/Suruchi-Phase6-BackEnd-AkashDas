package com.ehealthcare.medicare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
	private Integer userId;
	private String firstName;
	private String lastName;
	private Long mobileNo;
	private String emailId;
	private String userName;

}
