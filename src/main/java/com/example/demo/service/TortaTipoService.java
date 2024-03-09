package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TortarTipo;
import com.example.demo.repository.TortaTipoRepository;

@Service
public class TortaTipoService {

	@Autowired
	private TortaTipoRepository tortatiporepository;
	
	public List<TortarTipo> getAllTortaTipo(){
		return tortatiporepository.findAll();
	}

	public TortarTipo getTortarTipoById(int idTipo) {
		return tortatiporepository.findById(idTipo).orElse(null);
	}
}
