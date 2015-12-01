package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XSSForm {
	private Integer xs_id;
	private Integer userid;
	private String name;
	private String xs_text;
}
