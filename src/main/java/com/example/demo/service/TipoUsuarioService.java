package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TipoUsuario;
import com.example.demo.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
	
	@Autowired
	private TipoUsuarioRepository tipousuarioRepository;
	
	public List<TipoUsuario> getAllTipoUsuario(){
		return tipousuarioRepository.findAll();
	}
	
	public TipoUsuario getTipoUsuarioById(Long id) {
		return tipousuarioRepository.findById(id).orElse(null);
	}
}
