package com.udemy.sergai.mobileappws.ui.model.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateUserDetailsRequestModel {
	
	@NotNull (message = "first name is not null")
	private String firstName;
	@NotNull (message = "last name is not null")
	private String lastName;
	
}
