package com.example.domain;

import java.util.List;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
	private Integer id;
	private String name;
	private List<Sex> sex;
	private List<Prefacture> prefectures;
	private List<Hobby> hobby;
	private Integer age;
	private String first_e_mail;
	private String last_e_mail;
}
