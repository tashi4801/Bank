package com.example.domain;


import java.util.List;

import common.RevenueSpending;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankResistPage {
	/**  id	 **/
	private Integer id;
	/**
	 * 日付
	 */
	private String date;
	/**
	 * ユーザーId
	 */
	private Integer userid;
	/**
	 * 収支の選択
	 */
	private String revenueSpending;
	/**
	 * 金額
	 */
	private Integer money;
	/**
	 * 備考 
	 */
	private String memo;
	/**
	 * 収支の選択
	 */
	private List<RevenueSpending>revenueSpendingList;
	
}
