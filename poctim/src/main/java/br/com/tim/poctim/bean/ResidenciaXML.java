package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Dados")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResidenciaXML {

	@XmlElement(name = "Nome")
	private String nome;

	@XmlElement(name = "Endereco")
	private String endereco;

	@XmlElement(name = "CEP")
	private String cep;

	@XmlElement(name = "Municipio")
	private String municipio;

	@XmlElement(name = "Estado")
	private String estado;

	@XmlElement(name = "Data_de_Vencimento")
	private String dataVencimento;

	@XmlElement(name = "Data_de_Emissao")
	private String dataEmissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}