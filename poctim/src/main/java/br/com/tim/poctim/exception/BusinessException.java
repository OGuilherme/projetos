package br.com.tim.poctim.exception;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tim.poctim.bean.XmlErroBean;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private XmlErroBean erro;

	public BusinessException(XmlErroBean bean) {
		this.erro = bean;
	}

	public XmlErroBean getErro() {
		return erro;
	}

}