package br.com.tim.poctim.converter;

import org.springframework.stereotype.Component;

import br.com.tim.poctim.bean.DadosResidenciaBean;
import br.com.tim.poctim.bean.ResidenciaXML;

@Component
public class ResidenciaXmlToBean implements GenericConverter<ResidenciaXML, DadosResidenciaBean> {

	public ResidenciaXML convertBeanToEntity(DadosResidenciaBean bean) {
		if (bean == null) {
			return null;
		}

		ResidenciaXML xml = new ResidenciaXML();
		
		xml.setCep(bean.getCep());
		xml.setDataEmissao(bean.getDataEmissao());
		xml.setDataVencimento(bean.getDataVencimento());
		xml.setEndereco(bean.getEndereco());
		xml.setEstado(bean.getEstado());
		xml.setMunicipio(bean.getMunicipio());
		xml.setNome(bean.getNome());

		return xml;
	}

	public DadosResidenciaBean convertEntityToBean(ResidenciaXML xml) {
		if (xml == null) {
			return null;
		}

		DadosResidenciaBean bean = new DadosResidenciaBean();

		bean.setCep(xml.getCep());
		bean.setDataEmissao(xml.getDataEmissao());
		bean.setDataVencimento(xml.getDataVencimento());
		bean.setEndereco(xml.getEndereco());
		bean.setEstado(xml.getEstado());
		bean.setMunicipio(xml.getMunicipio());
		bean.setNome(xml.getNome());
		
		return bean;
	}
}