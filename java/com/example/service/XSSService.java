package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Bank;
import com.example.domain.XSS;
import com.example.repository.XSSRepository;

@Service
public class XSSService {
	@Autowired
	XSSRepository xssRepository;
//	public Bank findById() {
//		return xssRepository.findById();
//	}
	public List<XSS> findAll() {
		return xssRepository.findAll();
	}
	public XSS created(XSS xss) {
		return xssRepository.created(xss);
	}
}
