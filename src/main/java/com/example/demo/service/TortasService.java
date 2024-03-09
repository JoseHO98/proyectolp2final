package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tortas;
import com.example.demo.repository.TortasRepository;

@Service
public class TortasService {
	
	@Autowired
	private TortasRepository tortasrepository;
	
	public List<Tortas> getAllTortas(){
		return tortasrepository.findAll();
	}
	
	public Tortas createTortas(Tortas tortas) {
		return tortasrepository.save(tortas);
	}
	
	public void deletTortas(int idtortas) {
		tortasrepository.deleteById(idtortas);
	}
	
	public Tortas getTortasById(int idtortas) {
		return tortasrepository.findById(idtortas).orElse(null);
	}
}
