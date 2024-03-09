package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_lista_tortas_postres")
public class Tortas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigo", nullable = false)
	public int idtortas;
	
	@Column(name = "nombre", nullable = false)
	public String nombreTorta;
	
	@ManyToOne
	@JoinColumn (name = "cod_tipo", nullable = false)
	public TortarTipo  tortatipo;

	@ManyToOne
	@JoinColumn (name = "cod_sabor", nullable = false)
	public TortaSabor tortasabor;

	@ManyToOne
	@JoinColumn (name = "cod_unidad", nullable = false)
	public TortaUnidad tortaunidad;
	
	@Column(name = "dimensiones", nullable = false)
	public String dimensiones;
	
	@Column (name = "precio", nullable = false)
	public double precio;
	
	@Column (name = "stock", nullable = false)
	public int stock;
}
