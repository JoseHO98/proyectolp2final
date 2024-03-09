package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TortaSabor;
import com.example.demo.repository.TortaSaborRepository;

@Service
public class TortaSaborService {

	@Autowired
	private TortaSaborRepository tortasaborRepository;
	
	public List<TortaSabor> getAllTortaSabor(){
		return tortasaborRepository.findAll();
	}
	
	public TortaSabor getTortaSaborById(int idSabor) {
		return tortasaborRepository.findById(idSabor).orElse(null);
	}
}
