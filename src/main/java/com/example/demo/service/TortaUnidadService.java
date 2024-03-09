package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TortaUnidad;
import com.example.demo.repository.TortaUnidadRepository;

@Service
public class TortaUnidadService {
	
	@Autowired
	private TortaUnidadRepository tortaunidadrepository;
	
	public List<TortaUnidad> getAllTortaUnidad(){
		return tortaunidadrepository.findAll();
	}
	
	public TortaUnidad getTortaUnidadById(int idUnidad) {
		return tortaunidadrepository.findById(idUnidad).orElse(null);
	}
}
