package com.example.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserForm {
	@NotEmpty(message="名前が入力されておりません。")
	@Size(min=1,max=20,message="{min}文字以上{max}以下でなければなりません。")
	private String name;
	@NotEmpty(message="名前が入力されておりません。")
	@Size(min=8,max=16,message="{min}文字以上{max}以下でなければなりません。")
	private String password;
}
