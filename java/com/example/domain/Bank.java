package com.example.domain;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	private Integer id;
	private Date date;
	private Integer userid;
	private Integer revenue;
	private Integer spending;
	private Integer stock;
	private String memo;
}
