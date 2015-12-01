package com.example.domain;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
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
	@NotEmpty(message="日付が入力されておりません。")
	private String date;
	/**
	 * ユーザーId
	 */
	private Integer userid;
	/**
	 * 収支の選択
	 */
	@NotEmpty(message="収支の選択がされておりません。")
	private String revenueSpending;
	/**
	 * 金額
	 */
	@Min(value=0,message="金額はマイナスになっています。")
	@NotNull(message="金額が入力されておりません。")
	private Integer money;

	/**
	 * 備考 
	 */
	@NotEmpty(message="備考が入力されておりません。")
	@Size(min=0, max=127)
	private String memo;
	
	
}
