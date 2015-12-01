package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Bank;
import com.example.repository.BnakRepository;

@Service
public class BankService {
	@Autowired
	BnakRepository bankRepository;
	public Bank findById() {
		return bankRepository.findById();
	}
	public List<Bank> findAll(Integer userid) {
		return bankRepository.findAll(userid);
	}
	public Bank created(Bank bank) {
		return bankRepository.created(bank);
	}
}
