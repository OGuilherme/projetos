package br.com.tim.poctim.util;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tim.poctim.bean.CadastroResidenciaXML;
import br.com.tim.poctim.bean.CadastroUsuarioXML;
import br.com.tim.poctim.bean.ResidenciaXML;
import br.com.tim.poctim.bean.UsuarioXML;

@Component
public class LeitorDeXML {
	
	private static final Logger log = LoggerFactory.getLogger(LeitorDeXML.class);
	
	@Value("${path.xml.input}")
	private String caminhoXmlInput;

	public UsuarioXML getDadosUsuarioXml() throws JAXBException, FileNotFoundException {
		log.info("Inicio do método leitura de xml.");
		CadastroUsuarioXML cadastro = new CadastroUsuarioXML();
		File file = new File(caminhoXmlInput+"USUARIO_CNH.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(CadastroUsuarioXML.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		cadastro = (CadastroUsuarioXML) unmarshaller.unmarshal(file);
		log.info("Fim do método leitura de xml.");
		return cadastro.getUsuarioXML();
	}

	public ResidenciaXML getDadosResidenciaXml() throws JAXBException, FileNotFoundException {
		log.info("Inicio do método leitura de xml.");
		CadastroResidenciaXML cadastro = new CadastroResidenciaXML();
		File file = new File(caminhoXmlInput+"USUARIO_COMPR_RESIDENCIA.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(CadastroResidenciaXML.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		cadastro = (CadastroResidenciaXML) unmarshaller.unmarshal(file);
		log.info("Fim do método leitura de xml.");
		return cadastro.getResidenciaXML();
	}
}
