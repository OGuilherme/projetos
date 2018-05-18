package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Usuario")
public class CadastroUsuarioBean {

	private DadosUsuarioBean usuario;
	private DadosResidenciaBean residencia;

	@XmlElement(name = "Dados")
	public DadosUsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(DadosUsuarioBean usuario) {
		this.usuario = usuario;
	}

	@XmlElement(name = "Residencia")
	public DadosResidenciaBean getResidencia() {
		return residencia;
	}

	public void setResidencia(DadosResidenciaBean residencia) {
		this.residencia = residencia;
	}

}