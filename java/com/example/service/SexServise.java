package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.domain.Sex;
import com.example.repository.SexRepository;

@Service
public class SexServise {
	@Autowired
	SexRepository sexRepository;
	public List<Sex> findAll() {
		return sexRepository.findAll();
	}
}
