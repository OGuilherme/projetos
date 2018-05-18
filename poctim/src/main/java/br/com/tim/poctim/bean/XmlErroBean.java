package br.com.tim.poctim.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "erro")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlErroBean {
	@XmlTransient
	private String nome;
	private int codigo;
	private String documento;
	private String mensagem;
	
	public XmlErroBean() {
		super();
	}
	
	public XmlErroBean(String nome, int codigo, String documento, String mensagem) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.documento = documento;
		this.mensagem = mensagem;
	}



	@XmlTransient
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}