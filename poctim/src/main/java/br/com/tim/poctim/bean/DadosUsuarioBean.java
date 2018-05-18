package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Dados")
public class DadosUsuarioBean {

	private String nome;
	private String nomePai;
	private String nomeMae;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String ufCnh;
	private String dataEmissao;
	private String DataValidade;

	@XmlElement(name = "Nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement(name = "Nome_do_Pai")
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@XmlElement(name = "Nome_da_Mae")
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@XmlElement(name = "Data_de_Nascimento")
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@XmlElement(name = "CPF")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@XmlElement(name = "RG")
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@XmlElement(name = "UF_CNH")
	public String getUfCnh() {
		return ufCnh;
	}

	public void setUfCnh(String ufCnh) {
		this.ufCnh = ufCnh;
	}

	@XmlElement(name = "Data_de_Expedicao_CNH")
	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@XmlElement(name = "Data_de_Validade_CNH")
	public String getDataValidade() {
		return DataValidade;
	}

	public void setDataValidade(String dataValidade) {
		DataValidade = dataValidade;
	}

}