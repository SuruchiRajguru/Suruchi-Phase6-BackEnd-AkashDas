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
public class AdminLoginResponse {
	
	private Integer adminId;
	private String adminName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long mobileNumber;

}
