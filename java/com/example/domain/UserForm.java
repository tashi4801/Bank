package com.example.domain;


import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForm {
	@NotEmpty(message="名前が入力されておりません。")
	@Size(min=1,max=20,message="{min}文字以上{max}以下でなければなりません。")
	private String name;
	@NotEmpty(message="パスワードが入力されておりません。")
	@Size(min=8,max=16,message="{min}文字以上{max}以下でなければなりません。")
	private String password;
}
