package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Documento")
@XmlAccessorType(XmlAccessType.FIELD)
public class CadastroUsuarioXML {

	@XmlElement(name ="Dados")
	private UsuarioXML usuarioXML;
	
	public UsuarioXML getUsuarioXML() {
		return usuarioXML;
	}

	public void setUsuarioXML(UsuarioXML usuarioXML) {
		this.usuarioXML = usuarioXML;
	}

}