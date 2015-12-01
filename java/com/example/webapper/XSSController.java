package com.example.webapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.XSS;
import com.example.domain.XSSForm;
import com.example.service.XSSService;

@Controller
public class XSSController {
	@Autowired
	XSSService xssService;

	@ModelAttribute("xssForm")
	public XSSForm setupFrom() {
		return new XSSForm();
	}

	@RequestMapping("/xss")
	public String XssSetUP(Model model) {
		List<XSS> xssList = new ArrayList<>();
		xssList = xssService.findAll();
		model.addAttribute("xssList", xssList);
		return "xss/xss";
	}

	@RequestMapping("/output")
	public String output(
			Model model, XSS xss,XSSForm xssForm) {
		BeanUtils.copyProperties(xssForm, xss);
		xssService.created(xss);
		List<XSS> xssList = new ArrayList<>();
		xssList = xssService.findAll();
		model.addAttribute("xssList", xssList);
		return "xss/xss";
	}
}
