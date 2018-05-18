package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Dados")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioXML {
	
	@XmlElement(name ="Nome")
	private String nome;
	
	@XmlElement(name ="Nome_do_Pai")
	private String nomeDoPai;
	
	@XmlElement(name ="Nome_da_Mae")
	private String nomeDaMae;
	
	@XmlElement(name ="Data_de_Nascimento")
	private String dataNascimento;
	
	@XmlElement(name ="CPF")
	private String cpf;
	
	@XmlElement(name ="Numero_do_Documento")
	private String rg;
	
	@XmlElement(name ="UF_de_Expedicao")
	private String ufCNH;
	
	@XmlElement(name ="Data_de_Expedicao")
	private String dataExpedicaoCNH;
	
	@XmlElement(name ="Data_de_Validade")
	private String dataValidadeCNH;

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getUfCNH() {
		return ufCNH;
	}

	public void setUfCNH(String ufCNH) {
		this.ufCNH = ufCNH;
	}

	public String getDataExpedicaoCNH() {
		return dataExpedicaoCNH;
	}

	public void setDataExpedicaoCNH(String dataExpedicaoCNH) {
		this.dataExpedicaoCNH = dataExpedicaoCNH;
	}

	public String getDataValidadeCNH() {
		return dataValidadeCNH;
	}

	public void setDataValidadeCNH(String dataValidadeCNH) {
		this.dataValidadeCNH = dataValidadeCNH;
	}
}