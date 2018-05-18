package br.com.tim.poctim.converter;

import org.springframework.stereotype.Component;

import br.com.tim.poctim.bean.DadosUsuarioBean;
import br.com.tim.poctim.bean.UsuarioXML;

@Component
public class UsuarioXmlToBean implements GenericConverter<UsuarioXML, DadosUsuarioBean> {

	public UsuarioXML convertBeanToEntity(DadosUsuarioBean bean) {
		if(bean == null){
			return null;
		}
		
		UsuarioXML xml = new UsuarioXML();
		
		xml.setCpf(bean.getCpf());
		xml.setDataExpedicaoCNH(bean.getDataEmissao());
		xml.setDataNascimento(bean.getDataNascimento());
		xml.setDataValidadeCNH(bean.getDataValidade());
		xml.setNome(bean.getNome());
		xml.setNomeDoPai(bean.getNomePai());
		xml.setNomeDaMae(bean.getNomeMae());
		xml.setRg(bean.getRg());
		xml.setUfCNH(bean.getUfCnh());
		
		return xml;
	}

	public DadosUsuarioBean convertEntityToBean(UsuarioXML xml) {
		if(xml == null){
			return null;
		}
		
		DadosUsuarioBean bean = new DadosUsuarioBean();
		bean.setCpf(xml.getCpf());
		bean.setDataEmissao(xml.getDataExpedicaoCNH());
		bean.setDataNascimento(xml.getDataNascimento());
		bean.setDataValidade(xml.getDataValidadeCNH());
		bean.setNome(xml.getNome());
		bean.setNomeMae(xml.getNomeDaMae());
		bean.setNomePai(xml.getNomeDoPai());
		bean.setRg(xml.getRg());
		bean.setUfCnh(xml.getUfCNH());
		
		return bean;
	}
}