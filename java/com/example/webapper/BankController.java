package com.example.webapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.item.util.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Bank;
import com.example.domain.BankForm;
import com.example.domain.BankResistPage;
import com.example.domain.CustomerForm;
import com.example.domain.CustomerResistorPage;
import com.example.domain.Hobby;
import com.example.domain.Prefacture;
import com.example.domain.Sex;
import com.example.service.BankService;
import com.example.service.HobbyService;
import com.example.service.PrefacturesService;
import com.example.service.SexServise;

import common.CSVFileExport;
import common.CSVReader;
import common.RevenueSpending;
import common.Todate;

@Controller
@RequestMapping("/banController")
public class BankController {
	@Autowired
	BankService bankService;
	@Autowired
	PrefacturesService prefacturesService;
	@Autowired
	HobbyService hobbyService;
	@Autowired
	SexServise sexServise;

	@ModelAttribute("bankForm")
	public BankForm bankForm() {
		return new BankForm();
	}

	@ModelAttribute("customerForm")
	public CustomerForm customerForm() {
		return new CustomerForm();
	}

	@RequestMapping("/bankInputController")
	public String bankInputIndex(Model model, BankForm bankForm, BankResistPage bankResistPage) {
		List<RevenueSpending> revenueSpendingList = new ArrayList<>();
		revenueSpendingList.add(new RevenueSpending("", "--"));
		revenueSpendingList.add(new RevenueSpending("1", "収入"));
		revenueSpendingList.add(new RevenueSpending("2", "支出"));
		bankResistPage.setRevenueSpendingList(revenueSpendingList);
		BeanUtils.copyProperties(bankForm, bankResistPage);
		System.out.println("bankResistPage=" + bankResistPage);
		model.addAttribute("bankResistPage", bankResistPage);
		return "bank/input";
	}

	@RequestMapping(value = "/bankInput")
	public String bankInput(@Validated BankForm bankForm, BindingResult result, // 入力チェック
			Model model) {
		BankResistPage bankResistPage = new BankResistPage();
		BeanUtils.copyProperties(bankForm, bankResistPage);
		List<RevenueSpending> revenueSpendingList = new ArrayList<>();
		revenueSpendingList.add(new RevenueSpending("", "--"));
		revenueSpendingList.add(new RevenueSpending("1", "収入"));
		revenueSpendingList.add(new RevenueSpending("2", "支出"));
		bankResistPage.setRevenueSpendingList(revenueSpendingList);
		System.out.println("bankResistPage=" + bankResistPage);
		model.addAttribute("bankResistPage", bankResistPage);
		if (result.hasErrors()) {
			System.out.println("入力失敗");
			return "bank/input";
		}
		return "bank/inputView";
	}

	@RequestMapping(value = "/resist")
	public String resist(BankResistPage bankResistPage, BankForm bankForm, Model model, Bank bank) {

		return "";
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

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
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

	// 趣味Map
	public HashMap<String, String> hobbyMap() {
		List<Hobby> hobbyList = new ArrayList<>();
		hobbyList = hobbyService.findAll();
		HashMap<String, String> hobbyMap = new HashMap<String, String>();
		for (Hobby hobby : hobbyList) {
			hobbyMap.put(hobby.getHob_id(), hobby.getHob_name());
		}
		return hobbyMap;
	}

	// 都道府県Map
	public HashMap<String, String> PrefactureMap() {
		List<Prefacture> prefecturesList = new ArrayList<>();
		prefecturesList = prefacturesService.findAll();
		HashMap<String, String> prefactureMap = new HashMap<String, String>();
		for (Prefacture prefacture : prefecturesList) {
			prefactureMap.put(prefacture.getPref_id(), prefacture.getPref_name());
		}
		return prefactureMap;
	}

	// 性別List
	public List<Sex> sexList() {
		List<Sex> sexList = new ArrayList<>();
		sexList = sexServise.findAll();
		return sexList;
	}

	@RequestMapping(value = "/questionnaire")
	public String questionnaire(Model model, CustomerForm customerForm, CustomerResistorPage customerResistorPage) {
		BeanUtils.copyProperties(customerForm, customerResistorPage);
		customerResistorPage.setHobbyMap(hobbyMap());
		customerResistorPage.setSexList(sexList());
		customerResistorPage.setPrefectureMap(PrefactureMap());
		System.out.println("customerResistorPage=" + customerResistorPage);
		model.addAttribute("bankResistPage", customerResistorPage);
		return "bank/questionnaire";
	}

	@RequestMapping(value = "/questionnaireResistor", method = RequestMethod.POST)
	public String resistConfirm(Model model, CustomerForm customerForm, CustomerResistorPage customerResistorPage) {

		BeanUtils.copyProperties(customerForm, customerResistorPage);
		customerResistorPage.setHobbyMap(hobbyMap());
		customerResistorPage.setSexList(sexList());
		customerResistorPage.setPrefectureMap(PrefactureMap());

		System.out.println("customerResistorPage=" + customerResistorPage);
		System.out.println("customerForm=" + customerForm);
		model.addAttribute("bankResistPage", customerResistorPage);
		return "bank/qustunreResistPage";
	}

	@RequestMapping(value = "/resist", method = RequestMethod.POST)
	public String resist(Model model, CustomerForm customerForm, CustomerResistorPage customerResistorPage) {

		System.out.println("customerResistorPage=" + customerResistorPage);
		System.out.println("customerForm=" + customerForm);
		model.addAttribute("bankResistPage", customerResistorPage);
		return "bank/myPage";
	}

	// 帳簿一覧CSVのDL
	@RequestMapping(value = "/csvExport", method = RequestMethod.POST)
	public void csvExport(@RequestParam("userid") Integer userid, Model model, CSVFileExport csvFileExport,
			HttpServletResponse response) {
		List<Bank> bankList = new ArrayList<>();
		bankList = bankService.findAll(userid);
		csvFileExport.export(bankList, response);
	}

	// 帳簿一覧アップロード
	@RequestMapping(value = "/uploadRecv", method = RequestMethod.POST)
	public String uploadRecv(
			@RequestParam("userid") Integer userid, 
			@RequestParam MultipartFile file, 
			Model model, 
			Bank bank) throws IOException {
		//指定された位置にアップロード
		Path path = Paths.get(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
		// CSVファイル読み込み
		CSVReader reader = new CSVReader(path.toString(), 0);
		// CSVデータ取得
		List<List<String>> csv = reader.read();

		//useridの取得
		bank.setUserid(userid);
		//CSVデータをbankに入れて、DBに挿入
		for (List<String> list : csv) {
			int listIdx = 0;
			for (String string : list) {
				System.out.println(string);
				switch (listIdx){
				//日付を取り出す
				  case 0:
					  bank.setDate(Todate.toDate(string, "yyyy-MM-dd"));
					  break;
				//収入を取り出す
				  case 1:
						bank.setRevenue(Integer.parseInt(string));
						  break;
				//支出を取り出す
				  case 2:
						bank.setSpending(Integer.parseInt(string));
						  break;
				//残高を取り出す
				  case 3:
						bank.setStock(Integer.parseInt(string));
						  break;
				//備考を取り出す 
				  case 4:
						bank.setMemo(string);
						break;
				}
				listIdx++;
			}
			//bankをDBに挿入
			bankService.created(bank);
		}
		return output(userid, bank, model);
	}
}