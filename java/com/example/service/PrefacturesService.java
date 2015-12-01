package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Prefacture;
import com.example.repository.PrefactureRepository;

@Service

public class PrefacturesService {
	@Autowired
PrefactureRepository prefactureRepository;
	

//
 public List<Prefacture> findAll(){
	return prefactureRepository.findAll();
}


}
