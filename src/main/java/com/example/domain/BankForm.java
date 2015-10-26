package com.example.domain;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author takeshi
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankForm {
	
	/**  id	 **/
	private Integer id;
	/**
	 * 日付
	 */
//	@NotEmpty(message="日付が入力されておりません。")
	private Date date;
	/**
	 * ユーザーId
	 */
	private Integer userid;
	/**
	 * 収支の選択
	 */
	@NotEmpty(message="収支の選択がされておりません。")
	private Integer revenueSpending;
	/**
	 * 金額
	 */
	@Min(value=0,message="金額はマイナス")
	@NotNull(message="金額が入力されておりません。")
	private Integer money;
	
	/**
	 * 備考
	 */
	@NotEmpty(message="備考が入力されておりません。")
//	@Size(max=127,message="文字は${max}以下で入力してください。")
	private String memo;
}
