package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.TortaSabor;
import com.example.demo.model.TortaUnidad;
import com.example.demo.model.TortarTipo;
import com.example.demo.model.Tortas;

import com.example.demo.service.TortaSaborService;
import com.example.demo.service.TortaTipoService;
import com.example.demo.service.TortaUnidadService;
import com.example.demo.service.TortasService;

@Controller
@RequestMapping("/tortas")
public class TortasController {
	
	@Autowired
	private TortaSaborService tortasaborservice;
	@Autowired
	private TortaTipoService tortatiposervice;
	@Autowired
	private TortaUnidadService tortaunidadservice;
	@Autowired
	private TortasService tortasservice;
	
	
	@GetMapping("/getAllTortas")
	public String getAllUsuarios(Model model) {
		
		List<Tortas> listTortas = tortasservice.getAllTortas();
		model.addAttribute("tortas", listTortas);	
		return "TortasList";
	}
	
	
	@GetMapping("/register")
	public String registerSabor(Model model) {
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		return "TortasRegistro";
	}
	
	/*
	@GetMapping("/tortas/register/sabor")
	public String registerSabor(Model model) {
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		return "TortasRegistro";
	}
	
	@GetMapping("/tortas/register/tipo")
	public String registerTipo(Model model) {
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		return "TortasRegistro";
	}
	
	@GetMapping("/tortas/register/unidad")
	public String registerUnidad(Model model) {
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		return "TortasRegistro";
	}
	*/
	@PostMapping ("/register")
	public String createTortas(@RequestParam("nombret")String nombreTorta ,
			@RequestParam("codTipo")int cod_tipo, 
			@RequestParam("codsabor")int cod_sabor, @RequestParam("codunidad")int cod_unidad, 
			@RequestParam("dimensiones")String dimensiones, @RequestParam("precio")double precio,
			@RequestParam("stock")double stock, Model model ) { 
		
		Tortas torta = new Tortas();
		torta.nombreTorta =  nombreTorta;
		torta.dimensiones = dimensiones;
		torta.precio = precio;
		torta.stock = (int) stock;
		
		
		TortaSabor tortasabor = tortasaborservice.getTortaSaborById(cod_sabor);
		torta.tortasabor = tortasabor;
		
		TortarTipo tortatipo = tortatiposervice.getTortarTipoById(cod_tipo);
		torta.tortatipo = tortatipo;
		
		TortaUnidad tortaunidad = tortaunidadservice.getTortaUnidadById(cod_unidad);
		torta.tortaunidad = tortaunidad;
		
		tortasservice.createTortas(torta);
		
		
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		model.addAttribute("tortas", tortasservice.getAllTortas());
		
		return"TortasList";
	}
	
	@GetMapping("/edit/{idtortas}")
	
	public String edit (@PathVariable int idtortas, Model model) {
		
		Tortas tortas = tortasservice.getTortasById(idtortas);
		
		model.addAttribute("torta", tortas);
		
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		
		
		return "TortasEdit";
	}
	
	@PostMapping("/edit")
	
	public String createProduct(@RequestParam("idtortas") int idtortas, @RequestParam("nombret")String nombreTorta ,
			@RequestParam("codTipo")int cod_tipo, 
			@RequestParam("codsabor")int cod_sabor, @RequestParam("codunidad")int cod_unidad, 
			@RequestParam("dimensiones")String dimensiones, @RequestParam("precio")double precio,
			@RequestParam("stock")double stock, Model model) {
		
		Tortas tortas = tortasservice.getTortasById(idtortas);
		tortas.nombreTorta =  nombreTorta;
		tortas.dimensiones = dimensiones;
		tortas.precio = precio;
		tortas.stock = (int) stock;
		
		TortaSabor tortasabor = tortasaborservice.getTortaSaborById(cod_sabor);
		tortas.tortasabor = tortasabor;
		
		TortarTipo tortatipo = tortatiposervice.getTortarTipoById(cod_tipo);
		tortas.tortatipo = tortatipo;
		
		TortaUnidad tortaunidad = tortaunidadservice.getTortaUnidadById(cod_unidad);
		tortas.tortaunidad = tortaunidad;
		
		
		
		tortasservice.createTortas(tortas);
		
		model.addAttribute("tortas", tortasservice.getAllTortas());
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		
		return "TortasList";
	}
	
	@GetMapping("/delete/{idtortas}")
	public String DeletTorta(@PathVariable int idtortas, Model model) {
		
		tortasservice.deletTortas(idtortas);
		
		model.addAttribute("tortas", tortasservice.getAllTortas());
		
		model.addAttribute("sabor", tortasaborservice.getAllTortaSabor());
		model.addAttribute("tipo", tortatiposervice.getAllTortaTipo());
		model.addAttribute("unidad", tortaunidadservice.getAllTortaUnidad());
		
		return "TortasList";
	}
	
}
