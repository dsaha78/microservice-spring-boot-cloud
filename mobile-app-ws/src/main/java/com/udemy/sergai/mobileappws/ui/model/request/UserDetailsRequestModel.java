package com.udemy.sergai.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDetailsRequestModel {

	@NotNull(message = "first name is not null")
	private String firstName;
	@NotNull(message = "last name is not null")
	private String lastName;
	@Email(message = "Not a valid Email.")
	private String email;
	@Size(min = 8, max = 10, message = "should be between 8 and 10 char")
	private String password;
}
