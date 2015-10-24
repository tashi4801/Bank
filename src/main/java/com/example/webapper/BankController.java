package com.example.webapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Bank;
import com.example.service.BankService;

@Controller
@RequestMapping("/banController")
public class BankController {
	@Autowired
	BankService bankService;

	@RequestMapping("/bankInputController")
	public String bankInputIndex() {
		return "bank/input";
	}

	@RequestMapping(value = "/bankInput", method = RequestMethod.POST)
	public String bankInput(@RequestParam("revenueSpending") Integer revenueSpending,
			@RequestParam("money") Integer money, @RequestParam("userid") Integer userid, Bank bank,
			RedirectAttributes attributes) {
		bank.setUserid(userid);
		System.out.println(bank.getMemo());
		String message = null;
		if (revenueSpending.equals(1)) {
			bank.setRevenue(money);
			message = "収入";
			bank.setSpending(0);
		}
		if (revenueSpending.equals(2)) {
			bank.setSpending(money);
			bank.setRevenue(0);
			message = "支出";
		}
		List<Bank> bankList = new ArrayList<Bank>();
		bankList = bankService.findAll(userid);
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
		bankService.created(bank);
		attributes.addFlashAttribute("bank", bank);
		attributes.addFlashAttribute("money", money);
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
