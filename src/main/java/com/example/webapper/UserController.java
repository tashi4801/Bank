package com.example.webapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.domain.UserForm;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class UserController {
	@Autowired
	UserService userService;

	 @ModelAttribute
	  public UserForm setupForm() {
	    return new UserForm();
	  }
	 
//	 @ModelAttribute
//		public User setUser(){
//			return new User();
//		}
	
	@RequestMapping
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "userResistor")
	public String UserResistor() {
		return "user/user";
	}
	
	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
	public String userLoginController(
			RedirectAttributes attributes,
			User user, Model model) {
		List<User> userList = new ArrayList<>();
		userList = userService.findAll();

		for (User user1 : userList) {
			if (user.getName().equals(user1.getName())&&
					user.getPassword().equals(user1.getPassword())) {
				model.addAttribute("user", user1);
				return "redirect:/rebankViewContents";
			}
		}
		model.addAttribute("message", "登録情報がありません。登録を行ってください。");
		return "index";
	}

	@RequestMapping(value = "/rebankViewContents")
	public String rebankViewContents() {
		return "bank/myPage";
	}
	
	@RequestMapping(value = "userResistorController", method =RequestMethod.POST)
	public String postForm(
			@Validated
			UserForm form,//自動でパラメータを取得される。これは上記の@ModelAttributeで定義しているから。
			BindingResult result,//入力チェック
			RedirectAttributes attributes
	) {
		if(result.hasErrors()){
			System.out.println("登録失敗");
			return "user/user";
		}
		User user = new User();
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		userService.created(user);
		user.setId(userService.findById().getId());
		System.out.println("登録成功");
		attributes.addFlashAttribute("user",user);
		return "redirect:reUserResister";
	}
	@RequestMapping(value="reUserResister", method =RequestMethod.GET)
	public String reUserResister(){
		System.out.println("redirect成功");
		return "user/userResister";
	}
	
	@RequestMapping(value = "myPage")
	public String myPage() {
		return "bank/myPage";
	}
	
	@RequestMapping(value="logout")
	public String logout(
			SessionStatus sessionStatus,
			User user
			) {
		sessionStatus.setComplete();
		return "redirect:/";
	} 
	
	
	
}
