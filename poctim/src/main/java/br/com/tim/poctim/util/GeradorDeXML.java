package br.com.tim.poctim.util;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tim.poctim.bean.CadastroUsuarioBean;
import br.com.tim.poctim.bean.XmlErroBean;

@Component
public class GeradorDeXML {
	
	private static final Logger log = LoggerFactory.getLogger(GeradorDeXML.class);

	@Value("${path.xml.output}")
	private String caminhoXmlOutput;
	
	public void gerarXml(CadastroUsuarioBean dados) throws JAXBException, FileNotFoundException {
		log.info("Inicio do método de gravação de xml.");
		JAXBContext jaxbContext = JAXBContext.newInstance(CadastroUsuarioBean.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(dados, new File(caminhoXmlOutput+dados.getUsuario().getNome()+"_SUCESSO.xml"));
        log.info("Fim do método de gravação de xml.");
	}
	
	public void gerarXmlErro(XmlErroBean bean) throws JAXBException {
		log.info("Inicio do método de gravação de xml de erro.");
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlErroBean.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bean, new File(caminhoXmlOutput+bean.getNome()+"_ERRO.xml"));
        log.info("Fim do método de gravação de xml de erro.");
	}
}