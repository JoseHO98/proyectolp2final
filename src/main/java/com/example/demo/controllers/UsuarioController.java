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

import com.example.demo.model.TipoUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.TipoUsuarioService;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TipoUsuarioService tipousuarioService;
	
	@GetMapping("/getAllUsuarios")
	public String getAllUsuarios(Model model) {
		
		List<Usuario> listUsuario = usuarioService.getAllUsuarios();
		model.addAttribute("usuario", listUsuario);	
		return "UsuariosList";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("tipousuario", tipousuarioService.getAllTipoUsuario());
		return "usuarioRegister";
	}
	
	@PostMapping("/register")
	public String createUsuario(@RequestParam("nombre") String nombre,@RequestParam("apellido") String apellido,@RequestParam("email") String email,@RequestParam("celular") String celular,
			@RequestParam("username") String username,@RequestParam("contrasena") String contrasena,@RequestParam("fecha_registro") String FechaRegistro,@RequestParam("id") Long id,Model model) {
		
		Usuario usuario = new Usuario();
		usuario.nombre = nombre;
		usuario.apellido = apellido;
		usuario.email = email;
		usuario.celular = celular;
		usuario.username = username;
		usuario.contrasena = contrasena;
		usuario.FechaRegistro = FechaRegistro;
		
		TipoUsuario tipousuario = tipousuarioService.getTipoUsuarioById(id);
		
		usuario.TipoUsuario = tipousuario;
		usuarioService.createUsuario(usuario);
		
		model.addAttribute("usuarios",usuarioService.getAllUsuarios());
		model.addAttribute("tipousuarios",tipousuarioService.getAllTipoUsuario());
		
		//Redirigir al usuario a la lista de usuarios después de registrarse
		return "redirect:/usuario/getAllUsuarios";
	}
	
	@GetMapping ("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		
		Usuario usuario = usuarioService.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipousuarios", tipousuarioService.getAllTipoUsuario());
		
		return "usuarioEdit";
	}
	
	@PostMapping("/edit")
	public String createUsuario(@RequestParam("id") Long id, @RequestParam("nombre") String nombre,@RequestParam("apellido") String apellido,@RequestParam("email") String email,@RequestParam("celular") String celular,
			@RequestParam("username") String username,@RequestParam("contrasena") String contrasena,@RequestParam("fecha_registro") String FechaRegistro,@RequestParam("cod_tipo_usuario") Long CodTipoUsuario,Model model) {
		
		Usuario usuario = usuarioService.getUsuarioById(id);
		usuario.nombre = nombre;
		usuario.apellido = apellido;
		usuario.email = email;
		usuario.celular = celular;
		usuario.username = username;
		usuario.contrasena = contrasena;
		usuario.FechaRegistro = FechaRegistro;
		
		TipoUsuario tipousuario = tipousuarioService.getTipoUsuarioById(CodTipoUsuario);
		usuario.TipoUsuario = tipousuario;
		usuarioService.createUsuario(usuario);
		
		model.addAttribute("usuarios",usuarioService.getAllUsuarios());
		model.addAttribute("tipousuarios",tipousuarioService.getAllTipoUsuario());
		
		return "redirect:/usuario/getAllUsuarios";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUsuario(@PathVariable Long id,Model model) {
		
		usuarioService.deleteUsuario(id);
		
		model.addAttribute("usuarios",usuarioService.getAllUsuarios());
		model.addAttribute("tipousuarios",tipousuarioService.getAllTipoUsuario());
		
		return "redirect:/usuario/getAllUsuarios";
	}
}
