package com.example.domain;

import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm {
	private Integer id;
	private String name;
	
	private String prefectures;
	private HashMap<String,String> prefectureMap;

	
	private List<String> hobby;
	private HashMap<String,String> hobbyMap;
	
	private String sex;
	private List<Sex> sexList;

	private Integer age;
	private String first_e_mail;
	private String last_e_mail;
}