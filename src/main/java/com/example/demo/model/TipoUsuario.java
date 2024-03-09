package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_tipo_usuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "cod_tipo_usuario", nullable = false)
	public Long CodTipoUsuario;
	@Column(name = "tipo_usuario", nullable = false)
	public String TipoUsuario;
	
	public Long getCodTipoUsuario() {
		return CodTipoUsuario;
	}
	public void setCodTipoUsuario(Long codTipoUsuario) {
		CodTipoUsuario = codTipoUsuario;
	}
	public String getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	
}
