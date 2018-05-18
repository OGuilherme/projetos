package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Documento")
@XmlAccessorType(XmlAccessType.FIELD)
public class CadastroResidenciaXML {

	@XmlElement(name = "Dados")
	private ResidenciaXML residenciaXML;

	public ResidenciaXML getResidenciaXML() {
		return residenciaXML;
	}

	public void setResidenciaXML(ResidenciaXML residenciaXML) {
		this.residenciaXML = residenciaXML;
	}

}