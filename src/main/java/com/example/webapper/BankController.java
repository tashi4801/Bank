package com.example.webapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Bank;
import com.example.domain.BankForm;
import com.example.service.BankService;

import common.Todate;

@Controller
@RequestMapping("/banController")
public class BankController {
	@Autowired
	BankService bankService;
	
	@ModelAttribute("bankForm")
	public BankForm bankForm(){
		 return new BankForm();
	}

	@RequestMapping("/bankInputController")
	public String bankInputIndex() {
		return "bank/input";
	}

	@RequestMapping(value = "/bankInput", method = RequestMethod.POST)
	public String bankInput(
			@Validated
			BankForm bankForm,
			BindingResult result,//入力チェック
//			Bank bank,
			RedirectAttributes attributes) {
		if(result.hasErrors()){
			System.out.println("入力失敗");
			return "bank/input";
		}
		Bank bank=new Bank();
		System.out.println(bankForm);
		bank.setUserid(bankForm.getUserid());
		String message = null;
		if (bankForm.getRevenueSpending().equals(1)) {
			bank.setRevenue(bankForm.getMoney());
			message = "収入";
			bank.setSpending(0);
		}
		if (bankForm.getRevenueSpending().equals(2)) {
			bank.setSpending(bankForm.getMoney());
			bank.setRevenue(0);
			message = "支出";
		}
		List<Bank> bankList = new ArrayList<Bank>();
		bankList = bankService.findAll(bankForm.getUserid());
		Integer stock = 0;
		for (Bank bank2 : bankList) {
			if (bank2.equals(null)) {
				stock = bank.getRevenue() - bank.getSpending();
				break;
			}
			stock = stock + bank2.getRevenue() - bank2.getSpending();
		}
		stock = stock + bank.getRevenue() - bank.getSpending();
		bank.setStock(stock);
		bank.setMemo(bankForm.getMemo());
		bank.setDate(Todate.toDate(bankForm.getDate(),"yyyy-MM-dd"));
		bankService.created(bank);
		
		
		attributes.addFlashAttribute("bank", bank);
		attributes.addFlashAttribute("bankForm", bankForm);
		attributes.addFlashAttribute("message", message);
		return "redirect:reBankInput";
	}

	@RequestMapping(value = "/reBankInput")
	public String reBankInput() {
		return "bank/inputView";
	}

	@RequestMapping("/bankOutputController")
	public String output(@RequestParam("userid") Integer userid, Bank bank, Model model) {
		bank.setUserid(userid);
		List<Bank> bankList = new ArrayList<>();
		bankList = bankService.findAll(bank.getUserid());
		model.addAttribute("bankList", bankList);
		return "bank/outputView";
	}

	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("edit") String edit, @RequestParam("delete") String delete) {
		if (edit.equals(null)) {
			System.out.println(edit);
			System.out.println(1);

		}
		if (delete.equals(null)) {
			System.out.println(edit);
			System.out.println(3);
		}

		return "bank/outputView";
	}
}
