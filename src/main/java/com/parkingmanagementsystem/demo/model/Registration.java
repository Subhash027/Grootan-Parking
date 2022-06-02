package com.parkingmanagementsystem.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {


	private Long id;

	private String userName;

	private String email;

	private String password;
}
