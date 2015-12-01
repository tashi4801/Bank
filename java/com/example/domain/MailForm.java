package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailForm {
	
	//タイトル
	private String subject ;
	//送信先
	private String to ;
	//メッセージ
	private String message ;
}
